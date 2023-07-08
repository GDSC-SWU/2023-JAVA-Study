import object.Member;
import object.Quiz;
import util.IssueCrawlingProvider;
import util.QuizProvider;
import util.SpeakerProvider;

import java.util.ArrayList;

/*
1. 발표자 정하기 (1명)
2. 복습 질문 (인당 2개 * 3)
3. 새로운 내용 질문 (인당 3개 * 3)
4. 본인 질문은 제외되도록
*/
public class Main {
    public static void main(String[] args) {
        ArrayList<Member> members = new ArrayList<>() {
            {
                add(new Member("Yerim", "yerim123456"));
                add(new Member("Yusun", "nusuy"));
                add(new Member("Hyojeong", "hyojeongchoi"));
            }
        };

        // 발표자 선정
        SpeakerProvider speakerProvider = new SpeakerProvider(members);
        String speakerName = speakerProvider.getSpeaker();

        // 이슈 크롤링
        IssueCrawlingProvider issueCrawlingProvider = new IssueCrawlingProvider(members);
        ArrayList<Quiz> quiz_list = issueCrawlingProvider.saveQuiz();

        // 퀴즈 배분
        QuizProvider quizProvider = new QuizProvider(members, quiz_list);
        quizProvider.assignQuiz(false);
        quizProvider.assignQuiz(true);

        System.out.println("---------------Result--------------");
        System.out.println("Today's speaker is '" + speakerName + "'\n");
        System.out.println("Quiz Allocation Result");
        System.out.println(" Member  |  New  |  Review ");
        System.out.println("------------------------------");

        for (Member member : members) {
            ArrayList<Integer> new_list = new ArrayList<>();
            ArrayList<Integer> review_list = new ArrayList<>();
            for (Quiz quiz : quiz_list) {
                if (quiz.getA_member().equals(member) && !quiz.getIs_review()) {
                    new_list.add(quiz.getIssue_num());
                } else if (quiz.getA_member().equals(member) && quiz.getIs_review()) {
                    review_list.add(quiz.getIssue_num());
                }
            }

            System.out.printf(" %s | %s | %s\n", member.getName(), new_list, review_list);
        }
    }
}
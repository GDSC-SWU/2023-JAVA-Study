import util.Member;
import util.QuizProvider;
import util.SpeakerProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
                add(new Member("Yerim"));
                add(new Member("Yusun"));
                add(new Member("Hyojeong"));
            }
        };

        String input;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputList;

        for (Member member : members) {
            System.out.println(member.getName() + "이 등록한 '복습 질문 번호' 입력(띄어쓰기 없이 ,(쉼표)로 구분)");
            input = sc.next();
            inputList = new ArrayList<>();

            for (String item : input.split(",")) {
                inputList.add(Integer.parseInt(item));
            }

            member.setReviewQuizList(inputList);

            System.out.println(member.getName() + "이 등록한 '이번 주 진도 질문 번호' 입력(띄어쓰기 없이 ,(쉼표)로 구분)");
            input = sc.next();
            inputList = new ArrayList<>();

            for (String item : input.split(",")) {
                inputList.add(Integer.parseInt(item));
            }

            member.setNewQuizList(inputList);
        }

        // 발표자 선정
        SpeakerProvider speakerProvider = new SpeakerProvider(members);
        String speakerName = speakerProvider.getSpeaker();

        // 퀴즈 배분
        QuizProvider quizProvider = new QuizProvider(members);
        ArrayList<ArrayList<Integer>> newQuiz = quizProvider.assignNewQuiz();
        ArrayList<ArrayList<Integer>> reviewQuiz = quizProvider.assignReviewQuiz();

        System.out.println("---------------Result--------------");
        System.out.println("Today's speaker is '" + speakerName + "'\n");
        System.out.println("Quiz Allocation Result");
        System.out.println(" Member  |  New  |  Review ");
        System.out.println("------------------------------");

        int i = 0;

        for (Member member : members) {
            System.out.printf(" %s | %s | %s\n", member.getName(), newQuiz.get(i).toString(), reviewQuiz.get(i).toString());
            i++;
        }
    }
}

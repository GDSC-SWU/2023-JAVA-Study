package util;

import object.Member;
import object.Quiz;

import java.util.ArrayList;

public class QuizProvider {
    private final ArrayList<Member> members;
    private final Integer memberCount;
    private final ArrayList<Quiz> quizList;

    public QuizProvider(ArrayList<Member> members, ArrayList<Quiz> quizList) {
        this.members = members;
        this.memberCount = members.size();
        this.quizList = quizList;
    }

    private int getQuizCount(Member member, boolean is_review) {
        int count = 0;
        for (Quiz quiz : quizList) {
            if (quiz.getIs_review() == is_review && quiz.getQ_member().equals(member)) {
                count++;
            }
        }

        return count;
    }

    private int getResultCount(Member member, boolean is_review) {
        int count = 0;
        for (Quiz quiz : quizList) {
            if (quiz.getA_member() != null && quiz.getIs_review() == is_review && quiz.getA_member().equals(member))
                count++;
        }

        return count;
    }

    public void assignQuiz(boolean isReview) {
        for (Quiz quiz : quizList) {
            Member randMem;
            if (quiz.getIs_review() == isReview) {
                do {
                    randMem = members.get((int) (Math.random() * memberCount));
                } while (quiz.getQ_member().equals(randMem) || (getResultCount(randMem, isReview) + 1 > getQuizCount(randMem, isReview)));

                quiz.setA_member(randMem);
            }
        }
    }
}

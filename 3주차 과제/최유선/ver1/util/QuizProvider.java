package util;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizProvider {
    private final ArrayList<Member> members;
    private final Integer memberCount;

    public QuizProvider(ArrayList<Member> members) {
        this.members = members;
        this.memberCount = members.size();
    }

    public ArrayList<ArrayList<Integer>> assignNewQuiz() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> quizList = new ArrayList<>();

        for (Member member : members) {
            quizList.addAll(member.getNewQuizList());

            result.add(new ArrayList<>());
        }

        for (int quiz : quizList) {
            int randMem;
            do {
                randMem = (int) (Math.random() * memberCount);
            } while (members.get(randMem).getNewQuizList().contains(quiz) || (result.get(randMem).size() + 1 > members.get(randMem).getNewQuizList().size()));

            result.get(randMem).add(quiz);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> assignReviewQuiz() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> quizList = new ArrayList<>();

        for (Member member : members) {
            quizList.addAll(member.getReviewQuizList());

            result.add(new ArrayList<>());
        }

        for (int quiz : quizList) {
            int randMem;
            do {
                randMem = (int) (Math.random() * memberCount);
            } while (members.get(randMem).getReviewQuizList().contains(quiz) || (result.get(randMem).size() + 1 > members.get(randMem).getReviewQuizList().size()));

            result.get(randMem).add(quiz);
        }

        return result;
    }
}

package util;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Integer> newQuizList;
    private List<Integer> reviewQuizList;

    public Member(String name) {
        this.name = name;
        this.newQuizList = null;
        this.reviewQuizList = null;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getNewQuizList() {
        return newQuizList;
    }

    public List<Integer> getReviewQuizList() {
        return reviewQuizList;
    }

    public void setNewQuizList(List<Integer> newQuizList) {
        this.newQuizList = newQuizList;
    }

    public void setReviewQuizList(List<Integer> reviewQuizList) {
        this.reviewQuizList = reviewQuizList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Member.class) {
            return false;
        }

        return ((Member) obj).getName().equals(this.name);
    }
}

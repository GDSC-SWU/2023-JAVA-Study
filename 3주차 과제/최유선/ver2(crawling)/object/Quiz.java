package object;

public class Quiz {
    private final boolean is_review;
    private final int issue_num;
    private final Member q_member;
    private Member a_member;

    public Quiz(boolean is_review, int issue_num, Member q_member) {
        this.is_review = is_review;
        this.issue_num = issue_num;
        this.q_member = q_member;
    }

    public boolean getIs_review() {
        return is_review;
    }

    public int getIssue_num() {
        return issue_num;
    }

    public Member getQ_member() {
        return q_member;
    }

    public Member getA_member() {
        return a_member;
    }

    public void setA_member(Member member) {
        a_member = member;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Quiz.class) {
            return false;
        }

        return ((Quiz) obj).getIssue_num() == (this.issue_num);
    }
}

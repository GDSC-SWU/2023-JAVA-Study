package object;

public class Member {
    private final String name;
    private final String gitName;

    public Member(String name, String gitName) {
        this.name = name;
        this.gitName = gitName;
    }

    public String getName() {
        return name;
    }

    public String getGitName() {
        return gitName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Member.class) {
            return false;
        }

        return ((Member) obj).getName().equals(this.name);
    }
}

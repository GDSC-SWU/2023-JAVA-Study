package util;

import java.util.ArrayList;

// 발표자 선정 클래스
public class SpeakerProvider {
    private ArrayList<Member> members;
    private Integer memberCount;

    public SpeakerProvider(ArrayList<Member> members) {
        this.members = members;
        this.memberCount = members.size();
    }

    public String getSpeaker() {
        int index = (int) (Math.random() * memberCount);

        return members.get(index).getName();
    }
}

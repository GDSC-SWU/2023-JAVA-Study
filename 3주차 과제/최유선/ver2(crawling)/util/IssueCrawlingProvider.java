package util;

import object.Member;
import object.Quiz;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class IssueCrawlingProvider {
    private final String URL = "https://github.com/GDSC-SWU/2023-JAVA-Study/issues";
    private final ArrayList<Member> members;

    public IssueCrawlingProvider(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Quiz> saveQuiz() {
        ArrayList<Quiz> quizList = new ArrayList<>();

        try {
            Document document = Jsoup.connect(URL).get();
            Elements elements = document.select(".opened-by");  // 이슈 번호 및 발행인
            Elements label_elements = document.select(".lh-default");  // 레이블
            ArrayList<Elements> label_list = new ArrayList<>();

            // 레이블 추출
            for (Element element : label_elements) {
                Elements labels = element.select("a");
                label_list.add(labels);
            }

            for (int i = 0; i < elements.size(); i++) {
                String[] list = elements.get(i).text().split(" ");
                int issue_num = Integer.parseInt(list[0].split("#")[1]);
                String git_name = list[6];
                boolean is_review = label_list.get(i).size() == 2;

                // git name과 비교하여 저장
                for (Member member : members) {
                    if (member.getGitName().equals(git_name)) {
                        quizList.add(new Quiz(is_review, issue_num, member));
                    }
                }
            }

            return quizList;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        RandomPick Randompick = new RandomPick(); // 객체 생성
        Scanner scan = new Scanner(System.in); // 입력을 위한 객체 생성
      
        System.out.println("멤버의 수를 입력해주세요");
        int member = scan.nextInt();

        Randompick.numberOfmembers(member); // 멤버 수 입력 및 번호 부여
        System.out.println("");

        Randompick.presenter(member); // 발표자 선정
        System.out.println("");

        System.out.println("복습 질문 해결하는 사람은");
        Randompick.question_resolve(member, member*2); // 복습 질문 할당
        System.out.println("");
        
        
        System.out.println("이번주 질문 해결하는 사람은");
        Randompick.question_resolve(member, member*3); // 이번주 질문 할당
        System.out.println("");

        scan.close();
    }
    
}

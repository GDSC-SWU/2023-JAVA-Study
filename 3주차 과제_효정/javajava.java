import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class javajava {
    //전역변수 선언
    static String[] name = {"최효정","최유선","이예림"};
    static Scanner sc = new Scanner(System.in);

    //발표자를 뽑는 함수
    public static void Presenter() {
        int i,n;
        System.out.println("이번주 발표자를 추첨합니다.");
        for(i=0; i<=100; i++) {
            System.out.println("------------ " +name[i % name.length]);
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
        Random rm= new Random();
        n = rm.nextInt(name.length);
        System.out.println("이번주 발표자는 "+name[n]+"입니다.");


        System.out.println("발표자를 재추첨하시겠습니까? 0: 아니오, 1: 예");
        int num = sc.nextInt();
        if (num==1){
            Presenter();
            return;
        }
        else if(num==0){
            mainProgram();
            return;
        }
    }

    public static void Question (){
        System.out.println("질문을 할당합니다.");
        Random rm = new Random();
        int[] HJ = new int[5];
        int[] YS = new int[5];
        int[] YR = new int[5];

        int[] q= new int [15];
        int k=0;

        //복습 질문
        System.out.println("----복습 질문을 할당합니다.");
        for (int i=0; i<6; i++)
        {
            q[i]=rm.nextInt(6)+1;
            //중복 번호 삭제
            for (int j=0; j<i; j++) {
                if (q[i] == q[j]) {
                    i--;
                }
            }
        }
        //System.out.println("q 질문 : "+Arrays.toString(q));
        for(int i=0; i<6; i+=3){
            HJ[k]=q[i]; //0

            if((i+1>7)) {break;}
            YS[k]=q[i+1]; //1 4

            if((i+2>7)) {break;}
            YR[k]=q[i+2];     //2 5
            k++;
        }

        //새 단원 질문
        System.out.println("---새 단원 질문을 할당합니다.");
        for (int i=6; i<15; i++)
        {
            q[i]=rm.nextInt(9)+1;
            //중복 번호 삭제
            for (int j=6; j<i; j++) {
                if (q[i] == q[j]) {
                    i--;
                }
            }
        }
        for(int i=6; i<15; i+=3){
            HJ[k]=q[i]; //0

            if((i+1>15)) {break;}
            YS[k]=q[i+1]; //1 4

            if((i+2>15)) {break;}
            YR[k]=q[i+2];     //2 5
            k++;
        }
        System.out.println("--------------------------.");

        System.out.println("질문 : (복습, 복습, 새 단원, 새 단원, 새 단원)");
        System.out.println("효정 질문 : "+Arrays.toString(HJ));
        System.out.println("유선 질문 : "+Arrays.toString(YS));
        System.out.println("예림 질문 : "+Arrays.toString(YR));
    }

    //사용자 화면
    public static void mainProgram(){
        while(true){
            System.out.println("=============================");
            System.out.println("원하는 메뉴의 번호를 입력하세요.");
            System.out.println("1. 발표자 추첨하기");
            System.out.println("2. 질문 할당하기");

            System.out.println("\b메뉴 입력:  ");
            int menu = sc.nextInt();

            if(menu ==1){
                Presenter();
                return;
            } else if (menu==2) {
                Question();
                return;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        mainProgram();
        return;
    }
}

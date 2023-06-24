import java.util.*;


public class RandomPick  {


    // 참가자 이름 입력 및 랜덤 번호 부여 함수
    public void numberOfmembers(int n){
        String[] name=new String[n];
        Scanner scanName = new Scanner(System.in);

        for(int i = 0; i < n; i++){
            System.out.println((i+1)+"번째 멤버의 이름을 입력해주세요");
            name[i] = scanName.next();
        }
        scanName.close();

        Collections.shuffle(Arrays.asList(name)); // 배열을 섞는 방법
        
        System.out.println("");
        System.out.println("랜덤 번호를 공개하겠습니다!");
        
        for(int i = 0; i < n; i++){
            System.out.println((i+1)+"번째 멤버는 " + name[i] + "입니다");
        }
    }

    // 인원수에 맞춰 발표자 번호를 말해주는 함수
    public void presenter(int n){
		Random random = new Random();
         System.out.println("발표자는"+(random.nextInt(n)+1)+"번입니다.");
    }

    // 질문 수를 받아 랜덤으로 배정해주는 함수
    public void question_resolve(int n, int question){
        Random random = new Random(); // 랜덤 객체 생성
        random.setSeed(System.currentTimeMillis()); //시드값 설정

        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < question; ++i){
            list.addLast(i);   // 1~question까지의 값을 집어 넣음
        }


        for(int i = list.size(); i > 0; i--){
            int index;
            int random_number;
            index = random.nextInt(i); // 현재 list 길이 만큼의 숫자에서 랜덤 숫자 뽑아냄
            random_number= (Integer)list.get(index); // 랜덤 값이 나온 값을 리스트에서 뽑아냄 (결국 랜덤으로 나온 값을 뽑아내는것과 같음)
                
            System.out.println((random_number+1) + "번을 해결할 사람 : " + ((i%n)+1)); 
            list.remove(index);       //뽑아낸 리스트 제거    
        }
    }


}

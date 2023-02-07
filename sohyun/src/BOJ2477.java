import java.util.Scanner;

public class BOJ2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int height = 0;
        int width = 0;
        int heightIdx = 0;
        int widthIdx = 0;
        
        int[] dir = new int[6];
        int[] cnt = new int[6];
        for(int i=0;i<6;i++){
            dir[i] = sc.nextInt();
            cnt[i] = sc.nextInt();

            if(dir[i]==4 || dir[i]==3){
                // 남,북이면
                if (height < cnt[i]) {
                    height = cnt[i];
                    heightIdx = i;
                }
                
            }
            if(dir[i]==1||dir[i]==2){
                // 동,서면
                if (width < cnt[i]) {
                    width = cnt[i];
                    widthIdx = i;
                }
                 
            }
        }

        System.out.println(heightIdx);
        System.out.println(widthIdx);
        //작은 사각형 구하려고 할 때
        //hMAxIdx+3 %6
        //hMinIdx+3 %6
        //규칙을 못찾았음 ; 이걸로 구하면 깔끔
        int area = height * width;
        int hMinIdx = (heightIdx + 3) % 6;
        int wMinIdx = (widthIdx + 3) % 6;
        int sub = cnt[wMinIdx] * cnt[hMinIdx];
        
        System.out.println((area-sub)*N);
    }
}

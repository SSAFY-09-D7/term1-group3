import java.util.Scanner;

public class BOJ2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int height = 0;
        int width = 0;
        int[] dir = new int[6];
        int[] cnt = new int[6];
        for(int i=0;i<6;i++){
            dir[i] = sc.nextInt();
            cnt[i] = sc.nextInt();

            if(dir[i]==4 || dir[i]==3){
                // 남,북이면
                height = Math.max(height,cnt[i]);
            }
            if(dir[i]==1||dir[i]==2){
                // 동,서면
                width = Math.max(width,cnt[i]);
                 
            }
        }

        //i==i+2 인경우 찾아서 
        int area = height*width;
        int sub = 0;

        for(int i=0;i<3;i++){
            if(dir[i]==dir[i+2] && dir[i+1]==dir[i+3]){
                sub = cnt[i+2]*cnt[i+1];
                
            }
        }
        System.out.println((area-sub)*N);
    }
}

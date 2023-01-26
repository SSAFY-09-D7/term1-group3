import java.util.Scanner;

public class BOJ1592 {
    static boolean gameOver = false;
    static int N;
    static int M;
    static int L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();

        int[] ballCount = new int[N];
        int answer = 0;
        ballCount[0] = 1;
        int idx=0 ;
        
        while(!gameOver){
            if(ballCount[idx]>=M) {gameOver=true; break;}
            int curIdx = idx;
            idx = toss(ballCount,curIdx);
            ballCount[idx]+=1;
            answer+=1;
            
        }

        System.out.println(answer);

    }   
    public static int toss(int[] ballCount,int idx){
        int ballC = ballCount[idx];
        if(ballC%2==0){
            //짝수면
            return (N-L+idx)%N;
        }
        else{
            return (idx+L)%N;
        }
    } 
}

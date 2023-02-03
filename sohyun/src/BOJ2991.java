import java.util.*;
import java.io.*;
public class BOJ2991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int C = sc.nextInt();
        int D = sc.nextInt();

        int P = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();

        //우체부
        
        //우유배달원
        //신문배달원
        System.out.println(count(P,A,B,C,D));
        System.out.println(count(M,A,B,C,D));
        System.out.println(count(N,A,B,C,D));
    }

    private static int count(int who, int A, int B, int C, int D) {
        int answer = 0;
        if (who % (A + B)>0 && who % (A + B) <= A) {
            answer++;
        }
        if (who % (C + D) <= C && who %(C+D)>0) {
            answer++;
        }
        return answer;
    }
}

import java.io.*;
import java.util.*;
public class BOJ2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int big = N > M ? N : M;
        int small = N > M ? M : N;
        int GCD = 0;
        
        for (int i = 1; i <= small; i++) {
            if (small % i == 0 && big % i == 0)
                GCD = i;
        }
        int LCM = (small * big) / GCD;
        System.out.println(GCD);
        System.out.println(LCM);
    }
}

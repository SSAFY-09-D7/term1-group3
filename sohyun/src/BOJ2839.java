import java.util.*;
import java.io.*;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                answer += (N / 5);
                System.out.println(answer);
                return;
            }
            N -= 3;
            answer++;
        }
        System.out.println(-1);
        
    }
}

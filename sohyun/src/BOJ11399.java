import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] person = new int[N];
        for (int i = 0; i < N; i++) {
            person[i] = sc.nextInt();
        }
        //person 오름차순 정렬
        Arrays.sort(person);
        //누적 합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int time = person[i];
            sum += time * (N - i);
        }
        System.out.println(sum);
    }
}
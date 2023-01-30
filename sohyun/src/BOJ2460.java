import java.util.Scanner;

public class BOJ2460 {
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            sum -= out;
            sum += in;
            if (sum > answer)
                answer = sum;
        }
        System.out.println(answer);
    }
}

import java.util.Scanner;

public class BOJ8320 {
    public static void main(String[] args) {
        // 변의 길이가 1인 정사각형 n개
        // 이 정사각형을 이용해서 만들 수 있는 직사각형의 개수?
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        //일단.. 높이 1인 게 N개
        for (int h = 1; h <= N; h++) {
            for (int j = h; j <= N; j++) {
                if (h * j > N)
                    continue;
                else
                    count++;
            }
        }
        System.out.println(count);
    }
}
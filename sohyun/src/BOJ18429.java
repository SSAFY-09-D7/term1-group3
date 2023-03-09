import java.util.*;
import java.io.*;

public class BOJ18429 {
    static int K, N;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permu(0, new int[N], new boolean[N]);
        System.out.println(answer);
    }

    private static void permu(int i, int[] temp, boolean[] bs) {
        if (i == temp.length) {
            int sum = 500;
            boolean isFalse = true;
            for (int idx = 0; idx < temp.length; idx++) {
                sum = sum + temp[idx] - K;
                if (sum < 500) {
                    isFalse = false;
                    break;
                }
            }
            if (isFalse)
                answer++;
            return;
        }
        for (int d = 0; d < arr.length; d++) {
            if (!bs[d]) {
                bs[d] = true;
                temp[i] = arr[d];
                permu(i + 1, temp, bs);
                bs[d] = false;
            }
        }
    }
}

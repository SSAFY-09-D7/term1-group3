import java.util.*;
import java.io.*;

public class SWEA9229 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }


            int sum = 0;
            L: for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (snack[i] + snack[j] <= M) {
                        if (snack[i] + snack[j] == M) {
                            sum = M;
                            break L;
                        }
                        sum = Math.max(sum, snack[i] + snack[j]);
                    }
                }
            }
            if (sum == 0)
                sum = -1;
            System.out.printf("#%d %d\n",testcase,sum);

        }
    }
}

import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] arg) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ1806.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, min = 0, sum = 0;
        while(true) {
            if (sum >= S) {
                sum -= nums[start];
                if ( min == 0 ) min = end - start;
                else min = Math.min(min, end - start);
                start++;
            }

            else if (end == N) break;

            else {
                sum += nums[end];
                end++;
            }
        }

        System.out.print(min);
    }
}

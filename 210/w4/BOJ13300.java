package w4;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ13300.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] cnt = new int[2][6];
        int result = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) - 1;
            cnt[s][y]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                result += Math.ceil((double) cnt[i][j] / k);
            }
        }

        System.out.println(result);
    }

}

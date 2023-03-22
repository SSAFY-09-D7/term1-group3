package w03;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1106.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] leastMoney = new int[c + 1];
        int[][] city = new int[n][2]; // 돈 : 사람 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            city[i][0] = Integer.parseInt(st.nextToken());
            city[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= c; i++) {
            leastMoney[i] = getLeastMoney(leastMoney, i, city, n);
        }

        System.out.println(leastMoney[c]);
    }

    private static int getLeastMoney(int[] leastMoney, int idx, int[][] city, int n) {
        int min = -1;
        int tempMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (city[i][1] >= idx) {
                tempMin = Math.min(tempMin, city[i][0]);
            }

            if (idx - city[i][1] < 0)
                continue;

            min = min == -1 ? leastMoney[idx - city[i][1]] + city[i][0]
                    : Math.min(min, leastMoney[idx - city[i][1]] + city[i][0]);
        }

        return min == -1 || tempMin < min ? tempMin : min;
    }
}

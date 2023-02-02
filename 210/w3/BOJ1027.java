package w3;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1027.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int currH = nums[i];
            int currentCnt = getPossibleCnt(nums, n, i, currH, -1) + getPossibleCnt(nums, n, i, currH, 1);
            max = Math.max(max, currentCnt);
        }

        System.out.println(max);

    }

    private static int getPossibleCnt(int[] nums, int n, int idx, int currH, int dir) {
        if ((idx == 0 && dir == -1) || (idx == n - 1 && dir == 1))
            return 0;

        double delta = dir == -1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = idx + dir; i < n && i >= 0; i += dir) {
            double currDelta = (double) (nums[i] - currH) / (double) (i - idx);
            if ((currDelta - delta) * dir > 0) {
                delta = currDelta;
                cnt++;
            }
        }

        return cnt;
    }
}

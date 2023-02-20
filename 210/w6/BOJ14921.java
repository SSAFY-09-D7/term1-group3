package w6;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ14921.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int result = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                int sum = nums[i] + nums[mid];
                if (Math.abs(sum) < Math.abs(result)) {
                    result = sum;
                }

                if (sum < 0) left = mid + 1;
                else right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
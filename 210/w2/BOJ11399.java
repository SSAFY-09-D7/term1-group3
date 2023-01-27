package w2;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ11399.txt"));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int[] waits = new int[n];
        int result = waits[0] = nums[0];

        for (int i = 1; i < n; i++) {
            waits[i] += waits[i - 1] + nums[i];
            result += waits[i];
        }

        System.out.println(result);
        sc.close();
    }

}
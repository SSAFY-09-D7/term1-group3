package w02;

import java.io.*;
import java.util.*;

class Main {
        public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("./inputs/input_BOJ2501.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt() - 1;
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                nums.add(i);
            }
        }

        int result = m >= nums.size() ? 0 : nums.get(m);
        System.out.println(nums.get(0) + " " + result);
        sc.close();
    }
}
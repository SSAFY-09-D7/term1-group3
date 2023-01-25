package w2;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_SWEA2805.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int m = n / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                char[] numChars = sc.next().toCharArray();

                if (i <= m) {
                    for (int j = m - i; j <= m + i; j++) {
                        sum += numChars[j] - '0';
                    }
                } else {
                    for (int j = i - m; j < n - i + m; j++) {
                        sum += numChars[j] - '0';
                    }
                }

            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
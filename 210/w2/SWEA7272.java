package w2;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_swea_7272.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str1 = sc.next();
            String str2 = sc.next();
            String hole = "ADOPQR";

            str1 = str1.replaceAll("[" + hole + "]", "A");
            str1 = str1.replaceAll("[^" + hole + "B]", "C");

            str2 = str2.replaceAll("[" + hole + "]", "A");
            str2 = str2.replaceAll("[^" + hole + "B]", "C");

            String msg = str1.equals(str2) ? "SAME" : "DIFF";

            System.out.println("#" + test_case + " " + msg);

        }
    }
}
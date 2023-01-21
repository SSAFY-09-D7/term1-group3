package w1;

import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt(); // m초에 k개
            int k = sc.nextInt();
            List<Integer> arives = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                arives.add(a);
            }
            Collections.sort(arives);

            int accSell = 0;
            boolean isPossible = true;
            for (Integer arive : arives) {
                int lastFill = arive / m;
                int lastFillCnt = lastFill * k;
                accSell++;

                if (lastFillCnt - accSell < 0) {
                    isPossible = false;
                    break;
                }

            }

            String result = isPossible ? "Possible" : "Impossible";
            System.out.println("#" + test_case + " " + result);

        }
    }
}

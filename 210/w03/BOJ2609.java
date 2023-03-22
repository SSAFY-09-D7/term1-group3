package w03;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2609.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Math.min(a, b);
        int maxDiv = 1;
        for (int i = 2; i <= min; i++) {
            while (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
                maxDiv *= i;
            }
        }

        System.out.println(maxDiv);
        System.out.println(maxDiv * a * b);
    }
}

package w02;

import java.io.File;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(new File("./inputs/input_BOJ3460.txt"));
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            String str = "";
            int idx = 0;

            while (num >= 1) {
                if (num % 2 == 1)
                    str += " " + String.valueOf(idx);
                num /= 2;
                idx++;
            }
            System.out.println(str.substring(1));
        }
        sc.close();
    }

}
package w03;

import java.io.FileInputStream;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2460.txt"));
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int currPeople = 0;

        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();

            currPeople -= out;
            max = Math.max(max, currPeople);

            currPeople += in;
            max = Math.max(max, currPeople);
        }

        System.out.println(max);
        sc.close();
    }
}

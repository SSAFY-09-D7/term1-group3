package w3;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2693.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());
        int[] nums = new int[10];

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            System.out.println(nums[7]);
        }
    }
}
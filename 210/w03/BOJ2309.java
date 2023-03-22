package w03;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2309.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;
        int gap = -1;

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            nums.add(num);
        }

        gap = sum - 100;
        boolean isEnd = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (nums.get(i) + nums.get(j) == gap) {
                    nums.remove(j);
                    nums.remove(i);
                    isEnd = true;
                    break;
                }
            }
            if (isEnd)
                break;
        }

        Collections.sort(nums);

        for (Integer n : nums)
            System.out.println(n);
    }

}

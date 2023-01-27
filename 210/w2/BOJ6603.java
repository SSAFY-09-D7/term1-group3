package w2;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ6603.txt"));
        Scanner sc = new Scanner(System.in);

        while (true) {
            int cnt = sc.nextInt();
            if (cnt == 0)
                break;
            int[] nums = new int[cnt];
            boolean[] visited = new boolean[cnt];

            for (int i = 0; i < cnt; i++)
                nums[i] = sc.nextInt();

            Arrays.sort(nums);

            searchCombinations(nums, visited, 0, 0, cnt);
        }
        sc.close();
    }

    private static void searchCombinations(int[] nums, boolean[] visited, int depth, int start, int cnt) {
        if (depth == 6) {
            print(nums, visited, cnt);
            return;
        }

        for (int i = start; i < cnt; i++) {
            visited[i] = true;
            searchCombinations(nums, visited, depth + 1, i + 1, cnt);
            visited[i] = false;
        }
    }

    private static void print(int[] nums, boolean[] visited, int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (visited[i]) {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println("");
    }
}

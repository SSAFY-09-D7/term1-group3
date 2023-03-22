package w02;

import java.io.*;
import java.util.*;

public class MazeArive {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_maze_arrive.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int startR = sc.nextInt();
            int startC = sc.nextInt();
            int jumperCnt = sc.nextInt();
            int[] result = { startR, startC };
            int[][] jumpers = new int[jumperCnt][2];

            for (int i = 0; i < jumperCnt; i++) {
                jumpers[i][0] = sc.nextInt();
                jumpers[i][1] = sc.nextInt();
            }

            int cmdCnt = sc.nextInt();
            for (int i = 0; i < cmdCnt; i++) {
                int direction = sc.nextInt();
                int distance = sc.nextInt();

                move(result, direction, distance);
                if (needToGoFirst(n, jumpers, result)) {
                    result[0] = 0;
                    result[1] = 0;
                }
            }

            System.out.println("#" + tc + " " + result[0] + " " + result[1]);
        }
    }

    private static int[] move(int[] result, int direction, int distance) {
        result[0] = direction == 1 ? result[0] - distance : direction == 3 ? result[0] + distance : result[0];
        result[1] = direction == 2 ? result[1] + distance : direction == 4 ? result[1] - distance : result[1];

        return result;
    }

    private static boolean needToGoFirst(int n, int[][] jumpers, int[] result) {
        int r = result[0];
        int c = result[1];

        if (r < 0 || r >= n || c < 0 || c >= n)
            return true;

        for (int i = 0; i < jumpers.length; i++) {
            if (r == jumpers[i][0] && c == jumpers[i][1])
                return true;
        }

        return false;
    }
}

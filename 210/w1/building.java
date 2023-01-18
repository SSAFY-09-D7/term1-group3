package w1;

import java.io.FileInputStream;
import java.util.Scanner;

class solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("../inputs/input_building.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int max = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.next().charAt(0);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'B') {
                        int currentHight = hasGAround(map, n, i, j) ? 2 : getHight(map, n, i, j);
                        max = Math.max(max, currentHight);
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    private static boolean hasGAround(int[][] map, int n, int r, int c) {
        int[] dr = { 0, 0, 1, -1, -1, -1, 1, 1 };
        int[] dc = { -1, 1, 0, 0, -1, 1, -1, 1 };

        for (int i = 0; i < 8; i++) {
            int currR = r + dr[i];
            int currC = c + dc[i];

            if (currR < 0 || currR >= n || currC < 0 || currC >= n)
                continue;
            if (map[currR][currC] == 'G') {
                return true;
            }
        }
        return false;
    }

    private static int getHight(int[][] map, int n, int r, int c) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (map[i][c] == 'B') {
                cnt++;
            }
            if (map[r][i] == 'B') {
                cnt++;
            }
        }
        return --cnt;
    }

}
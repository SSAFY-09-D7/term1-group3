package w1;

import java.io.FileInputStream;
import java.util.Scanner;

class solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_jump_4way.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int[][] map = new int[h][w];
            int[][] players = new int[n][3];
            int result = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                players[i][0] = sc.nextInt() - 1;
                players[i][1] = sc.nextInt() - 1;
                players[i][2] = sc.nextInt();
            }

            int hudleCnt = sc.nextInt();
            for (int i = 0; i < hudleCnt; i++) {
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;

                map[r][c] = -1;
            }

            for (int i = 0; i < n; i++) {
                result += play(map, h, w, players[i][0], players[i][1], players[i][2]);
            }

            System.out.println("#" + tc + " " + result);

        }
    }

    private static int play(int[][] map, int h, int w, int startR, int startC, int cnt) {
        int result = -1000;

        int r = startR;
        int c = startC;
        for (int i = 0; i < cnt; i++) {
            int direction = map[r][c] / 10;
            int dis = map[r][c] % 10;
            r = direction == 4 ? r - dis : direction == 2 ? r + dis : r;
            c = direction == 3 ? c - dis : direction == 1 ? c + dis : c;
            if (r < 0 || r >= h || c < 0 || c >= w || map[r][c] == -1)
                return result;
        }

        result += map[r][c] * 100;

        return result;
    }
}
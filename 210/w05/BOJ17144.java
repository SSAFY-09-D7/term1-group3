package w05;

import java.io.*;
import java.util.*;

class Main {
    static int[][] board;
    static int R, C, T, aR = -1, aC = -1;

    public static void main(String[] arg) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ17144.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (aR == -1 && board[i][j] == -1) {
                    aR = i;
                    aC = j;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            ArrayList<int[]> dusts = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] > 0) {
                        dusts.add(new int[] { i, j, board[i][j] });
                    }
                }
            }

            for (int[] dust : dusts) {
                spread(dust[0], dust[1], dust[2]);
            }

            rotateTop();
            rotateBottom();
        }

        System.out.println(getSum());
    }

    private static void spread(int r, int c, int origin) {
        int[][] ds = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        int cnt = 0;
        int[][] tmp = new int[4][2];
        for (int i = 0; i < 4; i++) {
            int nr = r + ds[i][0];
            int nc = c + ds[i][1];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && board[nr][nc] != -1) {
                tmp[cnt][0] = nr;
                tmp[cnt][1] = nc;
                cnt++;
            }
        }

        int num = origin / 5;
        for (int i = 0; i < cnt; i++) {
            board[tmp[i][0]][tmp[i][1]] += num;
        }
        board[r][c] -= (num * cnt);
    }

    private static void rotateTop() {
        int[][] ds = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int d = 0;
        int currR = aR - 1;
        int currC = aC;
        while (true) {
            if (currR == aR && currC == aC + 1)
                break;
            if ((currR == aR && currC == C - 1) || (currR == 0 && currC == C - 1)
                    || (currR == 0 && currC == 0)) {
                d++;
            }
            board[currR][currC] = board[currR + ds[d][0]][currC + ds[d][1]];

            currR += ds[d][0];
            currC += ds[d][1];
        }

        board[aR][aC + 1] = 0;
    }

    private static void rotateBottom() {
        int currR = aR + 2;
        int currC = aC;
        int[][] ds = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int d = 0;
        while (true) {
            if (currR == aR + 1 && currC == aC + 1)
                break;
            if ((currR == R - 1 && currC == 0) || (currR == R - 1 && currC == C - 1)
                    || (currR == aR + 1 && currC == C - 1)) {
                d++;
            }
            board[currR][currC] = board[currR + ds[d][0]][currC + ds[d][1]];

            currR += ds[d][0];
            currC += ds[d][1];
        }

        board[aR + 1][aC + 1] = 0;
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0)
                    sum += board[i][j];
            }
        }

        return sum;
    }
}

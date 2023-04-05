package w12;

import java.util.*;
import java.io.*;

class Solution {
    static int N, X;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    static int[][] ds = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_SWEA4014.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + tc + " " + getCnt() + "\n");
        }

        System.out.println(sb);
    }

    private static int getCnt() {
        int cnt = 0;

        cnt += getVerticalCnt();
        cnt += getHorizontalCnt();

        return cnt;
    }

    private static int getHorizontalCnt() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            boolean isPossible = true;

            for (int j = 0; j < N - 1; j++) {

                // 나보다 낮으면
                if (board[i][j] > board[i][j + 1] && !canBuild(i, j, 0)) {
                    isPossible = false;
                    break;
                }

                // 나보다 높으면
                if (board[i][j] < board[i][j + 1] && !canBuild(i, j + 1, 1)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible)
                cnt++;
        }

        return cnt;
    }

    private static int getVerticalCnt() {
        int cnt = 0;

        for (int j = 0; j < N; j++) {
            boolean isPossible = true;

            for (int i = 0; i < N - 1; i++) {

                // 나보다 낮으면
                if (board[i][j] > board[i + 1][j] && !canBuild(i, j, 2)) {
                    isPossible = false;
                    break;
                }

                if (board[i][j] < board[i + 1][j] && !canBuild(i + 1, j, 3)) {
                    isPossible = false;
                    break;
                }

            }

            if (isPossible)
                cnt++;
        }

        return cnt;
    }

    private static boolean canBuild(int r, int c, int d) {
        int nr = r + ds[d][0];
        int nc = c + ds[d][1];
        if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[r][c] - board[nr][nc] > 1)
            return false;
        int target = board[nr][nc];

        for (int i = 1; i < X; i++) {
            nr += ds[d][0];
            nc += ds[d][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                return false;
            if (board[nr][nc] != target) {
                return false;
            }
        }

        for (int i = 1; i <= X; i++) {
            nr += ds[d][0];
            nc += ds[d][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                return true;
            if (board[nr][nc] > target)
                return false;
        }

        return true;
    }
}
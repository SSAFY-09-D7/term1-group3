package w12;

import java.util.*;
import java.io.*;

class Solution {
    static int result, D, W, K;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_SWEA2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            board = new boolean[D][W];
            result = K;

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    if (st.nextToken().equals("1"))
                        board[i][j] = true;
                }
            }

            if (K == 1)
                result = 0;
            else
                powerSet(new int[D], D, 0);
            sb.append("#" + tc + " " + result + "\n");
        }

        System.out.println(sb);
    }

    private static void powerSet(int[] sel, int cnt, int depth) {

        if (depth == sel.length) {
            if (cnt < K && isPass(sel))
                result = Math.min(cnt, result);
            return;
        }

        sel[depth] = 0;
        powerSet(sel, cnt - 1, depth + 1);
        sel[depth] = 1;
        powerSet(sel, cnt, depth + 1);
        sel[depth] = 2;
        powerSet(sel, cnt, depth + 1);
    }

    private static boolean isPass(int[] sel) {
        boolean[][] testBoard = getTestBoard(sel);

        for (int j = 0; j < W; j++) {
            boolean linePass = false;
            for (int i = 0; i <= D - K; i++) {

                boolean target = testBoard[i][j];
                boolean spotPass = true;
                for (int k = 1; k < K; k++) {
                    if (testBoard[i + k][j] != target) {
                        spotPass = false;
                        break;
                    }
                }

                if (spotPass) {
                    linePass = true;
                    break;
                }
            }

            if (!linePass)
                return false;
        }

        return true;
    }

    private static boolean[][] getTestBoard(int[] sel) {
        boolean[][] testBoard = new boolean[D][W];
        for (int i = 0; i < D; i++) {
            if (sel[i] == 0) {
                testBoard[i] = board[i].clone();
                continue;
            }

            testBoard[i] = new boolean[W];
            if (sel[i] == 2)
                Arrays.fill(testBoard[i], true);
        }

        return testBoard;
    }
}

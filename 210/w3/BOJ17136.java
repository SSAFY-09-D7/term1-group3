package w3;

import java.io.*;
import java.util.*;

class Main {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ17136.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] board = new int[10][10];
        int[] lefts = { 0, 5, 5, 5, 5, 5 };

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, lefts, 0, 0, 0);
        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);
    }

    static void dfs(int[][] board, int[] lefts, int r, int c, int cnt) {
        if (r == 10 || c == 10) {
            result = Math.min(cnt, result);
            return;
        }

        if (result <= cnt)
            return;

        if (board[r][c] == 1) {
            for (int i = 5; i > 0; i--) {
                if (isBoxStart(board, r, c, i) && lefts[i] > 0) {
                    lefts[i] -= 1;
                    fill(board, r, c, i, 0);
                    dfs(board, lefts, r + ((c + 1) / 10), (c + 1) % 10, cnt + 1);
                    fill(board, r, c, i, 1);
                    lefts[i] += 1;
                }
            }
        } else
            dfs(board, lefts, r + ((c + 1) / 10), (c + 1) % 10, cnt);

    }

    private static boolean isBoxStart(int[][] board, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i > 9 || j > 9)
                    return false;
                if (board[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    private static void fill(int[][] board, int x, int y, int size, int num) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = num;
            }
        }

    }

}
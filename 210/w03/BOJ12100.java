package w03;

import java.io.*;
import java.util.*;

class Main {
    private static int maxScore = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ12100.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, n, 0);
        System.out.println(maxScore);
    }

    private static void dfs(int[][] board, int n, int depth) {
        if (depth == 2) {
            updateMax(board, n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
            move(nextBoard, n, i);
            dfs(nextBoard, n, depth + 1);
        }
    }

    // 0:위로 1:오른쪽으로 2:아래로 3:왼쪽으로
    private static void move(int[][] board, int n, int direction) {
        for (int i = 0; i < n; i++) {
            Queue<Integer> q = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                int r = getR(n, i, j, direction);
                int c = getC(n, i, j, direction);

                if (board[r][c] != 0)
                    q.add(board[r][c]);
                board[r][c] = 0;
            }

            int j = 0;
            int prevNum = -1;
            boolean plused = false;
            while (!q.isEmpty()) {
                int currNum = q.poll();

                if (!plused && currNum == prevNum) {
                    board[getR(n, i, j - 1, direction)][getC(n, i, j - 1, direction)] = currNum * 2;
                    plused = true;
                } else {
                    board[getR(n, i, j, direction)][getC(n, i, j, direction)] = currNum;
                    j++;
                    plused = false;
                }

                prevNum = currNum;
            }
        }
    }

    private static int getR(int n, int i, int j, int direction) {
        if (direction == 0)
            return j;
        else if (direction == 2)
            return n - 1 - j;
        else if (direction == 1)
            return n - 1 - i;
        return i;
    }

    private static int getC(int n, int i, int j, int direction) {
        if (direction == 0 || direction == 2)
            return i;
        if (direction == 1)
            return n - 1 - j;
        return j;
    }

    private static void updateMax(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxScore = Math.max(board[i][j], maxScore);
            }
        }
    }
}
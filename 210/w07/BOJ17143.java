package w07;

import java.io.*;
import java.util.*;

class Main {
    static int R, C, M, result = 0;
    static int[][] board;
    static int[][] ds = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] sharks; // {속력, 이동방향, 크기}

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ17143.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[R + 1][C + 1];
        sharks = new int[M + 1][3];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            board[r][c] = i;
            sharks[i][0] = s;
            sharks[i][1] = d;
            sharks[i][2] = z;
        }

        for (int i = 1; i <= C; i++) {
            result += fish(i);
            moveAll();
        }

        System.out.println(result);
    }

    private static int fish(int j) {
        for (int i = 1; i <= R; i++) {
            if (board[i][j] != 0) {
                int size = sharks[board[i][j]][2];
                board[i][j] = 0;
                return size;
            }
        }
        return 0;
    }

    private static void moveAll() {
        int[][] nextBoard = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (board[i][j] != 0)
                    move(i, j, nextBoard);
            }
        }

        board = nextBoard;
    }

    private static void move(int r, int c, int[][] nextBoard) {
        int nr = r;
        int nc = c;
        int direction = sharks[board[r][c]][1];
        int distance = sharks[board[r][c]][0];

        while (distance > 0) {
            if ((direction == 1 && nr == 1) || (direction == 2 && nr == R) || (direction == 3 && nc == C)
                    || (direction == 4 && nc == 1)) {
                direction = direction == 1 ? 2 : direction == 2 ? 1 : direction == 3 ? 4 : 3;
            }

            nr += ds[direction][0];
            nc += ds[direction][1];
            distance--;

        }

        sharks[board[r][c]][1] = direction;

        if (nextBoard[nr][nc] != 0) {
            nextBoard[nr][nc] = sharks[board[r][c]][2] > sharks[nextBoard[nr][nc]][2] ? board[r][c] : nextBoard[nr][nc];
        } else {
            nextBoard[nr][nc] = board[r][c];
        }
    }

}

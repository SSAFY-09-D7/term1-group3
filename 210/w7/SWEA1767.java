package w7;

import java.io.*;
import java.util.*;

class Main {
    static List<Processor> ps;
    static int[][] board;
    static int[][] ds = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int N;
    static int maxOnCnt, minLineCnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_SWEA1767.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            ps = new ArrayList<>();
            maxOnCnt = 0;
            minLineCnt = Integer.MAX_VALUE;
            N = sc.nextInt();
            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        ps.add(new Processor(i, j));
                    }
                }
            }

            find(0, 0, 0);

            System.out.println("#" + tc + " " + minLineCnt);
        }
    }

    private static void find(int depth, int lineCnt, int onCnt) {
        if (onCnt + (ps.size() - depth) < maxOnCnt)
            return;

        if (depth == ps.size()) {
            if (onCnt > maxOnCnt) {
                maxOnCnt = onCnt;
                minLineCnt = lineCnt;

            } else if (onCnt == maxOnCnt && lineCnt < minLineCnt) {
                minLineCnt = lineCnt;

            }
            return;
        }

        Processor p = ps.get(depth);

        for (int i = 0; i < 4; i++) {
            int size = measure(p, i);
            if (size == -1) {
                find(depth + 1, lineCnt, onCnt);
            } else {
                fill(p, i, size, 1);
                find(depth + 1, lineCnt + size, onCnt + 1);
                fill(p, i, size, 0);
            }
        }
    }

    private static int measure(Processor p, int dir) {
        int cnt = 0;
        int nr = p.r + ds[dir][0];
        int nc = p.c + ds[dir][1];

        while (true) {
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                return cnt;
            }

            if (board[nr][nc] != 0)
                return -1;

            cnt++;
            nr += ds[dir][0];
            nc += ds[dir][1];
        }
    }

    private static void fill(Processor p, int dir, int size, int val) {
        int nr = p.r + ds[dir][0];
        int nc = p.c + ds[dir][1];

        for (int i = 0; i < size; i++) {
            board[nr][nc] = val;
            nr += ds[dir][0];
            nc += ds[dir][1];
        }
    }

    static class Processor {
        int r, c;

        public Processor(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

}
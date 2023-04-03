package w12;

import java.util.*;
import java.io.*;

class Solution {
    static int N, result, startR, startC, endR, endC;
    static int[][] board;
    static int[][] ds = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_SWEA4193.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endR = Integer.parseInt(st.nextToken());
            endC = Integer.parseInt(st.nextToken());

            bfs();

            sb.append("#" + tc + " " + result + "\n");
        }

        System.out.println(sb);
    }

    static private void bfs() {
        boolean[][][] visited = new boolean[N][N][3];
        Queue<Point> q = new LinkedList<>();
        visited[startR][startC][0] = true;
        q.add(new Point(startR, startC, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == endR && p.c == endC) {
                result = p.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + ds[i][0];
                int nc = p.c + ds[i][1];
                int turn = (p.cnt + 1) % 3;

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1 || visited[nr][nc][turn])
                    continue;

                if ((board[nr][nc] == 2 && turn == 0) || board[nr][nc] == 0) {
                    visited[nr][nc][turn] = true;
                    q.add(new Point(nr, nc, p.cnt + 1));
                    continue;
                }

                visited[p.r][p.c][turn] = true;
                q.add(new Point(p.r, p.c, p.cnt + 1));
            }

        }

        result = -1;
    }

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

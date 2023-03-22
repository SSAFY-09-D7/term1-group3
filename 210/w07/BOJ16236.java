package w07;

import java.io.*;
import java.util.*;

class Main {
    static int N, size = 2, needs = 2;
    static int[][] board;
    static int[][] ds = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ16236.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int currR = -1, currC = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    currR = i;
                    currC = j;
                }
            }
        }

        int cnt = 0;
        while (true) {
            Point nextPoint = bfs(currR, currC);
            if (nextPoint.r == -1 && nextPoint.c == -1)
                break;
            cnt += nextPoint.cnt;

            currR = nextPoint.r;
            currC = nextPoint.c;
        }
        System.out.println(cnt + " ");

    }

    private static Point bfs(int startR, int startC) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC, 0));
        boolean[][] visited = new boolean[N][N];

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int minCnt = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.r][p.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + ds[i][0];
                int nc = p.c + ds[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || board[nr][nc] > size)
                    continue;

                if (board[nr][nc] != 0 && board[nr][nc] < size) {
                    if (minCnt > p.cnt + 1) {
                        minR = nr;
                        minC = nc;
                        minCnt = p.cnt + 1;

                    } else if (minCnt >= p.cnt + 1 && nr < minR) {
                        minR = nr;
                        minC = nc;
                        minCnt = p.cnt + 1;
                    } else if (minCnt >= p.cnt + 1 && nr == minR && nc < minC) {
                        minR = nr;
                        minC = nc;
                        minCnt = p.cnt + 1;
                    }
                }

                q.add(new Point(nr, nc, p.cnt + 1));
            }
        }

        if (minR == Integer.MAX_VALUE && minC == Integer.MAX_VALUE)
            return new Point(-1, -1, 0);

        needs--;
        if (needs == 0) {
            size++;
            needs = size;
        }
        board[startR][startC] = 0;
        board[minR][minC] = 9;
        return new Point(minR, minC, minCnt);
    }

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
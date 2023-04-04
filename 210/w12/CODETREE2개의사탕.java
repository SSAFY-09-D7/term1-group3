package w12;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, RC, RR, BC, BR;
    static char[][] board;
    static int[][] ds = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'R') {
                    RR = i;
                    RC = j;
                    board[i][j] = '.';
                }

                else if (board[i][j] == 'B') {
                    BR = i;
                    BC = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(new State(RR, RC, BR, BC, 0));

        while(!q.isEmpty()) {
            State s = q.poll();

            if (s.cnt == 10) return -1;

            for (int i = 0; i < 4; i++) {
                State ns = move(s, i);

                if (ns.rr == -1 || ns.br == -1) continue;
                if (s.rr == ns.rr && s.rc == ns.rc && s.br == ns.br && s.bc == ns.bc) continue;
                if (ns.rr == -5 || ns.br == -5) return s.cnt + 1;
                q.add(ns);
            }
        }     

        return -1;
    }

    private static State move(State s, int d) {
        if ((d == 0 && s.rc > s.bc) || (d == 1 && s.rc < s.bc) || (d == 2 && s.rr > s.br) || (d == 3 && s.rr < s.br)) {
            int[] rtmp = push(s.rr, s.rc, d);
            if(rtmp[0] != -5) board[rtmp[0]][rtmp[1]] = '#';

            int[] btmp = push(s.br, s.bc, d);
            if(rtmp[0] != -5) board[rtmp[0]][rtmp[1]] = '.';

            if (btmp[0] == -5) return new State(-1, -1, -1, -1, -1);
            if (rtmp[0] == -5) return new State(-5, -5, -5, -5, -5);
            return new State(rtmp[0], rtmp[1], btmp[0], btmp[1], s.cnt+1);
        }

        int[] btmp = push(s.br, s.bc, d);
        if(btmp[0] == -5) return new State(-1, -1, -1, -1, -1);
        board[btmp[0]][btmp[1]] = '#';

        int[] rtmp = push(s.rr, s.rc, d);
        board[btmp[0]][btmp[1]] = '.';

        return new State(rtmp[0], rtmp[1], btmp[0], btmp[1], s.cnt+1);
    }

    private static int[] push(int r, int c, int d) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += ds[d][0];
            nc += ds[d][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == '#') return new int[]{ nr-ds[d][0], nc-ds[d][1] };
            if (board[nr][nc] == 'O') return new int[]{-5, -5};  // 구멍
        }
    }

    static class State {
        int rr, rc, br, bc, cnt;

        public State(int rr, int rc, int br, int bc, int cnt) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.cnt = cnt;
        }
    }
}

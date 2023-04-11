package w13;

import java.util.*;

class Solution {
    int N, M, startR, startC;
    char[][] board;
    boolean[][][] visited;
    int[][] ds = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        board = new char[N][M];
        visited = new boolean[N][M][2];
        
        for (int i = 0; i < N; i++) {
            board[i] = maps[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'S') {
                    startR = i;
                    startC = j;
                    continue;
                }
            }
        }
        
        return bfs();
    }
    
    private int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC, 0, 0));
        visited[startR][startC][0] = true;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = p.r + ds[i][0];
                int nc = p.c + ds[i][1];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][p.open] || board[nr][nc] == 'X') continue;
                
                if (board[nr][nc] == 'L') {
                    visited[nr][nc][1] = true;
                    q.add(new Point(nr, nc, p.cnt+1, 1));
                    continue;
                }
                
                if (p.open == 1 && board[nr][nc] == 'E') {
                    return p.cnt+1;
                }
                
                visited[nr][nc][p.open] = true;
                q.add(new Point(nr, nc, p.cnt+1, p.open));                
            }
        }
        
        return -1;
    }
    
    class Point {
        int r, c, cnt, open;
        
        public Point(int r, int c, int cnt, int open) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.open = open;
        }
    }
}

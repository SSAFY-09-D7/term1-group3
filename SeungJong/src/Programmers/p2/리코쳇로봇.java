package Programmers.p2;

import java.util.*;
class Solution {
    static char[][] map;
    static int Ans, R, C, endR, endC;
    public int solution(String[] board) {
        R = board.length;
        C = board[0].length();
        map = new char[R][C];
        int startR = -1;
        int startC = -1;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = board[i].charAt(j); 
                if(map[i][j] == 'R') {
                    startR = i;
                    startC = j;
                }
                else if(map[i][j] == 'G') {
                    endR = i;
                    endC = j;
                }
            }
        }
        bfs(startR, startC);
        return Ans==0?-1:Ans;
    }
    private static void bfs(int startR, int startC){
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(startR, startC, 0));
        boolean[][] v = new boolean[R][C];
        v[startR][startC] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.r == endR && p.c == endC) {
                Ans = p.cnt;
                return;
            }
            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                
                while(true){
                    if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc] == 'D'){
                        nr -= dr[i];
                        nc -= dc[i];
                        break;
                    }
                    nr += dr[i];
                    nc += dc[i];
                }
                if(v[nr][nc]) continue;
                v[nr][nc] = true;
                queue.offer(new Point(nr, nc, p.cnt+1));
            }
        }
    }
    private static class Point{
        int r, c, cnt;
        public Point(int r, int c,int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
}
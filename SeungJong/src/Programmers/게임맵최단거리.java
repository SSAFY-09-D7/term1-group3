package Programmers;

import java.util.*;
public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    private static int bfs(int[][] map){
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(0, 0, 1));
        boolean[][] v = new boolean[map.length][map[0].length];
        v[0][0] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.r == map.length-1&& p.c == map[0].length-1){
                return p.cnt;
            }
            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || v[nr][nc] || map[nr][nc] == 0) continue;
                v[nr][nc] = true;
                queue.offer(new Point(nr, nc, p.cnt+1));
            }
        }
        return -1;
    }
    private static class Point{
        int r, c, cnt;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
}
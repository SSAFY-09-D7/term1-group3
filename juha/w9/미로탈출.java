import java.util.*;
import java.io.*;

class Solution {
    static char[][] map;
    static int minE, minL;
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[i].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i = 0; i<map.length;i++){
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j] == 'S' || map[i][j]=='L'){
                    int a = bfs(i, j, map[i][j]);
                    if(a == -1) return -1;
                    else answer += a;
                }
            }
        }
        return answer;
    }
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Point{
        int r, c, cnt;
        public Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public int bfs(int r, int c, char n){
        if(n == 'S') n = 'L';
        else if(n == 'L') n = 'E';
        Queue<Point> queue = new LinkedList<>();
        boolean[][] v = new boolean[map.length][map[0].length];
        queue.offer(new Point(r, c, 0));
        v[r][c] = true;
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int d = 0; d<4; d++){
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length && !v[nr][nc] && map[nr][nc] != 'X'){
                    if(map[nr][nc] == n){
                        return p.cnt+1;
                    }
                    v[nr][nc] = true;
                    queue.offer(new Point(nr, nc, p.cnt+1));
                    
                }
            }
        }
        
        return -1;
    }
}

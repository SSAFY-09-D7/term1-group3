package w16;

import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] am = new boolean[51][51];
        int[][] pm = new int[51][51];
        int[][] ds = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for (int[] rec : rectangle) {
            for (int i = rec[1]; i < rec[3]; i++) {
                for (int j = rec[0]; j < rec[2]; j++) {
                    am[i][j] = true;
                }
            }
        }
        
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[51][51];
        q.add(new Point(characterY, characterX, 0));
        visited[characterY][characterX] = true;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            boolean[] isArea = new boolean[5];
            if (inRange(p.r-1, p.c) && am[p.r-1][p.c]) isArea[1] = true;
            if (inRange(p.r-1, p.c-1) && am[p.r-1][p.c-1]) isArea[2] = true;
            if (inRange(p.r, p.c-1) && am[p.r][p.c-1]) isArea[3] = true;
            if (am[p.r][p.c]) isArea[4] = true;
            
            for (int d = 0; d < 4; d++) {
                int nr = p.r + ds[d][0];
                int nc = p.c + ds[d][1];
                
                if (!inRange(nr, nc) || visited[nr][nc]) continue;
                
                if ((d == 0 && ((!isArea[1] && isArea[4]) || (isArea[1] && !isArea[4])))
                    || (d == 1 && ((!isArea[3] && isArea[4]) || (isArea[3] && !isArea[4])))
                    || (d == 2 && ((!isArea[2] && isArea[3]) || (isArea[2] && !isArea[3])))
                    || (d == 3 && ((!isArea[1] && isArea[2]) || (isArea[1] && !isArea[2])))) {
                    
                    if (nr == itemY && nc == itemX) return p.cnt + 1;
                    
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, p.cnt + 1));
                }
            }
        }

        return 0;
    }
    
    boolean inRange(int r, int c) {
        return r < 51 && r >=0 && c < 51 && c >= 0;
    } 
    
    class Point {
        int r, c, cnt;
        
        public Point (int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

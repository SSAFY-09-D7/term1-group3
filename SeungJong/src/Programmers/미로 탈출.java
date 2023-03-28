import java.util.*;

class Solution {
    static boolean[][][] v;
    static int Ans;
    public int solution(String[] maps) {
        v = new boolean[maps.length][maps[0].length()][2];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S') {
                    bfs(i, j, maps);
                }
            }
        }
        
        int answer = Ans==0?-1:Ans;
        return answer;
    }
    private static void bfs(int r, int c, String[] maps){
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(r, c, 0, false));
        v[r][c][0] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(!p.flag){
                for(int i=0; i<4; i++){
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                
                    if(nr<0 || nc<0 || nr>=maps.length || nc>=maps[0].length() || v[nr][nc][0]) continue;
                    if(maps[nr].charAt(nc) == 'L'){
                        v[nr][nc][0] = true;
                        queue.offer(new Point(nr, nc, p.cnt+1, true));
                    }
                    else if(maps[nr].charAt(nc) == 'O' || maps[nr].charAt(nc) == 'E'){
                        v[nr][nc][0] = true;
                        queue.offer(new Point(nr, nc, p.cnt+1, p.flag));
                    }
                }              
            } else {
                for(int i=0; i<4; i++){
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                
                    if(nr<0 || nc<0 || nr>=maps.length || nc>=maps[0].length() || v[nr][nc][1]) continue;
                    if(maps[nr].charAt(nc) != 'X'){
                        if(maps[nr].charAt(nc) == 'E'){
                            Ans = p.cnt+1;
                            return;
                        }
                        v[nr][nc][1] = true;
                        queue.offer(new Point(nr, nc, p.cnt+1, p.flag));
                    }                    
                }
            }           
        }
    }
    
    private static class Point{
        int r, c, cnt;
        boolean flag;
        Point(int r, int c, int cnt, boolean flag){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.flag = flag;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
}
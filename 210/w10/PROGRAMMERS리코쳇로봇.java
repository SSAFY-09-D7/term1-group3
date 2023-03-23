mport java.util.*;

class Solution {
    int H, W, result = Integer.MAX_VALUE;
    char[][] charBoard;
    boolean[][] visited;
    int[][] ds = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int startR = -1, startC = -1, endR = -1, endC = -1;
    public int solution(String[] board) {
        int answer = 0;
        H = board.length;
        W = board[0].length();
        charBoard = new char[H][W];
        visited = new boolean[H][W];
        
        for (int i = 0; i < H; i++) {
            charBoard[i] = board[i].toCharArray();
            for (int j = 0; j < W; j++) {
                if (startR == -1 && charBoard[i][j] == 'R') {
                    startR = i;
                    startC = j;
                }
                
                else if (endR == -1 && charBoard[i][j] == 'G') {
                    endR = i;
                    endC = j;
                }
            }
        }
        
        bfs();
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC, 0));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.r][p.c] = true;
            
            if (p.r == endR && p.c == endC) {
                result = Math.min(result, p.cnt);
            }
            
            for (int i = 0; i < 4; i++) {
                int[] next = move(p.r, p.c, i);
                int nr = next[0];
                int nc = next[1];
                
                if (p.r == nr && p.c == nc) continue;
                if (visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, p.cnt+1));
            }
        }
        
    }
    
    private int[] move(int r, int c, int d) {
        int nr = r;
        int nc = c;
        
        while (true) {
            nr += ds[d][0];
            nc += ds[d][1];
            
            if ( nr < 0 || nr >= H || nc < 0 || nc >= W || charBoard[nr][nc] == 'D') {
                return new int[] {nr-ds[d][0], nc -ds[d][1]};
            }
        }
    }
    
    class Point {
        int r, c, cnt;
        
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

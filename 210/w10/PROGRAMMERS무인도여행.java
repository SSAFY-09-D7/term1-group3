package w10;

import java.util.*;

class Solution {
    int[][] ds = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int H, W;
    boolean[][] visited;
    char[][] board;
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        H = maps.length;
        W = maps[0].length();
        board = new char[H][W];
        visited = new boolean[H][W];
        
        for (int i = 0; i < H; i++) {
            board[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if (answer.size() == 0) answer.add(-1);
        else Collections.sort(answer);
        return answer;
    }
    
    private int bfs(int r, int c) {
        int sum = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            sum += (board[p.r][p.c]-'0');
            visited[p.r][p.c] = true;
            
            for (int i = 0; i < 4; i++) {
                int nr = p.r + ds[i][0];
                int nc = p.c + ds[i][1];
                
                if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc] || board[nr][nc] == 'X') continue;
                
                visited[nr][nc] = true;
                q.add(new Point(nr, nc));
            }
        }
        
        return sum;
    }
    
    class Point {
        int r, c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
}

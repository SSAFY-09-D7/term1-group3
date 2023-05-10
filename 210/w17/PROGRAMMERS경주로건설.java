package w17;

import java.util.*;

class Solution {
    int[][] ds = {{0,1}, {1,0}, {0,-1}, {-1,0}};    // 좌, 하, 우, 상
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        boolean[][][] visited = new boolean[N][N][4];
        
        Queue<State> q = new PriorityQueue<>();
        q.add(new State(0,0,0,0));
        q.add(new State(0,0,1,0)); 
        while(!q.isEmpty()) {
            State s = q.poll();
            
            if (s.r == N - 1 && s.c == N - 1 && s.cost < answer) answer = s.cost;
            
            for (int i = 0; i < 4; i++) {
                if ((s.prevD + 2) % 4 == i) continue;
                int nr = s.r + ds[i][0];
                int nc = s.c + ds[i][1];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) continue;
                
                int nextCost = i == s.prevD ? 100 + s.cost : 600 + s.cost;
                if (!visited[nr][nc][i] || board[nr][nc] >= nextCost) {
                    q.add(new State(nr, nc, i, nextCost));
                    board[nr][nc] = nextCost;
                    visited[nr][nc][i] = true;
                }
            }
        }
        
        return answer;
    }
    
    class State implements Comparable<State> {
        int r, c, prevD, cost;
        
        public State(int r, int c, int prevD, int cost) {
            this.r = r;
            this.c = c;
            this.prevD = prevD;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(State s) {
            return this.cost - s.cost;
        }
    }

}

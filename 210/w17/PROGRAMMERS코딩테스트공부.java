package w17;

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int alpMax = -1, copMax = -1;
        boolean[][] visited = new boolean[151][151];
        
        for (int[] p : problems) {
            if (alpMax < p[0]) alpMax = p[0];
            if (copMax < p[1]) copMax = p[1];
        }
        
        Queue<State> q = new PriorityQueue<>();
        q.add(new State(alp, cop, 0));
        
        while(!q.isEmpty()) {
            State s = q.poll();
            if (s.alp > 150) s.alp = 150;
            if (s.cop > 150) s.cop = 150;
            if (visited[s.alp][s.cop]) continue;
            
            visited[s.alp][s.cop] = true;
            if (s.alp >= alpMax && s.cop >= copMax) return s.time;
            
            for (int[] p : problems) {
                if (s.alp >= p[0] && s.cop >= p[1]) q.add(new State(s.alp + p[2], s.cop + p[3], s.time + p[4]));
                if (p[0] > s.alp) q.add(new State(p[0], s.cop, s.time + (p[0] - s.alp)));
                if (p[1] > s.cop) q.add(new State(s.alp, p[1], s.time + (p[1] - s.cop)));
            }
        }
        
        return -1;
    }
    
    class State implements Comparable<State> {
        int alp, cop, time;
        
        public State(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }
        
        @Override
        public int compareTo(State s) {
            return this.time - s.time;
        }
    }
}

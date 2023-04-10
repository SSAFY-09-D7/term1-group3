package w13;

import java.util.*;

class Solution {
    List<Integer>[] edges;
    int V;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        V = n;
        
        edges = new List[n+1];
        
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        
        for (int[] wire : wires) {
            edges[wire[0]].add(wire[1]);
            edges[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int diff = getDiff(wire[0], wire[1]);
            answer = Math.min(diff, answer);
        }
        
        return answer;
    }
    
    private int getDiff(int aStart, int bStart) {
        boolean visited[] = new boolean[V+1];
        visited[aStart] = true;
        visited[bStart] = true;
        
        Queue<Integer> q = new LinkedList<>();
        
        int aCnt = 0;
        int bCnt = 0;
        
        q.add(aStart);
        while (!q.isEmpty()) {
            int curr = q.poll();
            aCnt++;
            
            for (int next : edges[curr]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
        
        q.add(bStart);
        while (!q.isEmpty()) {
            int curr = q.poll();
            bCnt++;
            
            for (int next : edges[curr]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
        
        
        if (aCnt + bCnt < V) return Integer.MAX_VALUE;
        return Math.abs(aCnt - bCnt); 
    }
}

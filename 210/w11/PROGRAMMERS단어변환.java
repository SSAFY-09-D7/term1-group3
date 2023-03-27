package w11;

import java.util.*;

class Solution {
    int answer = 0;
    List<Integer>[] edges;
    String[] ws;
    public int solution(String begin, String target, String[] words) {
        int targetIdx = -1;
        edges = new ArrayList[words.length + 1];
        ws = new String[words.length + 1];
        System.arraycopy(words, 0, ws, 0, words.length);
        ws[words.length] = begin;
        
        for (int i = 0; i <= words.length; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < ws.length - 1; i++) {
            if (ws[i].equals(target)) targetIdx = i;
            for (int j = i + 1; j < ws.length; j++) {
                if (canConnect(ws[i], ws[j])) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        
        if (targetIdx == -1) return 0;
        
        return bfs(targetIdx);
    }
    
    private boolean canConnect(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
    
    private int bfs(int targetIdx) {
        boolean[] visited = new boolean[ws.length + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(ws.length - 1);
        visited[ws.length - 1] = true;
        
        int depth = 0;
        int nextSize = 1;
        int currDepthLeft = nextSize;
        while(!q.isEmpty()) {
            Integer curr = q.poll();    
            
            visited[curr] = true;
            currDepthLeft--;
            if (currDepthLeft == 0) {
                depth++;
                currDepthLeft = nextSize;
                nextSize = 0;
            }
            
            for (Integer next : edges[curr]) {
                int tmp = 0;
                if (!visited[next]) {
                    if (next == targetIdx) return depth;
                    nextSize++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        
        return 0;
    }
}

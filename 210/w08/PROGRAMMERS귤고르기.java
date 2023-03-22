package w08;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Tang> q = new PriorityQueue<>(Comparator.comparing(Tang::getCnt).reversed());
        for (Integer key : map.keySet()) {
            q.add(new Tang(key, map.get(key)));
        } 
        
        int answer = 0;
        int currK = k;
        while(true) {
            if (currK <= 0) break;
            
            Tang t = q.poll();
            answer++;
            currK -= t.cnt;
        }
        
        return answer;
    }
    
    class Tang {
        int num;
        int cnt = 0;
        
        public Tang(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        
        public int getCnt() {
            return this.cnt;
        }
    }
}

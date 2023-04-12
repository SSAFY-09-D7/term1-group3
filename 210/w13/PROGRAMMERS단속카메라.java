package w13;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Integer last = null;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        
        for (int[] route : routes) {
            if (last == null) {
                last = route[1];
                answer++;
                continue;
            }
            
            if (last >= route[0] && last <= route[1]) {
                continue;
            }
            
            last = route[1];
            answer++;
        }        
        
        return answer;
    }
}

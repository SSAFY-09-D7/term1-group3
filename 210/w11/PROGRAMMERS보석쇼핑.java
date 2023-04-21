import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        int minLength = Integer.MAX_VALUE;
        int targetCnt = -1;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String str : gems)
            set.add(str);
        
        targetCnt = set.size();
        
        int left = 0;
        int right = 1;
        map.put(gems[0], 1);
        while(left < right) { 
            if (right == gems.length) {                
                if (map.size() == targetCnt && right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                if (map.get(gems[left]) == 1) map.remove(gems[left]);
                else map.put(gems[left], map.get(gems[left]) - 1);
                
                left++;
                continue;
            }
            
            if (map.size() == targetCnt) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
            
                if (map.get(gems[left]) == 1) map.remove(gems[left]);
                else map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }
            
            if (map.size() < targetCnt) {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
                continue;
            }
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, 1};
        int minLength = Integer.MAX_VALUE;
        Map<String, Integer> sel = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (String str : gems)
            set.add(str);
        int needs = set.size();
        
        int left = 0, right = 0;
        
        while (true) {
            if (sel.size() == needs) {
                if (sel.get(gems[left]) > 1) {
                    sel.put(gems[left], sel.get(gems[left]) - 1);
                } else sel.remove(gems[left]);
                
                left++;
            }
            
            else if (right < gems.length - 1) {
                right++;
                sel.put(gems[right], sel.getOrDefault(gems[right], 0) + 1);
            }
            
            else break;
            
            if (sel.size() == needs && Math.abs(right - left) < minLength) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                minLength = Math.abs(right - left);
            }
        }
        
        return answer;
    }
}

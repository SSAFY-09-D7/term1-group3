package w09;

import java.util.*;

class Solution {
    Object[] keys;
    int answer = 0;
    Map<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {        
        for (String[] c : clothes)
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        
        keys = map.keySet().toArray();
        
        powerset(0, 0);
        
        return answer;
    }
    
    private void powerset(int tmp, int idx) {
        if (idx == keys.length) {
            answer += tmp;
            return;  
        } 
        
        powerset(tmp, idx+1);
        tmp = tmp == 0 ? 1 : tmp;
        powerset(tmp *= map.get(keys[idx]), idx+1);
    }
}

package w11;

import java.util.*;

class Solution {
    
    List<Integer>[] possibles;
    Set<String> combis = new HashSet<>();
    int banSize = 0;
    public int solution(String[] user_id, String[] banned_id) {
        banSize = banned_id.length;
        possibles = new List[banSize];
        
        for (int i = 0; i < banSize; i++) {
            possibles[i] = new ArrayList<>();
        }
         
        for (int i = 0; i < banSize; i++) {
            String target = banned_id[i].replace("*", "\\w");
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].matches(target)) {
                    possibles[i].add(j);
                }
            }
        }
        
        find(0, new HashSet<>());
        return combis.size();
    }
    
    private void find(int depth, Set<Integer> tmp) {
        if (depth == banSize) {
            combis.add(tmp.toString());
            return;
        } 
        
        for (Integer num : possibles[depth]) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            find(depth + 1, tmp);
            tmp.remove(num);
        }
    }
}

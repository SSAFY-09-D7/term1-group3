import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] cards) {

        boolean[] visited = new boolean[cards.length];
        List<Integer> group = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            int cnt = 0;
            int k = i;
            while (true) {
                if (!visited[k]) {
                    visited[k] = true;
                    k = cards[k] - 1;
                    cnt++;
                } else {
                    if (cnt != 0) group.add(cnt);
                    break;
                }
            }
        }

        if (group.size() == 1) {
            return 0;
        }
        
        Collections.sort(group);
        Collections.reverse(group);
        return group.get(0) * group.get(1);


    }

}

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Set<Integer> set = new HashSet<>();
        set.add(x);
        
        int cnt = 0;
        while (true) {
            if (set.size() == 0) return -1;
            Set<Integer> tmp = new HashSet<>();
            for (Integer num : set) {
                if (num == y) return cnt;
                if (num + n <= y) tmp.add(num + n);
                if (num * 2 <= y) tmp.add(num * 2);
                if (num * 3 <= y) tmp.add(num * 3);
            }
            cnt++;
            set = tmp;
        }
    }
}

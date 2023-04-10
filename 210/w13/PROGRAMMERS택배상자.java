import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int currPullNum = 1;
        Stack<Integer> sub = new Stack<>();
        
        for (int num : order) {            
            if (num == currPullNum) {
                currPullNum++;
                answer++;
                continue;
            }
            
            if (!sub.isEmpty() && num == sub.peek()) {
                sub.pop();
                currPullNum++;
                answer++;
                continue;
            }
            
            if (sub.isEmpty() || num > sub.peek()) {
                while (currPullNum < num) {
                    sub.push(currPullNum++);
                }
                currPullNum++;
                answer++;
                continue;
            }
            
            if (!sub.isEmpty() && num < sub.peek()) break;
        }

        return answer;
    }
}

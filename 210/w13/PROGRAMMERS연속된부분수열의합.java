package w13;

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 1, sum = sequence[0];
        
        while (left < right) {
            if (sum < k && right < sequence.length) {
                sum += sequence[right];
                right++;
                continue;
            }
            
            if (sum == k && minLength > right - left) {
                minLength = right - left;
                answer[0] = left;
                answer[1] = right - 1;
            }
            
            sum -= sequence[left];
            left++;
        }
        
        return answer;
    }
}

package w13;

import java.util.*;

class Solution {
    boolean[] isRemoved;
    int size;
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        size = number.length();
        isRemoved = new boolean[size];
        int cnt = 0;
        
        for (int i = 0; i < size - 1; i++) {
            if (isRemoved[i]) continue;
            if (number.charAt(i) < number.charAt(getNextIdx(i))) {
                isRemoved[i] = true;
                i = getPrevIdxFront(i);
                cnt++;
            }
            if (cnt == k) break;
        }
        
        if (cnt < k) {
            for (int i = 0; i <= k - cnt; i++) {
                isRemoved[size - i - 1] = true;
            }
        }
        
        for (int i = 0; i < size; i++) {
            if (isRemoved[i]) continue;
            answer.append(number.charAt(i));
        }
        
        return answer.toString();
    }
    
    private int getPrevIdxFront(int currIdx) {
        if (currIdx == 0) return -1;
        for (int i = currIdx - 1; i >= 0; i--) {
            if (!isRemoved[i]) return i-1;
        }
        return -1; 
        
    }
    
    private int getNextIdx(int currIdx) {
        for (int i = currIdx + 1; i < size; i++) {
            if (!isRemoved[i]) return i;
        }
        return size - 1;
    }
}

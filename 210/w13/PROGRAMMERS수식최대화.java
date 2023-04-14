package w13;

import java.util.*;

class Solution {
    int[][] grades = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};    // *+-
    Deque<Long> ns = new ArrayDeque<>();
    Deque<Character> os = new ArrayDeque<>();
    int T = -1;
    long answer = -1;
    char[] ops;
    int[] nums;
    public long solution(String expression) {
        String numStr = expression.replaceAll("[*+-]", " ");
        String[] numStrs = numStr.split(" ");
        ops = expression.replaceAll("[0-9]", "").toCharArray();

        nums = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }
        
        for (int i = 0; i < 6; i++) {
            T = i;
            answer = Math.max(getResult(), answer);
        }
        
        return answer;
    }
    
    private long getResult() {
        ns.push(Long.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++) {            
            while (!os.isEmpty() && grade(os.peek()) >= grade(ops[i-1])) {
                Long a = ns.pop();
                Long b = ns.pop();
                ns.push(calc(b, a, os.pop()));
            }
            
            ns.push(Long.valueOf(nums[i]));
            os.push(ops[i-1]);
        }
        
        while (!ns.isEmpty()) {
            Long a = ns.pop();
            Long b = ns.pop();
            ns.push(calc(b, a, os.pop()));
            if (ns.size() == 1) break;
        }
        
        return Math.abs(ns.pop());
    }
    
    private Long calc(Long a, Long b, char c) {
        if (c == '*') return Long.valueOf(a * b);
        if (c == '+') return Long.valueOf(a + b);
        return Long.valueOf(a - b);
    }
    
    private int grade(char c) {
        int idx = c == '*' ? 0 : c == '+' ? 1 : 2;
        return grades[T][idx];
    }
    
    
}

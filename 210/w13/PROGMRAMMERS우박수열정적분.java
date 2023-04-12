package w13;

import java.util.*;

class Solution {
    double[] dp;
    public double[] solution(int k, int[][] ranges) {
        List<Integer> nums = new ArrayList<>();
        double[] answer = new double[ranges.length];
        
        int num = k;
        while (num > 1) {
            nums.add(num);
            if (num % 2 == 0) num /= 2;
            else num = num * 3 + 1;
        }
        nums.add(1);
        
        double sum = 0;
        dp = new double[nums.size()];
        for (int i = 1; i < nums.size(); i++) {
            sum += (nums.get(i) + nums.get(i-1)) / 2.0;
            dp[i] = sum;
        }
        
    for (int i = 0; i < ranges.length; i++)
        answer[i] = getSum(ranges[i][0], ranges[i][1]); 
        
        return answer;
    }
    
    private double getSum(int a, int b) {
        int endIdx = dp.length + b - 1;
        if (a > endIdx) return -1.0;
        return dp[endIdx] - dp[a];
    }
}

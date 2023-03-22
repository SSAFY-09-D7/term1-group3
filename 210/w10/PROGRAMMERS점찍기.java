package w10;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        double powD = Math.pow(d, 2);
        
        for (int y = 0; y <= d; y += k) {
            double currXMax = Math.sqrt(powD - Math.pow(y, 2));
            answer += Math.ceil(currXMax / k) + (currXMax % k == 0 ? 1 : 0);
        }

        return answer;
    }
}

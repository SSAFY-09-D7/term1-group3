package w13;

class Solution {
    public int solution(int storey) {        
        return find(storey);
    }
    
    private int find(int target) {
        if (target < 10) return target <= 5 ? target : 10 - target + 1;
        
        int up = 10 - (target % 10);
        int down = (target % 10);
        
        int a = up + find(((target + up) / 10));
        int b = down + find((target / 10));
        
        return Math.min(a, b);
    }
}

class Solution {
    String str;
    int size = 0;
    public int solution(String name) {
        int answer = 0;
        
        str = name;
        size = str.length();
        
        for (int i = 0; i < size; i++) {
            answer += getCurrCnt('A', str.charAt(i));
        }
        
        return getVerticalCnt() + answer;
    }
    
    private int getVerticalCnt() {
        int maxLen = 0;
        int currLen = 0;
        int i = 0;
        for (; i < size; i++) {
            if (str.charAt(i) == 'A') {
                currLen++;
                continue;
            }
            
            maxLen = Math.max(currLen, maxLen);
            currLen = 0;
        }
        
        if (currLen != 0) {
            while (str.charAt(getNextIdx(i, 1)) == 'A') {
                i = getNextIdx(i, 1);
                currLen++;
            }
        }
        maxLen = Math.max(currLen, maxLen);
        
        return size - maxLen - 1;
    }
    
    private int getNextIdx(int i, int d) {
        return i+d < 0 ? size - 1 : i+d >= size ? 0 : i+d;
    }
    
    private int getCurrCnt(char a, char b) {
        int gap = Math.abs((int) a - (int) b);
        int outerGap = 26 - gap;
        return Math.min(gap, outerGap);
    }
}

package w08;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int currNum = 0;
        int idx = 0;
        int targetIdx = p-1;
        int currT = 0;
        while(currT < t) {
            String currString = toStringNum(currNum++, n);
            while (targetIdx < idx + currString.length()) {
                answer += currString.charAt(targetIdx - idx);
                targetIdx += m;
                currT++;
                if (currT >= t) break;
            }
            idx += currString.length();
        }
        
        return answer;
    }
    
    private String toStringNum(int num, int n) {
        String result = "";
        int currNum = num;
        
        while(currNum > 0) {
            int tmp = currNum % n;
            char c = tmp >= 10 ? (char)('A' + (tmp - 10)) : (char)('0' + tmp);
            result = c + result;
            currNum /= n;
        }
        
        return result.equals("") ? "0" : result;
    }
}

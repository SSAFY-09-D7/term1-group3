package w11;

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Integer answer = null;
        
        Arrays.sort(data, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(data, (o1, o2) -> o1[col-1] - o2[col-1]);
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int tmp = 0;
            
            for (int j = 0; j < data[0].length; j++)
                tmp += (data[i][j] % (i+1));
            
            answer = answer == null ? tmp : answer ^ tmp;
        }
        
        
        return answer;
    }
}

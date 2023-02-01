import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        String[] digit = {"zero", "one", "two", "three", "four", "five", "six",
                             "seven", "eight", "nine"};
        int answer;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) >= 'a'){
                for(int j = 0;j<10;j++){
                    if(i == s.indexOf(digit[j], i)){
                        s = s.replace(digit[j], Integer.toString(j));
                    }
                }
            }else{
                continue;
            }
        }
        answer = Integer.valueOf(s).intValue();
        return answer;
    }
}

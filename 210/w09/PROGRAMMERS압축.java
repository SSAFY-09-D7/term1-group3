package w09;

class Solution {
    public int solution(String s) {
        int answer = 1000;
        if (s.length ==1) return 1;
        
        for(int i = 1; i < s.length / 2 + 1; i++){
            String str = new String();
            String c = s.substring(0, i);
            int cnt = 1;
            
            for(int j = i; j < s.length;j += i){
                if(j+i>len){
                    if(cnt > 1) str+=cnt+comp;
                    else str+=comp;
                    c = s.substring(j);
                    cnt=1;
                    continue;
                }
                else if(c.equals(s.substring(j, j + i))) cnt++;
                else {
                    if(cnt > 1) str += cnt + comp;
                    else str += c;
                    c = s.substring(j, j + i);
                    cnt = 1;
                }
            }
            
            if (cnt > 1) str += (cnt + c);
            else str += c;
            
            if (answer > str.length()) answer = str.length();
        }
        return answer;
    }
}

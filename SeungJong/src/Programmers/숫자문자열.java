package Programmers;

public class 숫자문자열 {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", 
                       "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++) {
            s = s.replaceAll(arr[i], i+"");
        }
        
        int answer = Integer.parseInt(s);
        return answer;
    }
}

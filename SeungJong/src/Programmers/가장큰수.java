package Programmers;

import java.util.*;
public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            num[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(num, new Comparator<String>(){
            public int compare(String n1, String n2){
                return Integer.compare(Integer.parseInt(n2+n1), Integer.parseInt(n1+n2));
            }
        });
        String answer = "";
        for(int i=0; i<numbers.length; i++){
            answer+=num[i];
        }
        return answer.charAt(0)=='0'?"0":answer;
    }
}
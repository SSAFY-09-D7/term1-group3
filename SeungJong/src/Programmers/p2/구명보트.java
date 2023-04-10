package Programmers.p2;

import java.util.*;
public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        int answer = 0;
        System.out.println(Arrays.toString(people));
        while(true){
            if(start == end) {
                answer++;
                break;
            }
            else if(start>end) break;
            if(people[start] + people[end] <= limit){
                start++;
                end--;
            }
            else {
                end--;
            }
            answer++;
        }
        return answer;
    }
}
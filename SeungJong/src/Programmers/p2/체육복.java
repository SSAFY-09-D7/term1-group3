package Programmers.p2;

import java.util.*;
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(lost[j] == reserve[i]) {
                    lost[j] = -1;
                    reserve[i] = 100;
                    answer++;
                    break;
                }
            }
        }
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(lost[j] == -1) continue;
                if(lost[j]+1 == reserve[i]){
                    lost[j] = -1;
                    answer++;
                    break;
                }
                else if(lost[j]-1 == reserve[i]){
                    lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
package Programmers.p2;

import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<len; i++){
            if(progresses[i] < 100) {
                int df = (100 - progresses[i])%speeds[i]==0?(100-progresses[i])/speeds[i]:(100-progresses[i])/speeds[i]+1;
                int cnt = 0;
                for(int j=i; j<len; j++){
                    progresses[j] += speeds[j] * df;
                }
                for(int j=i; j<len; j++) {
                    if(progresses[j] >= 100) cnt++;
                    else break;
                }
                list.add(cnt);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
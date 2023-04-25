package Programmers.p2;

import java.util.*;
public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>( (o1, o2) -> Integer.compare(o2, o1));
        int answer = 0;
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            queue.offer(enemy[i]);
            if(n<0){
                if(k>0){
                    n += queue.poll();
                    k--;
                }
                else return answer;
            }
            answer++;
        }  
        return enemy.length;
    }
}

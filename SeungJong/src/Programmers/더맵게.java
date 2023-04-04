package Programmers;

import java.util.*;
public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++){
            queue.offer(scoville[i]);
        }
        int answer = 0;
        while(!queue.isEmpty()){
            int num1 = queue.poll();
            if(num1 >= K){
                queue.offer(num1);
                break;
            }
            if(queue.isEmpty()) break;
            int num2 = queue.poll();
            queue.offer(num1 + num2 * 2);
            answer++;
        }
        if(queue.isEmpty()) return -1;
        return answer;
    }
}
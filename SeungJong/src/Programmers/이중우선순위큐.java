package Programmers;

import java.util.*;
public class 이중우선순위큐 {
    static PriorityQueue<Integer>queue = new PriorityQueue<Integer>();
    static PriorityQueue<Integer>tmp = new PriorityQueue<Integer>();
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(int i=0; i<operations.length; i++){
            if(operations[i].startsWith("I")){
                queue.offer(Integer.parseInt(operations[i].substring(2)));
            }
            else if(operations[i].equals("D -1")) {
            	queue.poll();
            }
            else if(operations[i].equals("D 1")){
                removeMax();
            }
        }
        answer[1] = queue.size()>0?queue.poll():0;
        if(queue.size()>0) {
        	int num = 0;
        	while(!queue.isEmpty()) {
        		num = queue.poll();
        	}
        	answer[0] = num;
        } else {
        	answer[0] = 0;
        }
        
        return answer;
    }
    private static void removeMax(){
        while(queue.size()>1){
        	int num = queue.poll();
        	System.out.println(num);
            tmp.offer(num);
        }
        queue.clear();
        while(!tmp.isEmpty()){
        	queue.offer(tmp.poll());
        }
        tmp.clear();
    }
}
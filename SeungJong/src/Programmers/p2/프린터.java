package Programmers.p2;

import java.util.*;
public class 프린터 {
    public int solution(int[] priorities, int location) {
        int[] pr = new int[10];
        Queue<Point> queue = new LinkedList<Point>();
        for(int i=0; i<priorities.length; i++){
            if(i==location) queue.offer(new Point(priorities[i], true));
            else queue.offer(new Point(priorities[i], false));
            pr[priorities[i]]++;
        }
        int answer = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            System.out.println(p.val);
            for(int i=9; i>0; i--){
                if(pr[i]!=0){
                    if(i > p.val){
                        queue.offer(p);
                    }
                    else if(i == p.val){
                        if(p.check) return answer+1;
                        else {
                            pr[i]--;
                            answer++;
                        }
                    }
                    break;
                }
            }
        }

        return answer;
    }
    private static class Point {
        int val;
        boolean check;
        public Point(int val, boolean check){
            this.val = val;
            this.check = check;
        }
    }
}
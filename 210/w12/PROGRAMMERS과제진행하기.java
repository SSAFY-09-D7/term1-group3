package w12;

import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        Stack<Subject> s = new Stack<>();   // 과제 하다 남은 것들
        
        for (String[] sub : plans) {
            pq.add(new Subject(sub[0], sub[1], sub[2]));
        }
        
        Subject currSub = pq.poll();
        while(!pq.isEmpty()) {           
            Subject nextSub = pq.poll();
            int currEndMinute = currSub.startMinute + currSub.leftTime;
            
            if (currEndMinute <= nextSub.startMinute) {
                answer.add(currSub.name);
                
                while(!s.isEmpty()) {
                    Subject tmpSubject = s.pop();
                    
                    if (currEndMinute + tmpSubject.leftTime > nextSub.startMinute) {
                        tmpSubject.leftTime -= currEndMinute - nextSub.startMinute;
                        s.add(tmpSubject);
                        break;
                    }
                    
                    answer.add(tmpSubject.name);
                }
                
            } else {
                currSub.leftTime -= nextSub.startMinute - currSub.startMinute;
                s.add(currSub);
                System.out.println(currSub);
            }
            
            currSub = nextSub;
        }
        
        answer.add(currSub.name);
        
        while(!s.isEmpty()) {
            answer.add(s.pop().name);
        }
        
        return answer;
    }
    
    class Subject implements Comparable<Subject> {
        String name;
        int startMinute;
        int leftTime;
        
        public Subject(String name, String start, String left) {
            this.name = name;
            this.startMinute = getStartMinute(start);
            this.leftTime = Integer.parseInt(left);
        }
        
        private int getStartMinute(String str) {
            String[] times = str.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
        
        @Override
        public int compareTo(Subject s) {
            return this.startMinute - s.startMinute;
        }
        
        public String toString() {
            return "start:" + startMinute + " left:" + leftTime + " Subject:" + name;
        }
    }
}

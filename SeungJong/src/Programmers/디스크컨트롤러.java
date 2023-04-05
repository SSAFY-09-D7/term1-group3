package Programmers;

import java.util.*;
public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        PriorityQueue<Task> q = new PriorityQueue<Task>(); // 요청시간 순으로 정렬
        for(int i=0; i<jobs.length; i++){
            q.offer(new Task(jobs[i][0], jobs[i][1]));
        }
        PriorityQueue<Job> queue = new PriorityQueue<Job>(); // 소요시간 순으로 정렬
        int cnt = 0; // 기다리는 시간 포함하는 소요시간
        int time = 0; // 작업이 끝나는 시간
        while(!q.isEmpty()){
            Task t = q.poll();
            //System.out.println(t.start);
            if(time < t.start && !queue.isEmpty()){ // 작업이 비었을 때 기다리고 있는 작업이 있으면
                Job j = queue.poll();
                System.out.println(j.time);
                int diff = time>j.start?time-j.start:0;
                cnt += diff + j.time;
                time += j.time;
                queue.offer(new Job(t.start, t.time));
                continue;
            }
            if(queue.isEmpty() && time <= t.start) { // 작업이 비었을 때 요청이 들어오면
                cnt += t.time;
                time = t.start + t.time;
                System.out.println(t.time);
                continue;
            }
            queue.offer(new Job(t.start, t.time)); // 작업이 있으면 큐에 넣는다 
        }
        while(!queue.isEmpty()){
            Job j = queue.poll();
            //System.out.println(j.time);
            int diff = time>j.start?time-j.start:0;
            cnt += diff + j.time;
            time += j.time;
            System.out.println(cnt);
        }
        return (cnt)/jobs.length;
    }
    private static class Job implements Comparable<Job>{
        int start, time;
        public Job(int start, int time){
            this.start = start;
            this.time = time;
        }
        public int compareTo(Job o){
            if(this.time == o.time){
                return Integer.compare(this.start, o.start);   
            }
            return Integer.compare(this.time, o.time);
        }
    }
    private static class Task implements Comparable<Task>{
        int start, time;
        public Task(int start, int time){
            this.start = start;
            this.time = time;
        }
        public int compareTo(Task o){
            if(this.start == o.start){
                return Integer.compare(this.time, o.time);
            }
            return Integer.compare(this.start, o.start);
        }
    }
}
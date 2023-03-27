import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    static int Ans;
    public static class Point{
        int cnt, index;
        Point(int cnt, int index){
            this.cnt = cnt;
            this.index = index;
        }
    }
    public int solution(String begin, String target, String[] words) {
        list = new ArrayList[words.length+1];
        v = new boolean[words.length+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        makeGraph(begin, words);
        bfs(words, target);
        int answer = Ans;
        return answer;
    }
    private void bfs(String[] words, String target){
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(0, 0));
        v[0] = true;
        while(!queue.isEmpty()){   
            Point p = queue.poll();
            if(p.index > 0 && words[p.index-1].equals(target)) {
                Ans = p.cnt;
                return;
            }
            for(int next : list[p.index]) {
                if(!v[next]){
                    v[next] = true;
                    queue.offer(new Point(p.cnt+1, next));
                }
            }
        }
    }
    private void makeGraph(String begin, String[] words){
        for(int j=0; j<words.length; j++){
            int cnt = 0;
            for(int i=0; i<begin.length(); i++){
                if(begin.charAt(i) != words[j].charAt(i)) cnt++;
            }
            if(cnt==1) {
                list[0].add(j+1);
                list[j+1].add(0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1; j<words.length; j++){
                int cnt = 0;
                for(int k=0; k<begin.length(); k++){
                    if(words[i].charAt(k) != words[j].charAt(k)) cnt++;
                }
                if(cnt==1){
                    list[i+1].add(j+1);
                    list[j+1].add(i+1);
                }
            }
        }
        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[i].size(); j++){
                System.out.print(list[i].get(j)+" ");
            }
            System.out.println("");
        }
    }
}
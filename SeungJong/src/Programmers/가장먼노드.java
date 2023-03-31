package Programmers;

import java.util.*;
public class 가장먼노드 {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    static int Ans;
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n+1];
        v = new boolean[n+1];
        for(int i=1; i<=n; i++) list[i] = new ArrayList<Integer>();
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        bfs(1);
        int answer = Ans;
        return answer;
    }
    private static void bfs(int start){
        v[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                for(int next : list[cur]){
                    if(!v[next]) {
                        v[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        System.out.println(size);
        Ans = size;
    }
}
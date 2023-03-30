package Programmers;

import java.util.*;
public class 네트워크 {
    static int[] parents;
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for(int i=0; i<n; i++) parents[i] = i;
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++) {
                if(find(i) == find(j) || computers[i][j] == 0 ) continue;
                union(i, j);
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            if(parents[i] == i) answer++;
        }
        return answer;
    }
    private static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) parents[pa] = pb;
    }
    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
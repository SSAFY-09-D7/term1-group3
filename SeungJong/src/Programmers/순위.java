package Programmers;
/*
dfs돌려서 방문을 n-1번 하면 모두와 경기를 치뤘기 때문에
순위를 알 수 있을까?
*/
import java.util.*;
public class 순위 {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    static int[] visit;
    static ArrayList<Integer> addList;
    public int solution(int n, int[][] results) {
        list = new ArrayList[n+1];
        visit = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<results.length; i++){
            list[results[i][0]].add(results[i][1]);
        }
        for(int i=1; i<=n; i++){
            v = new boolean[n+1];
            addList = new ArrayList<Integer>();
            if(list[i].size()>0) dfs(i);
            for (int j = 0; j < addList.size(); j++) {
				if(!list[i].contains(addList.get(j))) list[i].add(addList.get(j));
			}
        }
        for (int i = 1; i < list.length; i++) {
        	if(list[i].size()>0) visit[i] += list[i].size()-1; // 진출
        	for (int j = 0; j < list[i].size(); j++) {
				if(i != list[i].get(j)) {
					visit[list[i].get(j)]++;
				}
			}
		}
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(visit[i]==n-1) answer++;
        }
        return answer;
    }
    private static void dfs(int start) {
        v[start] = true;
        addList.add(start);
        for(int next : list[start]){
            if(!v[next]) {            
                dfs(next);
            }
        }
    }
}
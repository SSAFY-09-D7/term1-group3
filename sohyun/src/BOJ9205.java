import java.util.*;
import java.io.*;

public class BOJ9205 {

	static int N;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args)throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for(int i=0;i<N+2;i++) {
				st= new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x,y});
			}
			graph = new ArrayList[N+2];
			for(int i=0;i<N+2;i++) {
				graph[i] = new ArrayList<>();
			}
			//맨해튼 거리 1000m 이하 만족하는 두 정점을 찾고 양방향 그래프로 이어줌
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					int[] pos = list.get(i);
					int[] next = list.get(j);
					int dist = Math.abs(pos[0]-next[0])+Math.abs(pos[1]-next[1]);
					if(dist<=1000) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
			//BFS로 집에서 도착지까지 갈 수 있는지 탐색
			if(bfs()==true) {
				sb.append("happy"+'\n');
			}
			else {
				sb.append("sad"+'\n');
			}
		
		}
		System.out.println(sb);
	}

	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		boolean[] visited = new boolean[N+2];
		visited[0] = true;
		while(!q.isEmpty()) {
			int p = q.poll();
			if(p==N+1) {
				return true;
			}
			for(int next: graph[p]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}

		}
		return false;
	}

}

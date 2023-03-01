package BOJ_4;

/*
 * -- 생략 -- 1. 섬의 좌표를 기억하는 Point 클래스와 리스트를 만든다. (x, y) 
 * -- O -- 2. 섬의 개수에 맞게 index를 설정한다. 1번 섬에는 1 index 2번 섬에는 2 index ....
 * -- O -- 3. 각 섬에서 4방탐색 * K 를 해서 다른 섬의 도달하는 시작 섬의 index와 끝 섬의 index를 
 * 	   start, end로 설정하고 가중치를 k로 설정한다.
 * 4. Edge 클래스로 Kruskal 알고리즘 사용, cnt 가 섬의 개수 -1 에 도달하지 못한다면 -1
 * 	   도달한다면 sum의 값을 출력 
 */

import java.io.*;
import java.util.*;

public class BOJ_17472_다리만들기2 {
	
	private static class Point{
		int r, c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static class Edge implements Comparable<Edge>{
		int s, e, w;
		public Edge(int s, int e, int w, int r, int c) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] parents;
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) map[i][j] = -1;
			}
		}
		int index = 1;
		// 각 섬을 index 한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j] && map[i][j] == -1) bfs(i, j, index++);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					solve(i, j, map[i][j]);
				}
			}
		}
		parents = new int[index];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		Collections.sort(edge);
		int sum = 0, cnt = 0;
		for (int i = 0; i < edge.size(); i++) {
			Edge temp = edge.get(i);
			int pa = temp.s;
			int pb = temp.e;
			if(find(pa) == find(pb)) continue;
			sum += temp.w;
			cnt++;
			union(pa, pb);
			if(cnt == index-2) break;
		}
		System.out.println(cnt!=index-2?"-1":sum);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) parents[pa] = pb;
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static void solve(int r, int c, int islandNum) {
		for (int i = 0; i < 4; i++) {
			int k = 1;
			while(true) {
				int nr = r + (dr[i] * k);
				int nc = c + (dc[i] * k);
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == islandNum) break;
				if(map[nr][nc] != 0) {
					if(k <= 2) break;
					else {
						edge.add(new Edge(islandNum, map[nr][nc], k-1, nr, nc));
						break;
					}
				}
				k++;
			}
		}
		
	}

	private static void bfs(int r, int c, int index) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c));
		v[r][c] = true;
		map[r][c] = index;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc]) continue;
				if(map[nr][nc] == -1) {
					map[nr][nc] = index;
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

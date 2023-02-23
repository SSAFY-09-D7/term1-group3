package SWEA_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_1949_등산로조성 {

	static int N, K;
	static int[][] map;
	static boolean[][] v;
	static int max;
	static int Ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./input/input_swea1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(map[i][j], max);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						v[i][j] = true;
						dfs(i, j, 1, max, false);
						v[i][j] = false;
					}
				}
			}
			System.out.println("#"+tc+" "+Ans);
		}
	}

	private static void dfs(int r, int c, int cnt, int val, boolean flag) {
		Ans = Math.max(Ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N ||v[nr][nc]) continue;
			if(map[nr][nc] < val) {
				v[nr][nc] = true;
				dfs(nr, nc, cnt+1, map[nr][nc], flag);
				v[nr][nc] = false;
			}
			else {
				if(!flag) {
					if(map[nr][nc] - K < val) {
						int minusNum = 0;
						for (int j = 1; j <= K; j++) {
							if(map[nr][nc]-j < val) {
								minusNum = j;
								break;
							}
						}
						v[nr][nc] = true;
						dfs(nr, nc, cnt+1, map[nr][nc]-minusNum, true);
						v[nr][nc] = false;
					}
				}
			}
		}
	}
	// bfs는 dfs와 달리 방문 형식이 넓게 퍼져가기 때문에 방문을 조절하기가 어렵다
	// 반면 dfs는 한번에 재귀 호출전에 방문을 체크하고 리턴 맞고 다시 체크를 해제 함으로써 
	// 여러 길을 테스트할 수 있다. bfs로 풀었다가 방문을 해결하지 못해서 dfs로 풀었더니 해결
	private static void bfs(int r, int c, int val) {
		Stack<Point> queue = new Stack<Point>();
		queue.push(new Point(r, c, 1, val, false));
		while(!queue.isEmpty()) {
			Point p = queue.pop();
			v[p.r][p.c]= true; 
			Ans = Math.max(Ans,  p.cnt);
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N ||v[nr][nc]) continue;
				if(map[nr][nc] < p.val) {
					queue.push(new Point(nr,nc,p.cnt+1, map[nr][nc], p.check));
				}
				else {
					if(!p.check) {
						if(map[nr][nc] - K < p.val) {
							int minusNum = 0;
							for (int j = 1; j <= K; j++) {
								if(map[nr][nc]-j < p.val) {
									minusNum = j;
									break;
								}
							}
							queue.push(new Point(nr, nc, p.cnt+1, map[nr][nc]-minusNum, true));
						}
					}
				}
			}
		}
	}

	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static class Point{
		int r, c, cnt, val;
		boolean check;
		
		public Point(int r, int c, int cnt, int val, boolean check) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.val = val;
			this.check = check;
		}	
	}
}

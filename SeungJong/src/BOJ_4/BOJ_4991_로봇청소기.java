package BOJ.BOJ4;

/*
 * 각 점마다의 거리를 가중치로 하는 그래프를 만든다 -> bfs로 각 점마다 거리를 구함
 * 해당 그래프는 먼지의 개수 + 1 개의 길이를 갖는다.
 * 순열을 통해 먼지를 방문하는 순서를 정한다.
 * 1 ~ 먼지의 개수만큼의 순열을 구한다.
 * 0 -> 2 -> 1 -> 4 -> 3 와 같은 순서가 나올 것이다.
 * --> 0에서 2로감 + 2에서 1로감 + 1에서 4로감 + 4에서 3으로감
 * 이렇게 다 더한값 중에서 가장 작은 값을 출력
 * 이때 만약 연결되지 못한 먼지가 있으면 -1 출력
 * 
 */


import java.io.*;
import java.util.*;

public class BOJ_4991_로봇청소기 {
	static int R, C;
	static StringBuilder Ans = new StringBuilder();
	static char[][] map;
	static boolean[][] v;
	static ArrayList<Point> list;
	static int[][] adjmatrix;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			min = Integer.MAX_VALUE;
			list = new ArrayList<Point>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if(R == 0 && C == 0) break;
			map = new char[R][C];
			char num = '0';
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='o') {
						list.add(0, new Point(i, j, 0,  'o'));
					} else if(map[i][j] == '*') {
						list.add(new Point(i, j, 0, num));
						map[i][j] = num++;
					}
				}
			}
			adjmatrix = new int[list.size()][list.size()];
			for (int i = 0; i < list.size(); i++) {
				v = new boolean[R][C];
				bfs(list.get(i));
			}
			permutation(new int[list.size()-1], 0, 0);
			System.out.println(min==0?-1:min);
		}
	}


	private static void permutation(int[] sel, int k, int flag) {
		if(k == sel.length) {
			calcMin(sel);
			return;
		}
		for (int i = 0; i < sel.length; i++) {
			if( ( flag & (1<<i) ) > 0) continue;
			sel[k] = i;
			permutation(sel, k+1, flag | (1<<i));
		}
	}


	private static void calcMin(int[] sel) {
		int start = list.size()-1;
		int sum = 0;
		for (int i = 0; i < sel.length; i++) {
			int temp = adjmatrix[start][sel[i]];
			if(temp == 0) min = 0;
			sum += temp;
			start = sel[i];
		}
		min = Math.min(min, sum);
	}


	private static void bfs(Point point) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(point);
		v[point.r][point.c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr<0 || nc < 0 || nr >= R || nc >= C || v[nr][nc] || map[nr][nc] == 'x') continue;
				v[nr][nc] = true;
				if(map[nr][nc]!= '.') {
					if(p.val == 'o') {
						adjmatrix[list.size()-1][map[nr][nc]-'0'] = p.cnt+1;
					}
					else {
						if(map[nr][nc] == 'o') {
							adjmatrix[p.val-'0'][list.size()-1] = p.cnt+1;
						}
						else {
							adjmatrix[p.val-'0'][map[nr][nc]-'0'] = p.cnt+1;
						}
					}
				}
				queue.offer(new Point(nr, nc, p.cnt+1, p.val));
			}
		}
	}


	private static class Point{
		int r, c, cnt;
		char val;
		public Point(int r, int c, int cnt, char val) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.val = val;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", val=" + val + "]";
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}

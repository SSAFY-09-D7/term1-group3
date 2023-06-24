/*
 * 치즈가 아닌 빈 공간을 BFS돌린다.
 * 이 때, 외곽에 도달하지 못한다면 그 공간은 치즈 내부이기 때문에 넘어간다.
 * 외곽에 도달한다면 치즈부분은 사라진다.
 */

package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_2636_치즈 {
	
	static int R, C;
	static int[][] map;
	static boolean[][] v;
	static List<Point> list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int remain = 0;
		while(true) {
			list = new ArrayList<Point>();
			v = new boolean[R][C];
			bfs();
			if(list.size() == 0) break;
			remain = list.size();
			cnt++;
		}
		
		System.out.println(cnt);
		System.out.println(remain);
		
		
	}
	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0));
		v[0][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				// 범위 검사
				if(nr<0 || nc<0 || nr>=R || nc>= C || v[nr][nc]) continue;
				
				v[nr][nc] = true;

				// 제일 바깥에서 시작했으니 치즈라면 제일 바깥에 있는 치즈
				if(map[nr][nc] == 1) {
					map[nr][nc] = 0;
					list.add(new Point(nr, nc));
				}
				
				// 빈 공간에서 가장 바깥 치즈를 찾아 나간다
				else {
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}
	public static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}

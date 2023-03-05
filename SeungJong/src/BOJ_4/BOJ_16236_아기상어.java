package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_16236_아기상어 {
	static int N, Ans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Point p = null;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					p = new Point(i, j, 2, 0, 0, 0);
					map[i][j] = 0;
				}
			}
		}
		v = new boolean[N][N];
		while(true) {
			v = new boolean[N][N];
			ArrayList<Point> list = new ArrayList<Point>();
			list = bfs(p);
			if(list == null) break;
			v = new boolean[N][N];
			p = solve(p, list);
			if(p != null) Ans = p.cnt;
			else break;
		}
		System.out.println(Ans);
	}
	

	private static Point solve(Point temp, ArrayList<Point> list) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(temp);
		v[temp.r][temp.c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
				if(map[nr][nc] > p.size) continue;
				if(map[nr][nc] == p.size || map[nr][nc] == 0) {
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.size, p.feed, p.cnt+1, p.eat));
				}
				else if(map[nr][nc] < p.size && nr == list.get(0).r && nc == list.get(0).c) {
					map[nr][nc] = 0;
					p.eat++;
					v[nr][nc] = true;
					p.feed++;
					if(p.size == p.feed) {
						p.size++;
						p.feed = 0;
					}
					p = new Point(nr, nc, p.size, p.feed, p.cnt+1, p.eat);
					return p;
				}
			}
		}
		return null;
	}


	private static ArrayList<Point> bfs(Point temp) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(temp);
		ArrayList<Point> list = new ArrayList<Point>();
		int findCnt = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			v[p.r][p.c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					v[nr][nc] = true;
					if(p.cnt+1 < findCnt)
					queue.offer(new Point(nr, nc, p.size, p.feed, p.cnt+1, p.eat));
				}
				else {
					if(map[nr][nc] > p.size) continue;
					if(map[nr][nc] < p.size) {
						v[nr][nc] = true;
						findCnt = Math.min(findCnt, p.cnt+1);
						temp = new Point(nr, nc, p.size, p.feed, p.cnt+1, p.eat);
						list.add(temp);
					} else if(map[nr][nc] == p.size) {
						v[nr][nc] = true;
					}
					if(p.cnt+1 < findCnt)
					queue.offer(new Point(nr, nc, p.size, p.feed, p.cnt+1, p.eat));
				}
			}
		}
		Collections.sort(list);
		return list;
	}



	private static class Point implements Comparable<Point>{
		int r, c, size, feed, cnt, eat;

		public Point(int r, int c, int size, int feed, int cnt, int eat) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.feed = feed;
			this.cnt = cnt;
			this.eat = eat;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", size=" + size + ", feed=" + feed + ", cnt=" + cnt + ", eat=" + eat
					+ "]";
		}

		@Override
		public int compareTo(Point o) {
			if(this.cnt == o.cnt) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				else return Integer.compare(this.r,  o.r);
			}
			return Integer.compare(this.cnt, o.cnt);
		}

	}
	
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};

}

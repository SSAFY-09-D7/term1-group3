package w10;

import java.io.*;
import java.util.*;

public class BOJ1194 {
	static int N, M, min;
	static char[][] maze;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ1194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r=0, c=0;
		maze = new char[N][M];
		for(int i = 0; i<N;i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				maze[i][j] = s.charAt(j);
				if(maze[i][j] == '0') {
					r = i;
					c = j;
				}
			}
		}
		min = Integer.MAX_VALUE;
		//dfs(new Point(r, c, 0, new ArrayList<>()), new boolean[N][M]);
		
		bfs(r, c);
		
		System.out.println(-1);
	}

	static class Point{
		int r, c, cnt, list;
		
		public Point(int r, int c, int cnt, int list) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.list = list;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][64];
		queue.offer(new Point(r, c, 0,0));
		v[r][c][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >=0 && nr < N && nc>=0 && nc < M && !v[nr][nc][p.list] && maze[nr][nc] != '#') {
					if(maze[nr][nc] == '1') {
						System.out.println(p.cnt+1);
						System.exit(0);
					}else if(maze[nr][nc] == '.' || maze[nr][nc] == '0') {
						v[nr][nc][p.list] = true;
						queue.offer(new Point(nr, nc, p.cnt+1, p.list));
					}else if(maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') {
						int a = p.list|(int)Math.pow(2, maze[nr][nc]-'a');
						v[nr][nc][a] = true;
						queue.offer(new Point(nr, nc, p.cnt+1, a));
					}else if(maze[nr][nc] >= 'A' && maze[nr][nc]<='F') {
						if((p.list&(int)Math.pow(2,  maze[nr][nc]-'A'))>=(int)Math.pow(2,  maze[nr][nc]-'A')){
							v[nr][nc][p.list] = true;
							queue.offer(new Point(nr, nc, p.cnt+1, p.list));
						}
					}
				}
			}
		}
	}

}


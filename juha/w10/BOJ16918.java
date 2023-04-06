import java.io.*;
import java.util.*;

public class BOJ16918 {
	static int R, C, N;
	static char[][] map;
	static Queue<Point> queue;
	
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ16918.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		queue = new LinkedList<>();
		for(int i = 0; i<R; i++) {
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'O') queue.offer(new Point(i, j, 0));
			}
		}
		
		mapStatus(1);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void mapStatus(int cnt) {
		if(cnt == N) {
			print();
			return;
		}
		if(cnt%2 == 1) {
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j] == '.') {
						map[i][j] = 'O';
					}
				}
			}
			mapStatus(cnt+1);
		}else {
			while(!queue.isEmpty()) {
				if(queue.peek().cnt != cnt - 2)  break;
				
				Point p = queue.poll();
				map[p.r][p.c] = '.';
				for(int d = 0; d<4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]=='.') continue;
					
					map[nr][nc] = '.';
				}
			}
			
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j] == 'O') {
						queue.offer(new Point(i, j, cnt));
					}
				}
			}
			mapStatus(cnt+1);
		}
		
	}

	private static void print() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

}

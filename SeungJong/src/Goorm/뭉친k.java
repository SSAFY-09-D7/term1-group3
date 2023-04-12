import java.io.*;
import java.util.*;
class Main {
	static int N, Ans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int k = map[x][y];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(!v[i][j] && map[i][j] == k){
					v[i][j] = true;
					bfs(i, j, k);
				}
			}
		}
		System.out.println(Ans);
	}
	private static void bfs(int r, int c, int k){
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c));
		v[r][c] = true;
		int cnt = 0;
		while(!queue.isEmpty()){
			Point p = queue.poll();
			cnt++;
			for(int i=0; i<4; i++){
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc] != k || v[nr][nc]) continue;
				v[nr][nc] = true;
				queue.offer(new Point(nr, nc));
			}
		}
		Ans = Math.max(Ans, cnt);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static class Point{
		int r, c;
		public Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
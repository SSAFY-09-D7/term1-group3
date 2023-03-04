import java.util.*;
import java.io.*;
public class BOJ14503 {

	static int[][] map;
	static int answer;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	static int M;
	static class Point{
		int x;
		int y;
		int d;
		Point(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());

		int px = Integer.parseInt(st.nextToken());
		int py = Integer.parseInt(st.nextToken());
		int pd = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		bfs(px,py,pd);
		System.out.println(answer);
		
	}
	
	private static void bfs(int i, int j, int d) {
		Queue<Point> q = new LinkedList<>();
		map[i][j] = 2;
		answer = 1;
		q.add(new Point(i,j,d));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			boolean isBlank = false;
			for(int r=0;r<4;r++) {
				int nx = now.x+dx[r];
				int ny = now.y+dy[r];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny]==0) {
						isBlank = true;
						break;
					}
				}
			}
			if(isBlank) {
				while(true) {
					if(now.d==0) {
						now.d = 3;
					}
					else {
						now.d = now.d-1;
					}
					
					int nx = now.x+dx[now.d];
					int ny = now.y+dy[now.d];
					if(nx>=0 && nx<N && ny>=0 && ny<M) {
						if(map[nx][ny]==0) {
							answer++;
							map[nx][ny] = 2;
							q.add(new Point(nx,ny,now.d));
							break;
						}
					}
				}
				
				
			}
			else {
				int nx = now.x;
				int ny = now.y;
				if(now.d==0) {
					//북
					nx = now.x+1;
					ny = now.y;
				}
				if(now.d==1) {
					//동
					nx = now.x;
					ny = now.y-1;
				}
				if(now.d==2) {
					//남
					nx = now.x-1;
					ny = now.y;
				}
				if(now.d==3) {
					//서
					nx = now.x;
					ny = now.y+1;
				}
				if(nx<0 || nx>N || ny<0 || ny>M || map[nx][ny]==1) {
					break;
				}
				else {
					if(map[nx][ny]==0) {
						answer++;
						map[nx][ny] = 2;
						
					}
					q.add(new Point(nx,ny,now.d));
				}
			}
		}
		
	}

}

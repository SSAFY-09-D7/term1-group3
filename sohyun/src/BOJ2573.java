import java.util.*;
import java.io.*;

public class BOJ2573 {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		while(true) {
			visited = new boolean[N][M];
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited[i][j] && map[i][j]>0) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			if(cnt>=2) {
				break;
			}
			if(cnt==0) {
				year=0;
				break;
			}
			else {
				visited = new boolean[N][M];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j]>0) {
							visited[i][j] = true;
							int rcnt = 0;
							for(int d=0;d<4;d++) {
								int nx = i+dx[d];
								int ny = j+dy[d];
								if(nx>=0 && nx<N && ny>=0 && ny<M) {
									if(map[nx][ny]==0 && !visited[nx][ny]) rcnt++;
								}
							}
							map[i][j] = (map[i][j]-rcnt>=0) ? map[i][j]-rcnt : 0;
						}
					}
				}
			}
			year++;
		}
		
		System.out.println(year);
		
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			for(int d=0;d<4;d++) {
				int nx= x+dx[d];
				int ny = y+dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visited[nx][ny] && map[nx][ny]>0) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		
	}

}

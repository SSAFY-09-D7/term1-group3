
import java.util.*;
import java.io.*;

public class BOJ2468 {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x =x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 map = new int[N][N];
		
		int rainMax = Integer.MIN_VALUE;
		int answer = 0;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(rainMax<=map[i][j]) {
					rainMax = map[i][j];
				}
			}
		}
		
		for(int rain=rainMax;rain>=0;rain--) {
			boolean[][] visited = new boolean[N][N];
			int cc = rainBfs(rain,visited);
			
			answer = Math.max(cc, answer);
			
		}
		
		System.out.println(answer);
	}

	private static int rainBfs(int rain,boolean[][] visited) {
		int count = 0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[i][j]>rain && visited[i][j]==false) {
					count++;
					bfs(i,j,rain,visited);
				}
			}
		}
		return count;
	}

	private static void bfs(int i, int j,int rain,boolean[][] visited) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		visited[i][j] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int d=0;d<4;d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(!visited[nx][ny] && map[nx][ny]>rain) {
						visited[nx][ny] = true;
						map[nx][ny] = rain;
						q.add(new Point(nx,ny));
					}
				}
			}
			
		}
		
	}

}

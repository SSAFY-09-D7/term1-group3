import java.util.*;
import java.io.*;

public class BOJ14442 {

	static class Point{
		int x;
		int y;
		int cnt;
		int cut;
		Point(int x, int y, int cnt, int cut){
			this.x= x;
			this.y = y;
			this.cnt = cnt;
			this.cut =cut;
			
		}
	}
	static int N,M,K,answer;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[K+1][N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		answer = Integer.MAX_VALUE;
		bfs();
		System.out.println((answer == Integer.MAX_VALUE)? -1:answer);
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.add(new Point(0,0,1,0));
		while(!q.isEmpty()) {
			Point p= q.poll();
			if(p.x==N-1 && p.y==M-1) {
				answer = Math.min(answer, p.cnt);
				break;
			}
			for(int d=0;d<4;d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny]==0 && !visited[p.cut][nx][ny]) {
						//벽을 부순적 없는 경우
							//벽 부순적 있는 경우
							visited[p.cut][nx][ny] = true;
							q.add(new Point(nx,ny,p.cnt+1,p.cut));
						
					}
					if(map[nx][ny]==1) {
						//벽을 K보다 적게 부순경우
						if(p.cut<K && !visited[p.cut+1][nx][ny]) {
							visited[p.cut+1][nx][ny]= true;
							q.add(new Point(nx,ny,p.cnt+1,p.cut+1));
						}
					}
				}
			}
			
		}
		
	}

}

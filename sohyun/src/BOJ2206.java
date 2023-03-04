import java.util.*;
import java.io.*;

public class BOJ2206 {

	static int[][] map;
	static class Point{
		int x;
		int y;
		boolean cut;	//부쉈는지 안부쉈ㄴ는지 확인 (1,0)
		int cnt;
		
		Point(int x, int y,int cnt,boolean d){
			this.x = x;
			this.y =y;
			this.cnt =cnt;
			this.cut =d;
		}
	}
	static int answer;
	static int N;
	static int M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception{
		// 0은 이동할 수 있는 곳, 1은 이동할 수 없는 벽
		// (1,1)에서 (N,M)까지 이동하려고 하는데, 최단 경로로 이동하려고 함
		// 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로,
		// 시작하는 칸과 끝나는 칸도 포함해서 센다
		// 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 경로가 짧아지면
		// 벽을 한개까지 부수고 이동해도 된다.
		// 한 칸에서 이동할 수 있는 칸은 상하좌우 인접한 칸
		
		//(1,1)과 (N,M)은 항상 0이다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		answer = Integer.MAX_VALUE;
		bfs();
		System.out.println((answer==Integer.MAX_VALUE)? -1 : answer);
		
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.add(new Point(0,0,1,false));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x==N-1 && p.y==M-1) {
				answer = Math.min(answer, p.cnt);
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				
				if(nx>=0 && nx<N && ny>=0&& ny<M) {
					if(map[nx][ny]==0) {
						if(!p.cut && !visited[nx][ny][0]) {
							visited[nx][ny][0] = true;
							q.add(new Point(nx,ny,p.cnt+1,p.cut));
						}
						else {
							if(p.cut && !visited[nx][ny][1]) {
								visited[nx][ny][1]= true;
								q.add(new Point(nx,ny,p.cnt+1,p.cut));
							}
						}
					}
					if(map[nx][ny]==1){
						if(!p.cut) {
							visited[nx][ny][1] = true;
							q.add(new Point(nx,ny,p.cnt+1,true));
						}
					}
				}
			}
			
		}
		
		
		
	}
}

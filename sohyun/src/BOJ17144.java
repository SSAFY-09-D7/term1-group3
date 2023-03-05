import java.util.*;
import java.awt.Point;
import java.io.*;
public class BOJ17144 {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Point{
		int x;
		int y;
		int d;	//미세먼지 양
		Point(int x, int y, int d){
			this.x =x;
			this.y = y;
			this.d = d;
		}
	}
	static int r1 = -1;
	static int r2 = -1;
	public static void main(String[] args)throws Exception {
		
		
		//1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited= new boolean[R][C];
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1 && r1==-1 && r2==-1) {
					r1 = i;
					r2 = i+1;
				}
			}
		}
//		System.out.printf("%d %d\n",r1,r2);
		
		while(T>0) {
			Queue<Point> dust = new LinkedList<>();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j]>0) {
						dust.offer(new Point(i,j,map[i][j]));
					}
				}
			}
			bfs(dust);
			rorate(r1,r2);
			T--;
//		System.out.println(Arrays.deepToString(map));
		}
		
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) answer+=map[i][j];
			}
		}
		System.out.println(answer);
		
	}
	
	private static void rorate(int r1, int r2) {
//		System.out.printf("%d %d\n",r1,r2);
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int[] dx2 = {-1,0,1,0};
		int[] dy2 = {0,-1,0,1};
		
		int temp = map[0][0];
		int dir = 0;
		int x= 0;
		int y= 0;
		
		
		while(true) {
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				map[x][y] = map[nx][ny];
				x=nx;
				y=ny;
				if(y>=C-1 && dir==0) {
					dir++;
				}
				if(x>=r1 && dir==1) {
					dir++;
				}
				if(y<=0 && dir==2) {
					dir++;
				}
				if(x<=0 && dir==3) {
					break;
				}
			
		}
		map[1][0] = temp;
		int temp2 = map[R-1][C-1];
		x = R-1;
		y = C-1;
		dir = 0;
		while(true) {
			int nx = x+dx2[dir];
			int ny = y+dy2[dir];
			
			map[x][y] = map[nx][ny];
			x=nx;
			y=ny;
			if(x<=r2 && dir==0) {
				dir++;
			}
			if(y<=0 && dir==1) {
				dir++;
			}
			if(x>=R-1 && dir==2) {
				dir++;
			}
			if(y>=C-1 && dir==3) {
				break;
			}
		
		}
		map[R-1][C-2]=temp2;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) map[i][j] = 0;
			}
		}
		
		map[r1][0] = -1;
		map[r2][0] = -1;
		
	}

	private static void bfs(Queue<Point> dust) {
		while(!dust.isEmpty()) {
			Point now = dust.poll();
			int cnt = 0;
			int add = cal(now.d);
			for(int d=0;d<4;d++) {

				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				if(nx>=0 && nx<R && ny>=0 && ny<C) {
					if(map[nx][ny]!=-1) {
						map[nx][ny]+=add;
						cnt++;
					}
				}
			}
			now.d = map[now.x][now.y] - cnt*add;
			map[now.x][now.y] = now.d;
		}
	}
	private static int cal(int m) {
		return m/5;
	}

}

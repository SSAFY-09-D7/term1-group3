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
		//R*C
		//공기 청정기는 항상 1번 열, 두개행 차지
		//공기청정기 설치 안된 칸에는 미세먼지가 있음 
		//미세먼지 양 = Ar,c
		//1초동안 순서대로 일어남
		//1. 미세먼지가 확산된다. 확산은 미세먼지 있는 모든 칸에서 O
		// 동서남북으로 확산
		//인접한 방향에 공기청정기 있거나 칸이 없으면 확산 X
		// 확산되는 양은 Ar,c/5 이고 소수점 버림
		//r,c에 남은 미세먼지 양 = Ar,c-(Ar,c/5)*확산된 방향개수
		
		//2. 공기청정기 작동
		//위쪽 공기청정기의 바람은 반시계로 순환, 
		//아래쪽 공기청정기 바람은 시계방향으로 순환
		//바람이 불면 미세먼지가 바람의 방향대로 한칸씩 이동
		//공기청정기에서 부는 바람은 미세먼지가 없는 바람-공기청정기로 들어간 미세먼지 정화됨
		
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
		//2. T초동안 미세먼지 확산하는거
		//1초동안 변한거부터 뽑아보기
		
		while(T>0) {
			//1초동안 변화
			Queue<Point> dust = new LinkedList<>();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j]>0) {
						//공기청정기 있는 칸 큐에넣기
						dust.offer(new Point(i,j,map[i][j]));
					}
				}
			}
			bfs(dust);
			//회전 - -1의 행넣고
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
		//r1 : 공기청정기 첫 행
		//반시계 방향 돌리기
//		System.out.printf("%d %d\n",r1,r2);
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int[] dx2 = {-1,0,1,0};
		int[] dy2 = {0,-1,0,1};
		
		//시작점 저장해두기
		int temp = map[0][0];
		int dir = 0;
		int x= 0;
		int y= 0;
		
		//-1인 경우 0으로 바꾸고 
		
		
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
		//r2 : 공기청정기 두번째 행
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
		
		//-1인 곳 0으로 바꾸고
		//원래 -1 채우기
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
					//맵안에 있고
					//공기청정기 아니면 확산 
					
					if(map[nx][ny]!=-1) {
						map[nx][ny]+=add;
						cnt++;
					}
				}
			}
			//다하고나와서 더해준만큼 빼주기
			now.d = map[now.x][now.y] - cnt*add;
			map[now.x][now.y] = now.d;
		}
	}

	//미세먼지 계산
	private static int cal(int m) {
		return m/5;
	}

}

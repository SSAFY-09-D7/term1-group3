import java.util.*;
import java.io.*;

public class 토마토 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static int M;
	static int answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//Mㅣ 가로 칸 N 세로칸
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map =new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//0: 익지 않은 토마토 -1: 들어있지 않은 칸, 1: 익은 토마토
		answer = 0;
		bfs();
		
		//저장 될 대부터 모든 토마토가 익은 상태 = 0, 토마토가 모두 익지 못하면 -1
		L :for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					answer = -1;
					break L;
				}
			}
		}
		
		System.out.println(answer);
		
		
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					//토마토 들어있고 방문하지 않은 경우
					q.offer(new int[] {i,j,0});
					visited[i][j] =  true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y=now[1];
			int day = now[2];
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visited[nx][ny] && map[nx][ny]==0) {
						map[nx][ny]=1;
						visited[nx][ny]=true;
						q.add(new int[] {nx,ny,day+1});
						answer = Math.max(answer, day+1);
					}
				}
			}
		}
	}

}

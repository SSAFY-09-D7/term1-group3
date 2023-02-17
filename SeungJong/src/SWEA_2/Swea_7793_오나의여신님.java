package SWEA_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_7793_오나의여신님 {

	static int N, M;
	static char[][] map;
	static int dX, dY, sX, sY;
	static int Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			Queue<Point> devil = new LinkedList<Point>();
			Queue<Point> su = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'D') {
						dX = i;
						dY = j;
					}
					if(map[i][j] == 'S') {
						su.offer(new Point(i, j, 0, 'S'));
					}
					if(map[i][j] == '*') {
						devil.offer(new Point(i, j, 0, '*'));
					}
				}
			}
			bfs(su, devil);
			if(Ans==0) System.out.println("#"+tc+" "+"GAME OVER ");
			else System.out.println("#"+tc+" "+Ans);
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}			
			System.out.println();
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static class Point{
		int r, c, cnt;
		char simbol;
		
		public Point(int r, int c, int cnt, char simbol) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.simbol = simbol;
		}
	}
	
	private static void bfs(Queue<Point> su, Queue<Point> devil) {
		while(true) {
			int dSize = devil.size();
			for (int j = 0; j < dSize; j++) {
				Point pD = devil.poll();
				for (int i = 0; i < 4; i++) {
					int nrD = pD.r + dr[i];
					int ncD = pD.c + dc[i];
					if(nrD < 0 || ncD < 0 || nrD >= N || ncD >= M) continue;
					if(map[nrD][ncD] == '.' || map[nrD][ncD] == 'S') {
						map[nrD][ncD] = '*';
						devil.offer(new Point(nrD, ncD, pD.cnt+1, '*'));
					}
				}
			}
			int sSize = su.size();
			for (int j = 0; j < sSize; j++) {				
				Point pS = su.poll();
				if(pS.r == dX && pS.c == dY) {
					Ans = pS.cnt;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nrS = pS.r + dr[i];
					int ncS = pS.c + dc[i];
					if(nrS < 0 || ncS < 0 || nrS >= N || ncS >= M) continue;
					if(map[nrS][ncS] == '.' || map[nrS][ncS] == 'D') {
						map[nrS][ncS] = 'S';
						su.offer(new Point(nrS, ncS, pS.cnt+1, 'S'));
					}
				}
			}
			if(su.isEmpty()) return;
//			print();
//			System.out.println();
		}
	}
}

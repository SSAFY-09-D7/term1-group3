package SWEA_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_5644_무선충전 {

	static int[] personA;
	static int[] personB;
	static Battery[] battery;
	static String[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			map = new String[11][11];
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					map[i][j] = "0";
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			personA = new int[M];
			int pAR = 1;
			int pAC = 1;
			int pBR = 10;
			int pBC = 10;
			personB = new int[M];
			battery = new Battery[A];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				personA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				personB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int cov = Integer.parseInt(st.nextToken());
				int per = Integer.parseInt(st.nextToken());
				battery[i] = new Battery(r, c, cov, per);
			}

			
			for (int i = 0; i < A; i++) {
				bfs(battery[i].r, battery[i].c, battery[i].coverage, i+1);
			}
			int sum = 0;
			for (int i = 0; i <= M ; i++) {
				ArrayList<Battery> listA = new ArrayList<Battery>();
				ArrayList<Battery> listB = new ArrayList<Battery>();
				String curA = "", curB = "";
				if(!map[pAR][pAC].equals("0")) curA = map[pAR][pAC];
				if(!map[pBR][pBC].equals("0")) curB = map[pBR][pBC];
				if(curA.length() != 0 && curB.length() == 0) {
					System.out.println(battery[Integer.parseInt(curA.substring(0, 1))]);
					for (int j = 0; j < curA.length(); j++) {
						System.out.println(battery[j]);
						listA.add(battery[Integer.parseInt(curA.substring(j,j+1))-1]);
					}
					sum += Collections.max(listA).performance;
				}
				if(curA.length() == 0 && curB.length() != 0) {
					for (int j = 0; j < curA.length(); j++) {
						listB.add(battery[Integer.parseInt(curB.substring(j,j+1))-1]);
						System.out.println(listB);
					}
//					sum += Collections.max(listB).performance;
				}

				
			}
//			System.out.println(sumA+" "+sumB);
			
//			for (int i = 1; i < 11; i++) {
//				for (int j = 1; j < 11; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
		}
	}
	

	


	private static void bfs(int r, int c, int coverage, int num) {
		Queue<Battery> queue = new LinkedList<Battery>();
		queue.offer(new Battery(r, c, 0, num));
		while(!queue.isEmpty()) {
			Battery b = queue.poll();
			for (int i = 1; i <= 4; i++) {
				int nr = b.r + dr[i];
				int nc = b.c + dc[i];
				
				if(nr<1 || nc<1 || nr>=11 || nc>=11) continue;
				if(!map[nr][nc].contains(Integer.toString(b.performance))) {
					if(map[nr][nc].equals("0")) map[nr][nc] = Integer.toString(b.performance);
					else map[nr][nc] += Integer.toString(b.performance);
				}
				if(b.coverage+1 == coverage) continue;
				queue.offer(new Battery(nr, nc, b.coverage+1, num));
			}
		}
	}





	private static class Battery implements Comparable<Battery>{
		int r, c, coverage, performance;

		public Battery(int r, int c, int coverage, int performance) {
			super();
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.performance = performance;
		}

		@Override
		public String toString() {
			return "Battery [r=" + r + ", c=" + c + ", coverage=" + coverage + ", performance=" + performance + "]";
		}

		@Override
		public int compareTo(Battery o) {
			
			return Integer.compare(this.performance, o.performance);
		}


		
	}
	
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
}

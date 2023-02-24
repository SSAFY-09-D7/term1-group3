package SWEA_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Swea_5644_무선충전2 {

	static int[] personA;
	static int[] personB;
	static Battery[] battery;
	static String[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
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
			int sum = 0;
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
			for (int i = 0; i < M; i++) {
				List<Battery> chargerA = getCharger(pAR, pAC, battery);
				List<Battery> chargerB = getCharger(pBR, pBC, battery);
				if(chargerA.size() != 0 && chargerB.size() == 0) {
					sum += Collections.max(chargerA).performance;
				}
				if(chargerA.size() == 0 && chargerB.size() != 0) {
					sum += Collections.max(chargerB).performance;
				}
				if(chargerA.size() != 0 && chargerB.size() != 0) {
					int max = 0;
					for (int j = 0; j < chargerA.size(); j++) {
						for (int k = 0; k < chargerB.size(); k++) {
							int temp = chargerA.get(j).performance + chargerB.get(k).performance;
							if(chargerA.get(j) == chargerB.get(k)) {
								temp /= 2;
							}
							max = Math.max(max, temp);
						}
					}
					sum += max;
				}	
				pAR += dr[personA[i]];
				pAC += dc[personA[i]];
				pBR += dr[personB[i]];
				pBC += dc[personB[i]];
			}
			List<Battery> chargerA = getCharger(pAR, pAC, battery);
			List<Battery> chargerB = getCharger(pBR, pBC, battery);
			if(chargerA.size() != 0 && chargerB.size() == 0) {
				sum += Collections.max(chargerA).performance;
			}
			if(chargerA.size() == 0 && chargerB.size() != 0) {
				sum += Collections.max(chargerB).performance;
			}
			if(chargerA.size() != 0 && chargerB.size() != 0) {
				int max = 0;
				for (int j = 0; j < chargerA.size(); j++) {
					for (int k = 0; k < chargerB.size(); k++) {
						int temp = chargerA.get(j).performance + chargerB.get(k).performance;
						if(chargerA.get(j) == chargerB.get(k)) {
							temp /= 2;
						}
						max = Math.max(max, temp);
					}
				}
				sum += max;
			}	
			System.out.println("#"+tc+" "+sum);
			
		}
	}
	
	private static List<Battery> getCharger(int r, int c, Battery[] charger) {
		ArrayList<Battery> list = new ArrayList<Battery>();
		for (int i = 0; i < charger.length; i++) {
			if(Math.abs(r - charger[i].r) + Math.abs(c - charger[i].c)<=charger[i].coverage) {
				list.add(charger[i]);
			}
		}
		return list;
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
			// TODO Auto-generated method stub
			return Integer.compare(this.performance, o.performance);
		}
		
	}
	
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
}

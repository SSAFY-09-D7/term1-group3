package SWEA.SWEA2;

import java.io.*;
import java.util.*;

public class SWEA_2115_벌꿀채취 {
	static int N, M, C, Ans, tempProfit;
	static int[][] map;
	static ArrayList<Point> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			list = new ArrayList<Point>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					int val = 0;
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int k = j; k < j+M; k++) {
						val += map[i][k];
						temp.add(map[i][k]);
					}
					if(val <= C) {
						int profit = 0;
						for (int k = 0; k < temp.size(); k++) {
							profit += temp.get(k) * temp.get(k);
						}
						list.add(new Point(i, j, profit));
					} else {
						tempProfit = 0;
						powerset(new int[M], 0, new boolean[M], temp);
						list.add(new Point(i, j, tempProfit));
					}
				}
			}
			Collections.sort(list);
			Point p1 = list.get(0);
			int nr = p1.r;
			int nc = p1.c;
			Ans = p1.profit;
			for (int i = 1; i < list.size(); i++) {
				Point p2 = list.get(i);
				if(nr != p2.r) {
					Ans += p2.profit;
					break;
				}
				else if(p2.c+M-1 < nc) {
					Ans += p2.profit;
					break;
				}
				else if(nc+M-1 < p2.c) {
					Ans += p2.profit;
					break;
				}
			}
			System.out.println("#"+tc+" "+Ans);
		}
	}

	private static void powerset(int[] sel, int k, boolean[] v, ArrayList<Integer> temp) {
		if(k == sel.length) {
			int sum = 0, totalsum = 0;
			for (int i = 0; i < sel.length; i++) {
				if(v[i]) {
					sum += temp.get(i);
				}
			}
			if(sum <= C) {
				for (int i = 0; i < sel.length; i++) {
					if(v[i]) {
						totalsum += temp.get(i) * temp.get(i);
					}
				}
			}
			tempProfit = Math.max(totalsum, tempProfit);
			return;
		}
		v[k] = true;
		powerset(sel, k+1, v, temp);
		v[k] = false;
		powerset(sel, k+1, v, temp);
	}

	private static class Point implements Comparable<Point>{
		int r, c, profit;

		public Point(int r, int c, int profit) {
			super();
			this.r = r;
			this.c = c;
			this.profit = profit;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", profit=" + profit + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.profit, this.profit);
		}
	}
}

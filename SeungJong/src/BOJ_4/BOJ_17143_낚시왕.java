package BOJ_4;

import java.io.*;
import java.util.*;

public class BOJ_17143_낚시왕 {
	static int R, C, M, Ans;
	static ArrayList<Shark> list = new ArrayList<Shark>();
	static Shark[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Shark(r, c, s, d, z));
		}
		
		for (int i = 0; i < C; i++) {
			solve(i);
		}
		System.out.println(Ans);
	}
	
	private static void solve(int col) {
		// 0. 상어들을 행 별로 정렬해서 가장 위에 있는 상어가 먼저 탐색되도록
		Collections.sort(list);
		// 1. 낚시왕 오른쪽으로 한칸 이동
		col++;
		// 2. 해당 열에서 가장 가까운 상어 잡는다.
		for (int i = 0; i < list.size(); i++) {
			int sharkC = list.get(i).c;
			if(col == sharkC) {
				Ans += list.get(i).z;
				list.remove(i);
				break;
			}
		}
		// 3. 상어들 이동
		move();
		// 4. nC2 조합을 해서 같은 위치에 있다면 큰 상어가 먹는다.
		// -> 여러 상어가 겹칠 수 있으니 조합은 불가능.
		makeMap();
//		checkDup();
	}


	private static void makeMap() {
		map = new Shark[R+1][C+1];
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			if(map[r][c] != null) {
				if(map[r][c].z < list.get(i).z) map[r][c] = list.get(i);
			}
			else map[r][c] = list.get(i);
		}
		ArrayList<Shark> temp = new ArrayList<Shark>();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j] != null) temp.add(map[i][j]);
			}
		}
		list = temp;
	}

	private static void checkDup() {
		ArrayList<Duplicate> dup = new ArrayList<Duplicate>();
		if(list.size()>=2) {
			for (int i = 0; i < list.size()-1; i++) {
				for (int j = i+1; j < list.size(); j++) {
					if(list.get(i).r == list.get(j).r && list.get(i).c == list.get(j).c) {
						if(!dup.contains(new Duplicate(i, list.get(i).z))) dup.add(new Duplicate(i, list.get(i).z));
						if(!dup.contains(new Duplicate(j, list.get(j).z))) dup.add(new Duplicate(j, list.get(j).z));
					}
				}
			}
		}
		if(dup.size()>0) {
			int max = 0;
			Collections.sort(dup); // index가 가장 큰 상어로 정렬 나중에 뺄 때 index영향 안받기 위해
			for (int i = 0; i < dup.size(); i++) {
				max = Math.max(max, dup.get(i).z);
			}
			removeDup(dup, max);
//			removeDup(dup);
		}
	}

	private static void removeDup(ArrayList<Duplicate> dup, int max) {
		for (int i = 0; i < dup.size(); i++) {
			if(dup.get(i).z != max) {
				list.remove(dup.get(i).index);	
			}
		}
	}
	
	private static void removeDup(ArrayList<Duplicate> dup) {
	      ArrayList<Shark> tmp = new ArrayList<Shark>();
	      for (int i = 0; i < list.size(); i++) {
	         boolean has = false;
	         for (Duplicate d : dup) {
	            if (d.index == i) {
	               break;
	            }
	         }
	         if (!has) tmp.add(list.get(i));
	      }
	      
	      list = tmp;
	}

	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			int dir = list.get(i).d;
			int k = list.get(i).s;
			int nr = r, nc= c;
			for (int j = 0; j < k; j++) {
				nr += dr[dir];
				nc += dc[dir];
				if(nr < 1 || nr > R || nc < 1 || nc > C) {
					if(dir%2 == 0) dir--;
					else dir++;
					nr += dr[dir]*2;
					nc += dc[dir]*2;
				}
			}
			list.get(i).r = nr;
			list.get(i).c = nc;
			list.get(i).d = dir;
		}
	}

	private static class Shark implements Comparable<Shark>{
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		@Override
		public int compareTo(Shark o) {
			return Integer.compare(this.r, o.r);
		}
	}
	
	private static class Duplicate implements Comparable<Duplicate>{
		int index, z;

		public Duplicate(int index, int z) {
			super();
			this.index = index;
			this.z = z;
		}

		@Override
		public int compareTo(Duplicate o) {
			return Integer.compare(o.index, this.index);
		}

		@Override
		public String toString() {
			return "Duplicate [index=" + index + ", z=" + z + "]";
		}
		
	}
	
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};

}

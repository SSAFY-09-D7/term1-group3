package BOJ_2;

import java.util.Scanner;

public class Boj_17136_색종이붙이기 {

	static int Ans = Integer.MAX_VALUE;
	static int N = 10;
	static int[][] map;
	static int[] paper = {0,5,5,5,5,5};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[N][N];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		solve(0);
		System.out.println(Ans==Integer.MAX_VALUE?-1:Ans);
	}
	private static void solve(int cnt) {
		int Sr = -1, Sc = -1;
		L: for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 1) {
					Sr = r;
					Sc = c;
					break L;
				}
			}
		}
		// 만약 Sr, Sc == -1 이라면 더 이상 붙일 공간이 없다는 뜻
		if(Sr==-1 && Sc == -1) {
			Ans = Math.min(Ans, cnt);
			return;
		}
		
		// 붙일 수 있는 최대 크기를 구한다.
		int size = getPaperSize(Sr, Sc);
//		System.out.println(size);
		
		// 남은 색종이를 이용하여
		// 붙일 수 있는 제일 작은 종이 부터 제일 큰 종이까지 순차적으로 붙여본다
		for (int i = 1; i <= size; i++) {
			if(paper[i]>0 ) {
				paper[i]--;
				// 선택된 색종이 크기만큼 붙이기
				for (int r = 0; r < i; r++) {
					for (int c = 0; c < i; c++) {
//						if(Sr+r < 0 || Sr+r >=N || Sc+c <0 || Sc+c >= N) continue;
						map[Sr+r][Sc+c] = 0;
					}
				}
				
				solve(cnt+1);
				
				// 원복하는 코드
				for (int r = 0; r < i; r++) {
					for (int c = 0; c < i; c++) {
//						if(Sr+r < 0 || Sr+r >=N || Sc+c <0 || Sc+c >= N) continue;
						map[Sr+r][Sc+c] = 1;
					}
				}		
				paper[i]++;
			}
		}
	}
	private static int getPaperSize(int sr, int sc) {
		int size = 5;
		while(size > 1) {
			boolean flag = true;
			L:for (int r = sr; r < sr+size; r++) {
				for (int c = sc; c < sc+size; c++) {
					if(r < 0 || r >= 10 || c < 0 || c >= 10 || map[r][c] == 0) {
						flag = false;
						break L;						
					}
						
				}
			}
			if(flag) {
				return size;
			}
			size--;
		}
		return size;
	}
}

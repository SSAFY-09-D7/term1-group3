package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15685_드래곤커브 {

	static int[][] map = new int[101][101];
	static int x, y;
	static int maxR, maxC, Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			solve(Integer.toString(d), g);
		}
		countSquare();
		System.out.println(Ans);
	}
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	private static void countSquare() {
		for (int i = 0; i < maxC; i++) {
			for (int j = 0; j < maxR; j++) {
				if(map[i][j] == 1) {
					boolean isSquare = true;
					for (int k = 0; k < 3; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(map[nr][nc] == 0) isSquare = false;
					}
					if(isSquare) Ans++;
				}
			}
		}
	}
	private static void solve(String d, int g) {
		map[x][y] = 1;
		String[] arr = new String[g+1];
		arr[0] = d;
		int index = 1;
		while(index <= g) {
			String temp = arr[index-1];
			temp = reverse(temp);
			arr[index] = arr[index-1];
			for (int i = 0; i < temp.length(); i++) {
				int dir = Integer.parseInt(temp.substring(i,i+1));
				dir++;
				if(dir == 4) dir = 0;
				arr[index] += dir;
			}
			index++;
		}
		printMap(arr);
		
	}
	private static void printMap(String[] arr) {
		String str = arr[arr.length-1];
		for (int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case '0':
				y++;
				map[x][y] = 1;
				break;
			case '1':
				x--;
				map[x][y] = 1;
				break;
			case '2':
				y--;
				map[x][y] = 1;
				break;
			case '3':
				x++;
				map[x][y] = 1;
				break;
			}
			maxR = Math.max(maxR, y);
			maxC = Math.max(maxC, x);
		}
	}
	private static String reverse(String str) {
		String temp = "";
		for (int i = str.length()-1; i >= 0; i--) {
			temp += str.charAt(i);
		}
		return temp;
	}
}

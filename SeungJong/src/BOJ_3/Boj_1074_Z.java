package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074_Z {

	static int num;
	static int row, col;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		cut(0, 0, size);
	}
	private static void cut(int r, int c, int size) {
		if(size == 2) {
			if(r==row && c == col) System.out.println(num);
			c++; num++;
			if(r==row && c == col) System.out.println(num);
			r++; c--; num++;
			if(r==row && c == col) System.out.println(num);
			c++; num++;
			if(r==row && c == col) System.out.println(num);
			num++;
		}
		else {
			int half = size/2;
			if(row >= r && row <= r+half && col >= c && col <= c+half) cut(r, c, half);
			else num += half * half;
			if(row >= r && row <= r+half && col >= c+half && col <= c+half+half) cut(r, c+half, half);
			else num += half * half;
			if(row >= r+half && row <= r+half+half && col >= c && col <= c+half) cut(r+half, c, half);
			else num += half * half;
			if(row >= r+half && row <= r+half+half && col >= c+half && col <= c+half+half) cut(r+half, c+half, half);
			else num += half * half;
		}
	}

}

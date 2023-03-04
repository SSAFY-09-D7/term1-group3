import java.util.*;
import java.io.*;

public class BfsPractice {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N = 5;
	static int[][] arr = { { 1, 2, 3, 4, 5 },
			{ 6, 7, 8, 9, 10 },
			{ 11, 12, 13, 14, 15 },
			{ 6, 17, 18, 19, 20 },
			{ 21, 22, 23, 24, 25 } };

	public static void main(String[] args) {

		// arr 값이랑 거리 조회하기
		bfs();
	}

	private static void bfs() {

	}

	static class Point {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

}
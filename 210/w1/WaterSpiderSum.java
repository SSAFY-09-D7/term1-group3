package w1;

import java.util.*;
import java.io.*;

public class WaterSpiderSum {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("../inputs/input_water_spider_sum.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
            int spiderCnt = sc.nextInt();
            boolean[][] map = new boolean[n][n];
            int result = 0;

            for (int i = 1; i <= spiderCnt; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int direction = sc.nextInt();

                if (map[r][c]) continue;
                
                r = direction == 1 ? r - 6 : direction == 2 ? r + 6 : r;
                c = direction == 3 ? c - 6 : direction == 4 ? c + 6 : c;
                
                if (r < 0 || r >= n || c < 0 || c>= n) continue;
                if (map[r][c]) continue;
                
                map[r][c] = true;
                result++;
            }

			System.out.println("#" + tc + " " + result);
		}
		
		sc.close();
	}
}

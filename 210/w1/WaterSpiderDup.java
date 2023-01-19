package w1;

import java.util.*;
import java.io.*;

public class WaterSpiderDup {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("../inputs/input_water_spider_dup.txt"));
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

                map[r][c] = true;
                for (int j = 3; j > 0; j--) {
                	r = direction == 1 ? r + j : r;
                    c = direction == 2 ? c + j : c;

                    if (r >= n || c >= n) break;
                    if (map[r][c]) {
                        result = result == 0 ? i : result;
                        break;
                    }
                    map[r][c] = true;
                }
            }

			System.out.println("#" + tc + " " + result);
		}
	}
}

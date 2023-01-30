import java.util.*;
import java.lang.*;

public class BOJ2564 {
		static int[][] cw = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int c, r;
			c = sc.nextInt();
			r = sc.nextInt();

			int[][] rect = new int[r+1][c+1];
			int storeNum = sc.nextInt();
			for(int i = 1;i<=storeNum;i++) {
				switch(sc.nextInt()) {
				case 1:
					rect[0][sc.nextInt()] = i;
					break;
				case 2:
					rect[rect.length-1][sc.nextInt()] = i;
					break;
				case 3:
					rect[sc.nextInt()][0] = i;
					break;
				case 4:
					rect[sc.nextInt()][rect[0].length-1] = i;
					break;
				}
			}


			int secR = 0, secC = 0, dir = 0;
			switch(sc.nextInt()) {
			case 1:
				dir = 0;
				secR = 0;
				secC = sc.nextInt();
				break;
			case 2:
				dir = 2;
				secR = rect.length-1;
				secC = sc.nextInt();
				break;
			case 3:
				dir = 3;
				secR = sc.nextInt();
				secC = 0;
				break;
			case 4:
				dir = 1;
				secR = sc.nextInt();
				secC = rect[0].length-1;
				break;
			}
			
			int sum = 0;
			for(int i = 1;i<=storeNum;i++) {
				sum += Math.min(cwDis(rect, secR, secC, dir, i), (r+c)*2-cwDis(rect, secR, secC, dir, i));//ccwDis(rect, secR, secC, dir, i));
			}
			System.out.println(sum);
		}

		public static int cwDis(int[][] rect, int r, int c, int dir, int num) {
			int cnt = 1;
			int dr = r, dc = c;

			while(true) {
				dr = dr + cw[dir%4][0];
				dc =  dc + cw[dir%4][1];
				if(rect[dr][dc] == num) {
					break;
				}
				if(dr+cw[dir%4][0] >= rect.length || dr+cw[dir%4][0] < 0 || dc+cw[dir%4][1] >= rect[0].length || dc+cw[dir%4][1] < 0) {
					dir++;
				}
				cnt++;
			}

			return cnt;
		}

	}

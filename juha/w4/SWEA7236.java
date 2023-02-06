import java.util.*;

public class SWEA7236 {
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1;test_case<=T;test_case++) {
			int n = sc.nextInt();
			char[][] reservoir = new char[n][n];
			
			for(int i =0;i<n;i++) {
				for(int j = 0; j<n;j++) {
					String s = sc.next();
					reservoir[i][j] = s.charAt(0);
				}
			}
			System.out.println("#"+test_case+" "+findMaxDepth(reservoir));	
		}
	}
	
	private static int findMaxDepth(char[][] reservoir) {
		int maxD= 0;
		for(int i = 0;i<reservoir.length;i++) {
			for(int j = 0;j<reservoir[0].length;j++) {
				if(reservoir[i][j] == 'W') {
					int cnt = 0;
					for(int k = 0;k<8;k++) {
						int r = i+dr[k];
						int c = j+dc[k];
						if(r>=0 && r<reservoir.length && c >=0 && c<reservoir[0].length) {
							if(reservoir[r][c] == 'W') cnt++;
						}
					}
					if(cnt == 0) cnt = 1;
					maxD = Math.max(maxD, cnt);
				}
			}
		}
		return maxD;
	}

}

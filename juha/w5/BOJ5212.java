import java.util.*;

public class BOJ5212 {
	static int[] dr = { -1,0,0,1};
	static int[] dc = {0,-1,1,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char[][] map = new char[r][c];
		
		for(int i = 0;i<r;i++) {
			String s = sc.next();
			for(int j = 0;j<c;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		afterFifty(map);
	}

	private static void afterFifty(char[][] map) {
		for(int i = 0;i<map.length;i++) {
			for(int j = 0;j<map[i].length;j++) {
				if(map[i][j] == 'X') {
					changeMap(map, i, j);
				}else continue;
			}
		}
		resizeMap(map);		
	}

	private static void changeMap(char[][] map, int r, int c) {
		int cnt  = 0;
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<map.length && nc>=0 && nc<map[nr].length) {
				if(map[nr][nc] == '.') cnt++;
			}else cnt++;
		}
		if(cnt>=3) map[r][c] = 'O';
	}
	
	private static void resizeMap(char[][] map) {
		int[] resizeRect = new int[4];
		boolean firstCheck = false;
		for(int i = 0;i<map.length;i++) {
			for(int j = 0;j<map[i].length;j++) {
				if(map[i][j] == 'X') {
					if(!firstCheck) {
						resizeRect[0] = i;
						resizeRect[1] = j;
						resizeRect[2] = i;
						resizeRect[3] = j;
						firstCheck = true;
					}else {
						resizeRect[0] = Math.min(resizeRect[0], i);
						resizeRect[1] = Math.min(resizeRect[1], j);
						resizeRect[2] = Math.max(resizeRect[2], i);
						resizeRect[3] = Math.max(resizeRect[3], j);
					}
				}else if(map[i][j] == 'O') {
					map[i][j] = '.';
				}
			}
		}
		
		char[][] reMap = new char[resizeRect[2]-resizeRect[0]+1][resizeRect[3]-resizeRect[1]+1];
		
		for(int i = 0;i<reMap.length;i++) {
			for(int j = 0;j<reMap[i].length;j++) {
				reMap[i][j] = map[i+resizeRect[0]][j+resizeRect[1]];
				System.out.print(reMap[i][j]);
			}
			System.out.println();
		}
		
	}

}

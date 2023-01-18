import java.util.Scanner;

public class building {

	static int T, N, nr, nc, count = 0, max_count = 0;
	static char[][] arr;
	static boolean isfind = false;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			max_count = 0;
			
			// 'B' 찾기 2중 루프
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					count = 0;
					if(arr[i][j] == 'B') { // B를 찾는다면 8방탐색
						isfind = false;
						for(int k=0; k<8; k++) {
							nr = i + dr[k];
							nc = j + dc[k];
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							if(arr[nr][nc] == 'G') { // 인접한 곳에 G가 있다면 count = 2 break
								isfind = true;
								break;
							}
						}
						if(!isfind) { // 인접한 곳에 G가 없다면
							for(int k=0; k<N; k++) {  // 해당 행과 열의 개수를 더하고 중복 제외
								if(arr[i][k] == 'B') {
									count += 1;
								}
								if(arr[k][j] == 'B') {
									count += 1;
								}
							}
							count -= 1;
						} else {
							count = 2; //인접한 곳에 G가 있다면 2로 고정
						}
//					System.out.println(count);
					max_count = Math.max(max_count, count);  // 더 큰 값 최신화
					}
				}
			}
			System.out.println("#"+tc+" "+max_count);
		}
		
		sc.close();
		
	}

}

package w17;

import java.io.*;
import java.util.*;

public class Main {
	static int N, startR = -1, startC = -1, startType = -1, endR = -1, endC = -1, endType = -1;
	static char[][] board;
	static int[][] ds = {{0,1}, {0,-1}, {-1,0}, {1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();	// 보드 입력 받기
				
			if (startR == -1) {		// 만약 아직 시작점을 못 찾았다면
				for (int j = 0; j < N; j++) {
					if (startR != -1) break;
					if (board[i][j] != 'B') continue;	// 가로, 세로 구분
					
					startR = i;
					startC = j;
					startType = j+1 < N && board[i][j+1] == 'B' ? 0 : 1; 
				}
			}
			
			if (endR == -1) {		// 만약 아직 종착점을 못 찾았다면
				for (int j = 0; j < N; j++) {
					if (endR != -1) break;
					if (board[i][j] != 'E') continue;	// 가로, 세로 구분
					
					endR = i;
					endC = j;
					endType = j+1 < N && board[i][j+1] == 'E' ? 0 : 1; 
				}
			}
		}
		
		System.out.println(bfs());	// 너비 우선 탐색을 통해 최소 이동 횟수 연산
	}
	
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][2];		// 가장 왼쪽 위의 점을 기준으로 해당 좌표 방문 배열, 가로세로를 3차원 배열로 구분
		q.add(new Point(startR, startC, startType, 0));	// 시작점을 큐에 삽입
		visited[startR][startC][startType] = true;	// 방문처리
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.r == endR && p.c == endC && p.type == endType) return p.cnt;	// 만약 종착점이라면
			
			for (int i = 0; i < 4; i++) {
				if (canMove(p, i)) {	// 만약 해당 방향으로 이동이 가능하면
					int nr = p.r + ds[i][0];	// 다음 r
					int nc = p.c + ds[i][1];	// 다음 c
					
					if (visited[nr][nc][p.type]) continue;	// 이미 방문한 곳이면 continue
					visited[nr][nc][p.type] = true;		// 방문 처리
					q.add(new Point(nr, nc, p.type, p.cnt + 1));	// 다음 좌표값을 큐에 삽입
				}
			}
			
			if (canTurn(p)) {	// 만약 회전이 가능하면
				Point next;
				if (p.type == 0) next = new Point(p.r - 1, p.c + 1, 1, p.cnt + 1);	// 가로세로 구분하여 다음 좌표 얻기
				else next = new Point(p.r + 1, p.c - 1, 0, p.cnt + 1);
				
				if (visited[next.r][next.c][next.type]) continue;	// 이미 방문한 곳이면 continue
				visited[next.r][next.c][next.type] = true;			// 방문 처리
				q.add(next);	// 다음 좌표값을 큐에 삽입
			}
		}
		
		
		return 0;
	}
	
	static private boolean canMove(Point p, int d) {	// 해당 방향으로 이동할 수 있는지 판별
		for (int i = 0; i < 3; i++) {	// 3개의 점에 대해서
			int nr = p.type == 0? p.r + ds[d][0] : p.r + i + ds[d][0];	// 가로, 세로 구분하여 비교
			int nc = p.type == 0? p.c + i + ds[d][1] : p.c + ds[d][1];	
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == '1') return false; // 범위 밖이거나 벽이면 false
		}
		return true;
	}
	
	static private boolean canTurn(Point p) {		// 해당 위치에서 회전할 수 있는지 판별
		for (int i = 0; i < 3; i++) {
			int nr = p.type == 0? p.r + 1 : p.r + i;	// 해당 점의 아래 혹은 오른쪽 r에 대해
			int nc = p.type == 0? p.c + i : p.c + 1;	// 해당 점의 아래 혹은 오른쪽 c에 대해 
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == '1') return false; // 범위 밖이거나 벽이면 false
			
			nr = p.type == 0? p.r - 1 : p.r + i;	// 해당 점의 위 혹은 왼쪽 r에 대해
			nc = p.type == 0? p.c + i : p.c - 1;	// 해당 점의 위 혹은 왼쪽 c에 대해
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == '1') return false; // 범위 밖이거나 벽이면 false
		}
		return true;
	}
	
	static class Point { // 상태에 대한 클래스
		int r, c, type, cnt; // r좌표, c좌표, 가로세로구분, 현재까지의 이동거리

		public Point(int r, int c, int type, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
			this.cnt = cnt;
		}
	}
}

import java.util.*;
import java.io.*;

public class BOJ2178 {
    static int N;
    static int M;
    static int[][] map;

    static class Point {
        int x;
        int y;
        int cnt;
        Point(int x, int y,int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int answer;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        answer = Integer.MAX_VALUE;
        bfs();
        System.out.println(answer);

    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();        
        visited[0][0] = true;
        q.add(new Point(0, 0,1));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == N - 1 && p.y == M - 1) {
                answer = Math.min(answer, p.cnt );
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny,p.cnt+1));
                    }
                }
            }
            
        }
    }
}

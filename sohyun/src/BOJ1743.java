import java.util.*;
import java.io.*;

public class BOJ1743 {
    static int[][] map;
    static int N;
    static int M;
    static int K;
    static boolean[][] visited;
    static int answer;
    static int cnt;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s - 1][e - 1] = 1;

        }
        answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        visited[i][j] = true;
        cnt = 1;
        q.add(new Point(i, j));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        cnt++;
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            
        }
        answer = Math.max(answer, cnt);
    }
}

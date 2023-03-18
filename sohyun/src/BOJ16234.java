package src;
import java.util.*;
import java.io.*;

public class BOJ16234 {
    static int N, L, R;
    static int[][] map;
    static boolean visited[][];
    static int answer;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static ArrayList list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());



        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        while (true) {
            boolean isEnd = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        list = new ArrayList<int[]>();
                        int sum = bfs(i, j);
                        System.out.println(sum);
                        if (list.size() > 1) {
                            isEnd = true;
                            int move = sum/(list.size());
                            for (int l = 0; l < list.size(); l++) {
                                int[] n = (int[]) list.get(l);
                                map[n[0]][n[1]] = move;
                            }
                        }
                    }
                }
            }
            if (!isEnd) {
                break;
            }
            answer++;
        }
        System.out.println(answer);

    }
    
    static int bfs(int i, int j) {
        
        int sum = map[i][j];
        Queue<int[]> q = new LinkedList<>();
        list.add(new int[] { i, j });
        q.add(new int[] { i, j });
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(map[x][y] - map[nx][ny]);
                        if (diff >= L && diff <= R) {
                            visited[nx][ny] = true;
                            sum += map[nx][ny];
                            list.add(new int[] { nx, ny });
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return sum;
    }
}
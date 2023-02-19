import java.util.*;
import java.io.*;

public class SWEA7236 {
    static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dy = { 0, 0, -1, -1, -1, 1, -1, 1 };
    static int answer;
    static int N;
    static char[][] map;
    public static void main(String[] args)throws Exception {
        //N*N 구획으로 이루어진 지역에 있는 저수지의 물의 총 깊이는
        //각 구획의 물 깊이 중 가장 깊은 구획의 깊이가 저수지에서 가장 깊은 물의 깊이로
        //저수지의 총 깊이가 된다
        //둘러싼 모든 영역이 G인 경우 그 구획의 물깊이는 1이된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            answer = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            //
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'W') {
                        find(i, j);
                    }
                }
            }
            System.out.printf("#%d %d\n",testcase,answer);
        }

    }

    private static void find(int i, int j) {
        
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 'W') {
                    cnt++;
                }

            }
        }
        answer = Math.max(cnt, answer);
    }
}

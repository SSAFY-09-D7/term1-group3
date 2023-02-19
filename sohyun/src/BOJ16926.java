import java.util.*;
import java.io.*;

public class BOJ16926 {
    //
    static int[] dx = { 0, 1,0,-1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        //배열 크기 N*M 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //회전
        for (int j = 0; j < R; j++) {
            int square = Math.min(N, M) / 2;
            for (int cnt = 0; cnt < square; cnt++) {
                int temp = map[cnt][cnt];
                int startX = cnt;
                int startY = cnt;
                int dirr = 0;
                while (true) {
                    map[startX][startY] = map[startX + dx[dirr]][startY + dy[dirr]];
                    startX = startX + dx[dirr];
                    startY = startY + dy[dirr];
                    if (startY >= M - 1 - cnt && dirr == 0) {
                        dirr++;
                    }
                    if (startX >= N - 1 - cnt && dirr == 1) {
                        dirr++;
                    }
                    if (startY <= cnt && dirr == 2) {
                        dirr++;
                    }
                    if (startX <= cnt && dirr == 3) {
                        break;
                    }
                }
                map[cnt + 1][cnt] = temp;

            }
        }
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

    }

}

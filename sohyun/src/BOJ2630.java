package src;

import java.util.*;
import java.io.*;

public class BOJ2630 {
    static int N;
    static int[][] map;
    static int b;
    static int w;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0,N);
        System.out.println(w);
        System.out.println(b);
    }

    private static void recur(int x, int y, int size) {
      
        int color = map[x][y];
        boolean isEnd = true;
        L: for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    isEnd = false;
                    break L;
                }
            }
        }
        if (isEnd) {
            if (color == 1)
                b++;
            else
                w++;
            return;
        } else {
            recur(x, y, size / 2);
            recur(x + size / 2, y, size / 2);
            recur(x, y + size / 2, size / 2);
            recur(x + size / 2, y + size / 2, size / 2);
        }
        
    }
}

package src;

import java.util.*;
import java.io.*;

public class BOJ1780 {
    static int N;
    static int mCnt, zCnt, oCnt;
    static int[][] map;
    public static void main(String[] args)throws Exception {
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

        recur(0, 0, N);
        System.out.println(mCnt);
        System.out.println(zCnt);
        System.out.println(oCnt);
    }

    private static void recur(int x, int y, int size) {
        boolean isEnd = true;
        int num = map[x][y];
        L: for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != num) {
                    isEnd = false;
                    break L;
                }
            }
        }

        if (isEnd) {
            if (num == -1)
                mCnt++;
            else if (num == 0)
                zCnt++;
            else
                oCnt++;
            return;
        }
        else {
            for (int c = 0; c < 3; c++) {
                for (int cc = 0; cc < 3; cc++) {
                    recur(x+(size/3)*c, y+cc*(size/3), size/3);
                }
            }
        }
    }
}

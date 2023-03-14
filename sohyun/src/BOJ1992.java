import java.util.*;
import java.io.*;

public class BOJ1992 {
    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();
        recur(0, 0, N);
        System.out.println(sb);
    }

    private static void recur(int x, int y, int size) {
        int num = map[x][y];
        boolean isEnd = true;
        L: for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != num) {
                    isEnd = false;
                    break L;
                }
            }
        }
        if (isEnd) {
            if (num == 0)
                sb.append("0");
            else
                sb.append("1");
            return;
        } else {
            sb.append("(");
            recur(x, y, size / 2);
            recur(x, y + (size / 2), size / 2);
            recur(x + (size / 2), y, size / 2);
            recur(x + (size / 2), y + (size / 2), size / 2);
            sb.append(")");
        }
    }
}

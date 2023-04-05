package w12;

import java.util.*;
import java.io.*;

class Main {
    static int result = 0;
    static char[][] board = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[][] ds = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1941.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            board[i] = br.readLine().toCharArray();

        combi(-1, 0, 0);

        System.out.println(result);
    }

    private static void combi(int startIdx, int start, int depth) {
        if (depth == 7) {
            if (isPossible(startIdx))
                result++;
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;

            visited[r][c] = true;
            if (depth == 0)
                combi(i, i + 1, depth + 1);
            else
                combi(startIdx, i + 1, depth + 1);
            visited[r][c] = false;
        }
    }

    private static boolean isPossible(int startIdx) {
        boolean[][] smallV = new boolean[5][5];
        int cnt = 0;
        int yCnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(startIdx);
        while (!q.isEmpty()) {
            int idx = q.poll();
            cnt++;

            int r = idx / 5;
            int c = idx % 5;
            smallV[r][c] = true;
            if (board[r][c] == 'Y') {
                yCnt++;
                if (yCnt >= 4)
                    return false;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + ds[i][0];
                int nc = c + ds[i][1];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || !visited[nr][nc] || smallV[nr][nc])
                    continue;
                smallV[nr][nc] = true;
                q.add(nr * 5 + nc);
            }
        }

        if (cnt < 7)
            return false;

        return true;
    }
}
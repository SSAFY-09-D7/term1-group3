package w07;

import java.util.*;
import java.io.*;

class Main {
    static int[][] board, chart;
    static int[][] ds = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ21608.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        chart = new int[N * N + 1][4];

        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++)
                chart[num][j] = Integer.parseInt(st.nextToken());
            search(num);
        }

        System.out.println(getScore(N));
    }

    private static void search(int index) {
        Element max = new Element(N, N, 0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0)
                    continue;
                int blankCnt = 0;
                int likeCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = i + ds[d][0];
                    int nc = j + ds[d][1];

                    if (nc < 0 || nc >= N | nr < 0 || nr >= N)
                        continue;

                    if (board[nr][nc] == 0)
                        blankCnt++;
                    else if (hasVal(chart[index], board[nr][nc]))
                        likeCnt++;
                }

                if (likeCnt > max.likeCnt)
                    max = new Element(i, j, blankCnt, likeCnt);

                else if (likeCnt == max.likeCnt) {
                    if (blankCnt > max.blankCnt)
                        max = new Element(i, j, blankCnt, likeCnt);

                    else if (blankCnt == max.blankCnt) {
                        if (i < max.r)
                            max = new Element(blankCnt, likeCnt, j, i);
                        else if (i == max.r && j > max.c)
                            max = new Element(i, j, blankCnt, likeCnt);
                    }
                }
            }
        }

        board[max.r][max.c] = index;
    }

    private static int getScore(int N) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int cnt = 0;
                for (int s = 0; s < 4; s++) {
                    int nr = i + ds[s][0];
                    int nc = j + ds[s][1];

                    if (nc < 0 || nc >= N | nr < 0 || nr >= N)
                        continue;
                    if (hasVal(chart[board[i][j]], board[nr][nc]))
                        cnt++;
                }

                if (cnt > 0)
                    result += Math.pow(10, cnt - 1);
            }
        }
        return result;
    }

    private static boolean hasVal(int[] arr, int val) {
        for (int num : arr)
            if (num == val)
                return true;

        return false;
    }

    static class Element {
        int r, c, blankCnt, likeCnt;

        public Element(int r, int c, int blankCnt, int likeCnt) {
            this.r = r;
            this.c = c;
            this.blankCnt = blankCnt;
            this.likeCnt = likeCnt;
        }
    }
}
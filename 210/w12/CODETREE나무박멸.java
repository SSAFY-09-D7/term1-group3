package w12;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, C, kills;
    static int[][] board;
    static int[][] ds = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int[][] kds = {{1,1}, {1,-1}, {-1,-1}, {-1,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < M; i++) {
            execute();
        }

        System.out.println(kills);

    }

    private static void execute() {
        grow();
        spread();

        int[] spot = getKillSpot();
        kill(spot[0], spot[1]);
    }

    private static void grow() {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = board[i][j];
                if (board[i][j] == -1-C) newBoard[i][j] = 0;
                if (board[i][j] < -1) newBoard[i][j] = board[i][j] - 1;
                if (board[i][j] < 1) continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + ds[d][0];
                    int nc = j + ds[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] < 1) continue;
                    cnt++;
                }
                newBoard[i][j] += cnt;
            }
        }

        board = newBoard;
    }

    private static void spread() {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                newBoard[i][j] = board[i][j];
                if (board[i][j] == -1) continue;

                int[] empty = new int[4];

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + ds[d][0];
                    int nc = j + ds[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != 0) continue;
                    empty[cnt] = d;
                    cnt++;
                }
                
                int val = cnt == 0 ? 0 : board[i][j] / cnt;
                for (int e = 0; e < cnt; e++) {
                    newBoard[i+ds[empty[e]][0]][j+ds[empty[e]][1]] += val;
                }
            }
        }

        board = newBoard;
    }


    private static int[] getKillSpot() {
        int[] maxPos = {-1,-1};
        int maxVal = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] < 1) continue;

                int sum = board[i][j];
                for (int d = 0; d < 4; d++) {
                    int nr = i;
                    int nc = j;
                    while (true) {
                        nr += kds[d][0];
                        nc += kds[d][1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] < 1) break;
                        sum += board[nr][nc];
                    }
                }
                
                if (sum > maxVal) {
                    maxVal = sum;
                    maxPos[0] = i;
                    maxPos[1] = j;
                }
            }
        }

        kills += maxVal;
        return maxPos;
    }

    private static void kill(int r, int c) {
        board[r][c] = -2;
        for (int d = 0; d < 4; d++) {
            int nr = r + kds[d][0];
            int nc = c + kds[d][1];
            int k = K;
            while (true) {
                if (k == 0 || nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == -1) break;
                if (board[nr][nc] == 0) {
                    board[nr][nc] = -2;
                    break;
                }
                board[nr][nc] = -2;
                k--;

                nr += kds[d][0];
                nc += kds[d][1];
            }
        }
    }

    private static void print(int[][] b) {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}

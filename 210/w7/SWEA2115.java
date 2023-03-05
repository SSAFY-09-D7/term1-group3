package w7;

import java.util.*;
import java.io.*;

class Solution {
    static int N, M, C, result;
    static int currMax, currStartR, currStartC;
    static int[][] board;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_SWEA2115.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            result = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            board = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    board[i][j] = sc.nextInt();

            find(0, new int[4], 0, 0);
            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void find(int depth, int[] sels, int startR, int startC) {
        for (int i = startR; i < N; i++) {
            for (int j = i == startR ? startC : 0; j <= N - M; j++) {
                sels[depth * 2] = i;
                sels[depth * 2 + 1] = j;

                if (depth == 0) {
                    int nextR = j > N - 2 * M ? i + 1 : i;
                    int nextC = j > N - 2 * M ? 0 : j + M;
                    find(depth + 1, sels, nextR, nextC);
                    continue;
                }

                result = Math.max(getCurrMax(sels[0], sels[1]) + getCurrMax(sels[2], sels[3]), result);
            }
        }

        if (depth == 1)
            return;
    }

    private static int getCurrMax(int startR, int startC) {
        currMax = 0;
        currStartR = startR;
        currStartC = startC;
        powerSet(new boolean[M], 0);

        return currMax;
    }

    private static void powerSet(boolean[] sel, int idx) {
        if (M == idx) {
            currMax = Math.max(calcCurrSel(sel), currMax);
            return;
        }

        sel[idx] = true;
        powerSet(sel, idx + 1);
        sel[idx] = false;
        powerSet(sel, idx + 1);
    }

    private static int calcCurrSel(boolean[] sel) {
        int cnt = 0;
        int valSum = 0;

        for (int i = 0; i < M; i++) {
            if (sel[i]) {
                int currVal = board[currStartR][currStartC + i];
                cnt += currVal;
                valSum += currVal * currVal;
            }
        }

        return cnt > C ? 0 : valSum;
    }
}
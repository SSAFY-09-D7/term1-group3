package w07;

import java.io.*;
import java.util.*;

class Main {
    static int N, result = -1;
    static int[][] stats;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ17281.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stats = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                stats[i][j] = Integer.parseInt(st.nextToken());
        }

        perm(0, new int[9], new boolean[9]);

        System.out.println(result);

    }

    private static void perm(int idx, int[] tmp, boolean[] sel) {
        if (idx == 9) {
            result = Math.max(getScore(tmp), result);
            return;
        }

        if (idx == 3) {
            perm(idx + 1, tmp, sel);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!sel[i]) {
                sel[i] = true;
                tmp[idx] = i;
                perm(idx + 1, tmp, sel);
                sel[i] = false;
            }
        }
    }

    private static int getScore(int[] tmp) {
        int score = 0;
        int outCnt = 0;
        int idx = 0;
        boolean[] base = new boolean[3];

        for (int i = 0; i < N; i++) {
            outCnt = 0;
            base = new boolean[3];

            while (outCnt < 3) {
                int hit = stats[i][tmp[idx]];
                idx = (idx + 1) % 9;

                if (hit == 0)
                    outCnt++;
                else
                    score += hit(base, hit);
            }
        }

        return score;
    }

    private static int hit(boolean[] base, int hit) {
        int earn = 0;

        for (int i = 2; i >= 0; i--) {
            if (base[i]) {
                base[i] = false;
                int nextBase = i + hit;

                if (nextBase >= 3)
                    earn++;
                else
                    base[nextBase] = true;
            }
        }

        if (hit == 4)
            earn++;
        else
            base[-1 + hit] = true;

        return earn;
    }

}

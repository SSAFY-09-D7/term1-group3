package w12;

import java.util.*;
import java.io.*;

public class Main {
    static int[] dice = {0,0,0,0,0,0};
    static int[][] ds = {{0,0}, {0,1}, {0,-1}, {-1,0}, {1,0}};
    static int[][] board;
    static int N, M, K, currR, currC, bottomIdx = 5, frontIdx = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        currR = Integer.parseInt(st.nextToken());
        currC = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            currR += ds[cmd][0];
            currC += ds[cmd][1];

            if (currR < 0 || currR >= N || currC < 0 || currC >= M) {
                currR -= ds[cmd][0];
                currC -= ds[cmd][1];
                continue;
            }

            sb.append(i + " ============ ");
            roll(cmd);            
        }

        System.out.println(sb);
    }

    private static void roll(int cmd) {
        if (cmd == 1) {         // 동 (바닥 = 오른쪽)
            bottomIdx = getRightIdx();

        } else if (cmd == 2) {      // 서 (바닥 = 왼쪽)
            bottomIdx = getLeftIdx();

        } else if (cmd == 3) {      // 북 (바닥 = 뒤쪽, 앞 = 바닥)
            int tmp = getOpIdx(frontIdx);
            frontIdx = bottomIdx;
            bottomIdx = tmp;

        } else {        // 남 (바닥 = 앞, 앞 = 위쪽)
            int tmp = getOpIdx(bottomIdx);
            bottomIdx = frontIdx;
            frontIdx = tmp;
        }
        
        int tmp = board[currR][currC];
        board[currR][currC] = dice[bottomIdx];
        if (tmp != 0) dice[bottomIdx] = tmp;

       sb.append(dice[getOpIdx(bottomIdx)] + " t:" + getOpIdx(bottomIdx) + " f:" + frontIdx + " r:" + getRightIdx() + " bv:" + dice[bottomIdx]  + " \n");
       // sb.append(dice[getOpIdx(bottomIdx)] + "\n");
    }

    private static int getOpIdx(int idx) {
        return idx == 4 ? 5 : idx == 5 ? 4 : (idx + 2) % 4;
    }

    private static int getRightIdx() {
        if (bottomIdx == 5) return (frontIdx + 1) % 4;
        if (bottomIdx == 4) return (frontIdx - 1 + 4) % 4;
        if (frontIdx == 4) return (bottomIdx + 1) % 4;
        if (frontIdx == 5) return (bottomIdx - 1 + 4) % 4;
        if (frontIdx > bottomIdx) return 5;
        return 4;
    }

    private static int getLeftIdx() {
        if (bottomIdx == 4) return (frontIdx + 1) % 4;
        if (bottomIdx == 5) return (frontIdx - 1 + 4) % 4;
        if (frontIdx == 5) return (bottomIdx + 1) % 4;
        if (frontIdx == 4) return (bottomIdx - 1 + 4) % 4;
        if (frontIdx > bottomIdx) return 4;
        return 5;
    }
}

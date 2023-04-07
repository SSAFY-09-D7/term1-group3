package w12;

import java.util.*;
import java.io.*;

public class Main {
    static int N, K, currFirstIdx, cnt;
    static int[] board;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[2*N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 2*N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int turn = 0;
        while(cnt < K) {
            rotate();
            move();
            ride();
            turn++;
        }

        System.out.println(turn);
    }

    private static void rotate() {
        currFirstIdx = currFirstIdx == 0 ? 2 * N - 1 : currFirstIdx - 1;  
    }

    private static void ride() {
        q.add(currFirstIdx);
        board[currFirstIdx]--;
        if (board[currFirstIdx] == 0) cnt++;
    }

    private static void move() {
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int p = q.poll();
            int np = (p+1) % (2*N);
            board[np]--;
            if (board[np] == 0) cnt++;
            if (np != N-1) q.add(np);
        }
    }
}

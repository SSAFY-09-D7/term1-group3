package w5;

import java.util.*;
import java.io.*;

class Main {
    static boolean[][] board = new boolean[101][101];
    static int[][] ds = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
    static Queue<Integer> q = new LinkedList<>();
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ15685.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x, y, d, g);
        }

        int result = getCnt();
        System.out.println(result);
    }

    private static void draw(int x, int y, int d, int g) {
        q.offer(d);
        getCmds(g, 0);
        execute(x, y);
    }

    private static void getCmds(int g, int depth) {
        if (depth == g) {
            return;
        }

        for (int i = 0; i < q.size(); i++) {
            int num = q.poll();
            q.offer(num);
            s.push((num + 1) % 4);
        }

        while (!s.isEmpty()) {
            q.offer(s.pop());
        }

        getCmds(g, depth + 1);
    }

    private static void execute(int x, int y) {
        int currX = x;
        int currY = y;
        board[currX][currY] = true;

        while (!q.isEmpty()) {
            int cmd = q.poll();
            currX += ds[cmd][0];
            currY += ds[cmd][1];
            board[currX][currY] = true;
        }
    }

    private static int getCnt() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i + 1][j]
                        && board[i + 1][j + 1] && board[i][j + 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

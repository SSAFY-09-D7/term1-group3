package w04;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2477.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        int[][] lines = new int[6][2];
        int h = -1, w = -1, smallH = -1, smallW = -1;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            lines[i][0] = d;
            lines[i][1] = val;
        }

        for (int i = 0; i < 6; i++) {
            if (lines[i][0] == 1 || lines[i][0] == 2) {
                h = Math.max(lines[i][1], h);
                smallH = isInLine(lines, i) ? lines[i][1] : smallH;
            } else {
                w = Math.max(lines[i][1], w);
                smallW = isInLine(lines, i) ? lines[i][1] : smallW;
            }
        }

        System.out.println(((h * w) - (smallH * smallW)) * k);
    }

    private static boolean isInLine(int[][] lines, int idx) {
        int prevIdx = idx == 0 ? 5 : idx - 1;
        int nextIdx = idx == 5 ? 0 : idx + 1;

        return lines[prevIdx][0] == lines[nextIdx][0];
    }
}

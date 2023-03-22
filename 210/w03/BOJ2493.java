package w03;

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2493.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Stack<Tower> s = new Stack<>();
        String[] numStrs = br.readLine().split(" ");

        for (int i = n - 1; i >= 0; i--) {
            int currH = Integer.parseInt(numStrs[i]);
            while (!s.empty() && s.peek().h < currH) {
                Tower t = s.pop();
                answer[t.idx] = i + 1;
            }
            s.push(new Tower(currH, i));
        }

        while (!s.empty()) {
            Tower t = s.pop();
            answer[t.idx] = 0;
        }

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    static class Tower {
        int h;
        int idx;

        public Tower(int h, int idx) {
            this.h = h;
            this.idx = idx;
        }
    }

}
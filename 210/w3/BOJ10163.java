package w3;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ10163.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] results = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            addCells(map, i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (Integer key : map.keySet()) {
            results[map.get(key)] += 1;
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(results[i]);
        }
    }

    private static void addCells(HashMap<Integer, Integer> map, int num, int startR, int startC, int h, int w) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int k = (startR + i) * 101 + startC + j;
                map.put(k, num);
            }
        }
    }
}
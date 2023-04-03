package w12;

import java.util.*;
import java.io.*;

public class Main {
    static int V, A, B;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ3584.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            V = Integer.parseInt(br.readLine());
            parents = new int[V + 1];

            for (int i = 1; i < V; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                parents[end] = start;
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append(findAncestor() + "\n");
        }
        System.out.println(sb);
    }

    private static int findAncestor() {
        boolean[] visited = new boolean[V + 1];
        int currA = A;
        while (currA != 0) {
            visited[currA] = true;
            currA = parents[currA];
        }

        int currB = B;
        while (currB != 0) {
            if (visited[currB])
                return currB;
            currB = parents[currB];
        }

        return -1;
    }
}
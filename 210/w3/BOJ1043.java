package w3;

import java.io.*;
import java.util.*;

class Main {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1043.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowCnt; i++) {
            parent[Integer.parseInt(st.nextToken())] = 0;
        }

        int[][] people = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            people[i] = new int[cnt];
            if (cnt == 0)
                continue;
            int prev = Integer.parseInt(st.nextToken());
            people[i][0] = prev;
            for (int j = 1; j < cnt; j++) {
                int currNum = Integer.parseInt(st.nextToken());
                people[i][j] = currNum;
                union(parent, prev, currNum);
                prev = currNum;
            }
        }

        int result = m;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < people[i].length; j++) {
                if (getParent(parent, people[i][j]) == 0) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    private static void union(int[] parent, int a, int b) {
        parent[a] = getParent(parent, a);
        parent[b] = getParent(parent, b);

        if (parent[a] == parent[b])
            return;
        if (parent[a] < parent[b]) {
            parent[getParent(parent, b)] = a;
        } else {
            parent[getParent(parent, a)] = b;
        }
    }

    private static int getParent(int[] parent, int idx) {
        if (parent[idx] == idx)
            return idx;
        if (parent[idx] == 0)
            return 0;
        return parent[idx] = getParent(parent, parent[idx]);
    }
}
import java.util.*;
import java.io.*;

public class BOJ11725 {

    static int N;

    static ArrayList<Integer>[] tree;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        dfs(1);
        // bfs();
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int n) {
        for (int ch : tree[n]) {
            if (parents[ch] != 0)
                continue;
            parents[ch] = n;
            dfs(ch);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int j = 0; j < tree[p].size(); j++) {
                int ch = (int) tree[p].get(j);
                if (parents[ch] == 0) {
                    parents[ch] = p;
                    q.add(ch);
                }
            }
        }
    }
}

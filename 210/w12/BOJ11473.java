import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static List<Integer>[] edges;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ11473.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        edges = new List[V + 1];
        parents = new int[V + 1];

        for (int i = 1; i <= V; i++)
            edges[i] = new ArrayList<>();

        for (int i = 1; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        parents[1] = -1;
        q.add(1);
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            for (Integer next : edges[curr]) {
                if (parents[next] == 0) {
                    parents[next] = curr;
                    q.add(next);
                }
            }
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findAncestor(a, b) + "\n");
        }

        System.out.println(sb);
    }

    private static int findAncestor(int a, int b) {
        boolean[] visited = new boolean[V + 1];
        int currA = a;
        while (currA != 0 && currA != -1) {
            visited[currA] = true;
            currA = parents[currA];
        }

        int currB = b;
        while (currB != 0 && currB != -1) {
            if (visited[currB])
                return currB;
            currB = parents[currB];
        }

        return -1;
    }
}
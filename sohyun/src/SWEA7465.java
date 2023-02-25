import java.util.*;
import java.io.*;

public class SWEA7465 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            visited = new boolean[N + 1];
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
    
                list[s].add(e);
                list[e].add(s);
            }
           

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    cnt++;
                    bfs(i);
                }
            }
            System.out.printf("#%d %d",testcase,cnt);
            
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i <list[cur].size(); i++) {
                //cur의 list에 잇으면 check
                if (!visited[list[cur].get(i)]) {
                    visited[list[cur].get(i)] = true;
                    q.add(list[cur].get(i));
                }
            }
        }
        
    }
}

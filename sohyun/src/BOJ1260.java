import java.util.*;
import java.io.*;

public class BOJ1260 {
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static int V;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[1001][1001];
        visited = new boolean[1001];

        //M개의 줄에는 간선이 연결하는 두 정점 번호가 주어진다
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            //양방향
            arr[s][e] = arr[e][s] = 1;

        }
        
        dfs(V);

        visited = new boolean[1001];
        System.out.println();
        
        bfs(V);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        System.out.print(v+" ");
        while (!q.isEmpty()) {
            int nowQ = q.poll();
            
            for (int k = 1; k <= N; k++) {
                if (arr[nowQ][k] == 1 && !visited[k]) {
                    q.offer(k);
                    visited[k] = true;
                    System.out.print(k + " ");
                   
                }
            }
        }
    }

    private static void dfs(int v) {
        //재귀로 구현
        visited[v] = true;
        System.out.print(v + " ");

        for (int j = 1; j <= N; j++) {
            if (arr[v][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }    
}

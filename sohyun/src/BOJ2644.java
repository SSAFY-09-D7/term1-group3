import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    // static int[][] graph;
    static ArrayList[] graph;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        
        graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int findo = Integer.parseInt(st.nextToken())-1;
        int findw = Integer.parseInt(st.nextToken())-1;

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; //부모
            int y = Integer.parseInt(st.nextToken()) - 1; //자식
            graph[x].add(y);
            graph[y].add(x);
        }
        answer = -1;
        find(findo,findw,0);
        System.out.println(answer);
    }

    private static void find(int findo, int findw,int cnt) {
      
        if (findo == findw) {
            answer = cnt;
            return;
        }
        visited[findo] = true;
        for (int i = 0; i < graph[findo].size(); i++) {
            int next = (int)graph[findo].get(i);
            if (!visited[next]) {
                find(next, findw,cnt+1);
            }
        }
        
    }

}

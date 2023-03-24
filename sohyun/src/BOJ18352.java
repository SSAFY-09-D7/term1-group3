import java.util.*;
import java.io.*;

public class BOJ18352 {
    
    static class Point implements Comparable<Point>{
        int e;
        int w;

        Point(int e, int w) {
            this.e = e;
            this.w = w;
        }
        
        public int compareTo(Point o) {
            return this.w - o.w;
        }
    }
    static int[] dist;
    static ArrayList<Point>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //도시 개수 
        int M = Integer.parseInt(st.nextToken());   //도로 개수
        int K = Integer.parseInt(st.nextToken());   //거리 정보 (K가 되는 애 뽑음)
        int X = Integer.parseInt(st.nextToken())-1;   //출발 도시 
        
        
        //list, dist 초기화
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //거리 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            list[start].add(new Point(end, 1));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[X] = 0;
        pq.add(new Point(X, 0));
        
        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (dist[p.e] < p.w)
                continue;
            for (Point np : list[p.e]) {
                int nw = dist[p.e] + np.w;
                if (nw < dist[np.e]) {
                    dist[np.e] = nw;
                    pq.add(new Point(np.e, nw));
                }
            }
        }
        
        boolean isFind = false;
        for (int m = 0; m < N; m++) {
            if (dist[m] == K) {
                isFind = true;
                System.out.println(m + 1);
            }
        }
        if (!isFind)
            System.out.println(-1);

    }
}
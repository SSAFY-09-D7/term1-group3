import java.util.*;
import java.io.*;

public class BOJ1916 {
    static int N, M;

    static class Point implements Comparable<Point> {
        int e;
        int w;

        Point(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수
        ArrayList<Point>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            // 버스의 정보
            st = new StringTokenizer(br.readLine());
            // 출발 도시, 도착지 도시, 버스 ㅣㅂ용
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            arr[start].add(new Point(end, w));

        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        Queue<Point> q = new LinkedList<>();
        dist[a] = 0;
        q.add(new Point(a, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (dist[p.e] < p.w)
                continue;
            for (Point np : arr[p.e]) {
                int nw = dist[p.e] + np.w;
                if (nw < dist[np.e]) {
                    dist[np.e] = nw;
                    q.add(new Point(np.e, nw));
                }
            }
        }
        // a에서 b
        System.out.println(dist[b]);

    }
}

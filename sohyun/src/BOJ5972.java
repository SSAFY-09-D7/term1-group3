import java.util.*;
import java.io.*;

public class BOJ5972 {
    static class Point implements Comparable<Point> {
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

    static ArrayList<Point>[] arr;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        // 현서 : 1. 찬홍: N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            arr[start].add(new Point(end, w));
            arr[end].add(new Point(start, w));
        }
        PriorityQueue<Point> q = new PriorityQueue<>();
        dist[0] = 0;
        q.add(new Point(0, 0));

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
        System.out.println(dist[N - 1]);

    }
}

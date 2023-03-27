import java.util.*;
import java.io.*;

public class BOJ1238 {
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

    static int N, M, X;
    static int[] dist;
    static int[] answerD;
    static ArrayList<Point>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());// N명의 학생
        M = Integer.parseInt(st.nextToken());// M개의 도로
        X = Integer.parseInt(st.nextToken()) - 1;
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        answerD = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Point(e, w));
        }

        // 각 학생들이 X까지 가는 거리 구하기
        for (int i = 0; i < N; i++) {
            // 시작점 i로 해서
            dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Point> q = new PriorityQueue<>();
            q.add(new Point(i, 0));
            dist[i] = 0;
            while (!q.isEmpty()) {
                Point p = q.poll();
                if (dist[p.e] < p.w)
                    continue;
                for (Point np : list[p.e]) {
                    int nw = dist[p.e] + np.w;
                    if (dist[np.e] > nw) {
                        dist[np.e] = nw;
                        q.add(new Point(np.e, nw));
                    }
                }
            }

            answerD[i] = dist[X];
        }

        // X에서 각 N까지 가는거리 구하기
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(X, 0));
        dist[X] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (dist[p.e] < p.w)
                continue;
            for (Point np : list[p.e]) {
                int nw = dist[p.e] + np.w;
                if (dist[np.e] > nw) {
                    dist[np.e] = nw;
                    q.add(new Point(np.e, nw));
                }
            }
        }
        
        //왔다갔다 총 합 구하기
        int max_time = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            answerD[i] += dist[i];
            if (answerD[i] > max_time)
                max_time = answerD[i];
        }
        System.out.println(max_time);


    }
}
import java.util.*;
import java.io.*;

public class BOJ1966 {
    static class Point
    {
        int num;
        int idx;

        Point(int n, int i) {
            this.num = n;
            this.idx = i;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            ArrayList<Point> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int p = Integer.parseInt(st.nextToken());
                list.add(new Point(p, i));
            }

            int answer = 0;
            while (true) {
                Point now = list.get(0);

                int nowP = now.num;
                int nowI = now.idx;
                boolean isMax = true;

                for (int k = 0; k < list.size(); k++) {
                    if (nowP < list.get(k).num) {
                        isMax = false;
                        break;
                    }
                }
                if (isMax) {
                    answer++;
                    if (nowI == m) {
                        System.out.println(answer);
                        break;
                    } else {
                        list.remove(0);
                    }
                }
                else{
                    list.remove(0);
                    list.add(new Point(nowP, nowI));
                }
            }

        }
    }
}
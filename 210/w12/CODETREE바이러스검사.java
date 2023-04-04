package w12;

import java.util.*;
import java.io.*;

public class Main {
    static int N, leadMaxCnt, memberMaxCnt;
    static int[] cnts;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        cnts = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cnts[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        leadMaxCnt = Integer.parseInt(st.nextToken());
        memberMaxCnt = Integer.parseInt(st.nextToken());

        long answer = N;

        for (int i = 0; i < N; i++) {
            int cnt = cnts[i];
            cnt -= leadMaxCnt;

            if (cnt < 0) continue;
            answer += Math.ceil((double)cnt / (double)memberMaxCnt);
        }

        System.out.println(answer);

    }
}

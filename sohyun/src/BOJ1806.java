import java.util.*;
import java.io.*;

public class BOJ1806 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int minLen = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());

        //연속된 수들의 부분합 중 그 합이 S 이상이 되는 것 중 가장 짧은 것의 길이
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int total = 0;

        while (start <= N && end <= N) {
            if (total >= S && minLen > end - start)
                minLen = end - start;
            if (total < S)
                total += arr[end++];
            else
                total -= arr[start++];
        }

        if(minLen==Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(minLen);
    }
}

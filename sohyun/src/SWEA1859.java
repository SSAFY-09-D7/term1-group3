import java.util.*;
import java.io.*;
public class SWEA1859 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int startIdx = 0;
            int maxIdx = 0;
            int maxVal = arr[startIdx];
            
            while (true) {
                for (int i = startIdx; i < N; i++) {
                    if (maxVal < arr[i]) {
                        maxVal = arr[i];
                        maxIdx = i;
                    }
                }
                if (startIdx == maxIdx) {
                    while(startIdx+1<=N-1 && arr[startIdx]>arr[startIdx+1])
                        startIdx++;
                    if (startIdx >= N - 1)
                        break;
                } else {
                    for (int i = startIdx; i < maxIdx; i++) {
                        answer += maxVal - arr[i];
                    }
                    startIdx = maxIdx = maxIdx + 1;
                    if (startIdx >= N - 1)
                        break;
                    maxVal = arr[startIdx];
                }
            }

            System.out.printf("#%d %d\n",testcase,answer);
        }
    }
}

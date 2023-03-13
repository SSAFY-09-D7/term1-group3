package src;
import java.util.*;
import java.io.*;

public class BOJ6603 {
    static int[] arr;
    static int k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;
            else {
                arr =new int[k];
                for (int i = 0; i < k; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                combi(6, 0, new int[6], 0);
                System.out.println();
            }
        }
        

    }

    private static void combi(int r, int cur, int[] tmp, int start) {
        if (r == cur) {
            for (int i = 0; i < r; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            tmp[cur] = arr[i];
            combi(r,cur+1,tmp,i+1);
        }
    }
}

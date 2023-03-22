package w02;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./inputs/input_BOJ2798.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        int cnt = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[cnt];
        st = new StringTokenizer(br.readLine(), " ", false);

        for (int i = 0 ; i < cnt ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0;i<cnt;i++){
            for (int j = i+1; j< cnt; j++) {   
                for(int k = j+1; k <cnt; k++) {
                    int tmp = arr[i] + arr[j] + arr[k];
                    if (tmp > result && tmp <= num) { result = tmp;}
                }
            }
        }

        br.close();
        bw.write(result + "");
        bw.close();
    }
}

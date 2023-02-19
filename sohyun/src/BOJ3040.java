import java.util.*;
import java.io.*;
public class BOJ3040 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nan = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++)
        {
            nan[i] = Integer.parseInt(br.readLine());
            sum += nan[i];
        }

        int find = sum - 100;
        L: for (int i = 0; i < 8; i++) {
            for (int j = i; j < 9; j++) {
                if (nan[i] + nan[j] == find) {
                    nan[i] = 0;
                    nan[j] = 0;
                    break L;
                }
            }
        }
        for(int n:nan){
            if(n!=0) System.out.println(n);
        }

    }
}

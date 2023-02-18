import java.util.*;
import java.io.*;

public class BOJ10163 {
    public static void main(String[] args)throws Exception {
        // N장의 색종이가 주어진 위치에 차례로 놓일 경우
        // 각 색종이가 보이는 부분의 면적을 구하라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[1001][1001];
        int[][] input = new int[N][4];
        int[] area = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
            input[i][3] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            //x,y부터 너비 높이만큼채우기
            int sum = 0;
            for (int y = input[i][1]; y < input[i][1] + input[i][3]; y++) {
                for (int x = input[i][0]; x < input[i][0] + input[i][2]; x++) {
                    if (map[y][x] == 0) {
                        map[y][x] = 1;
                        sum++;
                    }

                }
            }
            area[i] = sum;
        }
        for(int s: area){
            System.out.println(s);
        }

    }
}

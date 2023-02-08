import java.util.*;
import java.io.*;
public class SWEA1954 {
    
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testcase=1;testcase<=T;testcase++){
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            visited = new boolean[N][N];
            map[0][0] = 1;
            visited[0][0] = true;
            int x = 0;
            int y = 0;
            int k=0;
            int number = 2;


            while (number <= N * N) {
                int nx = x + dir[k % 4][0];
                int ny = y + dir[k % 4][1];
                if ((nx >= 0 && nx < N && ny >= 0 && ny < N) && visited[nx][ny] == false) {
                    map[nx][ny] = number;
                    visited[nx][ny] = true;
                    x = nx;
                    y = ny;
                    number++;
                } else {
                    k++;
                }
            }
            System.out.println("#"+testcase);
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    System.out.print(map[a][b] + " ");
                }
                System.out.println();
            }
        }
    }
}

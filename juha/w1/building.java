import java.util.*;
import java.lang.*;

public class Solution{
    static int[] dr = {-1, -1, -1, 0,0,1,1,1};
    static int[] dc = {-1,0,1,-1,1,-1,0,1};

    static int[] dr2 = {-1, 0, 0, 1};
    static int[] dc2 = {0, -1, 1, 0};

    public static int count(char[][] arr, int a, int b, int n){
        int cnt = 0;
        for(int i = 0;i<4;i++){
            for(int j = 1;j<n;j++){
            int r = a + dr2[i]*j;
            int c = b + dc2[i]*j;
            if(r>=0&&r<arr.length && c>=0&&c<arr[a].length){
                if(arr[r][c] == 'B') cnt++;
            }
        }
        }
        return cnt+1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();
        for(int test_case = 1;test_case<=T;test_case++){
            int n;
            n = sc.nextInt();
            char[][] arr = new char[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = sc.next().charAt(0);
                }
            }
            int max = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(arr[i][j] == 'B'){
                        for(int k = 0;k<8;k++){
                            int r = i + dr[k];
                            int c = j + dc[k];
                            
                            if(r>=0&&r<arr.length && c>=0&&c<arr[i].length){
                                if(arr[r][c] != 'B') break;
                            }
                            if(k==7){
                                max = Math.max(max, count(arr, i, j, n));
                            }
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}

import java.util.*;
import java.io.*;

public class BOJ2003{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N+1];

        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(num));

        int start =0 ;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(start<N ){
            if(sum==M){
                count++;
            }
            if(sum>M || end ==N) {
                sum-=num[start];
                start++;
            }
            else{
                sum+=num[end];
                end++;
            }
        }

        System.out.println(count);
    }
}
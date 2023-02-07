import java.util.*;
import java.io.*;
public class BOJ2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int[] arr = new int[10001];

        for(int num=2;num<=10000;num++){
            arr[num] = num;
        }
        for(int i=2;i<=10000;i++){
            if(arr[i]==0) continue; 
            for(int j=2*i;j<=10000;j+=i){
                arr[j] = 0;
            }
        }

        int sum = 0;
        int min = 10001;

        for(int i=M;i<=N;i++){
            if(arr[i]!=0) {
                sum+=arr[i];
                min = min>arr[i] ? arr[i] : min;
            }
            
         }

         if(sum==0 ) System.out.println("-1");
         else{
            System.out.println(sum);
            System.out.println(min);
         }
        
    }   
}

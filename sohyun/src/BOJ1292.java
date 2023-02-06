import java.io.*;
import java.util.*;
public class BOJ1292{
    public static void main(String[] args) {
        //1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 
        //3번째 숫자부터 7번째 숫자까지 합 구하기
        


        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt()-1;
        int B = sc.nextInt()-1;
        int sum = 0;
        //B/2+1
        List<Integer> arr = new ArrayList<>();

        for(int idx=1;idx<=(B/2+1);idx++){
            for(int k=0;k<idx;k++){
                arr.add(idx);
            }
        } 
        for(int m=A;m<=B;m++){
            sum+=arr.get(m);
        }
        System.out.println(sum);

    }
}
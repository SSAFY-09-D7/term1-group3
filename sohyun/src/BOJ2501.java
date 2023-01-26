import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2501 {
    public static void main(String[] args) {
        //n의 약수들 중 k번쨰로 작은 수를 출력
        //N의 약수의 개수가 k개보다 적어서 존재하지 않으면 0 출력
        ArrayList<Integer> num = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer = 0;
        for(int i=1;i<=N;i++){
            if(N%i==0) num.add(i);
        }
        //오름차순 정렬
        Collections.sort(num);
        if(num.size()<K) answer =0;
        else {
            answer = num.get(K-1);
        }
        System.out.println(answer);
    }    
}

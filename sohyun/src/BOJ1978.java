import java.util.*;
import java.io.*;
public class BOJ1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            //소수판별: 특정 숫자 제곱근까지만 약수의 여부를 검증

            if (number == 2)
                count++;
            else if (number == 1)
                continue;
            else if (number % 2 == 0)
                continue;
            else {
                count+=findPrime(number,count);
            }
        }
        System.out.println(count);

    }

    private static  int findPrime(int number, int count){
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return 0;
        }
        return 1;
    }
}

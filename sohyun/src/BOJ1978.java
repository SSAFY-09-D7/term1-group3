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
            int cnt = 0;

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0)
                    return;
            }
            if (number != 1 && cnt == 0)
                count++;
        }
        System.out.println(count);

    }
    
}

import java.util.*;
import java.io.*;

public class BOJ1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> primeArr = findPrime(N);
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (start < primeArr.size()) {
            if (sum == N)
                count++;

            if (sum > N || end == primeArr.size()) {
                sum -= primeArr.get(start);
                start++;
            }
            else {
                sum += primeArr.get(end);
                end++;
            }
        }
        System.out.println(count);
    }

    private static ArrayList<Integer> findPrime(int n) {
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 1)
                continue;
            for (int u = 2 * i; u <= n; u += i) {
                arr[u] = 1;
            }
        }
        
        ArrayList<Integer> primeArr = new ArrayList<>();

        for (int idx = 2; idx < arr.length; idx++) {
            if (arr[idx] == 0)
                primeArr.add(idx);
        }
        

        return primeArr;
    }
}

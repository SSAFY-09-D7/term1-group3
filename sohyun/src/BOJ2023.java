import java.util.*;
import java.io.*;
public class BOJ2023 {
    static List<Integer> prime;
    static int[] pnum;
    
    public static void main(String[] args) {
        prime = Arrays.asList(2, 3, 5, 7 );
        pnum = new int[] { 1, 2, 3, 5, 7,9 };
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            for (int i = 0; i < prime.size(); i++) {
                System.out.println(prime.get(i));
            }
        }
        else {
            
            for (int cnt = 1; cnt < N; cnt++) {

                prime = updatePrime(prime, pnum);
            }
            for (int primeN : prime) {
                System.out.println(primeN);
            }
        }

        
    }   

    private static List<Integer> updatePrime(List<Integer> prime, int[] pnum) {
        List<Integer> newPrime = new ArrayList<Integer>();
        for (int k = 0; k < prime.size(); k++) {
            int n = prime.get(k) * 10;
            for (int j = 0; j < pnum.length; j++) {
                int p = pnum[j];
                int newP = n + p;
                if (isPrime(newP)) {
                    newPrime.add(newP);
                }
            }

        }
        return newPrime;
    }

    //단일 숫자 소수 여부 확인
    private static boolean isPrime(int number){
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0) return false;
        }
        return true;
    }
}

import java.util.*;

public class BOJ1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			cnt += findPrime(sc.nextInt());
		}
		System.out.println(cnt);
	}

	public static int findPrime(int n) {
		for(int i = 1;i*i<=n;i++) {
			if(i*i == n) return 0;
			if(n%i==0 && i != 1) return 0;
		}
		return 1;
	}
}

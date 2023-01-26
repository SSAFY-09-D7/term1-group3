import java.util.Scanner;

public class BOJ2501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();
		int cnt = 0;
		for(int i = 1;i<=n;i++) {
			if(n%i==0) cnt++;
			if(cnt == k) {
				System.out.println(i);
				break;
			}else {
				if(i == n) System.out.println(0);
			}
		}
	}

}

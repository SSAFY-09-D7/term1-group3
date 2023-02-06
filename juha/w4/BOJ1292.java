import java.util.*;

public class BOJ1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int sum = findSum(a, b);
		
		System.out.println(sum);
	}
	
	public static int findSum(int a, int b) {
		int sum = 0;
		for(int i = a;i <= b;i++) {
			int n = 1;
			while(true) {
				if(i<= (n*(1+n)/2)) {
					sum += n;
					break;
				}else n++;
			}
		}
		return sum;
	}
}

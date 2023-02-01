import java.util.*;
import java.lang.*;

public class BOJ10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n) {
		if(n == 1|| n == 0) {
			return n;
		}else{
		return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}

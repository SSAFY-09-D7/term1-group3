import java.util.*;

public class BOJ2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		int max = 0, min;
		for(int i = 1;i<=a;i++) {
			if(a%i==0) {
				if(b%i==0) {
					max = i;
				}
			}
		}
		System.out.println(max);
		min = a * (b/max);
		System.out.println(min);
	}

}

import java.util.*;

public class BOJ3460 {
	public static void binary(String binaryString) {
		for(int i = binaryString.length()-1;i>=0;i--) {
			if(binaryString.charAt(i) == '1') {
				System.out.print((binaryString.length()-1-i) + " ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0;test_case<T;test_case++) {
			int n;
			n = sc.nextInt();
			String binaryString = Integer.toBinaryString(n);
			binary(binaryString);
		}
	}
}

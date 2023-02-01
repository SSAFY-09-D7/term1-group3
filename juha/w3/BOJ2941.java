import java.util.*;

public class BOJ2941 {
	static String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		for(int i = 0;i<8;i++) {
			input = input.replace(alphabet[i], "a");
		}
		
		System.out.println(input.length());
	}
}

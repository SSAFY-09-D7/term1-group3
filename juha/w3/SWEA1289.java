import java.util.*;

public class SWEA1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T;test_case++) {
			String bit = sc.next();
			
			
			System.out.println("#" + test_case + " " + calcNum(bit));
		}
	}
	
	public static int calcNum(String bit) {
		int cnt = 1, ans = 0;
		for(int i = bit.length()-1; i>0;i--) {
			if(bit.charAt(i) == bit.charAt(i-1)) {
				cnt++;
			}else {
				bit = bit.substring(0, i) + bit.substring(i).replace(bit.charAt(i), bit.charAt(i-1));
				System.out.println(bit);
				ans++;
				cnt = 1;
			}
		}
		if(bit.charAt(0) != '0') {
			bit = bit.replace('1', '0');
			System.out.println(bit);
			ans++;
		}
		
		return ans;
	}

}

import java.util.*;

public class SWEA1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1;test_case<=T;test_case++) {
			int n = sc.nextInt();
			long[] price = new long[n];
			for(int i = 0;i<n;i++) {
				price[i] = sc.nextInt();
			}
			
			long sum = 0;
			
			for(int i = n-1;i>0;i--) {
				int cnt = i-1;
				while(true) {
					if(cnt ==-1) break;
					if(price[i] > price[cnt]) {
						sum += price[i] - price[cnt--];
					}else {
						cnt++;
						break;
					}
				}
				i = cnt;
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}

}

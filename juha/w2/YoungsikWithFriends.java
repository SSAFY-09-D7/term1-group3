import java.util.*;
import java.lang.*;

public class YounsikWithFriends {
	
	public static int cal(int n, int m, int l) {
		int[] arr = new int[n];
		int cnt = 0, start = 0;
		while(true) {
			arr[start]++;
			if(arr[start] == m) break;
			cnt++;
			if(arr[start]%2==0) {
				if(start - l >= 0) {
				start -= l;
				}else {
					start = n - Math.abs(start - l);
				}
			}else {
				if(start + l < n) {
				start += l;
				}else {
					start = Math.abs( n-1 - start-l) - 1;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, l;
		n = sc.nextInt();
		m = sc.nextInt();
		l = sc.nextInt();
		
		System.out.println(cal(n, m, l));
	}

}

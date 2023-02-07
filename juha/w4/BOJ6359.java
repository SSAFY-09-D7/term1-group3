import java.util.*;

public class BOJ6359 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int test_case = 0; test_case<t;test_case++) {
			int n = sc.nextInt();
			int[] room = new int[n];
			
			openOrClose(room);
			int cnt = 0;
			for(int i = 0;i<n;i++) {
				if(room[i] == 1) cnt++;
			}
			
			System.out.println(cnt);
		}
	}

	private static void openOrClose(int[] room) {
		for(int i = 1;i<=room.length;i++) {
			for(int j = 1;j*i<=room.length;j++) {
				if(room[i*j-1] == 0) room[i*j-1] = 1;
				else room[i*j-1] = 0;
			}
		}
	}

}

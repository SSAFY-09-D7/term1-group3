import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
	private static int n, m;
	private static int[] arr, sum;
	private static boolean check = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 9;
		m = 7;
		arr = new int[m];
		sum = new int[m];
		
		int[] dwarf = new int[n];
		for(int i = 0;i<9;i++) {
			dwarf[i] = sc.nextInt();
		}
		Arrays.sort(dwarf);
		
		
		combination(0,0,dwarf);
		
	}

	private static void combination(int cnt, int start, int[] dwarf) {
		if(cnt == m){
			if(sum[m-1]==100 && check == false) {
				check = true;
				for(int i = 0;i<m;i++)
					System.out.println(arr[i]);
			}
			return;
		}
		for(int i = start;i<n;i++) {
			if(cnt == 0) sum[cnt] = dwarf[i];
			else sum[cnt] = sum[cnt-1] + dwarf[i];
			arr[cnt] = dwarf[i];
			combination(cnt+1, i+1, dwarf);
		}
	}
}

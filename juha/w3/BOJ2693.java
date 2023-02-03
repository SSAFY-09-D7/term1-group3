import java.util.*;

public class BOJ2693 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0;i<T;i++) {
			Integer[] arr = new Integer[10];
			
			for(int j = 0;j<10;j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr, Collections.reverseOrder());
			System.out.println(arr[2]);
		}
	}

}

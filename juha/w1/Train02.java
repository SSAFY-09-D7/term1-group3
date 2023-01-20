import java.util.*;
import java.lang.*;

public class Train02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[10][2];
		
		int max = 0, sum = 0;
		for(int i = 0;i<10;i++) {
			for(int j = 0;j<2;j++) {
				arr[i][j] = sc.nextInt();
			}
			sum += -arr[i][0]+arr[i][1];
			if(max<sum) max = sum;
		}
		System.out.println(max);
	}

}

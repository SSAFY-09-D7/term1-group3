import java.util.*;
import java.lang.*;

public class BOJ1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] swi = new int[n];
		
		for(int i = 0;i<n;i++) {
			swi[i] = sc.nextInt();
		}
		
		int stuNum = sc.nextInt();
		for(int i = 0;i<stuNum;i++) {
			int gender, num;
			gender = sc.nextInt();
			num = sc.nextInt();
			
			if(gender == 1) {
				swi = male(num, swi);
			}else {
				swi = female(num-1, swi);
			}
		}
		int cnt = 0;
		while(true) {
			if(cnt>=swi.length) break;
			System.out.print(swi[cnt++] + " ");
			if(cnt%20 == 0) System.out.println();
		}
	}
	
	public static int[] male(int num, int[] swi) {
		for(int i = num-1;i<swi.length;i+=num) {
			if(swi[i] == 0) {
				swi[i] = 1;
			}else {
				swi[i] = 0;
			}
		}
		return swi;
	}
	
	public static int[] female(int num, int[] swi) {
		int i = 1;
		if(swi[num] == 0) {
			swi[num] = 1;
		}else {
			swi[num] = 0;
		}
		while(true) {
			if(num-i <0 || num+i>=swi.length) break;
			if(swi[num-i] == swi[num+i]) {
				if(swi[num+i] == 0) {
					swi[num+i] = 1;
					swi[num-i] = 1;
				}else {
					swi[num+i] = 0;
					swi[num-i] = 0;
				}
			}else {
				break;
			}
			i++;
		}
		return swi;
	}

}

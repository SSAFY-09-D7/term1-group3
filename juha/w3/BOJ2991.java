import java.util.*;
import java.lang.*;

public class BOJ2991 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dog = new int[2][2];
		
		for(int i = 0;i<2;i++) {
			for(int j = 0;j<2;j++) {
				dog[i][j] = sc.nextInt();
			}
		}
		
		int[] arrive = new int[3];
		for(int i = 0;i<3;i++) {
			arrive[i] = sc.nextInt();
			System.out.println(attack(dog[0], arrive[i]) + attack(dog[1], arrive[i]));
		}
	}
	
	public static int attack(int[] dog, int arrive) {
		int total = dog[0]+dog[1];
		int calc;
		if(arrive%total == 0) {
			calc = total;
		}else {
			calc = arrive%total;
		}
		if(calc - dog[0] <= 0) return 1;
		else return 0;
	}
}

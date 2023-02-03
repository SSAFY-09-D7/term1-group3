import java.util.*;

public class BOJ13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();
		
		int[][] student = new int[6][2];
		for(int i = 0;i<n;i++) {
			int gender, grade;
			gender = sc.nextInt();
			grade = sc.nextInt();
			student[grade-1][gender]++;
		}
		int sum = 0;
		for(int i = 0;i<6;i++) {
			for(int j = 0;j<2;j++) {
				sum += student[i][j]/k;
				if(student[i][j]%k>0) sum++;
			}
		}
		
		System.out.println(sum);
	}

}

import java.util.Scanner;

public class BOJ2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] path = new int[6][2];
		
		for(int i =0;i<6;i++) {
			for(int j = 0;j<2;j++) {
				path[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(calcArea(path)*n);
		}
	
	public static int calcArea(int[][] path) {
		int deleteArea = 0, area = 0;
		int cnt = 0, index = 0;
		int max1=0, max2=0;
		for(int i = 0;i<6;i++) {
			if(i%2==0) max1 = Math.max(max1, path[i][1]);
			else max2 = Math.max(max2, path[i][1]);
	
			if(i>=2) {
				if(path[i][0] == path[i-2][0]) {
					cnt++;
					index = i;
				}
			}
		}
		
		area = max1*max2;
		switch(cnt) {
		case 0:
			deleteArea = path[index][1]*path[5][1];
			break;
		case 1:
			if(path.length> index+1) index--;
			deleteArea = path[index][1]*path[index-1][1];
			break;
		case 2:
			index--;
			deleteArea = path[index][1]*path[index-1][1];
			break;
		}
		
		area = area - deleteArea;
		return area;
	}
}

import java.util.*;

public class BOJ2304 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] rect = new int[1001];
		
		int max = 0, min = 0, heightMax = 0;
		for(int i = 0;i<n;i++) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			if(i == 0) min = height;
			
			rect[width] = height;
			
			max = Math.max(max, width);
			min = Math.min(min, width);
			heightMax = Math.max(heightMax, height);
		}
		
		addArea(max, min, heightMax, rect);
	}
	
	public static void addArea(int max, int min, int heightMax, int[] rect) {
		int area = straight(min, max, heightMax, rect) + deStraight(max, heightMax, rect);
		System.out.println(area);
	}

	private static int straight(int min, int max, int heightMax, int[] rect) {
		int i = min;
		int area = 0, height = 0, cnt = 1;
		while(true) {
			if(height >= rect[i]) {
				cnt++;
			}
			else {
				area += height * cnt;
				height = Math.max(height, rect[i]);
				cnt = 1;
			}
			if(height == heightMax) {
				if(rect[i] == height) {
					area += height*cnt;
					cnt = 0;
				}
			}
			if(i == max) break;
			i++;
		}
		
		return area;
	}
	
	private static int deStraight(int max, int heightMax, int[] rect) {
		int i = max;
		int area = 0, height = 0, cnt = 1;
		while(true) {
			if(height >= rect[i]) {
				cnt++;
			}
			else {
				area += height * cnt;
				height = Math.max(height, rect[i]);
				cnt = 1;
			}
			if(rect[i] == heightMax) break;
			i--;
		}
		return area;
	}

}

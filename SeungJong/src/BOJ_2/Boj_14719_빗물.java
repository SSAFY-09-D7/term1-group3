package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14719_빗물 {  // 뒤에서부터 가장 작은 최대 높이를 찾고 
							 // rightIndex 구하는거 다시 
	static int[] arr;
	static int leftHeight;
	static int leftIndex;
	static int rightHeight;
	static int rightIndex;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[W];
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				leftIndex = i;
				break;
			}
		}
		rightIndex = W-1;
		for (int i = W-1; i > leftIndex; i--) {
			if(arr[rightIndex] <= arr[i]) {
				rightIndex = i;
			} else if(arr[leftIndex] < arr[i] && arr[i] < arr[rightIndex]) {
				rightIndex = i;
			}
		}
		if(leftIndex == rightIndex) {
			System.out.println("0");
			return;
		}
		calcRain();
		while(rightIndex!=W-1) {
			leftIndex = rightIndex;
			rightIndex = W-1;
			for (int i = W-1; i > leftIndex; i--) {
				if(arr[rightIndex] <= arr[i]) {
					rightIndex = i;
				}else if(arr[leftIndex] < arr[i] && arr[i] < arr[rightIndex]) {
					rightIndex = i;
				}
			}
			calcRain();
		}
		System.out.println(ans);

		

	}
	private static void calcRain() {
		int min = Math.min(arr[leftIndex], arr[rightIndex]);
		for (int i = leftIndex; i < rightIndex; i++) {
			if(arr[i] < min) {
				ans += min - arr[i];
			}
		}
	}
}

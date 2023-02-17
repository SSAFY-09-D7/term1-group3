package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10972_다음순열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		if(nextPermutation(arr)) {
			for (int i = 0; i < arr.length; i++) sb.append(arr[i]+" ");
		} else sb.append("-1");
		System.out.println(sb);
	}

	private static boolean nextPermutation(int[] arr) {
		int len = arr.length;
		int top = len-1;
		while(top>0 && arr[top-1] >= arr[top]) top--;
		if(top==0) return false;
		
		int change = len-1;
		while(arr[top-1] >= arr[change]) change--;
		
		swap(arr,top-1, change);
		
		int k = len -1;
		while(top < k) swap(arr, top++, k--);
		return true;
	}

	private static void swap(int[] arr, int i, int change) {
		int temp = arr[i];
		arr[i] = arr[change];
		arr[change] = temp;
	}

}

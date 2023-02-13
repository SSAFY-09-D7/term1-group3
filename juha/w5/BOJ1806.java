import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		str = bf.readLine();
		st = new StringTokenizer(str);
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = findMin(arr,s);
		if(min != Integer.MAX_VALUE) {
			System.out.println(min);
		}else System.out.println(0);
		
	}

	private static int findMin(int[] arr, int s) {
		int min = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
		while(true) {
			if(start == arr.length) break;
			if(end == arr.length) {
				sum = 0;
				start++;
				end = start;
				continue;
			}

			sum += arr[end];
			if(sum>=s) {
				sum = 0;
				min = Math.min(min, end-start+1);
				start++;
				end = start;
				continue;
			}
			end++;
		}
		return min;
	}



}

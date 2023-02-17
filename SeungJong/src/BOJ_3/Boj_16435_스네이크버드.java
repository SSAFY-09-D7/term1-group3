package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_16435_스네이크버드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		while(true) {
			boolean isFind = false;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] <= L) {
					L++;
					arr[i] = Integer.MAX_VALUE;
					isFind = true;
					break;
				}
			}
			if(!isFind) break;
		}
		System.out.println(L);
	}

}

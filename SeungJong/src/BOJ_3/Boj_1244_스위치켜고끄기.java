package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244_스위치켜고끄기 {

	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			changeSwitch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		print();
	}
	private static void print() {
		int cur = 1;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(cur == 20) {
				System.out.println();
				cur = 0;
			}
			cur++;
		}
	}
	private static void changeSwitch(int gender, int index) {
		switch(gender) {
		case 1: // 남자
			if(index == 1) {
				for (int i = 0; i < arr.length; i++) {
					if(arr[i] == 1) arr[i] = 0;
					else arr[i] = 1;
				}
			}else {
				for (int i = 0; i < arr.length; i++) {
					if((i+1) % index == 0) {
						if(arr[i] == 1) arr[i] = 0;
						else arr[i] = 1;
					}
				}
			}
			break;
		case 2: // 여자
			int l = index -1;
			int r = index -1;
			while(true) {
				if(l-1>=0 && r+1 <= N-1) {
					l--;
					r++;
				}
				else break;
			}
			int left = index - 1;
			int right = index - 1;
			while(true) {
				if(arr[left] != arr[right]) {
					break;
				}
				else {
					if(arr[left] == 1) {
						arr[left] = 0;
						arr[right] = 0;
					}else {
						arr[left] = 1;
						arr[right] = 1;
					}
				}
				if(left == l || right == r) break;
				left--;
				right++;
			}

		}
	}

}

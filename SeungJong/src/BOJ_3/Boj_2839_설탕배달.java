package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2839_설탕배달 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count5 = 0;
		int max5Count = 0;
		while(true) {
			if((N - count5) % 3 == 0) {
				max5Count = count5;
//				System.out.println(count5);
			}
			count5 += 5;
			if(count5 > N) break;
		}
		// max5Count = 나눴을 때 3이 남는 최대 5의 배수
		int cnt = 0;
//		System.out.println(max5Count);
		if((N-max5Count)%3!=0) {
			cnt = -1;
		} else {
			cnt = (N-max5Count)/3;
			cnt += max5Count / 5;
		}
		System.out.println(cnt);
	}
	
}

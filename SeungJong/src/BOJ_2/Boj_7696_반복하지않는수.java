package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_7696_반복하지않는수 {

	public static void main(String[] args) throws Exception{
		int n = -1;
		StringBuilder sb = new StringBuilder();
		while(n!=0) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			int ans = n;
			for (int i = 1; i <= n; i++) {
				String str = Integer.toString(i);
				if(str.length()>1) {
					for (int j = 0; j < str.length()-1; j++) {
						String temp = str.substring(j, j+1);
						if(str.substring(j+1).contains(temp)) {
							n++;
							ans++;
							break;
						}
					}
				}

			}
			if(ans!=0) sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

}

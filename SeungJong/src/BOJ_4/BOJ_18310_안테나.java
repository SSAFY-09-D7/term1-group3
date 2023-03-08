package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_18310_안테나 {
	static int N;
	static int[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		if(N<=2) {
			System.out.println(map[0]);
		}else {
			Arrays.sort(map);
			if(N%2==0) {
				System.out.println(map[N/2-1]);
			}else System.out.println(map[N/2]);
		}
	}
}

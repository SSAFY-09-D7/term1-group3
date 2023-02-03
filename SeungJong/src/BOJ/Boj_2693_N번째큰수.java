package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_2693_N번째큰수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				list.add(Integer.parseInt(st.nextToken()));				
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.println(list.get(2));
			list.clear();
		}
	}
}

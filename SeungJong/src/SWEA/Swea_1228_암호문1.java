package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_1228_암호문1 {

	static ArrayList<Integer> arrList = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			arrList.clear();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrList.add(Integer.parseInt(st.nextToken()));
			}
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for (int j = index; j < index+count; j++) {
					arrList.add(j, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+tc+" ");
			for (int j = 0; j < 10; j++) {
				System.out.print(arrList.get(j) + " ");
			}
			System.out.println();
		}
	}

}

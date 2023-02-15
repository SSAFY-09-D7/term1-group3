package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			arrList.add(i);
		}
		int nowIndex = K-1;
		for (int i = 0; i < N; i++) {
			ans.add(arrList.get(nowIndex));
			arrList.remove(nowIndex);
			nowIndex--;
			for (int j = 0; j < K; j++) {
				nowIndex++;
				if(nowIndex == arrList.size()) nowIndex = 0;
			}
		}
		sb.append("<");
		for (int i = 0; i < ans.size()-1; i++) {
			sb.append(ans.get(i)+", ");
		}
		sb.append(ans.get(ans.size()-1)+">");
		System.out.println(sb);
	}
}

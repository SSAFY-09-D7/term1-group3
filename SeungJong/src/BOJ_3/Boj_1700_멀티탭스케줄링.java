package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1700_멀티탭스케줄링 {

	static int ans;
	static int N;
	static ArrayList<String> plug, next;
	static ArrayList<String> endNext = new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] str = new String[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			str[i] =  st.nextToken();
		}
		plug = calcPlug(str, 0, N);
		if(plug == null) {
			System.out.println(ans);
		} else {
			int lastIndex = N;
			for (int i = N; i < str.length-N; i++) {  // 마지막 N-1개 체크 못함
				if(!plug.contains(str[i])) {
					endNext.clear();
					for (int j = i+1; j < str.length; j++) {
						endNext.add(str[j]);
					}
					change(str[i]);
					ans++;
				}
				lastIndex++;
			}
			for (int i = lastIndex; i < str.length; i++) {
				
				if(!plug.contains(str[i])) {
					ans++;
				}
			}
			System.out.println(ans);			
		}
	}


	private static void change(String find) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		int maxIdx = 0;
		for (int i = 0; i < plug.size(); i++) {
			if(endNext.contains(plug.get(i))) {
				int index = endNext.indexOf(plug.get(i));
				hmap.put(index, plug.get(i));
				maxIdx = Math.max(maxIdx, index);
			}
			else {
				plug.remove(plug.get(i));
				plug.add(find);
				return;
			}
		}
		plug.remove(hmap.get(maxIdx));
		plug.add(find);
	}
	private static ArrayList<String> calcPlug(String[] str, int i, int n) {
		ArrayList<String> temp = new ArrayList<String>();
		while(temp.size() != n) {
			if(i+1 == str.length) {
				temp = null;
				ans = 0;
				return null;
			}
			String check = str[i];
			if(!temp.contains(check)) {
				temp.add(check);
			}
			i++;
		}
		return temp;
	}
}


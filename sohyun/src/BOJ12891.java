
import java.util.*;
import java.io.*;
public class BOJ12891 {
	static int aCnt;
	static int cCnt;
	static int gCnt;
	static int tCnt;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//문자ㅕㅇㄹ길이
		int S = Integer.parseInt(st.nextToken());
		//부분문자열 길이
		int P = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		
		
		aCnt = Integer.parseInt(st.nextToken());
		cCnt = Integer.parseInt(st.nextToken());
		gCnt = Integer.parseInt(st.nextToken());
		tCnt = Integer.parseInt(st.nextToken());
		
		
		HashMap<Character,Integer> hs = new HashMap();
		hs.put('A', 0);
		hs.put('C', 0);
		hs.put('G', 0);
		hs.put('T', 0);
		
		for(int i=0;i<P;i++) {
			hs.put(str.charAt(i), hs.get(str.charAt(i))+1);
		}
		
		
		if(check(hs)) answer++; 
		
		//슬라이딩 윈도우
		for(int i=1;i+P-1<S;i++) {
			char del = str.charAt(i-1);
			char add = str.charAt(i+P-1);
			hs.put(del, hs.get(del)-1);
			hs.put(add, hs.get(add)+1);
			if(check(hs)) answer++; 
			
		}
		System.out.println(answer);
	}

	private static boolean check(HashMap<Character, Integer> hs) {
		for(Character key: hs.keySet()) {
			if (key == 'A') {
				if (hs.get(key) < aCnt)
					return false;
			}
			if (key == 'C') {
				if (hs.get(key) < cCnt)
					return false;
			}
			if (key == 'G') {
				if (hs.get(key) < gCnt)
					return false;
			}
			if(key=='T'){
				if(hs.get(key)<tCnt) return false;
			}
			
		}
		return true;
	}
}

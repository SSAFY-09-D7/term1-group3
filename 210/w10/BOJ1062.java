package w10;

import java.util.*;
import java.io.*;

public class Main {
	static int N, K, result = -1;
	static Set<Character> originSet = new HashSet<>(Set.of('a', 'n', 't', 'i', 'c'));
	static Set<Character> optionSet = new HashSet<>();
	static String[] words;
	static Character[] letters;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./inputs/input_BOJ1062.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			for (int j = 4; j < words[i].length() - 4; j++) {
				if (!originSet.contains(words[i].charAt(j)))
					optionSet.add(words[i].charAt(j));
			}
		}
		
		 letters = optionSet.toArray(new Character[0]);
		 
		 if (K < 5) System.out.println(0);
		 else {
			 find(originSet, 0, 5);
			 System.out.println(result);
		 }
	}
	
	private static void find(Set<Character> sel, int start, int depth) {
		if (depth == K || start >= letters.length) {
			result = Math.max(getPossibleCnt(sel), result);
			return;
		}
		
		for (int i = start; i < letters.length; i++) {
			sel.add(letters[i]);
			find(sel, i + 1, depth + 1);
			sel.remove(letters[i]);
		}
	}

	private static int getPossibleCnt(Set<Character> sel) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			boolean isPossible = true;
			for (int j = 4; j < words[i].length() - 4; j++) {
				if (!sel.contains(words[i].charAt(j))) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				cnt++;
			}
		}

		return cnt;
	}
}

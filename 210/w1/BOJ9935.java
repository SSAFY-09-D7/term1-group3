package w1;

import java.util.*;
import java.io.*;

class solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("../inputs/input_BOJ9935.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String target = br.readLine();
		int size = target.length();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			sb.append(c);
			if (sb.length() >= size) {
				boolean isSame = true;
				for (int j = 0; j < size; j++) {
					char c1 = sb.charAt(sb.length() - size + j);
					char c2 = target.charAt(j);
					if (c1 != c2) {
						isSame = false;
						break;
					}
				}
				
				if (isSame) {
					sb.delete(sb.length()-size, sb.length());
				}
			}
		}
		
		String res = sb.length() == 0? "FRULA" : sb.toString();

		System.out.println(res);
		br.close();
	}
}

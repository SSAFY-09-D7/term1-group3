package w04;

import java.io.*;
import java.util.*;

class Main
{
	public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1662.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		char[] chars = br.readLine().toCharArray();
		int result = 0;
		
		for (int i = 0; i < chars.length; i++) {
			if (i < chars.length - 1 && chars[i+1] == '(') {
				s.add( -1 * (chars[i] - '0') -1);
				i++;
				continue;
			}
			
			if (chars[i] == ')') {
				int cnt = 0;
				while(s.peek() >= 0) {
					cnt+=s.pop();
				}
				cnt = ((s.pop() + 1) * -1) * cnt;
				s.push(cnt);
				continue;
			}
			
			s.add(1);
		}
		
		while(!s.empty()) {
			result += s.pop();
		}
		
		System.out.println(result);
	}
}


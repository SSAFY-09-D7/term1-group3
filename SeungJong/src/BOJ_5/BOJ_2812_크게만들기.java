package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_2812_크게만들기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int k = K;
		String a = br.readLine();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < a.length(); i++) {
			while(!stack.isEmpty() && k>0 && stack.peek() < a.charAt(i)) {
				k--;
				stack.pop();
			}
			stack.push(a.charAt(i));
		}
		Stack<Character> temp = new Stack<>();
		if(stack.size()>N-K) {
			while(stack.size() != N-K) {
				stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		
		while(!temp.isEmpty()) {
			System.out.print(temp.pop());
		}
	}
}

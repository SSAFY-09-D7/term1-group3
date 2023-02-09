
import java.util.*;
import java.io.*;
public class BOJ2504 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<Character> score = new Stack<>();
		
		int i=0;
		int answer = 0;
		while (i < s.length()) {
			char now = s.charAt(i);
			//닫힌 괄호면 ),']'

			if (now == ')') {
				boolean isFind = false;
				while (!stack.isEmpty()) {
					char opo = stack.pop();
					if (opo == '(') {
						isFind = true;
						// score.add('2');
						break;
					}

				}
				if (isFind) {
					//찾았으면
					//2점을 더하는지 곱하는지??

				} else {
					//없으면 오류임
					answer = 0;
					break;
				}


			} else if (now == ']') {
				boolean isFind = false;
				while (!stack.isEmpty()) {
					char opo = stack.pop();
					if (opo == '[') {
						isFind = true;
						// score.add('3');
						break;
					}
				}
				if (isFind) {
				} else {

					answer = 0;
					break;
				}
			} else if (now == '(' || now == '[') {
				stack.add(now);
				if (i == 0) {
					if (now == '(')
						score.add('2');
					else
						score.add('3');
				}
				
				if (i < s.length() - 1 && i > 0) {
					if (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '[') {
						score.add('*');
						if(s.charAt(i)=='(')
							score.add('2');
						else
							score.add('3');
					} else if (s.charAt(i - 1) == ']'||  s.charAt(i - 1) == ')') {
						
						score.add('+');
						if(s.charAt(i)=='(')
							score.add('2');
						else
							score.add('3');
					}
				} 

			}
			i++;
			
			if(stack.isEmpty()) System.out.println(score);
			// System.out.println(score);
		}

		System.out.println(answer);
	}

}

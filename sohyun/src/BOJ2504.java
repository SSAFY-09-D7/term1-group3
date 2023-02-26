
import java.util.*;
import java.io.*;
public class BOJ2504 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		
		
		int answer = 0;
		int tmp = 1;
		for (int i = 0; i < s.length; i++) {
			char now = s[i];
			if (now == '(') {
				tmp *= 2;
				stack.push(now);
			}
			else if (now == '[') {
				tmp *= 3;
				stack.push(now);
			}
			else if (now == ')') {
				if (!stack.isEmpty()) {
					char top = stack.pop();
					if (top== '(') {
						if(s[i-1]=='(')
							answer += tmp;
						tmp /= 2;

					}
					else {
						answer = 0;
						break;
					}
				}
				else {
					answer = 0;
					break;
				}

			} else if (now == ']') {
				if (!stack.isEmpty()) {
					char top = stack.pop();
					if (top == '[') {
						if(s[i-1]=='[')
							answer += tmp;
						tmp /= 3;
					}
					else {
						answer = 0;
						break;
					}
					
				}
				else {
					answer = 0;
					break;
				}
			}
			
		}

		if (!stack.isEmpty()) {
			answer = 0;
		}
		System.out.println(answer);
		
	}

}

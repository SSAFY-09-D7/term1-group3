package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2504_괄호의값 {

	static Stack<String> stack = new Stack<String>();
	static int tempSum = 0;
	static Stack<String> tempStack = new Stack<String>();
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.replace("()", "2");
		str = str.replace("[]", "3");
		String[] arr = new String[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.substring(i, i+1);
			stack.push(arr[i]);
		}
		int temp = 0;
		L:while(!stack.empty()) {
			switch(checkType(stack.peek())) {
			case 1:  // (, [ 
				if(tempStack.empty()) {   // ( 나 [ 가 있을 때 짝이 없다면 0
					ans = 0;
					break L;
				}
				if(checkType(tempStack.peek()) != 3) {  // 이것도 짝이 안맞으면 0
					ans = 0;
					break L;
				}
				temp = Integer.parseInt(tempStack.pop());
				if(stack.peek().equals("(")) {  // ( 값 ) 이면 값 * 2
					if(!tempStack.empty() && tempStack.peek().equals("]")) {
						ans = 0;
						break L;
					}
					temp *= 2;
				} else if(stack.peek().equals("[")){
					if(!tempStack.empty() && tempStack.peek().equals(")")) {
						ans = 0;
						break L;
					}
					temp *= 3;  
				}
				tempStack.pop();
				stack.pop();
				stack.push(Integer.toString(temp));
				break;
			case 2:  // ), ]
				tempStack.push(stack.pop());
				break;
			case 3: // 숫자
				if(tempStack.empty()) {  // tempStack이 비어 있으면 정답에 값 더하기	
					ans += Integer.parseInt(stack.pop());
				} else if(checkType(tempStack.peek()) == 3) {  // tempStack에 숫자가 있으면 두 수 더하기
					temp = Integer.parseInt(stack.pop()) + Integer.parseInt(tempStack.pop());
					stack.push(Integer.toString(temp));
					temp = 0;
				} else {  // tempStack이 비어있지 않고, 숫자가 아니면 tempStack에 숫자 push
					tempStack.push(stack.pop());
				}
				break;
			}
		}
		if(!tempStack.empty()) {
			ans = 0;
		}
		System.out.println(ans);
	}
	private static int checkType(String s) {
		switch (s) {
		case "(":
		case "[":
			return 1;
		case ")":
		case "]":
			return 2;
		default:
			return 3;
		}
	}
}

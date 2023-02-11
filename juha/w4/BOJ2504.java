package com.w4;

import java.util.*;

public class BOJ2504 {
	static Stack<Integer> ans = new Stack<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ex = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		inputData(ex, stack);
		
		
		if(stack.size() == 1 && !ans.isEmpty()) {
			System.out.println(ans.peek());
		}else System.out.println(0);
		
	}

	private static void inputData(String ex, Stack<Character> stack) {
		for(int i = 0;i<ex.length();i++) {
			char c = ex.charAt(i);
			switch(c) {
			case '(':
				stack.push(c);
				break;
			case '[':
				stack.push(c);
				break;
			case ')':
				if(!stack.empty()) {
					if(stack.peek() == '(') {
						stack.pop();
						stack.push('2');
						ans.push(2);
					}else if(stack.peek() > '0' && stack.peek() != '['){
						stack.pop();
						int temp = ans.pop();
						while(true) {
							if(stack.empty()) {
								stack.push('!');
								break;
							}
							if(stack.peek() == '(') {
								stack.pop();
								temp = temp * 2;
								stack.push('2');
								ans.push(temp);
								break;
							}else if(stack.peek() > '0' && stack.peek() != '[') {
								stack.pop();
								temp += ans.pop();
							}else break;
						}
					}
				}else stack.push('!');
				break;
			case ']':
				if(!stack.empty()) {
					if(stack.peek() == '[') {
						stack.pop();
						stack.push('3');
						ans.push(3);
					}else if(stack.peek() > '0'){
						stack.pop();
						int temp = ans.pop();
						while(true) {
							if(stack.empty()) {
								stack.push('!');
								break;
							}
							if(stack.peek() == '[') {
								stack.pop();
								temp = temp * 3;
								stack.push('3');
								ans.push(temp);
								break;
							}else if(stack.peek() > '0') {
								stack.pop();
								temp += ans.pop();
							}else break;
						}
					}
				}else stack.push('!');
				break;
			default:
				stack.push('!');
				break;
			}
		}
		
		if(stack.size()>1 && stack.peek() > '0' && stack.peek() != '[') {
			stack.pop();
			int temp = ans.pop();
			while(true) {
				if(stack.peek()>'0'&& stack.peek() != '[') {
					stack.pop();
					temp += ans.pop();
				}else {
					stack.push((char) (temp + '0'));
					break;
				}
				if(stack.empty()) {
					stack.push((char) (temp + '0'));
					ans.push(temp);
					break;
				}
			}
		}
		
	}

}


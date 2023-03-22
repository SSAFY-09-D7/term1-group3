package w04;

import java.io.*;
import java.util.*;

class Main
{
	static boolean isPossible = false;
	static boolean toRight = false;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("./inputs/input_BOJ2504.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Stack<Integer> s = new Stack<>();
    	int result = 0;
    	char[] inputs = br.readLine().toCharArray();
    	
    	for (char c : inputs) {
    		int e = getNum(c);	// (:-1, ):-2, [:-5, ]:-6
    		
    		if (needToPush(s, e)) {
    			s.push(e);
    			
    		} else {
    			int n = -1;
    			if (s.peek() - e == 1) {
    				s.pop();
    	    		n = e == -2 ? 2 : 3;
    	    		
    	    	} else if (needToMul(s, e)) {
    	        	n = s.pop();
    	        	s.pop();
    	        	n = e == -2 ? n*2 : n*3;
    	        }
    			
    			
    			if (s.empty()) {
    				result += n;
    			} else if (s.peek() > 0) {
    				s.push(n+s.pop());
    			} else {
    				s.push(n);
    			}
    		}
    	}
    	
    	System.out.println(s.isEmpty()? result : 0);

    	
	}
	
	private static int getNum(char c) {
		if (c == '(') return -1;
		if (c == ')') return -2;
		if (c == '[') return -5;
		return -6;
		
	}
	
	private static boolean needToPush(Stack<Integer> s, int e) {
		if (s.isEmpty()) return true;
		if (s.peek() < 0) {
			if (s.peek() - e != 1) return true;
			else return false;
		}
		int tmp = s.pop();
		if (s.peek() - e != 1) {
			s.push(tmp);
			return true;
		}
		s.push(tmp);
		return false;
	}
	
	private static boolean needToMul(Stack<Integer> s, int e) {
		if (s.peek() < 0) return false;
		int tmp = s.pop();
		if (s.peek() - e == 1) {
			s.push(tmp);
			return true;
		}
		s.push(tmp);
		return false;
	}
}
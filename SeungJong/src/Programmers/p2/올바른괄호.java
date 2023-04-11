package Programmers.p2;

import java.util.*;
public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i) == ')') return false;
                stack.push(s.charAt(i));    
            }
            else {
                if(s.charAt(i) == ')') stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
package w4;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ4933.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	int[] tree1 = getTree(br.readLine().split(" "));
        	int[] tree2 = getTree(br.readLine().split(" "));
        	
        	boolean isEqual = checkEqual(tree1, tree2);
        	
        	System.out.println(isEqual);
        }
        
    }
    
    private static int[] getTree(String[] strs) {
    	int[] tree = new int[strs.length];
    	Stack<Integer> s = new Stack<>();
    	
    	for (String str : strs) {
    		if (str.equals("end")) break;
    		if (str.equals("nil")) {
    			s.add(0);
    		} else {
    			s.add(str.charAt(0)-'A'+1);
    		}
    	}
    		
    	makeTree(s, tree, 1);
    	
    	return tree;
    }
    
    private static void makeTree(Stack<Integer> s, int[] tree, int treeIdx) {
    	if (s.empty()) return;
    	if (s.peek() == 0) { 
    		s.pop();
    		return;
    	}
    	tree[treeIdx] = s.pop();
    	
    	makeTree(s, tree, treeIdx * 2 + 1);
    	makeTree(s, tree, treeIdx * 2);
    }
    
    private static boolean checkEqual(int[] tree1, int[] tree2) {
    	if (tree1.length == 0 && tree2.length == 0) return true;
    	if (tree1.length == 1 && tree2.length == 1) return true;
    	if(checkSameTree(tree1, 2, tree2, 2) && checkSameTree(tree1, 3, tree2, 3)) return true;
    	if(checkSameTree(tree1, 3, tree2, 2) && checkSameTree(tree1, 2, tree2, 3)) return true;

    	return false;
    }
    
    private static boolean checkSameTree(int[] tree1, int i, int[] tree2, int j) {
    	return (getString(tree1, i).equals(getString(tree2, j)));
    }
    
    private static String getString(int[] tree, int idx) {
    	if (idx >= tree.length) return "";
    	if (idx * 2 >= tree.length) return String.valueOf(tree[idx]);
    	if (tree[idx * 2] >= tree[idx*2 + 1]) {
    		return String.valueOf(tree[idx]) + getString(tree, idx * 2) + getString(tree, idx * 2 + 1);
    	}
    	else return String.valueOf(tree[idx]) + getString(tree, idx * 2 + 1) + getString(tree, idx * 2);
    }
}
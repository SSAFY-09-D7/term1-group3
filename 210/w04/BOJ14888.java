package w04;

import java.io.*;
import java.util.*;

class Main {
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ14888.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] operands = new int[n];
    	ArrayList<Integer> operators = new ArrayList<>();
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		operands[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < 4; i++) {
    		int cnt = Integer.parseInt(st.nextToken());
    		for (int j = 0; j < cnt; j++) {
    			operators.add(i);
    		}
    	}
    	
    	
    	perm(operators, operators.size(), new int[operators.size()], 0, new boolean[operators.size()], operands);
    	System.out.println(max + "\n" + min);
	}
	
	private static void perm(ArrayList<Integer> operators, int r, int[] temp, int current, boolean[] visited, int[] operands) {
		if (r == current) {
			int calcNum = calc(temp, operands);
			max = Math.max(max, calcNum);
			min = Math.min(min, calcNum);
			return;
		} 
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[current] = operators.get(i);
				perm(operators, r, temp, current +1, visited, operands);
				visited[i] = false;
			}
		}
	}
	
	private static int calc(int[] operators, int[] operands) {
		int result = operands[0];
		for (int i = 1; i < operands.length; i++) {
			if (operators[i-1] == 0) result+=operands[i];
			else if (operators[i-1] == 1) result-=operands[i];
			else if (operators[i-1] == 2) result*=operands[i];
			else if (operators[i-1] == 3) result/=operands[i];
		}
			
			
		return result;
	}
}

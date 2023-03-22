package w06;

import java.io.*;
import java.util.*;

class Main {
	static int N;
	static char[][] board;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("./inputs/input_BOJ1789.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        
        for (int i = 0; i < N; i++) {
        	board[i] = br.readLine().toCharArray();
        }
        
        System.out.println(findMax());
    }
    
    private static int findMax() {
    	int max = -1;
    	
    	for (int i = 0; i < N; i++) {
    		max = Math.max(max, getHorizonSize(i));
    		max = Math.max(max, getVerticalSize(i));
    	}
    	
    	return max;
    }
    
    private static int getHorizonSize(int pos) {
    	int size = 1;
    	for (int i = N-1; i >= 0; i--) {
    		boolean isFirst = true;
    		int currSize = 1;
    		char currChar = board[pos][i];
    		
    		for (int j = i + 1; j < N; j++) {
    			if (currChar == board[pos][j]) {
    				currSize++;
    				
    			} else if (isFirst && pos > 0 && board[pos - 1][j] == currChar) {
    				isFirst = false;
    				currSize++;
    				
    			} else if (isFirst && pos < N-1 && board[pos + 1][j] == currChar) {
    				isFirst = false;
    				currSize++;
    				
    			} else {
    				if (isFirst && j < N-1 && board[pos][j+1] == currChar) {
        				isFirst = false;
        				currSize++;
        			}
    				break;
    			}
    			
    		}
    		
    		if (isFirst) {
    			if (isFirst && i > 0 && pos < N-1 && board[pos + 1][i-1] == currChar) {
    				isFirst = false;
    				currSize++;
    			} else if (isFirst && i > 0 && pos > 0 && board[pos - 1][i-1] == currChar) {
    				isFirst = false;
    				currSize++;
    			} else if (isFirst && i > 1 && pos > 0 && board[pos][i-2] == currChar) {
    				isFirst = false;
    				currSize++;
    			}
    		}
    	
    		size = Math.max(currSize, size);
    	}
    	
    	return size;
    }
    
    private static int getVerticalSize(int pos) {
    	int size = 1;
    	for (int i = N-1; i >= 0; i--) {
    		boolean isFirst = true;
    		int currSize = 1;
    		char currChar = board[i][pos];
    		
    		for (int j = i + 1; j < N; j++) {
    			if (currChar == board[j][pos]) {
    				currSize++;
    				
    			} else if (isFirst && pos > 0 && board[j][pos - 1] == currChar) {
    				isFirst = false;
    				currSize++;
    				
    			} else if (isFirst && pos < N-1 && board[j][pos + 1] == currChar) {
    				isFirst = false;
    				currSize++;
    				
    			} else { 
    				if (isFirst && j < N-1 && board[j+1][pos] == currChar) {
        				isFirst = false;
        				currSize++;
        			}
    				break;
    			}
    			
    		}
    		
    		if (isFirst) {
    			if (isFirst && i > 0 && pos < N-1 && board[i-1][pos + 1] == currChar) {
    				isFirst = false;
    				currSize++;
    			} else if (isFirst && i > 0 && pos > 0 && board[i-1][pos - 1] == currChar) {
    				isFirst = false;
    				currSize++;
    			} else if (isFirst && i > 1 && pos > 0 && board[i-2][pos] == currChar) {
    				isFirst = false;
    				currSize++;
    			}
    		}
    	
    		size = Math.max(currSize, size);
    	}
    	
    	return size;
    }
}

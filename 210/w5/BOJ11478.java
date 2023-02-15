package w5;

import java.io.*;
import java.util.*;

class Main {
	static int[][] board, nums;
	static int N, M;
    public static void main(String[] arg) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ11478.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        
        for (int i = 1; i <= str.length(); i++) {
        	for (int j = 0; j <= str.length() - i; j++) {
        		set.add(str.substring(j, j+i));
        	}
        }
        
        System.out.println(set.size());
    }
 
}
package w04;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ1439.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startIdx = Integer.parseInt(st.nextToken()) - 1;
        int endIdx = Integer.parseInt(st.nextToken()) - 1;
        
        int currNum = 1;
        int smallIdx = 0;
        int idx = 0;
        int sum = 0;
        while (true) {
        	if (smallIdx == currNum) {
        		smallIdx = 0;
        		currNum++;
        	}
        	
        	if (idx >= startIdx) {
        		sum += currNum;
        	}
        	
        	idx++;
        	smallIdx++;
        	
        	if (idx > endIdx) break;
        }
        
        System.out.println(sum);
    }
}
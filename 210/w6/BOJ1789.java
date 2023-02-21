package w6;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] arg) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1789.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long S = Long.parseLong(br.readLine());
        
        long result = 0;
        long sum = 0;
        for (long i = 1; i < S; i++) {
        	sum += i;
        	if (S >= sum && S < sum + (i+1)) {
        		result = i;
        		break;
        	}
        }
        
        System.out.println(S == 1 ? 1 : result);
    }
}
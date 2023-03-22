package w04;

import java.io.*;

class Main2 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ2581.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());           
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = m; i <= n; i++) {
        	if (isPrime(i)) {
        		sum += i;
        		min = Math.min(min, i);
        	}
        }
        
        
        if (sum == 0)  System.out.println(-1);
        else  System.out.println(sum + " " + min);
        
    }
    
    private static boolean isPrime(int num) {
    	if (num == 1) return false;
    	for (int i = 2; i < (int)Math.sqrt(num); i++) {
    		if (num % i == 0) {
    			return false;
    		}
    	}
    		
    	return true;
    }
}
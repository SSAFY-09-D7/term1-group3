package w12;

import java.util.*;
import java.io.*;

class Solution
{
    static int N, target, result;
    static int[] nums;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            target = sc.nextInt();
            nums = new int[N];
            result = Integer.MAX_VALUE;
            
            for (int i = 0; i < N; i++) {
            	nums[i] = sc.nextInt();
            }
            
            find(0, 0, 0);
            System.out.println("#" + test_case + " " + result);
		}
	}
    
    public static void find(int sum, int start, int depth) {
        if(depth == N || sum >= target) {
            result = Math.min(sum-target, result);
            return;
        }
        for(int i = start; i<N; i++) {
                find(sum + nums[i], i+1, depth + 1);
        }
    }
        
}

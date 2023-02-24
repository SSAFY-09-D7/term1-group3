package w6;

import java.util.*;
import java.io.*;

class Main {
	static int N, result = Integer.MAX_VALUE;
	static int[] peopleCnt;
	static List<Integer>[] edges;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("./inputs/input_BOJ17471.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        edges = new ArrayList[N];
        peopleCnt = new int[N];

        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	peopleCnt[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	edges[i] = new ArrayList<Integer>();
        	
        	for (int j = 0; j < n; j++) {
        		edges[i].add(Integer.parseInt(st.nextToken()) - 1);
        	}
        }
        
        powerSet(0, new boolean[N]);
        System.out.println(result == Integer.MAX_VALUE? -1 : result);
    }
    
    private static void powerSet(int idx, boolean[] sel) {
        if(idx == N) {
        	if (isPossible(sel)) {
        		result = Math.min(result, getMinGap(sel));
        	}
        	
            return;
        }
        
        sel[idx]=true;
        powerSet(idx+1, sel);
        sel[idx]=false;
        powerSet(idx+1, sel);
    }
    
    private static boolean isPossible(boolean[] sel) {
    	int visitedCnt = 0, firstCnt = 0;
    	boolean[] visited = new boolean[N];
    	boolean firstBool = sel[0];
    	
    	int otherStart = -1;
    	for (int i = 0; i < N; i++) {
    		if (sel[i] != firstBool) {
    			otherStart = i;
    		} else {
    			firstCnt++;
    		}
    	}
    	
    	if (otherStart == -1) {
    		return false;
    	}
    	
    	
    	Stack<Integer> s = new Stack<>();
    	s.push(0);
    	
    	while(!s.isEmpty()) {
    		int currV = s.pop();
    		if(!visited[currV]) {
    			visitedCnt++;
    			visited[currV] = true;
    		}
    		
    		for (Integer next : edges[currV]) {
    			if (firstBool == sel[next] && !visited[next]) {
    				s.add(next);
    			}
    		}
    	}
    	
    	if (firstCnt != visitedCnt) return false;
    	
    	s.push(otherStart);
    	while(!s.isEmpty()) {
    		int currV = s.pop();
    		if(!visited[currV]) {
    			visitedCnt++;
    			visited[currV] = true;
    		}
    		
    		for (Integer next : edges[currV]) {
    			if (firstBool != sel[next] && !visited[next]) {
    				s.add(next);
    			}
    		}
    	}
    	
    	if (visitedCnt == N) return true;
    	return false;
    }
    
    private static int getMinGap(boolean[] sel) {
    	int trueSum = 0;
    	int falseSum = 0;
    	
    	for (int i = 0; i < N; i++) {
    		if (sel[i]) trueSum += peopleCnt[i];
    		else falseSum += peopleCnt[i];
    		
    	}
    	return Math.abs(trueSum - falseSum);
    }    
}
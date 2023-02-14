package w5;

import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] arg) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ1700.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] elecs = new int[101];
        int[] plugs = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
        	elecs[i] = Integer.parseInt(st.nextToken());
        	
        	if (map.containsKey(elecs[i])) {
        		map.get(elecs[i]).add(i);
        	} else {
        		map.put(elecs[i], new ArrayList<>(Arrays.asList(i)));
        	}
        	
        }        
        
        int cnt = 0;
        for (int i = 0; i < k; i++) {
        	
        	int mostIdx = -1;
        	
        	boolean added = false;
        	for (int j = 0; j < n; j++) {
        		if (plugs[j] == 0 || plugs[j] == elecs[i]) {
        			map.get(elecs[i]).remove(0);
        			plugs[j] = elecs[i];
        			added = true;
        			break;
        		}
        		
        		if (mostIdx == -1) {
        			mostIdx = j;
        		} else {        			
        			int a = map.get(plugs[mostIdx]).size() > 0 ? map.get(plugs[mostIdx]).get(0) : Integer.MAX_VALUE;
        			int b = map.get(plugs[j]).size() > 0 ? map.get(plugs[j]).get(0) : Integer.MAX_VALUE;
        			mostIdx = a > b ? mostIdx : j; 
        		}
        		
        		
        	}
        	if (added) continue;
        	plugs[mostIdx] = elecs[i];
        	if (map.get(plugs[mostIdx]).size() > 0) map.get(plugs[mostIdx]).remove(0);
        	cnt++;
        }
        
        System.out.println(cnt);
        
    }
    
}

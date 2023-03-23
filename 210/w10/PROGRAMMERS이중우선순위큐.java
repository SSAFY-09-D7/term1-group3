package w10;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        Map<Integer, Boolean> map = new HashMap<>();    // <숫자, 뽑힘여부>
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String str : operations) {
            String[] cmds = str.split(" ");
            
            if (cmds[0].equals("I")) {
                int num = Integer.parseInt(cmds[1]);
                map.put(num, false);
                minHeap.add(num);
                maxHeap.add(num);
                
                continue;
            }
            
            if (cmds[1].equals("1")) {
                while (!maxHeap.isEmpty() && map.get(maxHeap.peek()))
                    maxHeap.poll();
                
                if (!maxHeap.isEmpty())
                    map.put(maxHeap.poll(), true);  
                
                continue;
            }
            
            while (!minHeap.isEmpty() && map.get(minHeap.peek())) 
                minHeap.poll();
            
            if (!minHeap.isEmpty())
                map.put(minHeap.poll(), true);   
        }
        
        while (!maxHeap.isEmpty() && map.get(maxHeap.peek())) 
            maxHeap.poll();        
        while (!minHeap.isEmpty() && map.get(minHeap.peek())) 
            minHeap.poll();
        
        if (minHeap.isEmpty() || maxHeap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.poll(), minHeap.poll()};        
    }
}

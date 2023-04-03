package w12;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = -1;
        PriorityQueue<Book> pq = new PriorityQueue<>(Comparator.comparing(Book::getStart));
        PriorityQueue<Book> upq = new PriorityQueue<>(Comparator.comparing(Book::getEnd));
        Set<Integer> set = new HashSet<>();  
        
        for (int i = 0; i < book_time.length; i++)
            pq.add(new Book(i, book_time[i][0], book_time[i][1]));
        
        while (true) {
            if (pq.isEmpty() && upq.isEmpty()) break;
            
            if (upq.isEmpty() || (!upq.isEmpty() && !pq.isEmpty() && pq.peek().start < upq.peek().end)) {
                Book curr = pq.poll();
                set.add(curr.idx);
                upq.add(curr);
                answer = Math.max(answer, set.size());
                continue;
            }
            
            set.remove(upq.poll().idx);            
        }
        
        
        return answer;
    }
    
    class Book {
        int idx, start, end;
        
        public Book(int idx, String startStr, String endStr) {
            this.idx = idx;
            this.start = getTime(startStr);
            this.end = getTime(endStr) + 10;
        }
        
        private int getTime(String str) {
            String[] strs = str.split(":");
            return Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
        }
        
        public int getStart() {
            return start;    
        }
        
        public int getEnd() {
            return end;    
        }
        
    }
}

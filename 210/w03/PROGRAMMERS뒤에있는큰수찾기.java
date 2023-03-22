package w03;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Num> s = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while (!s.isEmpty() && s.peek().num < numbers[i]) {
                Num n = s.pop();
                answer[n.idx] = numbers[i];
            }
            s.push(new Num(numbers[i], i));
        }
        
        while (!s.isEmpty()) {
            Num n = s.pop();
            answer[n.idx] = -1;
        }

        return answer;
    }
    
    class Num {
        int num;
        int idx;
        
        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}

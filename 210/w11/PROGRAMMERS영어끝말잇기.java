import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (usedWords.contains(words[i]) ||
                words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0) ||
                words[i].length() <= 1) {
                return new int[] { (i%n) + 1, (i/n) + 1 };
            }
            usedWords.add(words[i]);
        } 

        return new int[] { 0, 0 };
    }
}

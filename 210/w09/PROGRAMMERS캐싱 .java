package w09;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length; 
        int answer = 0;

        String[] cache = new String[cacheSize];
        int[] addedTime = new int[cacheSize];
        
        for (int c = 0; c < cities.length; c++) {
            boolean added = false;
            int leastIdx = 0;
            int leastVal = addedTime[0];
            for (int i = 0; i < cacheSize; i++) {
                if (cache[i] != null && cache[i].toLowerCase().equals(cities[c].toLowerCase())) {
                    answer += 1;
                    addedTime[i] = c+1;
                    added = true;
                    break;
                }
                
                if (addedTime[i] == 0) {
                    answer += 5;
                    cache[i] = cities[c];
                    addedTime[i] = c+1;
                    added = true;
                    break;
                }
                
                if (addedTime[i] < leastVal) {
                    leastIdx = i;
                    leastVal = addedTime[i];
                }
            }
            
            if (!added) {
                answer += 5;
                cache[leastIdx] = cities[c];
                addedTime[leastIdx] = c+1;
            }
        }
        
        return answer;
    }
}

package w11;

import java.util.*;

class Solution {    
    public int solution(String[][] relation) {
        int answer = 0;
        int rowCnt = relation.length;
        int colCnt = relation[0].length;
        
        boolean[] visited = new boolean[colCnt];
        List<String> subset = new ArrayList<>();
        dfs(visited, subset, 0);
        Collections.sort(subset, (String s1, String s2) -> s1.length() - s2.length());
        
        HashSet<String> set = new HashSet<>();
        
        
        for(String currSet:subset) {
            boolean hasSubset = false;
            for(String str : set) {
                String tmp = currSet.replaceAll("[" + str + "]", "");
                if (currSet.length() - tmp.length() == str.length()) {
                    hasSubset = true;
                }
            }

            //System.out.println(currSet + " " + hasSubset);
            if(hasSubset) continue;

            List<String> rows = new ArrayList<>();
            for (String[] row: relation) {
                String element = "";
                for (char c:currSet.toCharArray()) {
                    int index = c - '0';
                    element += String.valueOf(row[index]);
                }
                if (!rows.contains(element)) rows.add(element);
            }
            if(rows.size() == rowCnt) {
                set.add(currSet);
            }
        }     
        
        return set.size();
    }
    
    void dfs(boolean[] visited, List<String> subset, int idx) {
        if (idx == visited.length) {
            String subsetStr = "";
            for(int i = 0;i<visited.length;i++) {
                if (visited[i]) subsetStr += String.valueOf(i);
            }
            if (!subsetStr.equals(""))subset.add(subsetStr);
            return;
        }
        
        visited[idx] = true;
        dfs(visited, subset, idx+1);
        visited[idx] = false;
        dfs(visited, subset, idx+1);
    }
}

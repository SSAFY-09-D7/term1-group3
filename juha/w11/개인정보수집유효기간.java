import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        int todayTotal = convert(today);
        int[] totals = new int[privacies.length];
        int[] pri = new int[privacies.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            map.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }
        String s = "";
        int idx = 0;
        for(int i = 0; i<totals.length; i++){
            totals[i] = convert(privacies[i]);
            StringTokenizer st = new StringTokenizer(privacies[i]);
            st.nextToken();
            pri[i] = map.get(st.nextToken().charAt(0))*28;
            if(todayTotal-totals[i] >= pri[i]){
                s += (i+1)+" ";
                idx++;
            }
        }
        answer = new int[idx];
        StringTokenizer st = new StringTokenizer(s);
        for(int i = 0; i<answer.length; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }
        
        
        return answer;
    }
    
    static int convert(String s){
        int year, month, day;
        StringTokenizer st = new StringTokenizer(s, ". ");
        year = Integer.parseInt(st.nextToken());
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        int ans = year*(12*28) + month*28 + day;
        return ans;
    }
}

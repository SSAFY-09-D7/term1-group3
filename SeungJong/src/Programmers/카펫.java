package Programmers;

import java.util.*;
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=yellow/2+1; i++){
            if(yellow%i == 0){
                int row = yellow / i;
                int col = i;
                if(((row*2) + (col*2) + 4) == brown){
                    list.add(row+2);
                    list.add(col+2);
                    break;
                }                  
            }
        }
        int[] answer = {list.get(0), list.get(1)};
        return answer;
    }
}
package Programmers;

import java.util.*;
public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        for(int i=0; i<answers.length; i++){
            if(a[i%a.length] == answers[i]) cntA++;
            if(b[i%b.length] == answers[i]) cntB++;
            if(c[i%c.length] == answers[i]) cntC++;
        }
        Num[] arr = new Num[3];
        arr[0] = new Num(1, cntA);
        arr[1] = new Num(2, cntB);
        arr[2] = new Num(3, cntC);
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0].person);
        for(int i=0; i<2; i++){
            if(arr[0].grade == arr[i+1].grade) list.add(arr[i+1].person);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    private static class Num implements Comparable<Num>{
        int person, grade;
        public Num(int p, int g){
            this.person = p;
            this.grade = g;
        }
        
        public int compareTo(Num o){
            return Integer.compare(o.grade, this.grade);
        }
    }
}
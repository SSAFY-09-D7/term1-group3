package Programmers;

import java.util.*;
public class 소수찾기 {
    static int Ans;
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public int solution(String numbers) {
        for(int i=1; i<=numbers.length(); i++){
            combination(new char[i], 0, 0, numbers);
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i)>1) isPrime(list.get(i));
        }
        return Ans;
    }
    private static void combination(char[] sel, int k, int idx, String num){
        if(sel.length == k){
            permutation(new char[sel.length], 0, 0, sel);
            return;
        }
        for(int i=idx; i<num.length(); i++){
            sel[k] = num.charAt(i);
            combination(sel, k+1, i+1, num);
        }
    }
    private static void permutation(char[] psel, int k, int flag, char[] arr){
        if(psel.length == k){
            String str = "";
            for(int i=0; i<psel.length; i++){
                str += psel[i];
            }
            if(!list.contains(Integer.parseInt(str))) list.add(Integer.parseInt(str));
            return;
        }
        for(int i=0; i<arr.length; i++){
            psel[k] = arr[i];
            if((flag & (1<<i)) > 0) continue;
            permutation(psel, k+1, flag | (1<<i), arr);
        }
    }
    private static void isPrime(int num){
        System.out.println(num);
        int cnt = 0;
        boolean[] v = new boolean[num+1];
        v[0] = v[1] = true;
        for(int i=2; i*i<=num; i++){
            if(!v[i]){
                for(int j=i*i; j<=num; j+=i) v[j] = true;
            }
        }
        if(!v[num]) Ans++;
    }
}
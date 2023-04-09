package Programmers;

import java.util.*;
public class 피로도 {
    static int Ans;
    public int solution(int k, int[][] dungeons) {
        permutation(new int[dungeons.length], 0, 0, dungeons, k);
        return Ans;
    }
    private static void permutation(int[] sel, int k, int flag, int[][] arr, int tired){
        if(k == sel.length){
            calc(sel, arr, tired);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if( (flag & (1<<i)) > 0 ) continue;
            sel[k] = i;
            permutation(sel, k+1, flag | (1<<i), arr, tired);
        }
    }
    private static void calc(int[] sel, int[][] arr, int k){
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<sel.length; i++){
            int index = sel[i];
            if(k >= arr[index][0]){
                cnt++;
                k -= arr[index][1];
            }
            else break;
        }
        Ans = Math.max(Ans, cnt);
    }
}
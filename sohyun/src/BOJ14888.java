import java.util.*;
import java.io.*;

public class BOJ14888 {
    static int N;
    static char[] oper = { '+', '-', '*', '/' };
    static List<Character> operArr = new ArrayList<>();
    static int calc;
    static int[] numarr;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        numarr = new int[N];
        for (int i = 0; i < N; i++) {
            numarr[i] = sc.nextInt();
        }
        
        for (int j = 0; j < 4; j++) {
            int cnt = sc.nextInt(); //0 0 1 0 
            for (int m = 0; m < cnt; m++) {
                operArr.add(oper[j]);
            }
        }
        perm(new int[operArr.size()], 0, new boolean[operArr.size()]);
        System.out.println(maxVal);
        System.out.println(minVal);
    }
    
    private static void perm(int[] temp, int idx,boolean[] visited) {
        if (idx == temp.length) {
            calc = numarr[0];
            for (int k = 0; k < temp.length; k++) {
                int tempIdx = temp[k]; //1,2.,33..
                char operC = operArr.get(tempIdx);
                switch (operC) {
                    case '+':
                        calc = (calc + numarr[k+1]);
                        break;
                    case '-':
                        calc = (calc - numarr[k+1]);
                        break;
                    case '*':
                        calc = (calc * numarr[k+1]);
                        break;
                    case '/':
                        if (calc < 0) {
                            calc = (-1)*((-1) * calc) / numarr[k+1];
                        } else {
                            calc = (calc / numarr[k+1]);
                        }
                        break;
                }
            }
            maxVal = Math.max(maxVal, calc);
            minVal = Math.min(minVal, calc);
           
            return;
        }

        for (int i = 0; i < temp.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[idx] = i;
                perm(temp, idx + 1,visited);
                visited[i] = false;
            }
           
        }

    }
}

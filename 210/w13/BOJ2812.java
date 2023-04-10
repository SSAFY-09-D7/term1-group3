package w13;

import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static boolean[] isRemoved;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./inputs/input_BOJ2812.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String number = br.readLine();
        isRemoved = new boolean[size];
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        
        for (int i = 0; i < size - 1; i++) {
            if (isRemoved[i]) continue;
            if (number.charAt(i) < number.charAt(getNextIdx(i))) {
                isRemoved[i] = true;
                i = getPrevIdxFront(i);
                cnt++;
            }
            if (cnt == k) break;
        }
        
        int idx = getPrevIdxFront(size) + 1;
        while (cnt < k) {
        	isRemoved[idx] = true;
            cnt++;
            idx = getPrevIdxFront(idx) + 1;
        }
        
        for (int i = 0; i < size; i++) {
            if (isRemoved[i]) continue;
            answer.append(number.charAt(i));
        }
        
        System.out.println(answer);
    }
    
    private static int getPrevIdxFront(int currIdx) {
        if (currIdx == 0) return -1;
        for (int i = currIdx - 1; i >= 0; i--) {
            if (!isRemoved[i]) return i-1;
        }
        return -1;
    }
    
    private static int getNextIdx(int currIdx) {
        for (int i = currIdx + 1; i < size; i++) {
            if (!isRemoved[i]) return i;
        }
        return size - 1;
    }
}

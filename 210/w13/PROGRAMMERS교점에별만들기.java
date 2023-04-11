pacakge w13;

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer;
        int lineCnt = line.length;
        Set<int[]> set = new HashSet<>();
        int maxR = Integer.MIN_VALUE, minR = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE, minC = Integer.MAX_VALUE;
        
        for (int i = 0; i < lineCnt - 1; i++) {
            for (int j = i+1; j < lineCnt; j++) {
                int[] point = getPoint(line[i], line[j]);
                if (point == null) continue;
                set.add(point);
                maxR = Math.max(maxR, point[0]);
                minR = Math.min(minR, point[0]);
                maxC = Math.max(maxC, point[1]);
                minC = Math.min(minC, point[1]);
            }
        }
        
        char[][] board = new char[maxC - minC + 1][maxR - minR + 1];
        answer = new String[maxC - minC + 1];
        int delR = 0 - minR;
        int delC = 0 - minC;
        
        for (int[] p : set) {
           // System.out.print(p[0] + "," + p[1] + " -> ");
           // System.out.println(((maxR - minR) - (p[1] + delR)) + " " + ((maxC - minC) - (p[0] + delC)));
            board[(maxC - minC) - (p[1] + delC)][(maxR - minR) - (p[0] + delR)] = '*';
        }
        
        StringBuilder sb;
        for (int i = 0; i < maxC - minC + 1; i++) {
            sb = new StringBuilder();
            
            for (int j = 0; j < maxR - minR + 1; j++) {
                if (board[i][j] == '*') sb.append("*");
                else sb.append(".");
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private int[] getPoint(int[] first, int[] second) {  
        double x0, y0;
        
        if (first[0] == 0) {
            y0 = (-1.0) * (first[2] / (double) first[1]);
            x0 = (-1.0) * (second[1] * y0 + second[2]) / second[0];
        }
        
        else if (first[1] == 0) {
            x0 = (-1.0) * (first[2] / (double) first[0]);
            y0 = (-1.0) * (second[0] * x0 + second[2]) / second[1];
        }
        
        else if (second[0] == 0) {
            y0 = (-1.0) * (second[2] / (double)second[1]);
            x0 = (-1.0) * (first[1] * y0 + first[2]) / first[0];
        }
        
        else if (second[1] == 1) {
            x0 = (-1.0) * (second[2] / (double) second[0]);
            y0 = (-1.0) * (first[0] * x0 + first[2]) / first[1];
        }
         
        else {
            double firstI = (-1) * first[0] / (double) first[1];
            double firstD = (-1) * first[2] / (double) first[1];
            double secondI = (-1) * second[0] / (double) second[1];
            double secondD = (-1) * second[2] / (double) second[1];
        
            x0 = (secondD - firstD) / (double) (firstI - secondI);
            y0 = x0 * firstI + firstD;  
        } 
        
        if (x0 - (int)x0 == 0 && y0 - (int)y0 == 0) return new int[]{(int)x0, (int)y0};
        return null;
    }
}

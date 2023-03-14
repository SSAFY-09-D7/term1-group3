
import java.util.*;
import java.io.*;

public class BOJ1074 {

    static int r, c, N;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        recur(r, c, (int) Math.pow(2, N));
        System.out.println(answer);

    }

    private static void recur(int x, int y, int size) {
        if(size==1) return;
        if (x < size / 2 && y < size / 2)
            recur(x, y, size / 2);
        else if (x < size / 2 && y >= size / 2) {
            answer += size * size / 4;
            recur(x, y-size/2, size / 2);
        } 
        else if (x >= size / 2 && y < size / 2) {
            answer += size * size / 4 * 2;
            recur(x - (size / 2), y, size / 2);
        } 
        else {
            answer += size * size / 4 * 3;
            recur(x - (size / 2), y - (size / 2), size / 2);
        }
        
    }
}

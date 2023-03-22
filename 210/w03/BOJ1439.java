package w03;

import java.io.FileInputStream;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1439.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String str1 = str.replaceAll("0+", " ").trim();
        String str0 = str.replaceAll("1+", " ").trim();

        if (str0.length() == 0 || str1.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(Math.min(str1.split(" ").length, str0.split(" ").length));
        }
        sc.close();
    }
}
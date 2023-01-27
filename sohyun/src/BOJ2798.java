import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ2798 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num < M)
                number.add(num);
        }
        Collections.sort(number, Collections.reverseOrder());
        //number에서 3개 고르기
        int answer = 0;
        for (int i = 0; i < number.size()-2; i++) {
            int first = number.get(i);
            for (int j = i + 1; j < number.size()-1; j++) {
                int sec = number.get(j);
                for (int k = j + 1; k < number.size(); k++) {
                    int third = number.get(k);
                    if (third + sec + first >= answer && third+sec+first<=M)
                        answer = third + sec + first;
                }
            }
        }
        System.out.println(answer);
    }
}

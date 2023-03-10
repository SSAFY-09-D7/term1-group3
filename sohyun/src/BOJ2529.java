import java.util.*;
import java.io.*;

public class BOJ2529 {
    static int k; // 부등호 숫자
    static char[] inequal; // 부등호 담은 배열
    static ArrayList list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inequal = new char[k];
        for (int i = 0; i < k; i++) {
            inequal[i] = st.nextToken().charAt(0);
        }
        // System.out.println(Arrays.toString(inequal));
        // 10개에서 K+1개 순열 구하기(0~10)
        list = new ArrayList<String>();
        permu(0, new int[k + 1], new boolean[10]);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void permu(int current, int[] temp, boolean[] v) {
        if (current == temp.length) {
            // System.out.println(Arrays.toString(temp));

            // Queue<Integer> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            boolean isEnd = false;
            // k=2,
            for (int i = 0; i < k; i++) {
                char c = inequal[i]; // <
                int f = temp[i]; // 0 1
                int s = temp[i + 1]; // 1 2
                if (c == '<') {
                    if (f < s) {
                    } else {
                        isEnd = true;
                        break;
                    }
                } else {
                    if (f > s) {
                    } else {
                        isEnd = true;
                        break;
                    }
                }
            }
            if (isEnd == true)
                return;
            else {
                for (int j : temp) {
                    sb.append(j);
                }
                list.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!v[i]) {
                v[i] = true;
                temp[current] = i;
                permu(current + 1, temp, v);
                v[i] = false;
            }
        }
    }
}

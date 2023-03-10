import java.util.*;
import java.io.*;

public class BOJ2529 {
    static int k;
    static char[] inequal;
    static ArrayList list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inequal = new char[k];
        for (int i = 0; i < k; i++) {
            inequal[i] = st.nextToken().charAt(0);
        }
        list = new ArrayList<String>();
        permu(0, new int[k + 1], new boolean[10]);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void permu(int current, int[] temp, boolean[] v) {
        if (current == temp.length) {
            StringBuilder sb = new StringBuilder();
            boolean isEnd = false;
            // k=2,
            for (int i = 0; i < k; i++) {
                char c = inequal[i];
                int f = temp[i];
                int s = temp[i + 1];
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

import java.util.*;
import java.io.*;

public class BOJ1543 {
    static String str;
    static char[] strC;
    static String find;
    static int answer;

    public static void main(String[] args) throws Exception {
        // 어떤 단어가 총 몇번 등장하는지?
        // 중복되어 세는 것은 빼고 세어야 한다
        // abababa. 이고 찾으려는단어가 ababa라면
        // 이단어를 0번부터 찾을수도있고, 2번부터도 찾을 수 있음
        // 동시에 셀수는 없다
        // 그 단어가 최대 몇번 중복되지 않게 등장하는지
        // ababababa

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        find = br.readLine();
        int size = find.length();
        func(0, size);
        // index 로 넣??

    }

    private static void func(int idx, int size) {
        if (idx + size > str.length()) {
            System.out.println(answer);
            return;
        }
        // idx~idx+size-1 (0 1 2)
        if (str.substring(idx, idx + size).equals(find)) {
            // 같으면
            answer++;
            func(idx + size, size);
        } else {
            func(idx + 1, size);
        }

    }
}

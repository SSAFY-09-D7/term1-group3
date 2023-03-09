import java.util.*;
import java.io.*;

public class BOJ1476 {
    static int E, S, M;
    static int answer;

    public static void main(String[] args) throws Exception {
        // 수 3개를 이용해서 연도를 나타낸다
        // 지구, 태양, 달
        // 지구 : E, 태양 : S, 달 : M
        // 1ㄴ년 : 1씩 증가
        // 15년 : 15 15 15
        // 16년-> 1 16 16 1<=E<=15리사
        // ESM이 주어질 때, 몇년인지 계산해기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 1;
        func(1, 1, 1);
    }

    private static void func(int e, int s, int m) {
        if (e == E && s == S && m == M) {
            System.out.println(answer);
            return;
        }
        if (e == 15) {
            e = 0;
        }
        if (s == 28) {
            s = 0;
        }
        if (m == 19) {
            m = 0;
        }

        answer++;
        func(e + 1, s + 1, m + 1);
    }
}

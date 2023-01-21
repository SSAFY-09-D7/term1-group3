package w1;

import java.io.*;
import java.util.*;

// 전체 부배열 경우의 수를 탐색
class Main {
    static int T, n, m;
    static int[] A, B;
    static List<Integer> subA, subB;

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < m; i++)
            B[i] = Integer.parseInt(st.nextToken());

        subA = new ArrayList<>();
        int tmpSum = 0;
        for (int i = 0; i < n; i++) {
            tmpSum = 0;
            for (int j = i; j < n; j++) {
                tmpSum += A[j];
                subA.add(tmpSum);
            }
        }

        subB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tmpSum = 0;
            for (int j = i; j < m; j++) {
                tmpSum += B[j];
                subB.add(tmpSum);
            }
        }

        subA.sort(null);
        subB.sort(null);

        // System.out.println(subA.toString());
        // System.out.println(subB.toString());

        int pa = 0;
        int pb = subB.size() - 1;
        long equalCnt = 0;
        while (pa < subA.size() && pb >= 0) {
            // System.out.println(subA.get(pa) + " " + subB.get(pb) + " ");
            int sum = subA.get(pa) + subB.get(pb);
            // 만약에 합이 T와 같다면
            if (sum == T) {

                // 동일 개수 확인
                long a = subA.get(pa);
                long b = subB.get(pb);
                long cntA = 0;
                long cntB = 0;

                while (pa < subA.size() && subA.get(pa) == a) {
                    cntA++;
                    pa++;
                }
                while (pb >= 0 && subB.get(pb) == b) {
                    cntB++;
                    pb--;
                }

                equalCnt += cntA * cntB;
            }

            else if (sum > T) {
                pb--;
            }

            else if (sum < T) {
                pa++;
            }
        }

        System.out.println(equalCnt + "");
    }
}
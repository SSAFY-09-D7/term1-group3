import java.util.*;
import java.io.*;
public  class BOJ16206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 롤케이크 개수
        int N = Integer.parseInt(st.nextToken());
        //최대 M번 자를 수 있다.
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> roll = new ArrayList<>();
        
        //케이크 값 넣기
        while (st.hasMoreTokens()) {
            roll.add(Integer.parseInt(st.nextToken()));
        }
        
        int count = 0;
        int rollCnt = 0;

        for (int idx = 0; idx <N; idx++) {
            int x = roll.get(idx);
            // System.out.println(num);
            if (x == 10) {
                //10이면 걍 넘김
                rollCnt++;
            }
            else if (x < 10) {
                continue;
            }
            else {
                //10보다 큰 경우
                while (x > 0 && M>0) {
                    x = x - 10;
                    rollCnt++;
                    M--;
                   

                }
                if (x % 10==0)
                {
                    M++;
                }
                if (x == 10)
                    rollCnt++;
            }

        }
        System.out.println(rollCnt);
    }
}
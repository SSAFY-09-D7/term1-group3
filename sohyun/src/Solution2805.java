import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution2805 {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("sohyun/input/2805input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= TC; testcase++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            int[][] map = new int[N][N];
            for(int i=0;i<N;i++)
            {
                String[] str = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str[j]);

                }
            }
            for(int r=0;r<N;r++)
            {
                for (int c = 0; c < N; c++) {
                    if (c == (N / 2)) {
                        answer += map[r][c];
                        if (r < N / 2) {
                            for (int k = 1; k <= r; k++) {
                                answer += map[r][c + k];
                                answer += map[r][c - k];
                            }
                        } else if (r > N / 2) {
                            for (int k = 1; k < N-r; k++) {
                                answer += map[r][c + k];
                                answer += map[r][c - k];
                            }
                        }
                        else if(r==(N/2)){
                            for(int k=0;k<N;k++)
                            {
                                answer += map[r][k];
                            }
                            answer -= map[r][c];
                        }

                    }
                }
            }
            System.out.printf("#%d %d\n",testcase,answer);
        }

    }
}

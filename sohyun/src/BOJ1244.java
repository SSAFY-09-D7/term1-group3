import java.util.*;
import java.io.*;

public class BOJ1244 {
    static int[] swtc;
    static int N;

    public static void main(String[] args) throws Exception {
        //1은 스위치 켜져있음, 0은 꺼져있음
        // 남학생 : 스위치 번호가 자기가 받은 수의 배수이면 상태를 바꾼다. 
        // 0이면 1로, 1이면 0으로
        // 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로
        // 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아
        // 그 구간안에 속한 스위치 상태를 모두 바꾼다.
        // 입력받은 수대로 바꾼뒤 스위치들의 마지막 상태를 출력하라
        //스위치의 상태를 1부터 시작하여 마지막 스위치까지 한줄에 30개씩 ㅈ출력하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        swtc = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            swtc[i] = Integer.parseInt(st.nextToken());
        }

        //학생 수, 
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            switch (gender) {
                case 1:
                    //남자인 경우
                    //자기가 받은 수의 배수이면 상태 바꿈
                    changeSwtc(number);
                    // System.out.println(Arrays.toString(swtc));
                    break;
                case 2:
                    //여자인 경우
                    // 여학생을 중심으로 
                    findSwtc(number);
                    // System.out.println(Arrays.toString(swtc));
                    break;
            }
        }
        print();
    }
    

    private static void print() {
        //스위치를 한줄에 20개씩 출력
        for (int i = 1; i <= N; i++) {
            if (i>20 && i % 20 == 1) {
                System.out.println();
            }
            System.out.print(swtc[i]+" ");
        }
    }


    private static void findSwtc(int number) {
        //number를 중심으로 -1 -2 -3... number-i
        //number[number-1] == number[numbet+1]??
        // swtc[number] = (swtc[number] == 0) ? 1 : 0;
        int i = 0;
        while (number - i >= 1 && number + i <= N) {
            if (swtc[number - i] != swtc[number + i])
                break;
            i++;
        }
        i -= 1;
        //i값 찾았으면
        for(int j=number-i;j<=number+i;j++){
            swtc[j] = (swtc[j] == 0) ? 1 : 0;
        }
        
    }

    private static void changeSwtc(int number) {
        for (int i = number; i <= N; i += number) {
            if (swtc[i] == 0)
                swtc[i] = 1;
            else
                swtc[i] = 0;
        }
    }
}

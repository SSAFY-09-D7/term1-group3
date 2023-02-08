// package ssafy.day01;
import java.util.*;
import java.io.*;
public class SWEA1210 {

	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//어느 사다리를 고르면 X 표시에 도착하는지?
		// 두 막대 사이에 임의의 개수의 막대들이 랜덤 간격으로 추가되고
		// 이 막대들 사이에 가로 방향 선들이 연결됨
		// 아래 방향으로 진행하다가 좌우 방향으로 이동 가능한 통로 나오면 방향 전환
		// 방향 전환 이후에 다시 아래로 이동 -> 바닥에 도착하면 멈춘다
		//0으로 채워진 평면상에 사다리는 연속된 1로 표현됨. 도착 지점은 2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] ladder = new int[100][100];

		int endX = 0;
		int endY = 0;
		for (int i = 0; i < 100; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 100; j++) {
				ladder[i][j] = Integer.parseInt(st.nextToken());
				if (ladder[i][j] == 2) {
					endX = i;
					endY = j;
				}
			}
		}
		//endX,endY : 끝점


        while (true) {
            if (endX == 0)
                break;
            if (endY + 1 <= 99 && ladder[endX][endY + 1] == 1) {

                endY = endY + 1;
                ladder[endX][endY] = 2;
            } else if (endY - 1 >= 0 && ladder[endX][endY - 1] == 1) {
                endY = endY - 1;
                ladder[endX][endY] = 2;
            } else if (endX - 1 >= 0) {
                endX = endX - 1;
                ladder[endX][endY] = 2;
            }
        }
        System.out.printㄹ("#%d %d\n",T,endY);

		
	}

}

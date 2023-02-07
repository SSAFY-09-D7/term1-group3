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

        while (true) {
            if (endX == 0)
                break;
            if (endY + 1 <= 99 && ladder[endX][endY + 1] == 1) {

                endX = endX;
                endY = endY + 1;
                ladder[endX][endY] = 2;
            } else if (endY - 1 >= 0 && ladder[endX][endY - 1] == 1) {
                endX = endX;
                endY = endY - 1;
                ladder[endX][endY] = 2;
            } else if (endX - 1 >= 0) {
                endX = endX - 1;
                ladder[endX][endY] = 2;
            }
        }
        System.out.println(endY);
		//1 testcase (99,57==2) , endX는 항상 99
		// System.out.printf("%d %d\n",endX,endY);
		// while(endX>0){
		// 	//1. 좌우 에 1이 있는지 확인
		// 	//0인 경우, 1인 경우
        //     // System.out.printf("%d %d\n", endX, endY);
        //     if (endX == 0)
        //         break;
		// 	if(endY==0){
		// 		//(99,0) 인경우
		// 		//ㅇ오른쪽만 보면됨
                
		// 		while(endX>0){
        //             System.out.printf("%d %d\n",endX,endY);
		// 			if(endY+1<=99 && ladder[endX][endY+1]==1){
		// 				//좌우에 1이 있으면 그쪽으로 이동해야됨
		// 				endX = endX;
		// 				endY = endY+1;
        //                 ladder[endX][endY]=2;
		// 			}
		// 			else if(endX-1>=0){
        //                 //없으면 위로 이동
        //                 endX = endX - 1;
        //                 ladder[endX][endY] = 2;
		// 				// if(endX==0 ) break;
        //             } else
        //                 break;
		// 		}
		// 		//endX ==0이면 나옴


		// 	}
		// 	if(endY==99){
		// 		//왼쪽만 보면됨
		// 		while(endX>0){
		// 			if(endY-1>=0 && ladder[endX][endY-1]==1){
		// 				//좌우에 1이 있으면 그쪽으로 이동해야됨
		// 				endX = endX;
		// 				endY = endY-1;
        //                 ladder[endX][endY]=2;
						
		// 			}
		// 			else if(endX-1>=0){
		// 				//없으면 위로 이동
		// 				endX = endX-1;
        //                 ladder[endX][endY]=2;
		// 				// if(endX==0 ) break;
		// 			}
		// 		}
		// 	}
		// 	else{
		// 		//좌우 다 봐야됨
		// 		while(endX>0){
		// 			if(endY+1<=99 && ladder[endX][endY+1]==1){
						
		// 				endX = endX;
		// 				endY =  endY + 1 ;      
		// 				ladder[endX][endY] = 2;
		// 			}
		// 			else if(endY-1>=0 && ladder[endX][endY-1]==1){
		// 				endX = endX;
		// 				endY = endY - 1;
		// 				ladder[endX][endY] = 2;
		// 			}
		// 			else if(endX-1>=0){
        //                 endX = endX - 1;
        //                 ladder[endX][endY]=2;
		// 			}
		// 		}
		// 	}
		// }
		// //2를 찾고, 위로가면서 출발지점 찾기- 거꾸로
		// System.out.println(endY);

		
	}

}

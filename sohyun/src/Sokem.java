import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sokem {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./input/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int testcase=1;testcase<=TC;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N= Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());	//소금쟁이 수
			int[][] map = new int[N][N];				//처음에 0으로 초기화됨 
			boolean isFind = false;						//소금쟁이 찾으면 true
			int answer = 0;
			int[][] sokem = new int[cnt][3];			//소금쟁이 배열
			
        
			//소금쟁이 입력받기
			for(int c=0;c<cnt;c++)
			{
				//(i,j): 소금쟁이 위치, dir:방향
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				sokem[c][0]=i;
				sokem[c][1]=j;
				sokem[c][2]=dir;
						
			}
			

			for(int c=0;c<cnt;c++)
			{
				//(i,j): 소금쟁이 위치, dir:방향(상:)
				int i = sokem[c][0];
				int j = sokem[c][1];
				int dir = sokem[c][2];
				
				//3번 뛴다고 했으니까 for문 
				//시작 위치가 이미 뛰었던 자리면 break
				if(map[i][j]==1) {answer = c+1; break;}
				for(int jump=3;jump>0;jump--)
				{
					if(dir==2) {
						//오른쪽으로 이동
						if(j+jump>=N)break;
						else {
							if(map[i][j+jump]==1)
							{
								isFind = true;
								break;
							}
							else {
								map[i][j+jump]=1;
								j=j+jump;
							}
						}
					}
					else {
						//1이면 아래로 이동
						if(i+jump>=N) break;
						else {
							if(map[i+jump][j]==1)
							{
								isFind = true;
								break;
							}
							else {
								map[i+jump][j]=1;
								i=i+jump;
							}
						}
					}
				}
				if(isFind==true) {
					answer = c+1;
					break;
				}
			}
			if(isFind==true) System.out.printf("#%d %d\n",testcase,answer);
			else System.out.printf("#%d 0\n",testcase,0);
		}
		
	}
}

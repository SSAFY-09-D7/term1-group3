import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sokem2 {

	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("./input/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int testcase=1;testcase<=TC;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N= Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());	//소금쟁이 수(죽으면 cnt--)
			int[][] map = new int[N][N];				//처음에 0으로 초기화됨 
			
					
			
			int[][] sokem = new int[cnt][3];			//소금쟁이 배열
			
			//소금쟁이 입력받기
			for(int c=0;c<cnt;c++)
			{
				//(i,j): 소금쟁이 위치, dir:방향(상:1,하:2,좌:3,우:4)
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				sokem[c][0]=i;
				sokem[c][1]=j;
				sokem[c][2]=dir;
						
			}
			for(int c=0;c<sokem.length;c++)
			{
				//(i,j): 소금쟁이 위치, dir:방향
				int i = sokem[c][0];
				int j = sokem[c][1];
				int dir = sokem[c][2];
				boolean isIt = false;		//3번 다 뛰고 살아남은 소금쟁이는 true로 설정함
					for(int jump=3;jump>0;jump--)
					{
						if(map[i][j]>3) {
							cnt--;
							isIt = true;
							break;
						}
						if(dir==1) {
							//위로이동 : 연못밖으로 나가거나 3번째 위치와 충돌하면 죽는다
							if(i-jump<0) {cnt--; isIt = true; break; }
							else {
								if(map[i-jump][j]<3)
								{
									map[i-jump][j] +=1;
									i=i-jump;
								}
								else {
									//죽음
									cnt--;
									isIt=true;
									break;
								}
							}
							
						}
						else if(dir==2){
							//2이면 아래로 이동 
							if(i+jump>=N) {cnt--; isIt = true; break;}
							else {
								if(map[i+jump][j]<3)
								{
									map[i+jump][j] +=1;
									i=i+jump;
								}
								else {
									cnt--;
									isIt = true;
									break;
								}
							}
						}
						else if(dir==3) {
							//3이면 왼쪽으로 이동
							if(j-jump<0) {cnt--; isIt = true; break;}
							else {
								if(map[i][j-jump]<3) {
									map[i][j-jump]+=1;
									j=j-jump;
								}
								else {
									cnt--;
									isIt = true;
									break;
								}
							}
						}
						else if(dir==4) {
							//4면 오른쪽으로 이동
							if(j+jump>=N) {cnt--; isIt = true; break;}
							else {
								if(map[i][j+jump]<3) {
									map[i][j+jump]+=1;
									j=j+jump;
								}
								else {
									cnt--;
									isIt = true;
									break;
								}
							}
						}
					}
					if(isIt==false) map[i][j]=3;
				
				
			}
			System.out.printf("#%d %d\n",testcase,cnt);
		}
		
	}

}

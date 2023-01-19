import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Robot {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=TC;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int answer = 0;
			String [][] arr = new String[N][N];
			
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					arr[i][j] = st.nextToken();
				}
			}
			
			
			int r = 0;
			int l = 0;
			int u = 0;
			int d = 0;
			
			//탐색
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					String temp = arr[i][j];
					if(temp.equals("A"))
					{	
						r = j;
						while(true) {
							r++;
							if(r<N)
							{
								if(!arr[i][r].equals("S")) break;
								else answer+=1;
							}else break;
						}
					}
					else if(temp.equals("B"))
					{
						l = j;
						r = j;
						while(true) {
							//왼쪽으로 1칸 이동 
							l-=1;
							if(l>=0)
							{
								if(!arr[i][l].equals("S")) break;
								else answer+=1;
							}else break;
						}
						while(true) {
							r++;
							//오른쪽으로 2칸 이동.
							if(r<N)
							{
								if(!arr[i][r].equals("S")) break;
								else answer+=1;
							}else break;
						}
					}
					else if(temp.equals("C"))
					{
						//상하좌우1
						u=i;		
						d=i;		
						l=j;
						r=j;
						//순서대로 상,하,좌,우
						while(true) {
							u-=1;
							if(u>=0) {
								if(!arr[u][j].equals("S")) break;
								else answer+=1;
							}else break;
						}
						while(true) {
							d+=1;
							if(d<N) {
								if(!arr[d][j].equals("S")) break;
								else answer+=1;
							}else break;
						}
						while(true) {
							l-=1;
							if(l>=0) {
								if(!arr[i][l].equals("S")) break;
								else answer+=1;
							}else break;
						}
						while(true) {
							r+=1;
							if(r<N) {
								if(!arr[i][r].equals("S")) break;
								else answer+=1;
							}else break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",testcase,answer);

		}
	}
}

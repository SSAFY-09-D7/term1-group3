import java.util.Scanner;

public class Building {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int testcase=1;testcase<=TC;testcase++)
		{
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			int maxHeight=0;
					
			int[] nx = {-1,1,0,0,-1,-1,1,1};
			int[] ny = {0,0,-1,1,-1,1,-1,1};
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					int height=0;
					int cnt = 0;
					boolean isG = false;
					if(map[i][j]=='B')
					{
						for(int c=0;c<8;c++)
						{
							int dx = i+nx[c];
							int dy = j+ny[c];
							if(dx>=0 && dx<N && dy>=0 &&dy<N)
							{
								if(map[dx][dy]=='G')
								{
									isG = true;
									break;
								}
								
							}
						}
						if(isG==false) {
							for(int r=0;r<N;r++)
							{
								if(map[i][r]=='B') height++;
								if(map[r][j]=='B') height++;
							}
							maxHeight=Math.max(height-1, maxHeight);
						}
						else {
							height=2;
						}
						
					}
				}
			}
			System.out.printf("#%d %d\n",testcase,maxHeight);
		}
		
	}
		
}

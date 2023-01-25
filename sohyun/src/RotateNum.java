import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
{
	public static int[][] rotateArr(int[][] origin, int N)
	{
			//origin array에 대해 90도 회전
			int[][] rotateArr = new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					int tempSrc = origin[N-1-j][i];
					rotateArr[i][j]=tempSrc;
				}
			}
			return rotateArr;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(bw.readLine());
		ArrayList<Integer> board = new ArrayList<>();
		for(int testcase=1;testcase<=TC;testcase++)
		{
			int N = Integer.parseInt(bw.readLine());
			int[][] arr = new int[N][N];
			int[][] rotateArr = new int[N][N];
			ArrayList<int[][]> answerList = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			//입력받아 N*N array 완성
			for(int i=0;i<N;i++)
			{
				String str = bw.readLine();
				for(int j=0;j<N;j++)
				{
					String[] str_arr = str.split(" ");
					arr[i][j] = Integer.parseInt(str_arr[j]);
					
				}
			}
			
			// 1. 90도 회전한 배열 만들기, 180도 회전한 것, 270 회전한 것
			// 2. answerList에 3개 배열 저장		
			for(int cnt=0;cnt<3;cnt++)
			{
				rotateArr = rotateArr(arr,N);
				arr = rotateArr;
				answerList.add(rotateArr);
			}
			// 3. answerList에 있는 것 꺼내print
			for(int n=0;n<N;n++)
			{
				for(int idx=0;idx<3;idx++)
				{
					for(int m=0;m<N;m++)
					{
						sb.append(answerList.get(idx)[n][m])	;
					}
					sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.printf("#%d\n%s",testcase,sb);
			
		}

	}
}
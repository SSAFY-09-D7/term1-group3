package BOJ_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_11726_2xn타일링 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+2];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= N; i++) arr[i] = (arr[i-2] + arr[i-1]) % 10007;		
		bw.write(arr[N]+"");
		bw.flush();
	}
}

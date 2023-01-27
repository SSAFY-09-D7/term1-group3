package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10818_최소최대 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[T];
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxVal = Math.max(arr[i], maxVal);
			minVal = Math.min(arr[i], minVal);
		}
		bw.write(minVal+" "+maxVal);
		bw.flush();
	}

}

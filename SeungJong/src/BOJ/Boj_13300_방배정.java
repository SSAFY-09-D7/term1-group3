package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_13300_방배정 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] students = new int[2][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			students[gender][grade-1]++;
		}
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[0].length; j++) {
				if(students[i][j] > 0) {
					count += Math.ceil(students[i][j] / (double)K);
				}
			}
		}
		bw.write(count+"");
		bw.flush();
	}
}

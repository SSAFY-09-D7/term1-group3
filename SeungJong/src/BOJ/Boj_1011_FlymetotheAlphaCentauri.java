package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1011_FlymetotheAlphaCentauri {

	static long distance;
	static long count = 0;
	static long sum = 0;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./input/input_boj1011.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			count = 0;
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			long X = Long.parseLong(st.nextToken());
			long Y = Long.parseLong(st.nextToken());
			distance = Y - X;
			if(distance == 1) {
				bw.write("1\n");
				bw.flush();
			}else {
				long k = maxAccel();
				slow(k);
				bw.write((count+1)+"\n");
				bw.flush();				
			}
		}
	}

	private static void slow(long k) {
		long remain = distance;
		while(remain!=1) {
			if(sum > remain) {
				sum -= k;
				k--;
			}
			remain -= k;
			count++;
		}
	}

	private static long maxAccel() {
		long k = 0;
		long remain = distance;
		while(true) {
			if(sum+(k+1) <= remain ) {
				k++;
				count++;
				sum += k;
			}
			else {
				distance = remain;
				return k;
			}
			remain -= k;
		}
	}
}

package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1225_암호생성기 {

	static int T = 10;
	static int decrease;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./seungJong/input/input_swea1225.txt"));
		Queue<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= T; tc++) {
			q.clear();
			decrease = 1;
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));			
			}
			while(true) {
				int temp = q.poll() - decrease;
				if(temp <= 0) {
					q.offer(0);
					break;
				}
				else q.offer(temp);
				if(decrease == 5) decrease = 1;
				else decrease++;
			}
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();	
		}
	}
}

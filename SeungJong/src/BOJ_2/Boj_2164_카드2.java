package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2164_카드2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(q.size()!=1) {
			q.poll();
			int temp = q.poll();
			q.offer(temp);
		}
		System.out.println(q.peek());
	}

}

package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_5215_햄버거다이어트 {
	static int N;
	static int L;
	static Hambuger[] arr;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new Hambuger[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int favor = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				Hambuger temp = new Hambuger(favor, cal);
				arr[i] = temp;
			}
			for (int i = 1; i <= N; i++) {
				combination(new Hambuger[i], 0, 0);
			}
//				combination(new Hambuger[3], 0, 0);
			System.out.println("#"+tc+" "+max);
		}
	}
	private static void combination(Hambuger[] sel, int idx, int k) {
		if(k == sel.length) {
			int tempSumCal = 0;
			int tempSumFavor = 0;
			for (int i = 0; i < sel.length; i++) {
				tempSumCal += sel[i].cal;
				tempSumFavor += sel[i].favor;
			}
			if(tempSumCal <= L) {
				max = Math.max(tempSumFavor, max);
			}
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(sel, i+1, k+1);
		}
	}

}
class Hambuger{
	int favor;
	int cal;
	Hambuger(int favor, int cal) {
		this.favor = favor;
		this.cal = cal;
	}
	@Override
	public String toString() {
		return "Hambuger [favor=" + favor + ", cal=" + cal + "]";
	}
}

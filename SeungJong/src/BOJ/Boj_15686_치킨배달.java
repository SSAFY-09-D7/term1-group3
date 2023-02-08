package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15686_치킨배달 {

	static ArrayList<Position> home = new ArrayList<Position>();
	static ArrayList<Position> chicken = new ArrayList<Position>();
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					Position p = new Position(i, j);
					home.add(p);
				}else if(tmp == 2) {
					Position p = new Position(i, j);
					chicken.add(p);
				}
			}
		}
		combination(new Position[M], 0, 0);
		System.out.println(min);
	}
	private static void combination(Position[] positions, int idx, int k) {
		if(idx == positions.length) {
			calcDistance(positions);
			return;
		}
		for (int i = k; i < chicken.size(); i++) {
			positions[idx] = chicken.get(i);
			combination(positions, idx+1, i+1);
		}
	}
	private static void calcDistance(Position[] positions) {
		int homeToChicken = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			homeToChicken = Integer.MAX_VALUE;
			int homeX = home.get(i).x;
			int homeY = home.get(i).y;
			for (int j = 0; j < positions.length; j++) {
				int chickenX = positions[j].x;
				int chickenY = positions[j].y;
				int temp = Math.abs(homeX-chickenX) + Math.abs(homeY-chickenY);
				homeToChicken = Math.min(homeToChicken, temp);
			}
			sum += homeToChicken;
		}
		min = Math.min(min, sum);
	}
}

class Position{
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}

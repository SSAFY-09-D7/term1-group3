package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_2668_숫자고르기 {
	static int N, Ans;
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static boolean flag;
	static ArrayList<Integer> temp;
	static ArrayList<Integer> set = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			int temp = Integer.parseInt(br.readLine());
			list[i].add(temp);
		}
		for (int i = 1; i < list.length; i++) {
			v = new boolean[N+1];
			temp = new ArrayList<Integer>();
			flag = false;
			dfs(i, i);
			if(flag) {
				for (int j = 0; j < temp.size(); j++) {
					if(!set.contains(temp.get(j))) set.add(temp.get(j));
				}
			}
		}
		Collections.sort(set);
		System.out.println(set.size());
		for (int i = 0; i < set.size(); i++) {
			System.out.println(set.get(i));
		}

	}
	private static void dfs(int start, int end) {
		temp.add(start);
		v[start] = true;
		for (int next : list[start]) {
			if(!v[next]) dfs(next, end);
			else {
				if(next == end) flag = true;
			}
		}
	}
}

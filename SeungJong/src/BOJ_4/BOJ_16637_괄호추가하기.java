package BOJ_4;

/*
 * -- O -- 1. 연산자의 인덱스를 기억하는 List
 * 2. 연산자의 인덱스로 부분집합 구하기
 * 3. 부분집합 결과가 연산자 인덱스가 연속됐다면 Pass (2차이가 나면 연속됨)
 * 4. 연속되지 않은 연산자로 수식 계산 중 최대값 저장
 */

import java.io.*;
import java.util.*;

public class BOJ_16637_괄호추가하기 {

	static int N, Ans = Integer.MIN_VALUE;
	static char[] arr;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);
			if(arr[i] - '0' < 0 || arr[i] - '0' > 9 )
				list.add(i);
		}
		solve(new int[list.size()], 0, new boolean[list.size()]);
		System.out.println(Ans);
	}
	private static void solve(int[] sel, int idx, boolean[] v) {
		if(idx == sel.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					temp.add(list.get(i));
				}
			}
			check(temp);
			return;
		}
		v[idx] = true;
		solve(sel, idx+1, v);
		v[idx] = false;
		solve(sel, idx+1, v);
	}
	private static void check(ArrayList<Integer> temp) {
		ArrayList<Operator> oper = new ArrayList<Operator>();
		for (int i = 0; i < temp.size(); i++) {
			if(i > 0 && oper.get(i-1).c >= temp.get(i)-1) {
				return;
			}
			else oper.add(new Operator(temp.get(i)-1, temp.get(i), temp.get(i)+1));
		}
		calc(oper);
	}
	
	private static void calc(ArrayList<Operator> oper) {
		String[] tempArr = new String[N];
		for (int i = 0; i < tempArr.length; i++) {
			tempArr[i] = String.valueOf(arr[i]);
		}
		for (int i = 0; i < oper.size(); i++) {
			int a = arr[oper.get(i).a]-'0';
			char b = arr[oper.get(i).b];
			int c = arr[oper.get(i).c]-'0';
			int temp = 0;
			switch(b) {
			case '+':
				temp = a+c; break;
			case '-':
				temp = a-c; break;
			case '*':
				temp = a*c; break;
			}
			tempArr[oper.get(i).a] = "a";
			tempArr[oper.get(i).b] = String.valueOf(temp);
			tempArr[oper.get(i).c] = "a";
		}
		operration(tempArr);
	}

	private static void operration(String[] temp) {
		int sum = 0;
		ArrayList<String> arrList = new ArrayList<String>();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].equals("a")) continue;
			arrList.add(temp[i]);
		}
		for (int i = 1; i < arrList.size()-1; i++) {
			if(arrList.get(i).equals("+") || arrList.get(i).equals("-") || arrList.get(i).equals("*")) {
				int a = Integer.parseInt(arrList.get(i-1));
				char b = arrList.get(i).charAt(0);
				int c = Integer.parseInt(arrList.get(i+1));
				switch(b) {
				case '+':
					arrList.set(i+1, Integer.toString(a+c)); break;
				case '-':
					arrList.set(i+1, Integer.toString(a-c)); break;
				case '*':
					arrList.set(i+1, Integer.toString(a*c)); break;
				}
				
			}
		}
		Ans = Math.max(Ans, Integer.parseInt(arrList.get(arrList.size()-1)));
	}

	private static class Operator{
		int a, b, c;
		public Operator(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Operator [a=" + a + ", b=" + b + ", c=" + c + "]";
		}
	}
}

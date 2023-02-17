package com.study.w5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1009 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ1009.txt"));
		//Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0;test_case<T;test_case++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a%10 == 1) {
				System.out.println(1);
			}else {
				int num = findRule(a%10, b);
				System.out.println(num == 0 ? 10 : num);
			}
		}
	}

	private static int findRule(int a, int b) {
		int cnt = 1, rule = a;
		List<Integer> list = new ArrayList<>();
		list.add(a%10);
		while(true) {
			rule *= a;
			if(rule%10 == a%10) break;
			list.add(rule%10);
			cnt++;
		}
		
		int last = list.get(b%cnt == 0 ? cnt-1 : b%cnt-1);
		return last;
	}

}

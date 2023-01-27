package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Swea_1218_괄호짝짓기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_swea1218.txt"));
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			int ans = calcCount(str);
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}

	private static int calcCount(String str) {
		// TODO Auto-generated method stub
		int[][] count = new int[4][2];
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				count[0][0] ++;	break;
			case ')':
				count[0][1] ++; break;
			case '[':
				count[1][0] ++; break;
			case ']':
				count[1][1] ++; break;
			case '{':
				count[2][0] ++; break;
			case '}':
				count[2][1] ++; break;
			case '<':
				count[3][0] ++; break;
			case '>':
				count[3][1] ++; break;
			}
		}
		boolean isBreak = false;
		for (int i = 0; i < 4; i++) {
			if(count[i][0] != count[i][1]) isBreak = true;
		}
		if (isBreak) return 0;
		else return 1;
	}

}

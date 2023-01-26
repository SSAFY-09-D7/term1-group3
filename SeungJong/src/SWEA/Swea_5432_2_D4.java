package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Swea_5432_2_D4 {

	static int T, sum, num;
	static char[] arr;
	static String tmpInput;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_swea5432.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sum = 0; // 나뉜 막대의 개수
			num = 0; // 막대의 개수
			tmpInput = sc.next();
			String changeInput = tmpInput.replace("()", "0"); // 레이저를 0으로 표시
			for(int i=0; i<changeInput.length();i++) {
				if(changeInput.charAt(i) == '(') {
					num += 1; // 막대가 시작하면 개수 증가
				}
				else if(changeInput.charAt(i) == '0') {
					sum += num; // 레이저를 만나면 현재 막대 수만큼 증가
				}
				else {
					num -= 1; // ')'를 만나면 막대 개수 감소
					sum += 1; // 마무리 되기 전 조각 추가
				}
			}
			
			System.out.println("#" + tc+" "+sum);
		}
		
		sc.close();
	}

}

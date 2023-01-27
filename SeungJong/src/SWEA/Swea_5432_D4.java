package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Swea_5432_D4 {

	static int T, sum;
	static char[] arr;
	static String tmpInput;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_swea5432.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int tc=1; tc<=T; tc++) {
			num.clear();
			sum = 0;
			tmpInput = sc.next();
			arr = new char[tmpInput.length()];
			for(int i=0; i<tmpInput.length(); i++) {
				arr[i] = tmpInput.charAt(i);
			}
			for(int i=0; i<tmpInput.length(); i++) {
				if(arr[i] == '(') {
					if(arr[i+1] == '(') {
						num.add(1);	
					}
				} 
				else if(arr[i-1] == '(' && arr[i] == ')'){
					for(int j=0; j<num.size(); j++) {
						num.set(j, num.get(j)+1);
					}
				}
				else if(arr[i] == ')' && arr[i-1] == ')') {
					sum += num.get(num.size()-1);
					if(num.size()>0) num.remove(num.size()-1);
				}
				
			}
			System.out.println("#" + tc+" "+sum);
		}
		
		sc.close();
	}

}

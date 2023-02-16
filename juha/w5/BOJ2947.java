package com.w5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ2947 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ2947.txt"));
		//Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i = 0;i<5;i++) {
			arr[i] = sc.nextInt();
		}
		boolean check = false;
		L: while(true) {
			for(int i = 0;i<5;i++) {
				if(arr[i] != i+1) {
					break;
				}
				if(i == 4) {
					check = true;
					break L;
				}
			}
			
			for(int i = 0;i<4;i++) {
				swap(arr, i);
			}
		}
		
	}

	private static void swap(int[] arr, int i) {
		if(arr[i] > arr[i+1]) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
			for(int j = 0;j<5;j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		
	}

}

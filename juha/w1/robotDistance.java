package com.ssafy.ws.step3;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static int move(char[][] arr) {
		int sum = 0;
		for(int i = 0;i<arr.length; i++) {
			for(int j = 0;j<arr[i].length;j++) {
				int right = 0, left = 0, up = 0, down = 0;
				switch(arr[i][j]) {
				case 'A':
					while(j+right+1 < arr[i].length) {
						if(arr[i][j+right+1]!= 'S'){ 
							break;
						}
						right++;
					}
					break;
				case 'B':
					while(j+right+1 < arr[i].length) {
						if(arr[i][j+right+1]!= 'S'){ 
							break;
						}
						right++;
					}
					while(j-(left+1)>=0) {
						if(arr[i][j-(left+1)] != 'S') {
							break;
						}
						left++;
					}
					break;
				case 'C':
					while(j+right+1 < arr[i].length) {
						if(arr[i][j+right+1]!= 'S'){ 
							break;
						}
						right++;
					}
					while(j-(left+1)>=0) {
						if(arr[i][j-(left+1)] != 'S') {
							break;
						}
						left++;
					}
					while(i+down+1< arr.length) {
						if(arr[i+down+1][j]!= 'S') {
							break;
						}
						down++;
					}
					while(i-(up+1)>=0) {
						if(arr[i-(up+1)][j]!= 'S') {
							break;
						}
						up++;
					}
					
					break;
					default:
						break;
				}
				sum += right + left + up + down;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int n;
			n = sc.nextInt();
			
			char[][] arr = new char[n][n];
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}			
			
			
			int result = move(arr);
			
			System.out.println("#"+test_case + " " + result);
		}
	}
}

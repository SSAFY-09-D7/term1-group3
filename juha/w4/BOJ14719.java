package com.w4;
import java.util.*;

public class BOJ14719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int n = sc.nextInt();
		
		int[] rect = new int[n];
		
		int heightMax = 0;
		int sum = 0;
		for(int i = 0;i<n;i++) {
			int height = sc.nextInt();

			rect[i] = height;
			sum += height;
			heightMax = Math.max(heightMax, height);
		}
		
		System.out.println(addArea(heightMax, rect) - sum);
	}
	
	public static int addArea(int heightMax, int[] rect) {
		int area = straight(heightMax, rect) + deStraight(heightMax, rect);
		return area;
	}

	private static int straight(int heightMax, int[] rect) {
		int i = 0;
		int area = 0, height = 0, cnt = 1;
		while(true) {
			if(height >= rect[i]) {
				cnt++;
			}
			else {
				area += height * cnt;
				height = Math.max(height, rect[i]);
				cnt = 1;
			}
			if(height == heightMax) {
				if(rect[i] == height) {
					area += height*cnt;
					cnt = 0;
				}
			}
			if(i == rect.length-1) break;
			i++;
		}
		
		return area;
	}
	
	private static int deStraight(int heightMax, int[] rect) {
		int i = rect.length-1;
		int area = 0, height = 0, cnt = 1;
		while(true) {
			if(height >= rect[i]) {
				cnt++;
			}
			else {
				area += height * cnt;
				height = Math.max(height, rect[i]);
				cnt = 1;
			}
			if(rect[i] == heightMax) break;
			i--;
		}
		return area;
	}

} 

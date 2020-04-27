package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		Scanner sc = new Scanner(System.in);
		
		
		int[] score = new int[5];
		int total = 0;
		double avg = 0.0;
		int max = 0, min = 100;		//최대 점수 범위
		
		
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수를 입력하세요 : ");
			score[i] = sc.nextInt();
			total += score[i];
			if(max < score[i]) {
				max = score[i];
			}else if(min > score[i]) {
				min = score[i];
			}
//		min = (score[i] < min) ? score[i] : min;
		}
				
				
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (avg =  (double)total/score.length));
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		
		
		// 최댓값
//		int max = score[0];
//		for (int i = 1; i < score.length; i++) {
//			if(score[i] > max) {
//				max = score[i];
//			}
//		}
//		System.out.println("최댓값 = " + max);

//		// 최솟값 
//		int min = score[0];
//		for (int i = 1; i < score.length; i++) {
//			if (score[i] < min) {
//				min = score[i];
//			} // end if
//		} // end for
//		System.out.println("최솟값 = " + min);		
		
		
	} // end main()

} // end class Array04Main

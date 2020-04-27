package practice.stddev;

import java.util.Random;
/*
정수 5개를 담는 배열을 생성하고
1 ~ 100 사이의 임의의 자연수로 초기화되게 하고,
생성된 배열원소들을 출력하고

그  배열원소의  평균, 분산, 표준편차를 구하라
 */

public class StdDev {
	public static double total; // 모든메서드에서 각각의 총합으로 사용
	// double로 선언한 이유는 어차피 int형으로 저장해도 자동형변환 되고
	// 사용될 때 double로 명시적 형변환을 통해 값을 바꿔야해서 편의상

	public static double avg; // 메서드 매개변수를 int형 배열만 쓰셔서
	// 그것만 매개변수로 넣으려고 전역변수 설정

	public static double variacne; // 분산 위와 마찬가지

	public static void main(String[] args) {
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		
		Random randNum = new Random(); // 랜덤으로 숫자를 뽑기위해
//		int[] num = new int[5];
		int[]num = {81, 76, 81, 55, 36};	 
		// 동작 확인용 예시에 나와있는 숫자
		
		for (int i = 0; i < num.length; i++) {
//			num[i] = randNum.nextInt(100) + 1; // 0~99임의 정수 + 1
			total += num[i];
			System.out.print(num[i] + " ");
//			System.out.println(num[i]);
//			System.out.println(total);
		}	// end for
		System.out.println(); // 줄 변경
		System.out.printf("평균:%.1f\n", calcAvg(num)); // 평균
		System.out.printf("분산:%.2f\n", calcVariance(num)); // 분산
		System.out.println("표준편차:" + calcStdDev());	// 표준편차
	} // end main

	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] num) {
		avg = total / num.length;
		return avg;
	}

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 * 
	 * @return
	 * 
	 * @return
	 */
	public static double calcVariance(int[] arNum) {
		double deviation = 0.0; // 편차

		for (int i = 0; i < arNum.length; i++) {
			total = 0; // 기존 다른 총합 초기화
			total = arNum[i] - avg; // 산술 연산자의 자동형변환
			deviation += total * total;
		}
		variacne = deviation / arNum.length;
		return variacne;
	}

	/**
	 * 메소드 이름 : calcStdDev 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev() { // int[] 을 매개변수로 넣어서 어떻게 제작하는지
										// 파악하지 못해 넣지 않았습니다.
		double StdDev = Math.sqrt(variacne);	// 루트 방법을 몰라서 검색했습니다.
		return StdDev;
	}
} // end class

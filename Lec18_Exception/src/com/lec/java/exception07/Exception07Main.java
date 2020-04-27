package com.lec.java.exception07;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Exception 클래스 만들어 사용하기  & throw
 	Exception 또는 RuntimeException 클래스를 상속 받아서 만듬
 */
public class Exception07Main {

	static Scanner sc = new Scanner(System.in);
	
	
	// TODO : ScoreException 을 throws 하는 메소드 만들기
	public static int inputScore() throws ScoreException{
		int score = sc.nextInt();

		if(score < 0 || score > 100) {
			//ScoreException ex = new ScoreException();
			ScoreException ex = new ScoreException();
			throw ex;  // 예외객체 throw!
		}
		
		return score;
	} // end inputScore()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기, throw");
		
		System.out.println();

		//  ScoreException 을 catch 해보자
		int i = 0;
		while(i < 5) {			
			try {			
				System.out.println("국어 점수 입력:");
				int kor = inputScore();
				System.out.println("kor = " + kor);
				
//				System.out.println("영어 점수 입력:");
//				int eng = inputScore();
//				System.out.println("eng = " + eng);
				i++;
				
			} catch (ScoreException ex) {
				System.out.println(ex.getMessage());
			} catch (InputMismatchException ex) {
				System.out.println("적절하지 않은 입력값입니다");
				sc.nextLine();
			}
		}
		
		sc.close();
			
		System.out.println("프로그램 종료");
	} // end main()

} // end class Exception07Main










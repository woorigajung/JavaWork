package com.lec.java.class06;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score sc1 = new Score("정종훈", 100, 95, 37);
		System.out.println(sc1.calcAvg());
		System.out.println(sc1.calcTotal())
		;
		sc1.displayInfo();

		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main











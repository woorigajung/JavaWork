package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
		// 덧셈연산
		MyOperate ab = new MyOperate();
		System.out.println(ab.operate(421, 51));
		
		
//		 방법 2) 익명클래스
		// 뺼셈 연산
		Operable opertor2 = new Operable() {
			@Override
			public double operate(double x, double y) {
				return x - y;
			}
		};
		System.out.println(opertor2.operate(23, 321));
		
	
//		 방법 3) 람다 표현식 lambda expression
		// 제곱 연산
		Operable a = (x,y) -> {
			x *= x;
			y *= y;
			return x*y;
		};
		System.out.println(a.operate(53	, 47));
//		 = (x,y) -> {Math.pow(a,b)};
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class


interface Operable {
	public abstract double operate(double x, double y);
}

class MyOperate implements Operable{
	@Override
	public double operate(double x, double y) {
		return x + y;
	}
}
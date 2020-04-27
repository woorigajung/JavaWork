package com.lec.java.wrapper01;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * 			각각의 기본 자료형을 담을 수 있다.
 * 
 * Wrapper 클래스는 immutable 하다!
 * 
 * 
 * 
 * 클래스명.파란색대문자
 * staic 클래스. final 맴버변수
 * 삐딱하게 : static
 * 대문자 : final
 * 파란색 : 맴버변수
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();

		Integer i1 = 100;
		// reference 타입 // int (primitive 타입)

		i1 = i1 + 200; // reference 가 산술 연산?
		System.out.println("i1 = " + i1); // 300
		// Wrapper 클래스는 마치 primitive 타입처럼 동작한다!

		// 1. 생성자 이용
		Integer num1 = new Integer(123);
		System.out.println("num1 = " + num1);

		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);

		if (num1 == num2) {
			System.out.println("== 같다");
		} else {
			System.out.println("== 다르다!");
		}

		if (num1.equals(num2)) { // 값 비교시 .equals 사용
			System.out.println("equals() 같다");
		} else {
			System.out.println("equals() 다르다");
		}

		// 3. new Integer() VS Integer.valueOf()
		Integer num3 = new Integer(123); // new 는 새로운 instance 생성
		Integer num4 = Integer.valueOf(123);
		// valueOf()는 생성한 Object 를 cache 해둔다.
		// 동일 literal 로 valueOf() 생성하면, 기존의 생성된 Object 리턴
		// 왜? .. 메모리 절약!
		// 한마디로 valueOf()도 heap메모리에 Integer 객체를 만든다
		// 하지만 동일한 리터럴을 입력하면 새로 만들지 않고 그 주소를 넘긴다. 그래서 valueOf끼리 동일한 리터럴로 생성시 주소값이 같다

		// new로 생성한 것들끼리 비교
		if (num1 == num3) { // new로 만든 값은 언제나 다르다
			System.out.println("생성자: 같은 참조");
		} else {
			System.out.println("생성자: 다른 참조");
		}

		// valueOf()로 생성한 것들끼리 비교
		if (num2 == num4) {
			System.out.println("valueOf(): 같은 참조");
		} else {
			System.out.println("valueOf(): 다른 참조");
		}

		
		
		// 4. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;
		// 내부적으로 Integer.valueOf(123) 동작(Auto-Boxing)
		
		if (num4 == num5) {		// 같다
			System.out.println("literal(valueof()): 같은 참조");
		} else {
			System.out.println("literal(valueof()): 다른 참조");
		}
		
		
		
		// 5. valueOf(문자열) 가능!
		Integer num6 = Integer.valueOf("123");
		System.out.println(num6);

		if (num6 == num5) {	//같다
			System.out.println("valueOf(): 같은 참조");
		} else {
			System.out.println("valueOf(): 다른 참조");
		}
		
		// 6. 산술 연산 가능
		num6 *= 2;
		System.out.println(num6);
		
		if (num6 == num5) {	// 다르다   // Wrapper 클래스가 immutable이기 때문에 연산결과는 새로운 Wrapper 생성  따라서 주소값이 다르다
			System.out.println("valueOf(): 같은 참조");
		} else {
			System.out.println("valueOf(): 다른 참조");
		}

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

package com.lec.java.variable02;

//자바의 기본 자료형(primitive data type) : 8가지
//정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
//실수 타입: float(4바이트), double(8바이트)
//문자 타입: char(2바이트)
//논리 타입: boolean

public class Variable02Main {
	
	public static void main(String[] args) {
		System.out.println("정수타입 변수들");	
	
		
		System.out.println("byte : " + Byte.MIN_VALUE);
		System.out.println("byte : " + Byte.MAX_VALUE);
		System.out.println("byte : " + Byte.MIN_VALUE + " ~ " 
		+ Byte.MAX_VALUE);
		byte num1 = -128;//양쪽이 타입이 같아야동작, convert(형변환);
		byte num2 = 0;		//0은 int (대표)타입이지만 byte타입에 저장되기 위해 자동 형변환 된다.
		byte num3 = 123;
		byte num4 = 123;
		// byte는 용량 : 1byte : -128 ~ 127까지 저장가능
		// 따라서 byte에 저장용량을 넘어선 값을 넣으면 에러가 뜬다.
//		byte num5 = 1234;
		
		System.out.println("short: " + Short.MIN_VALUE 
				+ " ~ " + Short.MAX_VALUE);
		short num5 = -12345;
		short num6 = 12345;
		short num7 = 32767;
//		short num8 = 32768;	//에러
//		short num8 = -32769;
		
		System.out.println("int : " + Integer.MIN_VALUE 
				+ " ~ " + Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE 
				+ " ~ " + Long.MAX_VALUE);
	
//		int num9 = 9876543210;
		//long num10 = 9876543210; //에러 : The literal 9876543210 of type int is out of range 
		// 리터럴 : literal
		//  코드상에 직접 입력한 값들
		//	 정수리터럴 --> int로 형변환 하려 한다.
		//	 실수리터럴 --> double로 형변환 하려 한다.
		//	 "~"리터럴 --> 문자열(String) 로 변환
		
		long num11 = 9876543210L;	// <-- long 형 리터럴로 인식
		long num12 = 12; 	//4byte -> 8byte (Integer -> long 형변환)
		long num13 = 12L;	//처음부터 8byte
		int num14  = 12;
//		int num15  = 12L;	// long 타입을 int에 대입 불가
		
		// 값의 경계선
		byte num15 = Byte.MAX_VALUE; //127
		byte num16 = (byte)(num15 + 1);
		System.out.println("num15 = " + num15);
		System.out.println("num16 = " + num16);
		//num15 = 127
		//num16 = -128
		//정수타입 4가지에 대해서만 나오는 증상
		
		// 정수 표기법
		int number1 = 11;	// 10진수(Decimal)
		int number2 = 0xB;	// 16진수(Hexadecimal), 0x로 시작
		int number3 = 013;	// 8진수(Octal) : 0으로 시작
		int number4 = 0b1011;	// 2진수(Binary) : 0b로 시작
		
		System.out.println("number1 = " + number1);
		System.out.println("number2 = " + number2);
		System.out.println("number3 = " + number3);
		System.out.println("number4 = " + number4);
		
		// String.format() 을 사용하여 원하는 포맷(진법)으로 출력가능
		System.out.println("number1 = " + String.format("%x", number1));	//16진법
		System.out.println("number1 = " + String.format("%o", number1));	//8진법
		
		//Integer.toXxx(n)를 사용하여 원하는 포맷의 문자열로 변환 가능
		System.out.println("number1 = " + Integer.toHexString(number1));	//number1을 16진수 문자열로 변경
		System.out.println("number1 = " + Integer.toOctalString(number1));
		System.out.println("number1 = " + Integer.toBinaryString(number1));
		
	
	}	// end main()
}	// end class

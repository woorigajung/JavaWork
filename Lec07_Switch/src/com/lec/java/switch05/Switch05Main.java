package com.lec.java.switch05;

public class Switch05Main {

	// enum 타입 정의하는 방법:
	// enum 이름 {}
	// enum 타입 정의 메소드 안에서는 할 수 없다.
	// *enumeration
	
	//Days 라는 enum type선언, 변수 정의한 것 아님
	enum Days {SUN, MON, TUE, WED, THU ,FRI, SAT}
	//Days가 가지는 변수값은 위에 입력한 값이다.
	//값은 대문자로 쓴다.
	
	public static void main(String[] args) {
		System.out.println("enum 타입을 switch에서 사용하기");

		Days day1 = Days.THU;
		System.out.println(day1);
		Days day2 = Days.MON;

		switch(day1) {
		case SUN:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("일요일");
			break;
		case MON:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("일요일");
			break;
		case TUE:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("화요일");
			break;
		case WED:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("수요일");
			break;
		case THU:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("목요일");
			break;
		case FRI:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("금요일");
			break;
		case SAT:		//	enum 타입은 스위치  문안에서는 경로를 쓰면 안된다.
			System.out.println("토요일");
			break;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











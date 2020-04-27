package com.lec.java.class01;

import java.util.StringTokenizer;

/*
 	클래스 정의 및 사용
 	
 	우리가 만든 클래스를 사용하려면,
	그 클래스의 '인스턴스(실체 instance)'를 생성해야 함.
	
	구문
		클래스이름 변수이름 = new 생성자();
		생성자(): 클래스의 이름과 동일, 클래스의 멤버변수들을 초기화
		
 	new 로 생성하는 instance 들은
 	지역변수와는 달리 인스턴스가 생성될 때 (자동으로) 초기화가 된다.
 	특별히 초기화를 할 값들이 지정되어 있지 않을 때는
 	각 변수 타입의 기본값(디폴트 값)으로 초기화가 됨
 		boolean -> false, 숫자타입(int, double, ...) -> 0
 		String, 참조 타입(Object클래스) -> null
 	
 	지역변수: 메소드 안에서 선언된 변수
 	지역변수는 사용하기 전에 반드시 초기화를 해줘야 함.
 */
public class Class01Main {

	public static void main(String[] args) {
		System.out.println("클래스 생성 & 사용");
		MyTV tv1;
		tv1 = new MyTV();	// MyTv 인스턴스 생성
		tv1.displayStatus();
		
		// Tv 켜기
		tv1.powerOnOff();
		
		// 볼륨 조정
		tv1.volumeUp();
		tv1.volumeUp();
		tv1.volumeUp();
		
		// 채널 조정
		tv1.channelDown();
		tv1.channelDown();
		tv1.channelDown();
		System.out.println();
		
		
//		 일반적으로
//		 멤버변수는 private 으로 설정하여
//		 외부클래스에서 아래와 같이
//		 직접 사용하는 것을 금하게 설계함.
//		tv1.isPowerOn = false;
//		tv1.volume = 32;
//		tv1.channel = 100;
		
		tv1.displayStatus();
		
		
		System.out.println();
		MyTV tv2 = new MyTV();  // 다른 MyTV 인스턴스
		tv2.powerOnOff();
		tv2.channelUp();
		tv2.volumeUp();
		tv2.displayStatus();
		
		System.out.println();
		System.out.println(tv1);
		System.out.println(tv2);
		
		System.out.println();
		tv1 = tv2;	// 이러한 동작을  주소(reference)가 끈기다고 한다. 
					// Heap 영역에 tv1 tv2 가 움직이고 복사되는 것이 아니라
		// Stack 부분 tv1에 저장된 tv1주소부분에 tv2주소가 복사되어 들어와 tv1의 주소를 지워 버리는 동작을 한다
		// 따라서 주소가 끈긴 tv1의 주소는 삭제 된다. Garbage Collector 에 의해 소멸된다. (GC된다)
		//		=> 주소가 끈긴다.
		
		
		
		
		tv1.displayStatus();
		tv2.displayStatus();
		tv1.powerOnOff();
		tv2.displayStatus();	// tv1 과 tv2 는 같은 인스턴스를 레퍼런싱 하고 있다..
		
		System.out.println(tv1);
		System.out.println(tv2);

		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class











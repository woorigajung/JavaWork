package com.lec.java.inner05;

public class TestOuter {
	// TestOuter 클래스의 멤버 변수
	private int num1 = 100;
	
	// TestOuter 클래스의 멤버 메소드
	public void localMethod(int num4) {
		int num2 = 200;		// localMethod() 의 지역변수
//		num4 = 600;
		// 매개변수도 같은 local이기 때문에 effectively final 이어야 한다.
		
		// Local inner class
		class TestLocal{
			// 멤버변수
			private int num3 = 300;
			
			// 멤버메소드
			public void showNumbers() {
				System.out.println("num1 = " + num1);	// 외부 클래스의 멤버
				System.out.println("num1 = " + num2);	// class 같은 local 의 지역변수
				System.out.println("num1 = " + num3);	// 자기자신의 멤버변수
				System.out.println("num4 = " + num4);	
			}
		}
		
		TestLocal local = new TestLocal();
//		num2 = 400;	// effectively final 이어야 하기 때문에 안된다.
		// num2 값을 변경하면.. 아래 showNumbers()에선
		// 200 이 찍혀야 하나? 400이 찍혀야 하나?
		// 그래서 로컬내부클래스에서 사용 가능한 지역의 변수는 
		// 반드시 effectively final 이어야 한다
		// 	  즉 한번 초기화 된후 값이 변경되지 않거나, final 이어야 한다.

		local.showNumbers();
		
		
		
	} // end localMethod()
	

} // end class TestOuter














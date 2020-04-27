package com.lec.java.inner04;

public class TestOuter {

	// 멤버변수
	private int value;  // 인스턴스 변수
	private static int count = 100; // 클래스 변수 (static)
	
	// 생성자
	public TestOuter(int value) {
		this.value = value;
	}
	
	// Nested class (static inner class)
	public static class TestNested {
		
		public void displayInfo() {
//			System.out.println("value = " + value);
			// static 클래스에서는 외부 클래스의 
			// non-static 멤버 사용 불가
			
			System.out.println("count : " + count);
		}
		
		
	}	// end TestNested
	
	
} // end class TestOuter


// TestOuter: 외부 클래스(outer class, enclosing class)
// TestNested: 중첩 클래스(nested class, static inner class)









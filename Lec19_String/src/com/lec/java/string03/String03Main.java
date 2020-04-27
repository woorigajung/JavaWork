package com.lec.java.string03;

/*  StringBuffer, StringBuilder

	 String 클래스는 immutable(변할 수 없는) 클래스이고,	
	 // 변할 수 없다는 의미 : Stack에 담고 있는 주소가 변할 수 없는 것이 아니라, M.A에 생성된 ex)"Hello"라는 String 값이 변하지 않는다라는 뜻
	 다른 리터럴이 새로 생성 되면 Heap에 생성됨 -> 매번 생성됨 		
	 따라서 하나에 Heap 메모리에서 변경되는 StringBuffer, StringBuilder가 속도가 더 빠르다.
	 ex) str1 = str1.concat("Java"); -> Heap메모리 "HelloJAVA" 생성된 주소를 참조 
	 
	 StringBuffer, StringBuilder는 mutable(변할 수 있는) 클래스임	// 자바 기본제공 문자열 StringBuffer, StringBuilder


	 StringBuffer:
		Java ver 1.0부터 있던 클래스
		쓰레드에 안전(thread-safe), 속도가 느림
		신호등이 있다 생각(멈추라면 멈춘다)
	
	 StringBuilder:
		Java 5부터 생긴 클래스
		쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		신호등이 없다(사고만 안나면 빠르다)
	
		그 외에는 StringBuffer와 StringBuilder는 같은 기능(메소드)을 갖고 있음
		

	** 웹 프로그래밍 등에선 문자열을 '붙여 나가며' 완성하는 동작을 많이 함
		실무에서는
			String 을 concat() (혹은 + 연산)하기 보다는
			StringBuffer 를 append() 하는 것을 더 많이 사용함  (성능 UP)
			
		※ 그러나 학습예제에선 예제단순화를 위해 String 을 기본적으로 사용하니 참조 바랍니다
 */
public class String03Main {

	public static void main(String[] args) {
		System.out.println("[1] StringBuffer, StringBuilder");
		// String 클래스는 immutable 클래스이고,
		// StringBuffer, StringBuilder는 mutable 클래스임
		
		System.out.println("[String: immutable]");

		String str1 = "Hello";
		String str2 = str1;	// Stack에서 str1이 "Hello"로 주소를 갖고 그게 복사되는 것
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		
		if(str1 == str2) {
			System.out.println("== 동일 참조"); // 동일
		} else {
			System.out.println("== 다른 참조");
		}
				
		System.out.println(str1.concat("Java"));
		System.out.println(str1); // str1이 실제 변경되지 않는다
		str1 = str1.concat("Java");
		System.out.println(str1);
		
		if(str1 == str2) {
			System.out.println("== 동일 참조"); // 동일
		} else {
			System.out.println("== 다른 참조");
		}
		// 
		
		
		System.out.println();
		System.out.println("[StringBuffer: mutable]");

		StringBuffer buff1 = new StringBuffer("Hello");
		StringBuffer buff2 = buff1;
		
		System.out.println("buff1 = " + buff1);
		System.out.println("buff2 = " + buff2);
		
		if(buff1 == buff2) {
			System.out.println("== 동일 참조");
		}else {
			System.out.println("다른 참조");
		}
		System.out.println(buff1.append("Java"));
		System.out.println(buff1);
		
		if(buff1 == buff2) {
			System.out.println("== 동일 참조"); // 동일
		} else {
			System.out.println("== 다른 참조");
		}
		// StringBuffer:
		//  Java ver 1.0부터 있던 클래스
		//  쓰레드에 안전(thread-safe), 속도가 느림
		
		// StringBuilder:
		// Java 5부터 생긴 클래스
		// 쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		
		// 그 외에는 StringBuffer와 StringBuilder는 같은 기능을 갖고 있음
		
		StringBuilder buff3 = new StringBuilder("Hello");
		System.out.println(buff3.append("Java"));
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











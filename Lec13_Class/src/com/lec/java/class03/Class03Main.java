package com.lec.java.class03;

/*

*/
public class Class03Main {

	public static void main(String[] args) {
		System.out.println("Getter & Setter");
		
		Number n1 = new Number(100,'A');
		// n1.num = 200;	// not visible : 보이지않는것이지 없는 것이 아니다.
		// n1.name = 400;	// can not be resolved 이름 없음.
		
		System.out.println(n1.getNum());
		n1.setNum(200);
		System.out.println(n1.getNum());
		n1.setNum(20);
		System.out.println(n1.getNum());
		
		System.out.println("프로그램 종료");
	} // end main()
} // end class Class03Main















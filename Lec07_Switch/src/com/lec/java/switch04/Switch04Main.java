package com.lec.java.switch04;

public class Switch04Main {

	public static void main(String[] args) {
		System.out.println("String 타입을 switch에서 사용하기");
		
		String language = "C++";
		switch(language) {
		case "Java":
			System.out.println("Hello" + language);
			break;

		case "C++":
			System.out.println("good bye" + language);
			break;
			
		case "Swift":
			System.out.println("Wow" + language);
			break;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










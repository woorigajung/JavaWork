package com.lec.java.input02;

import java.util.Scanner;

// Ctrl + Shift + O : 자동 import

// 문자열(String) 입력
// char 입력

public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");
		
		Scanner sc = new Scanner(System.in);
		
//		//String 입력
//		System.out.print("이름을 입력하세요: ");
//		String name = sc.nextLine();	
//		// 엔터를 입력하기 전까지의 모~든 문자들을 문자열로 리턴(엔터도 포함)
//
//		System.out.print("별명을 입력하세요: ");
//		String nick = sc.nextLine();
//		
//		System.out.println("이름은 : " + name + "\n별명은 : " + nick);
//		
//		// char 입력
//		// .nextChar(? 라는 명령 없다!
//		System.out.println("성별을 입력하세요 M/F : ");
//		char gender = sc.next().charAt(0); //index 위치에 존재하는 입력값 출력 
//		
//		System.out.println("이름은 : " + name + "\n별명은 : " + nick + "\n성별 : " + gender);
//
//		System.out.println();
		
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();		// 키보드 버퍼에 입력된 값이 엔터와 같이 저장되는데
									// nextLine이외에 next()메서드들은 값만 가져가기 때문에
									// 버퍼안에 엔터는 그대로 남아있다.
									// 따라서 그 엔터값을 nextLine이 입력 받는다.
									// *공백을 구분점으로 판단해서 각각의 문자열로 입력받음   


		
		// 숫자 입력 받은 뒤에 문자열 입력시에는 반드시 '\n'을 
		// consume(버퍼에서 제거) 해야한다.
		// nextLine();을 한번 더 써준다.
		sc.nextLine();

		System.out.println("주소도 입력하세요: ");
		String adress = sc.nextLine();
		
		System.out.println("나이 : " + age + "\n주소: " + adress);
		
		
		sc.close();
		
		
	} // end main()

}	// end class

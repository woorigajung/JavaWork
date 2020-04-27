package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		
		// MemberModel 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		//        (id, passwd)
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		
		Scanner sc = new Scanner(System.in);
		ArrayList<MemberModel> stu = new ArrayList<MemberModel>();
		
		for (int i = 0; i < 3; i++) {
			System.out.println("정보를 입력하세요");
			System.out.println("id : ");
			String id = sc.next();
//			sc.nextLine();
			System.out.println("pw : ");
			String passwd = sc.next();
//			sc.nextLine();
			System.out.println();
			
			stu.add(new MemberModel(id, passwd));
		}	// end for
		
		System.out.println(); 	// 줄바꿈
		
		for (int j = 0; j < stu.size(); j++) {
			System.out.println(j + "번 Member 정보");
			//System.out.println(stu.get(j));
			stu.get(j).displayInfo();
			System.out.println();
		}	// end for
		
		
		System.out.println("ArrayList 연습");
		

		System.out.println("\n프로그램 종료");

		sc.close();
	
	} // end main()

} // end class













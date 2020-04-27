package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {

		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		//	(id, name, kor, eng, math)
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		
		ArrayList<Student> scs = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
	

		System.out.println("ArrayList 연습");

		for (int i = 0; i < 3; i++) {	// 3개만 받으라 했기 때문에 반복 3번 
			int id, kor, math, eng;
			Score score;
			String name;
			
			System.out.println("학생정보를 입력해 주세요");	// Student 클래스 값
			System.out.println("id 입력 : ");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("이름 입력 : ");
			name = sc.nextLine();
			
			
			System.out.println("국어,영어,수학 점수를 차례로 입력 :");	// Score 값 입력
			kor = sc.nextInt();
			sc.nextLine();
			
			eng = sc.nextInt();
			sc.nextLine();
			
			math = sc.nextInt();
			
			scs.add(new Student(id, name, new Score(kor,eng,math)));	// Score 인스턴스화	// ArrayList에 담기
		}
		System.out.println();
		for (int i = 0; i < scs.size(); i++) {
			System.out.println(scs.get(i));
		}
		
		for (Student e : scs) {
			System.out.println(e);
		}
		sc.close();
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










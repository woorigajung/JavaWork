package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		ArrayList<String> str = new ArrayList<String>();
		// 배열은 길이를 꼭 넣어 주어야 되지만
		// ArrayList는 고정된 길이가 없어서 굳이 선언 안해주어도 된다.
		System.out.println(str.size());
		str.add("가");
		str.add("나");
		str.add("다");
		str.add("라");
		str.add("마");
		
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
		
		System.out.println();
		for(String e : str) {
			System.out.println(e);
		}
		
		str.forEach(System.out::print);
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator

		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class













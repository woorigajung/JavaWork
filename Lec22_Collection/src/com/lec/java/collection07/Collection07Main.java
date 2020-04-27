package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		Scanner sc = new Scanner(System.in);
		// TODO
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기
		
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < 5; i++) {
			System.out.println("입력");
			set.add(sc.next());
		}
		
		for(String x : set) {
			System.out.println(x);
		}
		System.out.println();
		
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			// 출력결과, 저장순서와 관계 없다.
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















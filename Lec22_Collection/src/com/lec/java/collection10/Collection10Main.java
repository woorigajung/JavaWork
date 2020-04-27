package com.lec.java.collection10;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기

		System.out.println("TreeSet 연습");
		Scanner sc = new Scanner(System.in);
		
		TreeSet<String> tSet= new TreeSet<String>();
		for (int i = 0; i < 5; i++) {
			System.out.println("입력 :");
			tSet.add(sc.nextLine());
		}
		System.out.println(tSet);
		
		Iterator<String> itr = tSet.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main
/*
 * TreeSet 연습
입력 :
AAaa
입력 :
AAAA
입력 :
AAaA
입력 :
AaAa
입력 :
aAaA
[AAAA, AAaA, AAaa, AaAa, aAaA]
aAaA
AaAa
AAaa
AAaA
AAAA

 */
} // end class


















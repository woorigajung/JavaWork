package com.lec.java.collection01;

import java.util.ArrayList;
import java.util.Iterator;
/*
■ 컬렉션 프레임 워크
- 많은 데이터를 쉽고 효율적으로 관리 할 수 있는
- 표준화된 방법을 제공하는 클래스의 집합

# 컬렉션 프레임 워크의 주요 인터페이스


 ArrayList<E>
	
	 
	 
	 ※계층도 숙지 중요
	 Collection<E> 다 제네릭이다
	  |__ List<E>
	       |__ ArrayList<E>, LinkedList<E>
	
	 List 특징(ArrayList와 LinkedList의 공통점)
	 1. 중복 저장 허용
	 2. 저장 순서 유지 (인덱스 존재)
	
	 ArrayList:
	 1. 저장 용량을 늘리는 데 많은 시간 소요 - 단점
	 2. 데이터를 삭제하는 데 많은 연산 - 단점
	 3. 데이터 참조 매우 빠름 - 장점
	 내부구조가 배열식으로 나열
	// 배열 늘리기 가능(배열체로 옮기기 때문에 느리다)
	// * 객체명을 쓰면 주소가 아니라 값이 나온다.
	
	 LinkedList:
	 1. 저장 용량을 늘리는 과정이 매우 간단 - 장점
	 2. 데이터를 삭제하는 과정이 간단 - 장점
	 3. 데이터 참조가 느리다 - 단점
	 장점 : 삽입, 삭제, 추가
	 내부구조가 포인터로 링크되는 구조
	 index 번호 x
	 ex) get(2) -> 인덱스 2번을 바로 찾는게 아니고 연결된 링크 순서로 부터 2번째까지 찾아감
	 add(1, "hh") -> 1번째 순서 링크가 끈어지고  그 1번째 링크를(0->1) hh에 연결
	 (1->2) "hh" -> 원래 연결되있던값 // 이렇게 구성
	 remove도 똑같이 링크 끈고 양쪽 연결 작용
	 
	 ※ Vector<E> <-- ArrayList 와 비슷하나... ArrayList 추천.
	  걍 ArrayList 쓰세요~~~
*/


public class Collection01Main {

	public static void main(String[] args) {
		System.out.println("ArrayList<E>");
		
		// ArrayList 선언 - ArrayList 인스턴스 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>();

		
		// 데이터 추가(저장): add(element) 메소드 사용
		//               add(idnex, element) -> index 번째 삽입

		list1.add(100);
		list1.add(400);
		list1.add(500);
		list1.add(200);
		list1.add(400);
		list1.add(0, 300);
		System.out.println(list1);
		
		// 데이터 참조(읽기, 검색): get(index) 메소드 사용
		// size(): ArrayList의 크기를 반환(리턴)
		System.out.println("size() : " + list1.size());
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println(list1.get(1));
		
		// 데이터 삭제: remove(index) 메소드 사용
		list1.remove(3);
		System.out.println("삭제 후");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		
		// 데이터 수정: set(index, element) 메소드 사용
		list1.set(2, 333);
		
		// ArrayList 출력 방법
		// 1) for
		// 2) Enhanced-for 사용
		// 3) Iterator(반복자) 사용
		// 4) forEach() 사용

		System.out.println("Enhanced for를 사용한 출력");
		// Enhanced for 사용 가능
		for(int e : list1) {
			System.out.println(e);
		}
		
		
		System.out.println("Iterator 를 사용한 출력");
		// Iterator(반복자) 사용법
		// iterator() 메소드를 사용해서 인스턴스 생성
		Iterator<Integer> itr = list1.iterator();
		
		// hasNext(): iterator가 다음 원소를 가지고 있는 지(true/false)
		// next(): 현재 iterator 위치의 원소를 값을 리턴하고,
		//   iterator의 위치를 다음 원소의 위치로 변경
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
		System.out.println("forEach() 를 사용한 출력");
		// forEach() + functional interface
		// Java8 부터 등장
		list1.forEach(System.out::println);
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class











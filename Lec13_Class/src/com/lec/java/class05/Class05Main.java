package com.lec.java.class05;

/* 메소드 체이닝 : method chaining
 *  	this는 자기자신 인스턴스 입니다.
 *  	메소드에서 this를 return 하면
 *  	호출한쪽에서 곧바로 연이어 호출 가능
 *  
    	객체.메소드1().메소드2().메소드2()....
    
   메소드체이닝을 사용하면, 반복되는 지루한 코딩을 줄여줄수 있다.
   프로그래밍시 각 메소드가 무엇을 리턴하는지는 항상 예의주시해야 합니다
 */
public class Class05Main {

	public static void main(String[] args) {
		System.out.println("클래스 정의 연습 : this, 메소드 체이닝");
		
		Point p1 = new Point();
		Point p2 = new Point(1,2);
		
		double distance = p1.distance(p2);
		System.out.println(distance);
		
		distance = p2.distance(p1);
		System.out.println(distance);
		System.out.println("프로그램 종료");
		
		System.out.println(p1.add(p2).add(p1).add(p1).xPos);
		System.out.println(p1.add(p2).add(p1).add(p1).yPos);
	} // end main()

} // end class Class05Main












package com.lec.java.inner07;

public class Person {

	// 외부 클래스 멤버변수
	private String name;

	// 외부 클래스 생성자
	public Person(String name) {
		this.name = name;
	}

	public Readable createInstance(int age) {
		
		// 익명 내부 클래스:
		// 인스턴스 생성과 동시에 클래스가 정의됨.
		// new 인터페이스() { 익명 클래스 내부 작성 }; 
		// new 부모클래스() { 익명 클래스 내부 작성 };
		return new Readable() {
			@Override
			public void readInfo() {
				System.out.println(name);
				System.out.println(age);
			}
		};
		

		
	} // end createInstance()
} // end class Person

interface Readable {
	public abstract void readInfo();
}

abstract class Movable{
int speed =100;
public abstract void move(int times);
}

class MyClass {
	public void aaa() {
		System.out.println("aaa");
	}
	
	public void bbb() {
		System.out.println("bbb");
	}
}
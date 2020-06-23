package com.lec.spring;

public class MessageKor implements MessageBean {

	String msgKor = "안녕하세요";
	
	// 생성자 : 언제 생성되는지 예의 주시
	public MessageKor() {
		System.out.println("MessageKor() 생성");
	}

	@Override
	public void sayHello() {
		System.out.println(msgKor);
	}

}









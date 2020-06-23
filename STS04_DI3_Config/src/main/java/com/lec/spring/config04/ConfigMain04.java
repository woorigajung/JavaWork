package com.lec.spring.config04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigMain04 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig04.class);
		
		System.out.println("-- ctx 생성 --");
		
		// XML에서 설정
		System.out.println(ctx.getBean("score1"));
		
		// Java 에서 설정
		System.out.println(ctx.getBean("score2"));
		
	} // end main

} // end class

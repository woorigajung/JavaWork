package com.lec.java.dowhile;

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do ~ while문 연습");
		
		int n = 0;
		while(n>0) {
			System.out.println("카운트다운: " + n);
			n--;
		}
		
		do {
			System.out.println("카운트다운: "+ n);
			n--;
		} while (n>0);
		// 구구단 9단 do ~ while 로 출력
		
		int i = 1;
		do {
			System.out.println(9 * i);
			i++;
		}while(i<10);
	
	} // end main()

} // end class While04Main

package com.lec.java.while02;

public class While02Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		// 구구단 2단
		// while 사용
		int i = 2;
		int cnt = 1;
		System.out.println("구구단 2단");
		while(cnt<10) {
			System.out.printf("%d * %d = %d\n",i,cnt,i*cnt);
			cnt ++;
		}


	} // end main()

} // end class While02Main










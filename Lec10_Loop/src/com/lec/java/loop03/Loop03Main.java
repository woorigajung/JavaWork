package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

//		// 구구단 출력 : 중첩 for 사용
//		for (int i = 2; i <= 9; i++) {
//			System.out.printf(" %d 단 \n", i);
//			for (int j = 1; j <= 9; j++) {
//				System.out.printf("%d x %d = %d", i, j, i * j);
//				System.out.println();
//			}
//			System.out.println();
//		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int cnt = 1,dan = 2;
		while(dan<=9) {
			System.out.printf(" %d 단 \n", dan);
			cnt = 0;
			while(cnt<=9) {
				System.out.printf("%d x %d = %d", dan, cnt, dan*cnt);
				System.out.println();
				cnt++;
			}
			System.out.println();
			dan++;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

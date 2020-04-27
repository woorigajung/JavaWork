package com.lec.java.for02;

import java.util.Scanner;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");

		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 2 x 9 = 18
		System.out.println("출력하고 싶은 단을 입력하시오 (ex : 2 ~ 9)");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d x %d = %d\n"
					, num
					, i
					, num * i);
		}
		
		for (int i = 2; i <= 9; i++) {
			System.out.printf("\n%d x %d = %d\n"
					, i
					, i
					, i * i);


			
		}

	} // end main()

} // end class For02Main

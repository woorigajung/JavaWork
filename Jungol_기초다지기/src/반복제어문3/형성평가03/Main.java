package 반복제어문3.형성평가03;

import java.util.Scanner;

//	자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
//	주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.
//	
//	
//	입력 예
//	3
//	출력 예
//	*
//	**
//	***
//	**
//	*
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		if (0 < num1) {
			for (int i = 1; i <= num1; i++) {
				for (int j = 0; j < num1 - (num1 - i); j++) {
					System.out.print("*");
				} // end for
				System.out.println();
			} // end for
			
			
			for ( int i = 1; i <= num1; i++) {
				for (int j = num1 - i; j > 0; j--) {					
					System.out.print("*");
				} // end for
				
				System.out.println();
			} // end for

		} else if(num1 == 1) {
			 System.out.println("*");
		} // end if

	} // end main
} // end class

package 반복제어문3.자가진단04;

import java.util.Scanner;

//	자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.
//	
//	
//	입력 예
//	3
//	출력 예
//	***
//	 **
//	  *
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = num - i; j < num; j++) {
				System.out.print(" ");
			} // end for
			for (int j = 0; j < num - i; j++) {
				System.out.print("*");
			} // end for
			System.out.println();
		} // end for
	} // end main
} // end class

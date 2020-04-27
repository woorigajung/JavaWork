package 반복제어문3.자가진단03;

import java.util.Scanner;

//	자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.
//	
//	
//	입력 예
//	3
//	출력 예
//	***
//	**
//	*
//	*
//	**
//	***
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			for (cnt = i; cnt < num; cnt++) {
				System.out.print("*");				
			}
//			if(i != num - 1)
			System.out.println();
		} // end for
		
		for (int i = 0; i < num; i++) {
			for (cnt = num - i; cnt <= num; cnt++) {
				System.out.print("*");				
			}
			System.out.println();
		} // end for
		
	} // end main
} // end class

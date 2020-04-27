package 반복제어문3.자가진단07;

import java.util.Scanner;

//	자연수 n을 입력받아서 n개의 줄에 n+1개의 숫자 혹은 문자로 채워서 
//  다음과 같이 출력하는 프로그램을 작성하시오.
//	
//	
//	입력 예
//	3
//	출력 예
//	1 2 3 A
//	4 5 B C
//	6 D E F
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int cnt = 0;
		int startNum = 1;
		char startChar = 65;
		
		for (int i = num1; i > 0; i--) {
			for (int j = 0; j < num1 + 1; j++) {
				if(j < num1-cnt) {
					System.out.print(startNum + " ");
					startNum++;
				} else {
					System.out.print((char)startChar + " " );
					startChar ++;
				} // end if
			} // end for

			cnt++;
			System.out.println();
			
		} // end for
		
		
	} // end main
} // end class

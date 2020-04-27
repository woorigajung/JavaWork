package 반복제어문3.형성평가02;

import java.util.Scanner;

//	1부터 100까지의 정수 중 한 개를 입력받아 100 보다 작은 배수들을 
//	차례로 출력하다가 10 의 배수가 출력되면 프로그램을 종료하도록 프로그램을 작성하시오.
//	
//	
//	입력 예
//	7
//	출력 예
//	7 14 21 28 35 42 49 56 63 70
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num2 = 0;
		boolean isCheck = true;
		
		for (int num1 = sc.nextInt(); num1 < 100; num1 += 0) {
			if(isCheck) {
				num2 = num1;
				isCheck = false;
			}
 			
			if (1 <= num1 && num1 <= 100) {
				System.out.print(num1 + " ");
				if(num1 % 10 == 0) break;
				num1 += num2;
			}
		} // end if

	} // end main
} // end class

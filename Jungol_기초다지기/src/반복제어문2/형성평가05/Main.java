package 반복제어문2.형성평가05;

import java.util.Scanner;

//	10개의 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 
//개수를 각각 구하여 출력하는 프로그램을 작성하시오.
//	
//	
//	입력 예
//	10 20 30 55 66 77 88 99 100 15
//	출력 예
//	even : 6
//	odd : 4
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int evenCnt = 0, oddCnt = 0;
		
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			switch (num%2) {
			case 1:
				oddCnt++;
				break;

			default:
				evenCnt++;
				break;
			}
		} // end for
		System.out.printf("even : %d\n" + 
				"odd : %d",evenCnt,oddCnt);
	} // end main
} // end class

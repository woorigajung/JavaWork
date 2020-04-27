package 반복제어문2.형성평가06;

import java.util.Scanner;

//	두 개의 정수를 입력받아 두 정수 사이(두 정수를 포함)에 
//	3의 배수이거나 5의 배수인 수들의 합과 평균을 출력하는 프로그램을 작성하시오.
//	
//	(평균은 반올림하여 소수 첫째자리까지 출력한다.)
//	
//	
//	입력 예
//	10 15
//	출력 예
//	sum : 37
//	avg : 12.3
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(), num2 = sc.nextInt();
		int sum = 0, cnt = 0;
		double avg = 0;

		if (num1 > num2) {
			for (int i = num2; i <= num1; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					sum += i;
					cnt++;
				} // end if
			} // end for
		} else if (num2 > num1) {
			for (int i = num1; i <= num2; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					sum += i;
					cnt++;
				} // end if
			} // end for
		} else{
			sum = num1;
			cnt ++;
		} // end if
		avg = (double) sum / cnt;
		System.out.printf("sum : %d\n" + "avg : %.1f", sum, avg);
	} // end main
} // end class

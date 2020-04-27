package 반복제어문2.형성평가04;

import java.awt.print.Printable;
import java.util.Scanner;

//	100 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 평균을 출력하는 프로그램을 작성하시오.
//	(평균은 반올림하여 소수 둘째자리까지 출력하도록 한다.)
//	
//	
//	입력 예
//	3
//	99 65 30
//	출력 예
//	64.67
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		double avg = 0;
		if (num <= 100) {
			for (int i = 0; i < num; i++) {
				int num2 = sc.nextInt();
				sum += num2;
			} // end for
		} // end if
		avg = (double)sum/num;
		System.out.printf("%.2f",avg);
		
	} // end main
}

package 반복제어문1.형성평가03;

import java.util.Scanner;

public class Main {
//	0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
//
//	(평균은 반올림하여 소수 첫째자리까지 출력한다.)
//
//
//	입력 예
//	55 100 48 36 0 101
//	출력 예
//	sum : 239
//	avg : 47.8
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		int cnt = 0;
		double avg = 0.0;

		while (true) {
			num = sc.nextInt();
			if (!(0 <= num && num <= 100))
				break;
			sum += num;
			cnt ++;
//			if (num == 0) {
//				continue;
//			} else {
//				cnt++;
//			} // end if
		} // end while

		avg = (double) sum / cnt;
		System.out.printf("sum : %d\navg : %.1f", sum, avg);

		sc.close();

	} // end main

} // end class
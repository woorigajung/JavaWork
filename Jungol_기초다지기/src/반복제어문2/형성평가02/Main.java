package 반복제어문2.형성평가02;

import java.util.Scanner;

//	100 이하의 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램을 작성하시오.
//	
//	
//	입력 예
//	10 5
//	출력 예
//	5 6 7 8 9 10
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if (num1 <= 100 && num2 <= 100) {
			if (num1 > num2) {
				for (int i = num2; i <= num1; i++) {
					System.out.print(i + " ");
				}
			} else {
				for (int i = num1; i <= num2; i++) {
					System.out.print(i + " ");
				}
			}
		}
	}
}

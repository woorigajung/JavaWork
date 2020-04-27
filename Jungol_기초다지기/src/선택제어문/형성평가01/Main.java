package 선택제어문.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1, num2;
		num1 = sc.nextInt();
		num2 = sc.nextInt();

		if (num1 > num2) {
			System.out.println(num1 - num2);
		} else if (num2 > num1) {
			System.out.println(num2 - num1);
		}
	}

}

package 반복제어문1.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		while (true) {
			System.out.println("number?");
			num1 = sc.nextInt();
			if (num1 > 0) {
				System.out.println("positive integer");
			} else if (num1 < 0) {
				System.out.println("negative number");
			} else {
				break;
			}
		}
	}

}

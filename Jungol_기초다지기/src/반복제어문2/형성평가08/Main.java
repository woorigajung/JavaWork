package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int column = sc.nextInt();
		int cnt = 1;
		for (int i = 1; i <= row; i++) {
			cnt = i;
			for (int j = 1; j <= column; j++) {
				System.out.print(cnt + " ");
				cnt += i;
			}
			System.out.println();
		}
	}

}

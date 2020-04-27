package 선택제어문.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double score = sc.nextDouble();
		int gradeScore = (int) score;
		int choice;
		if (gradeScore >= 0 && gradeScore <= 4.5) {
			choice = 1;
		} else {
			choice = 0;
		}

		switch (choice) {
		case 1:
			if (gradeScore >= 4.0) {
				System.out.println("scholarship");
			} else if (gradeScore >= 3.0) {
				System.out.println("next semester");

			} else if (gradeScore >= 2.0) {
				System.out.println("seasonal semester");

			} else if (gradeScore < 2.0) {
				System.out.println("retake");
		
			}
			
			break;

		case 0:
			break;
		}

	}

}

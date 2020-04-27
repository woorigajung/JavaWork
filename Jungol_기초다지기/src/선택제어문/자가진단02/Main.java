package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int ORate = w + 100 - h;
		
		if(ORate > 0) {
			System.out.println(ORate);
			System.out.println("Obesity");
		} else {
			System.out.println(ORate);
		}
		
	}	// end Main()

}	// end Class 

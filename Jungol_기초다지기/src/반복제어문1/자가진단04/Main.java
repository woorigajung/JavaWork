package 반복제어문1.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		int sum = 0, cnt = 0;
		for (;;) {
			n = sc.nextInt();
			sum += n;
			cnt++;
			if (n >= 100)
				break;

		}
		System.out.println(sum);
		System.out.printf("%.1f\n", (double) sum / cnt);
		
		sc.close();
	}
}

//		int num = 0;
//		int cnt = 0;
//		int sum = 0;
//		double avg = (double)sum/cnt;
//		while(num>=100) {
//			num = sc.nextInt();
//			sum +=num;
//			cnt ++;
//		}
//		sc.close();
//		System.out.println(num);
//	}

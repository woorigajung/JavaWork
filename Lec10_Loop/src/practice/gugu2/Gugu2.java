package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {
		// 10-04 2페이지에 있는 것만
		int dan = 2; // 단수
		int cnt = 1; // 곱하는 값

		while (dan <= 9) {
			cnt = 1;
			while (cnt <= 9) {
				if (dan == 8) {
					System.out.printf("%d X %d = %d \t %d X %d = %d\n", dan, cnt, dan * cnt, dan + 1, cnt,
							(dan + 1) * cnt);

				} else { // end if
					System.out.printf("%d X %d = %d \t %d X %d = %d \t %d X %d = %d \n", dan, cnt, dan * cnt, dan + 1,
							cnt, (dan + 1) * cnt, dan + 2, cnt, (dan + 2) * cnt);
				} // end else

				cnt++;
			} // end inner while
			System.out.println();
			dan += 3;

		} // end while

	} // end main()

} // end class

package com.lec.java.array09;

/* ragged array: column(열)의 개수가 일정하지 않은 배열

	가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
	열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
 */
public class Array09Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)");

		int[][] arr = new int[3][]; // int[] 3개짜리 2차원배열 객체만 생성
		arr[0] = new int[1];
		arr[1] = new int[2];
		arr[2] = new int[3];

		// 확인
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				System.out.print(arr[x][y] + " ");
			} // end for(y)
			System.out.println();
		} // end for (x)

	} // end main()

} // end class Array09Main

package com.lec.java.array03;

public class Array03Main {

	public static void main(String[] args) {
		System.out.println("여러가지 자료형의 배열");

		System.out.println();
		System.out.println("[1] double형 배열");
		// 타입[] 이름 = new 타입[배열 길이];
		// 타입[] 이름 = new 타입[] {a, b, ...};
		// 타입[] 이름 = {a, b, ...};

		double[] array1 = { 1.2, 2.3, 3.4 };
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}

		System.out.println();
		System.out.println("[2] char형 배열");

		char[] array2 = new char['z' - 'a' + 1];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (char) ('a' + i);
			System.out.println(array2[i] + " ");
		}

		System.out.println();
		System.out.println("[3] boolean형 배열");

		boolean[] array3 = new boolean[4];
		// 짝수 index => true, 홀수 index => false;
		for (int i = 0; i < array3.length; i++) {
			if (i%2==0) {
				array3[i] = true;
				
			}else {
				array3[i] = false;
				
				System.out.println(i + " : " + array3[i]);
			
			}
				
		}

		System.out.println();
		System.out.println("[4] String형의 배열");

		String[] a4 = new String[3];
		a4[0] = "adf";
		a4[1] = "adfdasf";
		a4[2] = "adf adsfdsa";
		
		for (int i = 0; i < a4.length; i++) {
			System.out.println(a4[i]);
		}
	} // end main()

} // end class Array03Main

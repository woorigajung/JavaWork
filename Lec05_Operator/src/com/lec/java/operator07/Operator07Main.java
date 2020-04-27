package com.lec.java.operator07;

/* 게으른 계산(Lazy Evaluation)
 * SCE: Short-Circuit Evaluation
 *
 * A && B를 계산할 때
 *	A가 거짓이면, B의 결과에 상관 없이 결과가 항상 거짓이 되기 때문에
 *	B는 연산이 이루어지지 않는다.
 *
 * A || B를 계산할 때
 * 	A가 참이면, B의 결과에 상관 없이 결과가 항상 참이 되기 때문에
 * 	B는 연산이 이루어지지 않는다.
 */
public class Operator07Main {

	public static void main(String[] args) {
		System.out.println("게으른 계산(Lazy Evaluation)");
		System.out.println("SCE: Short-Circuit Evaluation");

		int num1 = 0, num2 = 0;
		boolean b;

		b = ((num1 += 10) < 10) && ((num2 += 10) > 0);
		System.out.println(b);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		// ↑ 실무에서는 이런 코드 작성하지 말자!!
		// num2는 수행되지 않았다.
		num1 += 10;
		num2 += 10;
		b = (num1 < 0) && ((num2 += 10) > 0);
		

	} // end main ()

} // end class

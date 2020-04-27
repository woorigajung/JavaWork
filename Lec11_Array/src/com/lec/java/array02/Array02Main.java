package com.lec.java.array02;
/*  배열의 선언과 초기화
  
 
  
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		
		// 배열선언 따로, 초기화 따로
		int[] korean = new int[3];
						// length : 데이터 개수 -----> 3
						// size : 데이터 용량 ------> ? byte
		
		korean[0] = 100;
		korean[1] = 90;
		korean[2] = 80;
		
		for (int i = 0; i < korean.length; i++) {
			System.out.println(korean[i]);
		}
						
	} // end main()

} // end class Array02Main












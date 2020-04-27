package com.lec.java.array13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* java.util.Arrays 클래스
     배열을 다루는 유용한 메소드들 제공
		Arrays.toString() : 문자열 형태로 리턴
		Arrays.copyOf(원본배열, 복사할 length)
		Arrays.copyOfRange(원본배열, from, to))
		Arrays.fill()  : 배열에 특정 값으로 채우기
		Arrys.sort(원본배열) :  오름차순 변경
		Arrays.asList() : array -> List 로
 */
public class Array13Main {

	public static void main(String[] args) {
		System.out.println("java.util.Arrays 클래스");
	
		int [] arr = {10, 20, 30, 40, 50};
		System.out.println(Arrays.toString(arr));
		
		// Arrays.copyOf(원본배열, 복사할 length)
		// 배열을 복사하여 새로운 배열생성하여 리턴
		
		int [] arr2 = Arrays.copyOf(arr, 3);
		System.out.println(Arrays.toString(arr2));
		
		int [] arr3 = Arrays.copyOf(arr, 10);		// 초과되는 값은 초기화 
		System.out.println(Arrays.toString(arr3));
		
		// Arrys.sort(원본배열)
		// 오름차순 변경.  원본 배열을 변경시킨다
		// 내림차순은 지원하지 않는다.
		int [] arr7 = {8, 9, 3, 5 , 1, 2};
		Arrays.sort(arr7);
		System.out.println(Arrays.toString(arr7));
		
		// Arrays.equals(배열1, 배열2)
		int [] arr8 = {10, 20, 30};
		int [] arr9 = {10, 20, 30};
		System.out.println(arr8 == arr9);
		System.out.println(Arrays.equals(arr8, arr9));
		
		
		
	} // end main

} // end class

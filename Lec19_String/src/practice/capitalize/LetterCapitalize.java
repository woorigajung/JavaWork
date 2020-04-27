package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		System.out.println("입력 :\t\t(종료) quit ");

		Scanner sc = new Scanner(System.in);

		String line;
		String[] words;
		
		while(true) {
			line = sc.nextLine();
			if(line.trim().equalsIgnoreCase("quit")) break;
			
			line = line.toLowerCase(); // 일단 소문자로 변환
			words = line.split("\\s+");   // 공백 기준 단어 쪼개기
			
			for(String word : words) {
				if(word.length() > 0) {
					// 앞글자 떼어내기
					String firstLetter = word.substring(0, 1).toUpperCase();
					String rest = word.substring(1);   // 나머지 문자열
					System.out.print(firstLetter + rest + " ");  // 최종 출력					
				}				
			}
			System.out.println();
			
		}
		
		
//		while (true) {
//			String line = sc.nextLine();
//			if (line.equalsIgnoreCase("quit"))
//				break;
//			String temp = (line.charAt(0) + "").toUpperCase();
//			line = line.substring(1);
//			line = temp.concat(line);
//			System.out.print(line);
//		} // end while

		sc.close();
	} // end main()
} // end class

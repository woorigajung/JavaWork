package practice.game369;

import java.util.Arrays;
import java.util.Scanner;

public class Game369 {
	public static void main(String[] args) {
		String endNum = "1232"; // 369게임 마지막 숫자의 문자
//		String 배열 값으로 설정한 이유 : (3,6,9) 유/무 를  각 index로 뽑아내서 판별하기 위해서
		
//			게임 숫자 임의로 조정	
//		Scanner sc = new Scanner(System.in);
//		String  endNum = sc.next();
		

		int endNumI = Integer.parseInt(endNum); 
		// 마지막 숫자의 정수 값 : 실행횟수, I는 String -> int 로 변환 해줬다는 뜻
		
		
		String allNum;	// 각각 따로따로 입력받자 마자 구분하기 위한 변수
		boolean flag = true; // 369게임 일반 숫자를 표현하기 위한 구분점 (ex 1,2,4,5,7 ...1232)
		// 중첩 for문 안에 조건문을 만족하지 않을 때 !!한번씩만!! 출력하기 위한 구분점
		
		int[] temp = new int[1];	// 어차피 하나씩 사용하기 때문에 크기를 1로 선언한다.
		// 제출하고 복습하다 Array.toString 으로 될꺼같아서 사용
		
		for (int i = 1; i <= endNumI; i++) {	// 입력한 값만큼 동작
			
			// allNum = (i) + ""; 	// ""는 Sring타입으로 자동 형변환 위해
			temp[0] = i;	// toString을 사용하기위에 정수형 배열에 담는다
			allNum = Arrays.toString(temp);
			// charAt으로 뽑아 내기위해 String 타입 배열로 변경했다.
			// 배운 것들 중에 각 자릿 수 마다 구분할 방법으로 생각난게 index로 접근하는 방법 뿐이어서 

			for (int j = 0; j < allNum.length(); j++) { // 눌러보니까 String 타입 배열은 .length x -> .length()로 길이 접근
			// allNum.length() : 자릿수마다 접근하기 위해서 
			// 몰라서 길이를 뽑아봤는데 각각의 char들이 원소의 숫자가.(String도 배열)
				
				if (allNum.charAt(j) == '3' || allNum.charAt(j) == '6' || allNum.charAt(j) == '9') {
				// 3개중에 하나만 만족해도 되기 때문에 논리 연산자 중 OR을 썻다.
 
					System.out.printf("%-5c", '*');	
					// 포멧 출력 방식으로 표현한 이유 : 공백값을 일정하게 입력하기 위해서
					// %d 정수형만 되는 줄 알았는데 사용했더니 동작해서 그대로 둠
					
					flag = false; // if문안에 들어왔을 때 일반 숫자는 출력x 따라서 논리값 false로 변경
					break;	// 예시에 3,6,9가 두개씩 있어도 *은 하나씩만 출력된다.
					// break를 통해 탈출해야 *이 두개이상 출력되는 것을 막을 수 있다.
					// 애초에 포맷으로 출력에 공백을 넣어놨고 공백설정이 없으면  출력값의 정렬도 조절할 능력이 없음 나는..
				
				}	// end if	
			}	// end 중첩 for(3,6,9 유효검사)
			
			if (flag) {
				System.out.printf("%-5d", i);
			}	//end flag if
			flag = true;	// 평소 loop 때는 바로 위 조건문이 동작해야 한다.

			if (i % 10 == 0)	// 입력 10번 마다 단 바꿈 설정
				System.out.println();
		} // end for main
		
//		sc.close();
	}	// end main()
}	// end class





//		String[] a = { "20" };
//		System.out.println(a[0].charAt(1));
//		배열에 숫자를 문자열로 입력해 각 index마다 뽑아내려했는데
//		문자열과, 입력된 문자(숫자)에 index로 접근하려는데 
//		배열 크기를 벗어났다는 오류를 고치지 못해서 포기
//		, 그래서 더 간결하게 본 소스코드처럼 하나씩 바로 접근
		

		
		
//		처음에 만든 소스코드
//		만들다 보니까 각자리 숫자마다 3,6,9 유효검사를 해야하는데
//		숫자로는 못 만들겠어서 포기
		
//		System.out.println("(369게임)숫자 입력 : ");
//		int num = sc.nextInt();
//		int cnt = 1;
//		for (int i = 1; i <= num; i++) {
//			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9 ) {
//				System.out.printf("%-5c", '*');
//			} else {m
//				System.out.printf("%-5d", i);
//			}
//			if (cnt % 10 == 0) {
//				System.out.println();
//			}
//
//			cnt++; // 단수 변수값 증가
//		}

package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	public static String[] divSentences(String allSentence) {
		// 들어온 문장 구분자로 구분하여 String[]에 담는 메서드

		StringTokenizer tokenizer = new StringTokenizer(allSentence, ".!?");
		// .!?로 구분하여 tokenizer token에 내부적으로 저장

		String[] arSentence = new String[tokenizer.countTokens()];
		// 각 문장을 담는 배열로 크기는 토큰의 갯수(: 문장을 나눈 숫자) 만큼으로 한다.

		int i = 0;
		// 문장배열 인덱스 번호

		while (tokenizer.hasMoreTokens()) {
			arSentence[i] = tokenizer.nextToken().trim(); // 나눈 문장을 배열에 담는다
//			System.out.println(arSentence[i].isEmpty());
			if (arSentence[i].isEmpty()) {
				arSentence[i] = " ";
				// 검색을 하다보니 isBlank라는 메서드는 공백을 확인해주는데 버전 11부터된다길래 고민을 하다가
				// trim()을 쓰면 공백만 들어갔을 때 제거는 되서 empty 상태인데 값이 없어 뭐라 바꿀 방법이 없어서
				// "" 도 안되고 해서
				// " " 공백 하나를 넣어주었다.
			}
			i++;
		} // end while

		return arSentence;
	}

	public static int[] divWords(String[] arSentence) {
		// 구분된 문장들 단어 구분하여 개수를 리턴하는 메서드
		String[] arWords; // 문장의 단어를 각각 담을 배열
		int[] arWordsCnt = new int[arSentence.length]; // 각각 구분된 문장의 단어 수 저장을 위한 int[] 변수

		for (int i = 0; i < arSentence.length; i++) {
			arWords = arSentence[i].trim().split("\\s+");
			arWordsCnt[i] = arWords.length; // 단어 갯수
//			System.out.println(arWords.length);		
			// 이부분 입니다. " ".length가 왜 0이 안나올까요 ..
			// 공백을 trim()으로 제거하면 0이 나와야 하는데..
			// 1이 나옵니다 여기서는...
			// 한 칸 공백은 그대로 -> 0
			// 여러칸 공백은 -> 1
			// 아 .... split("\\s+")로 return 을 0번쨰 방으로 "" 받았기 때문에
			// arWords.length는 0번 인덱스에 존재함으로 1이되는구나

		} // end for
		return arWordsCnt;
	}

	public static void printMWS(String allSentence) {
		String[] arSentence = divSentences(allSentence);
		int[] arWordsCnt = divWords(arSentence);
		int max = 0; // 최대단어 갯수
		String maxInd = ""; // 최대값이 중복 될 수 있기 때문에

		for (int i = 0; i < arSentence.length; i++) {
			if (arWordsCnt[i] >= max) { // 최대 문자 갯수 구하기
				max = arWordsCnt[i];
			} // end if
		} // end for

		for (int i = 0; i < arSentence.length; i++) {
			if (max == arWordsCnt[i]) { // 최대 문자 문장 인덱스 구하기
				maxInd += i + "";
			}
		} // end for

		int[] arMaxInd = new int[maxInd.length()];
		// 인덱스 갯수를 바로 위에서 구했기 때문에 지금 선언해준다.
		// maxInd 문자열이기 때문에 index에 접근해 출력하기위하여
		// Sring => int로 바꾸는 작업

		for (int i = 0; i < arMaxInd.length; i++) {
			arMaxInd[i] = Integer.parseInt(maxInd.split("")[i]);
		} // end for
		// 굳이 for문을 쓴이유는 .split이 String 배열을 리턴하기 때문에
		// int로 형변환 하기 위해서 각각에 인덱스에 접근해 형변환 했다.

		if (max == 0 || arSentence[arMaxInd[0]].equals(" ")) {
			System.out.println("나눌 수 있는 단어가 없습니다.");
//			System.out.println(max);	// 공백이 따로 넓게 입력될 때 
//			System.out.println(arSentence[0]);	// 공백 출력
		} else {

			System.out.println(max + "개");
			for (int i = 0; i < arMaxInd.length; i++) {
				System.out.println(arSentence[arMaxInd[i]].trim());
			} // end for
		} // end if

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String allSentence = sc.nextLine();
		// divWords 과정에서 문장 양끝 공백을 지웠기 때문에 굳이 main에서 하지 않았다.
		printMWS(allSentence);

		sc.close();
	} // end main
} // end class



// 오류 제거 : 공백만 입력시 ex)  .        .        ., . . . . .















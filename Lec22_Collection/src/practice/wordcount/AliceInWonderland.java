//package practice.wordcount;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Map;
//import java.util.StringTokenizer;
//import java.util.TreeMap;
//
///* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
// * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
// *  - 2글자 이상만 계수하기
// *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
// *  - 공백 짤라내기
// * ex)
// * 	an : 234
// * 	the : 314
// * ...
// * 
// * hint]
// * 	split("\\s+")  --> String[]   
// * 	--> StringTokenizer  (혹은 정규표현식)
// *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
// * ───────────────────────────────────────────────────────────    
// * 2] 빈도수 내림차순으로 정렬하여 출력하기
// * 	ex)
// *	1 the:113개
// *	2 she:95개
// *	3 to:85개
// *	...   
// *
// * hint]
// * 	Comparable<> 이나 Comparator<> 적용
// */
//
//// TODO : 필요한 객체들 작성
//// hint> 빈도수 담을 객체, Comparator<> ..
//
//public class AliceInWonderland {
//
//	public static void main(String[] args) {
//		System.out.println("실습: 단어 발생 빈도");
//		ArrayList<String> wordList = new ArrayList<String>();	// 단어 담을 변수
//		ArrayList<String> delOverlapW = new ArrayList<String>();	// 중복 제거된 단어
//		TreeMap<String, Integer> wordTMap = new TreeMap<String, Integer>();
////		String[] a = {"A","B"};
////      Arrays.toString(a).CharAt[0]
//		
//		
//		// 단어 구분
//		String[] words = C.ALICE30.toLowerCase().split("\\s+"); // 공백기준 단어 구분
//		StringTokenizer tokenizer = 
//				new StringTokenizer(Arrays.toString(words),"[,],_, ,.\"\'`!?;:-()");	
//		// Arrays.toString()하면 (공백,[])이 생긴다 -> 문자열 양끝에 [] , 이어 붙은 단어 사이에 " " 생성 따라서
//		// 어차피 공백이 한칸 이기 때문에 " ", []을 구분점에 추가하여 제거
//
//		
//		// 발생빈도 작성 & 중복제거
//		int howMany = 1;	// 각각의 단어 갯수 초기값
//		while(tokenizer.hasMoreTokens()) {	// 나눈 단어 담기
//			wordList.add(tokenizer.nextToken());
//		}	// end while
//		for (int index = 0; index < wordList.size(); index++) {	// 중복제거 및 3글자 이상 유효성검사
//			if(!delOverlapW.contains(wordList.get(index)) && (wordList.get(index).length() >= 2)) {	// 중복제거 조건
//				delOverlapW.add(wordList.get(index));
//				wordTMap.put(wordList.get(index), howMany);
//			} else if(delOverlapW.contains(wordList.get(index))) {	// 중복 횟수
//				wordTMap.put(wordList.get(index), wordTMap.get(wordList.get(index))+1);	// 중복 될 때마다 1증가
//			} // end if
//		}	// end for	
////		System.out.println(wordTMap);	// 확인용
//		
//
//
//		// sort 하기 위해 List로 형변환
//		// List<entry<String, Integer> --> 되도록 형변환 
//		ArrayList<Map.Entry<String, Integer>> wordNumList =
//				new ArrayList<Map.Entry<String,Integer>>(wordTMap.entrySet());
//		// 검색하니 저기에 값을 넣으면 선언하면서 초기화 가능		// addall 기능
//		
//		// 내림차순 정렬
//		Collections.sort(wordNumList,new Comparator<Map.Entry<String, Integer>>() {
//		// 익명클래스 어차피 comparator가 인터페이스이므로 바로 재정의 해주었다.
//			@Override
//			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//				return o2.getValue().compareTo(o1.getValue());
//			}
//		});	// 원래 오름차순으로 정리 되기 때문에 o1,o2 순서만 바꾸면 내림차순
//		
//		
//		// 결과 출력
//		for (int index = 0; index < wordNumList.size(); index++) {
//			System.out.println((index+1) + " " + wordNumList.get(index).getKey() + ":" + wordNumList.get(index).getValue());
//		}	
//		System.out.println(wordNumList);
//		System.out.println("\n프로그램 종료");
//	} // end main()
//	
//} // end class
//
//
//
package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// by 장윤성
public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도 (내림차순) ");
		String[] words = C.ALICE30.trim().toLowerCase().split("\\W+|\\_|\\t|\\n|\\d+|\\s+|\\r");

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		List<word> word = new ArrayList<word>();
		// 발생빈도 작성
		for (int i = 0; i < words.length; i++) {
			Integer v = hmap.get(words[i]); // words[i] 가 key
			if (words[i].length() > 1) {
				// 기존에 해당 key 값이 없었다면 ( 즉 첫 등장이면)
				if (v == null) {
					hmap.put(words[i], 1);
				} else {// 기존 등장횟수에 +1 증가
					hmap.put(words[i], v + 1);
				}

			}
		}
		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			word.add(new word(e.getKey(), e.getValue()));
		}
		Collections.sort(word);
		for (word words1 : word) {
			System.out.println(words1.word + " : " + words1.count + "개" );
		}
			
		
		System.out.println("\n프로그램 종료");


	} // end main()

	 

} // end class

class word implements Comparable<word> {
	String word;
	int count;

	public word() {
		super();
	}

	public word(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	@Override
	public int compareTo(word o) {

		// 점수 내림차순
		if (o.count < this.count)
			return -1; // 내가 더 작으면 음수
		if (this.count < o.count)
			return 1; // 내가 더 크면 양수
		return 0; // 같으면 0

	}

}

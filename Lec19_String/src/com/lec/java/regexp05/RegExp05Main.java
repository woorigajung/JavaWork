//package com.lec.java.regexp05;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///* 대표적인 정규 표현식 
// *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
// *  각 정규표현식들을 작성해보고
// *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
// */
//public class RegExp05Main {
//
//	public static void main(String[] args) {
//		System.out.println("많이 쓰는 정규표현식");
//
//		String regex, intput, title;
//		String [] arrInput;
//		
//		//─────────────────────────────────────────
//		title = "URL";
//		regex =  "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";; 
//			//   [(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)
//
//		arrInput = new String[] {
//			"http://goodidea.tistory.com/86",
//			"http://goodidea.tistory.com/86",
//			"http://goodidea.tistory.com/8",
//			"http://goodidea.tistory.c",
//			"http://goodidea.tist",
//			"http://goodidea.t",
//			"http://g",
//			"http://",// 여기서 부터매칭 X //( ^(https?):\\/\\/([^:\\/\\s]+)
//			"http"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//		//
//
//		
//		//─────────────────────────────────────────
//		title = "email";
//		regex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
//		arrInput = new String[] {
//			"woorigajung@naver.com"
//			,"aeh0609@hanmail.net"
//			,"qjfjwlwndrnr@naver.com"
//			,"dustjd2081!@naver.11@#"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//
//		//─────────────────────────────────────────
//		title = "주민등록번호";
//		regex = "\\d{6}\\-[1-4]\\d{6}"; // TODO
//		arrInput = new String[] {
//				"960811-1234567",
//				"111111-1111111",
//				"1234!!-232131!"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//		
//		//─────────────────────────────────────────
//		title = "날짜 YYYY-MM-DD";
//		regex = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";
//		arrInput = new String[] {
//			// TODO
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//		
//		//─────────────────────────────────────────
//		title = "자연수";
//		regex = "(\\d*)[1-9]$"; 
//		arrInput = new String[] {
//			"1",
//			"123",
//			"0",
//			"123124"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//
//		//─────────────────────────────────────────
//		title = "정수";
//		regex = "^[+-]?[1-9]\\d*$"; // TODO
//		arrInput = new String[] {
//				"123",
//				"0",
//				"-321"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//
//		//─────────────────────────────────────────
//		title = "소수";
//		regex = "^[+-]?\\d*(\\.\\d*)$"; // TODO
//		arrInput = new String[] {
//				"11.1212"
//				,"1232.213144124"
//				,"0.0"
//				,"0.123"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//
//		//─────────────────────────────────────────
//		title = "소숫점 둘째자리까지";
//		regex = "^[+-]?\\d*(\\.(\\d?){2})$"; // TODO
//		arrInput = new String[] {
//				"11.1212"
//				,"1232.21"
//				,"0.0"
//				,"0.12"
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//
//		//─────────────────────────────────────────
//		title = "통화표시 (￦)";
//		regex = "^[$]?\\d+$"; 
//		// 정확히 어떤건지 몰라서 못했습니다
//		arrInput = new String[] {
//
//		
//		};
//		System.out.println(title);
//		regExpTest(regex, arrInput);
//
//		System.out.println("프로그램 종료");
//
//	} // end main()
//
//	// 도우미 함수
//	public static void regExpTest(String regex, String[] arrInput) {
//		for (String input : arrInput)
//			regExpTest(regex, input);
//	}
//
//	public static void regExpTest(String regex, String input) {
//		System.out.println("[정규표현식 매칭 테스트]-----------------");
//		System.out.println("정규표현식: " + regex);
//		System.out.println("입력문자열: " + input);
//
//		if(Pattern.matches(regex, input)) {
//			System.out.println("   ●매칭●");
//		} else {
//			System.out.println("   Ⅹ매칭 없슴Ⅹ");
//		}
//		
//		System.out.println();
//	} // end regExpTest()
//
//} // end class


package com.lec.java.regexp05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^(http|https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";
//		"^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]{2.6}+([a-zA-Z0-9.?#]+)?";
		arrInput = new String[] {
				"http://www.daum.net",
				"https://dextto.tistory.com/151",
				"http://blog.daum.net/dexter",
				"http:web.site",
				"naver.com",
				"www.web.site"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "email";
		regex = "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+";
				//"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"; 
		arrInput = new String[] {
			"adwff_ww@naver.com",
			"29ei38@gmail.com",
			"okjsp@okjsp.pe.kr",
			"hello@kr",
			"@okjsp.pe.kr",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$"; 
		arrInput = new String[] {
			"001225-4321126",
			"980013-1617960",
			"950726-7113243",
			"93829-2244333",
			"011111-1111111"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "^((19|20)\\d\\d)?([- /.])?(0[1-9]|1[012])([- /.])?(0[1-9]|[12][0-9]|3[01])$"; 
		
		arrInput = new String[] {
			"1997-12-23",
			"1982-12-33",
			"1990-33-11",
			"1999"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[0-9]+$";
		arrInput = new String[] {
				"3w",
				"55",
				"v4",
				"1",
				"24356786543",
				"35634mk",
				"23453676"
		
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^[-+]?(0|[1-9][0-9]*)$"; // TODO
		arrInput = new String[] {
			"1",
			"11",
			"-3456654",
			"-2345-",
			"22.44",
			"233-",
			"0",
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "^\\d+(?:[.]\\d+)?$"; 
		arrInput = new String[] {
			"224.3333",
			"0.2222",
			"03.4444",
			"3.4444444",
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^\\d+(?:[.]?[\\d]?[\\d])?$";
		arrInput = new String[] {
			"0.111",
			"22.33",
			"0.44",
			"333.3666"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
	

		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "^[1-9][0-9]{0,2}(,[0-9]{3})*";  
		arrInput = new String[] {
			"1",
			"1,333",
			"11,444",
			"203,333",
			"22,333,465",
			"2352,364,234,345"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		 

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class




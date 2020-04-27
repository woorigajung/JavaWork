package com.lec.java.crawl01;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


// java.lang 또는 같은 패키지 내에 있는 class는 import 할 필요 없다.
/* jre에 BuildPath에 설정이 되어 있었기 때문에 import할 필요가 없었던 것.
 * 
 * 
 * crawl
 * 외부 라이브러리를 사용한 자바 프로젝트
 * 1. 라이브러리 다운로드
 * 2. 프로젝트내 (혹은 특정경로)에 라이브러리 저장
 * 3. 프로젝트의 BuildPath 설정
 */

/*
 * 1. https://jsoup.org/  에서 다운로드
 * 2. 프로젝트에 폴더만들고 (ex: libs) 라이브러리 복사
 * 3. 프로젝트명 우클릭 -> BuildPathe -> Configure BuildPath -> Add Jars(혹은 라이브러리 추가) -> 다운받은 jre선택후 Apply
 * 		jre가 깨졌을 때										   Add Library -> Jre system Library -> finish -> apply
 */


/* 네이버 뉴스 캐스트(상단의 실시간 뉴스)
 * Ctrl + U -> element검색해서 있다는 것만 확인 (ex : 기사내용)
 * f12 (개발자 도구) -> select an Element(Ctrl + Shift + C)
 */
public class Crawl01Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");
		
		String url;	// 크롤링할 주소 url
		Response response;	// response 객체
		Document doc;	// JSOUP의 document object model 객체
		// 엘리먼트 노드를 묶여있는 계층도를 말함 -> 불러왔을 때 doc로 되있어야지 찾아 낼 수가 있다
		Element element;	// HTML의 element 표현 객체 => <> ~ <> : element
		
		url = "http://www.naver.com";
		response = Jsoup.connect(url).execute(); 
		// GET 방식 request 는 다음과 같이 해도된다.
		// Jsoup.connect(url).get();
		// response 객체 return
		// IO 17번 패키지 내용과 같은데 1줄로 표시된다
		// 반복되는 내용을 줄이기 위해 library쓰는 것
		
		System.out.println(response.statusCode());
//		대표 메세지
//		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
		System.out.println(response.statusMessage());

		doc = response.parse(); // response -> document로 변환
		System.out.println(doc.title());	// <title> element의 텍스트
		System.out.println(doc.location());	// 현재 웹문서의 URL
		
		String outerHtml = doc.outerHtml();	// 현재 node 의 outer htm1 텍스트
		System.out.println(outerHtml.substring(0,200) + "...");
		
		// Document 나 Element 객체의
		// select() : 여러개 리턴, selectFirst() : 하나만 리턴
		// 메소드로 특정 element(들)을 추출
		System.out.println("[네이버 뉴스 캐스트]");
		element = doc.selectFirst("#news_cast");	// 검색된 Element 들 중 최초 1개만 Element 로 리턴 	
		// id안에 있으면 id값을 넣어준다
//		System.out.println(element);
		Elements newsElements  = doc.select("#news_cast li.ca_item"); // 검색된 Element 들이 담겨 있는 Elements 리턴
		// 복수개  목록 크롤링 할시, 내가 원하는 개수만큼 크롤링 되었는지 우선 확인해보자.
		System.out.println(newsElements.size() + " 개");
		
		for(Element e : newsElements) {
//			System.out.println(e.outerHtml());
			element = e.selectFirst("a");
			System.out.println(element.text());		// Element 의 text() -> text들을 묶어서 하나로 리턴
			System.out.println(element.attr("href"));// 특정 attribute값 끄집어 내기(주소값)
		}
		
		
		
		System.out.println("\n프로그램 종료");
	}	// end main()

}	// end class 

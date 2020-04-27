package com.lec.java.crawl0;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup");
		
		Element element;
		Elements elements;
		
		File f = new File("data/hello.html");
//		File f = new File("data\\hello.html"); 이게 맞는 문법 인데 자바에서 /가 먹혀서 쓴다
												// 하이튼 둘다 된다는 뜻임
		Document doc = Jsoup.parse(f,"UTF-8");
		// utf-8방식의 f를 뽑아낸다  
		// File-> DOCUMENT 변환(DOM구조 변환)
		// System.out.println(doc.outerHtml());
		element = doc.selectFirst("div");
		// System.out.println(element);
		
		elements = doc.select("div");
		System.out.println(elements.size() + " 개");
		
		// Elements 의 get(n) -> n번 째 Element 리턴
//		element = elements.get(3);
//		System.out.println(element.outerHtml());
		
//		for(int i = 0; i < elements.size(); i++) {
//			element = elements.get(i);
//			System.out.println(element);
//			System.out.println();
//		}
		
//		for(Element e : elements) {
//			System.out.println(e);
//			System.out.println();
//		}

		element = doc.selectFirst("div#addr");
		// System.out.println(element.outerHtml());	// outerHtml() 안써도 나온다
		
		elements = element.select("ul.favorite a");
		System.out.println(elements.size() + " 개");
		
//		for(Element e : elements) {
//			//System.out.println(e.outerHtml());
//			System.out.println(e.text().trim());
//			// 텍스트 꺼내고 나면 좌우 공백
//			System.out.println(e.attr("href").trim());
//			// 특정 attribute값 끄집어 내기(주소값)
//		}
		
		
		// TODO
		System.out.println();
		for(Element img : doc.select("img")) {
			System.out.println(img.attr("src").trim());
		}
		
	} // end main()

} // end class

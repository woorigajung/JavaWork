package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이트 인기 검색어");
		
		String url = "https://www.nate.com";	// MalformedURL : 말도 안되는 URL 형식
		Document doc;
		Response response = Jsoup.connect(url).execute();
		// www.nate.com
		doc = response.parse();
		System.out.println(response.statusCode());
		
		Elements elements = doc.select(".search_keyword dd a");
		System.out.println(doc.select(".search_keyword dd a").size());

		for(Element e : elements) {
			System.out.println(e.text().trim());	// contant 부분
			System.out.println(e.attr("href").trim());
		}
		
		System.out.println("\n프로그램 종료");
	}

}

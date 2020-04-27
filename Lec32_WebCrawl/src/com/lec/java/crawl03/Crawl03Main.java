package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		String url = "http://www.daum.net";
		Response response = Jsoup.connect(url).execute();
		// http://www.daum.net
		// 15개
		Document doc = response.parse();
		System.out.println(response.statusCode());
		Element element;
		Elements elements = doc.select("div.slide_favorsch");
//		System.out.println(elements);
		elements = doc.select("div.slide_favorsch ul.list_favorsch li a");
		System.out.println(elements.size());
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		//		elements = elements.select("ul.list_favorsch");
//		int cnt = 0;
//		for (int i = 0; i < elements.size(); i++) {
//			cnt += elements.get(i).childrenSize();
//		}
//		System.out.println(cnt);
	}

	
}
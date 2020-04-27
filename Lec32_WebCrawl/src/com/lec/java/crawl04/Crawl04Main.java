package com.lec.java.crawl04;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc; 
		Response response;
		Elements elements;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword, "utf-8"); 
		// 네이버 검색페이지는 utf-8로 url encode 함
		
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=" + encoded;
		
		System.out.println(url);
		
		response = Jsoup.connect(url).execute();
		doc = response.parse();
		
		Elements elements2 = doc.select("div#nx_related_keywords .lst_relate ul li");
		System.out.println(doc.select("div#nx_related_keywords .lst_relate ul li").size() + "개");
		// 연관 검색어
		
		for(Element e : elements2) {
			System.out.println(e.selectFirst("a").text());
		}
		
		
		// 
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class














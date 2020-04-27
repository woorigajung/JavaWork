package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl09Main {
	
/* 연습
 * 네이버 '검색어'
 * 블로그
 * 		- post title
 * 		- post url
 * 		- blog title
 * 
 * 페이지 구현
 */
	public static void main(String[] args) throws IOException {

		crawlNaverBlog("자바", 1);
	}
	
	
	public static void crawlNaverBlog(String search, int page) throws IOException {
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d"
							,URLEncoder.encode(search, "utf-8"),page,page);
		// https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%EC%9E%90%EB%B0%94&sm=tab_pge&srchby=all&st=sim&where=post&start=11

		doc = Jsoup.connect(url).execute().parse();
		elements = doc.select("#elThumbnailResultArea > .sh_blog_top");
		//System.out.println(elements.size()); 	// 확인용
		for(Element e : elements) {
			String postTitle = e.selectFirst("dl > dt > a").text().trim();
			String blogTitle = e.selectFirst("dd.txt_block a.txt84").text().trim();
			String postUrl = e.selectFirst("a").attr("href").trim();
			System.out.println(postTitle + " : " + blogTitle + " : " + postUrl);
		}
				
	}
}

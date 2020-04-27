package test;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test{

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 영화 인기 검색어");

		String url;
		Response response;
		Elements elements;
		Document doc; // DOM

		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#assistant > div:nth-child(1) > ul.r_ranking > li > a:first-child");		
		//System.out.println(elements.size());
		
		for(Element e : elements) {
			e.selectFirst("span.blind").remove();
			System.out.println(e.text().trim());
		}
		
		System.out.println("\n프로그램 종료");
		
	}

}









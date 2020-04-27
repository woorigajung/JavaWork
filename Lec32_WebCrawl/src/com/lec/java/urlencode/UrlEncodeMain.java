package com.lec.java.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.activation.URLDataSource;

/*  URLEncoder, URLDecoder
 * 
 * URL 은  한글, 특수기호, 공백등의 문자를 담을수 없다.
 * 따라서 위와 같은 문자를 URL에 담으려면 URL 인코딩 을 하여야 한다.
 *  
 * O : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC
 * X : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=파이썬
 * 
 * 인코딩-디코딩 온라인 테스트 사이트
 * 	http://coderstoolbox.net/string/#!encoding=xml&action=encode&charset=us_ascii
 * 
 */

public class UrlEncodeMain {

	public static void main(String[] args) {
		System.out.println("URLEncoder, URLDecoder");

		String str = "파이썬";
		
		// 한글관련 자주 사용되는 인코딩
		String charset[] = {
			"euc-kr", "ksc5601", "cp949", "ms949", // 한글 표현 -> 2byte 
			"iso-8859-1", "8859_1", "ascii",   // 아스키 인코드(한글 -> 1byte 표현인데 256가지 표현 
											   // 한글이 조합하면 만가지가 넘어가기때문에 못씀 
											   // 한글 불가
			"UTF-8",   // 한글표현 -> 3byte
			"UTF-16"   // 한글표현 -> 2byte  (이상?)
			// euc-kr 이나 UTF-8만 알면된다 
		};
		for (int i = 0; i < charset.length; i++) {
			try {
				// 문자열 -> URL 인코딩
				System.out.printf("%11s -> %s\n", charset[i],
						URLEncoder.encode(str, charset[i])); // str을 인코딩 방법으로 인코딩해준다
				
				
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}	
		}
		
		System.out.println();
		String enc_utf8 = "%ED%8C%8C%EC%9D%B4%EC%8D%AC";
		try {
			System.out.println(URLDecoder.decode(enc_utf8, "UTF-8"));
			System.out.println(URLDecoder.decode(enc_utf8, "euc-kr"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}

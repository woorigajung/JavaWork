package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1. URL : 웹 상의 주소, 
 * 	2. HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 * 
 * 컴퓨터등등	request(URL)		  서버
 * client	----------->	server
 * 			<-----------	(HTML)
 * 			response
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url = "https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0";
		
		StringBuffer sb = readFromUrl(url);
		System.out.println(sb);
		//System.out.println(sb.toString().substring(0, 200));

		System.out.println("\n프로그램 종료");
	} // end main()

	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로 부터 받은 텍스트데이터(HTML) 리턴
	 */

	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buff = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초이내에 '연결' 이 수립안되면
				// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET"); // GET 방식 request
				// url에 ? 같이 요청하는 방법일경우 Get 방식이다.
				// post 방식 : 
				// "GET", "POST" ....
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함
				// 사용했던것을 기억안한다는 뜻
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을 때 까지 delay
				System.out.println("response 완료");

				// response 받은 후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);

				if (responseCode == HttpURLConnection.HTTP_OK) { // https://developer.mozilla.org/ko/docs/Web/HTTP/Status
									// 상수값으로 정의가 되있다.   	// 200만 성공, 위에 주소에 코드값 정보가 있음
					in = conn.getInputStream(); // InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); //BufferedReader <- InputStreamReader
					
					int cnt;	// 읽은 글자 개수
					while((cnt = br.read(buff))!= -1) {
						sb.append(buff, 0, cnt);	// response 받은 텍스트를 StringBuffer에 추가
					}
					
				} else {
					System.out.println("respose 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) { // 형식에 맞지 않는 Url 정규표현식
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect();		// 작업 끝나고 Connection 해졔
			
		}

		return sb;
	}
	//</html>로 끝나면 재대로 동작된 것
} // end class

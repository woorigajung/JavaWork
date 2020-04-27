package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* XML, JSON 파싱 연습
■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울
 */
public class Crawl11Main {

	public static final String REQ_SERVICE = "stationList"; // TODO
	public static final String API_KEY = "4d46796d7366726f3833774a774955"; // 너의 key 값은?

	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사(station) 정보");

		int startIndex;
		int endIndex;
		String date;

		String url_address = "";
		StringBuffer sb; // response 받은 텍스트

		startIndex = 0; // : API url 에 필요한 parameter 들
		endIndex = 5;
		date = "서울";

		System.out.println("--- XML 파싱 ---");
		// http://swopenAPI.seoul.go.kr/api/subway/(인증키)/xml/stationInfo/0/5/서울
		url_address = buildUrlAddress("xml", startIndex, endIndex, date);
		// System.out.println(url_address); //확인용
		sb = readFromUrl(url_address);
		parseXML(sb.toString());

		System.out.println("--- JSON 파싱 ---");
		url_address = buildUrlAddress("json", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		
		parseJSON(sb.toString());
		
		System.out.println("\n프로그램 종료");
	} // end main()

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) throws IOException {

		String url_address = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s",
				API_KEY, reqType, startIndex, endIndex, URLEncoder.encode(date, "utf-8"));

		return url_address;
	}

	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체

		URL url = null; // java.net.URL 인터넷에서, 어느 사이트에 접속하기 위해서 입력해야 하는, 주소를 포함한 일련의 문자.
		HttpURLConnection conn = null; // java.net.HttpURLConnection
		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초이내에 '연결' 이 수립안되면
												// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET", "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함

				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");

				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) {

					in = conn.getInputStream(); // InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader

					int cnt; // 읽은 글자 개수
					while ((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer 에 추가
					}

				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect(); // 작업 끝나고 Connection 해제
		}

		return sb;
	}
	/*
	 * # DOM(표준) 엘리먼트 노드로 구성됨 계층구조 Document head Attribute body title href ----- a
	 * hi My title 부속부품 text text
	 * 
	 * node 
	 * 이걸 쓸 때 공백 엔터 다 있는데 
	 * Text노드로 숨겨져 있다  따라서 각 element마다 child 새끼는 Text노드가 들어가는데
	 * 이걸 뺴주는 메소드가 .normalize() 이며 꼭 해줘야한다
	 * 
	 * 	type
	 * 		Element( <dd> ... </dd>로 끝나는 것) ->의 이름 태그 안에 값 (dd) -> value
	 * 			Attribute 얘는 childe말고 부속으로 생각
	 * 			Text 노드 안에  value 가 들어있음
	 * 	
	 * 	name : <안에 있는 값>
	 * 
	 * 	value : element노드 -> Text노드 -> value
	 * 
	 */

	public static void parseXML(String xmlText) {
		// XML 파싱
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;

		try {
			// DOM parser 객체 생성
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();

			// String -> InputStream 변환
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));

			// InputStream -> DOM 객체 생성
			Document dom = dBuilder.parse(in);

			// DOM 최상위 document element 추출
			Element docElement = dom.getDocumentElement(); // DOM의 최상위 element
			// DOM 뽑아내야 select 해서 elements들을 찾아 낼 수 있다

			// 파싱하기전 normalize()
			docElement.normalize(); // 흩어진 text node 들을 정렬하는 등의 절차,
									// XML 파싱하기 전에 꼭 normalize() 부터 해주자
			// 개발자 도구로 보면 text들이 난잡하게 떨어진걸 정리하는 내부적 동작
			
			// DOM 내의 데이터 파싱
			NodeList nList = docElement.getElementsByTagName("row");
			System.out.println("<row> 개수 " + nList.getLength());

			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				
				if(node.getNodeType() != node.ELEMENT_NODE)continue;
				
				Element rowElement = (Element)node;
				
				String statnNm = rowElement
						.getElementsByTagName("statnNm")
						.item(0).getChildNodes()
						.item(0).getNodeValue().trim();

				String subwayId = rowElement
						.getElementsByTagName("subwayId")
						.item(0).getChildNodes()
						.item(0).getNodeValue().trim();
				
				String subwayNm = rowElement
						.getElementsByTagName("subwayNm")
						.item(0).getChildNodes()
						.item(0).getNodeValue().trim();
				
				System.out.printf("%d : %2s역 %s %s\n"
						, i + 1, statnNm, subwayId, subwayNm);
				
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // end parseXML()

	public static void parseJSON(String jsonText) {
		
		JSONObject jObj = new JSONObject(jsonText);
		JSONArray row = jObj.getJSONArray("stationList");
//.getJSONArray("row");		
//		System.out.println("row의 개수 : " + row.length());	// 확인용

		for (int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i);	//Object -> Object : element명 
			String statnNm = station.getString("statnNm");
			String subwayId = station.getString("subwayId");
			String subwayNm = station.getString("subwayNm");
		
		System.out.printf("%d : %2s역 %s %s\n"
				, i + 1, statnNm, subwayId, subwayNm);
		}
	} // end parseJSON()

} // end class

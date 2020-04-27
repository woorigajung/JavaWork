package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl15Main {
	// Ctrl + U 후 검색해서 없으면 크롤링 못하는 것
	// 동적 + 추가적인 request는 자바 스크립트가 해준다
	// chrome extention -> web Developer
	// 자바 스크립트 비활성화 해서 안뜨는 것이 json 크롤링 못하는 것 ?이면 json 데이터 타입이다
	
	/*PostMan을 깐 뒤에  값을 입력 해주면 된다.
	x-apikey
	x-apisecret 
	*/
	
	/* XML, JSON 파싱 연습
	■서울시 지하철 역사 정보
	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

	샘플url

	XML 버젼
	http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

	JSON 버젼
	http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울
	*/
	public static final String API_KEY = "4d46796d7366726f3833774a774955"; // 너의 key 값은?
	public static void main(String[] args) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String url1 = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s",API_KEY,"json",1,5,URLEncoder.encode("서울"));
		URL url2 = new URL(url1);
		
		Station station = mapper.readValue(url2, Station.class);
		System.out.println(station.getStationList());
		
//		for (int i = 0; i < station.getStationList().size(); i++) {
//			System.out.printf("%d : %s  %s  %s",
//					i + 1,
//					station.getStationList().get(i).getStatnNm(),
//					station.getStationList().get(i).getSubwayId(),
//					station.getStationList().get(i).getSubwayNm());
//			System.out.println();
//		}
		int i = 0;
		for(StationList e : station.getStationList()) {
			System.out.printf("%d : %s  %s  %s",
					i += 1,
					e.getStatnNm(),
					e.getSubwayId(),
					e.getSubwayNm()); 
			System.out.println();
//			System.out.print(e.getStatnNm());
//			System.out.print(e.getSubwayId());
//			System.out.print(e.getSubwayNm());
//			System.out.println();
		}
		
		System.out.println("\n 프로그램 종료");
	}	// end main()
}	// end class()

@JsonIgnoreProperties(ignoreUnknown = true)
class Station{
	// stationList
	private ArrayList<StationList> stationList;

	public ArrayList<StationList> getStationList() {
		return stationList;
	}

	public void setStationList(ArrayList<StationList> stationList) {
		this.stationList = stationList;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StationList{
//	statnId: "1065006501",
//	statnNm: "서울",
//	subwayId: "1065",
//	subwayNm: "공항철도",
	
	private String statnNm;
	private String subwayId;
	private String subwayNm;
	
	public String getStatnNm() {return statnNm;}
	public void setStatnNm(String statnNm) {this.statnNm = statnNm;}
	public String getSubwayId() {return subwayId;}
	public void setSubwayId(String subwayId) {this.subwayId = subwayId;}
	public String getSubwayNm() {return subwayNm;}
	public void setSubwayNm(String subwayNm) {this.subwayNm = subwayNm;}
	
}	// end stationList















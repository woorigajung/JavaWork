package com.lec.java.crawl14;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 XML, Json 파싱1
 
 ■서울시 지하철호선별 역별 승하차 인원 정보 
 http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 
 샘플url
 XML 버젼
 http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/CardSubwayStatsNew/1/5/20181001
   
 JSON 버젼
 http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001 

JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
*/
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습 : URL -> json -> Java");

		ObjectMapper mapper = new ObjectMapper();

		URL url = new URL("http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001");
				

		Subway subway = mapper.readValue(url, Subway.class);

		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());

		for(SubRow e : subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n"
					, e.getLineNUM()
					, e.getStationName()
					, e.getRidePassenger()
					, e.getAlightPassenger());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {
	// CardSubwayStatsNew
	public Stats CardSubwayStatsNew;

	public Stats getCardSubwayStatsNew() {return CardSubwayStatsNew;}
	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {CardSubwayStatsNew = cardSubwayStatsNew;}
}

@JsonIgnoreProperties(ignoreUnknown = true) // 원래 포함하는 모든 Elements들로 구성해야되는데
// 이와같이 하면 원하는 것만 뽑고 생략할 수 있다
class Stats {
	int list_total_count;
	private ArrayList<SubRow> row;

	public int getList_total_count() {return list_total_count;}
	public void setList_total_count(int list_total_count) {	this.list_total_count = list_total_count;}

	public ArrayList<SubRow> getRow() {return row;}
	public void setRow(ArrayList<SubRow> row) {this.row = row;}
	
}	// end Stats

// JSON 필드명과 매핑되는 Java 객체의 변수명을 달리 하고 싶다면
// @JsonProperty("기본 멤버변수 값") 사용
@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow {
	
	@JsonProperty("LINE_NUM")	
	private String lineNUM;
	
	@JsonProperty("SUB_STA_NM")	
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")	
	private int ridePassenger;

	@JsonProperty("ALIGHT_PASGR_NUM")	
	private int alightPassenger;

	public String getLineNUM() {
		return lineNUM;
	}

	public void setLineNUM(String lineNUM) {this.lineNUM = lineNUM;}

	public String getStationName() {return stationName;}
	
	public void setStationName(String stationName) {this.stationName = stationName;}

	public int getRidePassenger() {return ridePassenger;}

	public void setRidePassenger(int ridePassenger) {this.ridePassenger = ridePassenger;}

	public int getAlightPassenger() {return alightPassenger;}

	public void setAlightPassenger(int alightPassenger) {this.alightPassenger = alightPassenger;}
	
}	// end SubRow

// Retrofit
// volley










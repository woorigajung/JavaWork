package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요  // 12번 class
// JSON 은  jackson 을 활용하여 파싱하세요 // 14번 class

public class DailySumMain {
	
	public static final String API_KEY = "4d46796d7366726f3833774a774955";
	public static final String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("날짜입력 : ");
		int date = sc.nextInt();

		System.out.println("인덱스 값은 0~1000까지 입력해 주세요");
		System.out.print("시작Index : ");
		int startIdx = sc.nextInt();

		System.out.print("끌Index : ");
		int endIdx = sc.nextInt();
		System.out.println();
		
		
		// XML -> Jsoup	
		String url = initXML(date, startIdx, endIdx);	// url
		xmlParsing(url);
		
		// JSON -> Jackson
		url = initJSON(date, startIdx, endIdx);
		
		URL url2 = new URL(url);
		
		jsonParsing(url2);
		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main
	
	static public String initXML(int date, int startIdx, int endIdx) {
		String url = String.format("http://openapi.seoul.go.kr:8088/%s/%s/%s/%d/%d/%d",
				API_KEY,
				"xml",
				REQ_SERVICE,
				startIdx,
				endIdx,
				date);
		return url;
	}
	
	static public void xmlParsing(String url) throws IOException{
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
		
		System.out.println("[XML]");
		System.out.println("날짜                  구ID       총생활인구수                       일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		for(Element e : elements) {
			String STDR_DE_ID =
					e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE =
					e.select("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO =
					e.select("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_LVPOP_CO =
					e.select("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			
			System.out.printf("%-8s     %-8s   %-16s     %-16s \n",
					STDR_DE_ID,
					SIGNGU_CODE_SE,
					TOT_LVPOP_CO,
					DAIL_MXMM_LVPOP_CO);
		}
	}

	static public String initJSON(int date, int startIdx, int endIdx) {
		//http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
		String url = String.format("http://openapi.seoul.go.kr:8088/%s/%s/%s/%d/%d/%d",
				API_KEY,
				"json",
				REQ_SERVICE,
				startIdx,
				endIdx,
				date);
		return url;
	}
	
	static public void jsonParsing(URL url2) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		CurentPop crtPop = mapper.readValue(url2, CurentPop.class);
		
		// System.out.println(crtPop.getSPOP_DAILYSUM_JACHI().getRow());
		
		System.out.println("[JSON]");
		System.out.println("날짜                  구ID       총생활인구수                       일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		for(rowInfo e : crtPop.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.printf("%-8s     %-8s   %-16s     %-16s \n",
					e.getBaseDate(),
					e.getSignguCode(),
					e.getTotalPop(),
					e.getDailyMaxPopMove());
		}
	}
	
} // end class
	@JsonIgnoreProperties(ignoreUnknown = true)
	class CurentPop {
		public Pop SPOP_DAILYSUM_JACHI;

		public Pop getSPOP_DAILYSUM_JACHI() {
			return SPOP_DAILYSUM_JACHI;
		}
		public void setSPOP_DAILYSUM_JACHI(Pop sPOP_DAILYSUM_JACHI) {
			SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	class Pop{
		private ArrayList<rowInfo> row;

		public ArrayList<rowInfo> getRow() {return row;}
		public void setRow(ArrayList<rowInfo> row) {this.row = row;}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	class rowInfo{
		
		@JsonProperty("STDR_DE_ID")
		private String baseDate;
		@JsonProperty("SIGNGU_CODE_SE")
		private String signguCode;
		@JsonProperty("TOT_LVPOP_CO")
		private String totalPop;
		@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
		private String dailyMaxPopMove;
		
		public String getBaseDate() {return baseDate;}
		public void setBaseDate(String baseDate) {this.baseDate = baseDate;}
		
		public String getSignguCode() {	return signguCode;}
		public void setSignguCode(String signguCode) {this.signguCode = signguCode;}
		
		public String getTotalPop() {return totalPop;}
		public void setTotalPop(String totalPop) {this.totalPop = totalPop;}
		
		public String getDailyMaxPopMove() {return dailyMaxPopMove;}
		public void setDailyMaxPopMove(String dailyMaxPopMove) {this.dailyMaxPopMove = dailyMaxPopMove;}
		
		
	}
	


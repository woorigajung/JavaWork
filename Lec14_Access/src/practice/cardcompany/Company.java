package practice.cardcompany;

public class Company {
	// 필요한 변수, 메소드, 생성자 정의하기
	static int num = 10000;				// 초기값 10000 카드 만들어질 때 ++ 
	// 필요한 변수
	// 회사
	private static Company instance = null;	// 싱글톤 패턴을 위한 변수

	// 생성자 정의하기
	// 싱글톤 패턴 인스턴스 생성
	static Company getInstance() {		
		if(instance == null) {	// (회사 클래스) 싱글톤 패턴을 위한 조건 
			instance = new Company();
		}
		return instance;
	}
	
	// 메서드
	// 카드만들기
	public Card createCard() {
		num++;
		return new Card(num);	// 추상적인 카드 -> 인스턴스(객체화) 
	}

} // end class

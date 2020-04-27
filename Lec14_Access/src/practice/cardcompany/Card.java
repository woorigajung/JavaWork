package practice.cardcompany;

public class Card {
	
	// 필요한 변수, 메소드, 생성자 정의하기

	// 필요한 변수
	// 카드번호
	
	private int cardNumber;					// 카드번호는 num에서 차례대로 받는다.
	 									// 굳이 초기화할 필요 x
	 
	// 메서드	getter(), setter();
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int num) {
		this.cardNumber = num;			// 카드가 만들어질 때마다 번호가 1증가
										// Company 클래스
										// creatCard에 호출
	}
	
	// 생성자 정의하기
	public Card(int num) {				
								// 카드발급 받을 때 카드 번호도 같이 받아야 한다.
		this.setCardNumber(num);		// default 생성자
	}	

} // end class

// 카드 번호를 굳이 2가지로 나누어 옮겨준 이유
/*
   int cardNum은 Heap 메모리 안에 생기는 primitve 타입 변수로서
   인스턴스 안에서 아무리 건드려도 생성된 그 인스턴스에서만 값이 변경된다.
   
   static num 변수는 Stack 메모리 영역에 저장 모든 인스턴스와 연결 되어 있다.
   main이 끝날 때까지 지워지지 않고 변경 된 값이 유지된다.
   따라서 인스턴스를 생성했을 때 num 값을 증가 시키고 그값은 setter()로 cardNumber에 입력하면
  인스턴스가 생성 될 때마다 번호가 1증가한 카드를 만들 수 있다.
  
  
  쉽게 말하면 카드 고유번호는 만들 때마다 증가해야 되고
  그 번호는 카드를 만들 때마다 각각 부여 된다 생각하면된다.
 
 */

package com.lec.java.file08;

import java.io.Serializable;

public class Member implements Serializable {
							// Serializable(직렬화) 하는 이유는 어디서부터 출력하고 어디서 부터 받을 것인지 정하기 위해
							// 순서를 알아야 내보내고 받을 수 있기 때문이다
							// 모든 컬렉션 타입은  Serializable 되어 있다.
/**	
 * 
 */
	private static final long serialVersionUID = -4564811082080172359L;
// Add generated serial version ID 을 꼭 해주어야 한다
	private String id;
	private String pw;
	transient private int num;		// 0
	transient private boolean isExist;	// false
	
	// transient로 선언된 변수는 serialization(직렬화) 대상에서 제외됨.
	// (파일에 write되지 않는다)
	// de-serializtion(역직렬화, 파일에서 읽기)를 할 때는 
	// 해당 타입의 기본값(0, false, null)으로 초기화됨
	
	public Member() {}
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.num = 123;
		this.isExist = true;
	}
	
	public void displayInfo() {
		System.out.println("--- 회원 정보 ---");
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		System.out.println("번호: " + num);
		System.out.println("Exist? " + isExist);
	}
	
} // end class Member 







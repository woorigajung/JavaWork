package com.lec.java.static03;

public class Test {
	private int num;
	
	static int count = 0;
	
	// singleton 패턴
	// 기본생성자
	private Test() {
		count++;
		System.out.println(count + "번째 인스턴스 생성");
	}
	
	private static Test instance = null;
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test();  // 인스턴스 생성!
		}
		return instance;
		// 한번 생성됬으면 null이 아니고 주소값이 존재하기 때문에 instance를 그대로 return
		// 따라서 인스턴스는 총1개이다.
		
	}
	
	
	// getter & setter
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
}

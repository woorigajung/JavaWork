package com.lec.java.inherit07;

public class BusinessPerson extends Person {

	private String company;

	// getter & setter
	public String getComapny() {
		return company;
	}

	public void setComapny(String company) {
		this.company = company;
	}
	
	// 메소드 재정의( Overriding)
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사 : " + company);
		
	}
	
	// 메소드 오버로딩 (OverLoading
	public void showInfo(int id) {
		System.out.println("id: " + id);
		showInfo();
	}
	
	// 이클립스 단축키
	// Alt + Shift + S, V
	
	
	// final 메서드 오버라이딩 불가
//	@Override
//	public void whoAreYou() {
//		super.whoAreYou();
//		System.out.println("회사");
//	
//	}
	
	@Override
	public String toString() {
		return "BisomessPerson:" + getName() + " " + company;
	}
	
}

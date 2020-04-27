package com.lec.java.inherit02;

// BasicTV
//   ㄴ smartTV
public class SmartTV extends BasicTV {
	String ip;
	
	public void displayInfo() {
		super.displayInfo();
		System.out.println("IP 주소 : " + ip);
	}
}

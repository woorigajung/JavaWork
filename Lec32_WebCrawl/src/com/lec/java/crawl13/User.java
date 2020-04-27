package com.lec.java.crawl13;

import java.util.List;

public class User {
	private String name;
	private int age;
	private List<String> messages;
	private Score score1;
	
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) { this.age = age;}
    public List<String> getMessages() {return messages;}
    public void setMessages(List<String> messages) {        this.messages = messages;}	
    
    public Score getScore1() {
		return score1;
	}
	public void setScore1(Score score1) {
		this.score1 = score1;
	}
	@Override
    public String toString() {
    	return "[name:" + name + ",age:" + age + ",messages:" + messages +"]";
    }
}

class Score {
	private int kor;
	private int eng;
	private int math;
	
	public Score() {}	
	public Score(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getKor() {return kor;}
	public void setKor(int kor) {this.kor = kor;}
	public int getEng() {return eng;}
	public void setEng(int eng) {this.eng = eng;}
	public int getMath() {return math;}
	public void setMath(int math) {this.math = math;}
	
	
	
	
	
	
}






























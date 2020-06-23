package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteListJson {
	int count;  // 데이터 개수
	String status;  // 처리 결과
	
//	@JsonIgnore
	String message;   // response 에서 제외할 필드
	
	@JsonProperty("data")  // Json property 이름과 Java 필드명이 다른 경우
	List<CategoryDTO> list;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CategoryDTO> getList() {
		return list;
	}

	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}
	
	
}

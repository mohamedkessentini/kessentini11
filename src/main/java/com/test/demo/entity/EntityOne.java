package com.test.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EntityOne {
	
	String aidprt;
	String allprt;
	public String getAidprt() {
		return aidprt;
	}
	public void setAidprt(String aidprt) {
		this.aidprt = aidprt;
	}
	public String getAllprt() {
		return allprt;
	}
	public void setAllprt(String allprt) {
		this.allprt = allprt;
	}
	
}

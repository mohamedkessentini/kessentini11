package com.test.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EntityTwo {
	String aidgrp;
	String acdprt;
	String acealia;
	String adtaprt;
	public String getAidgrp() {
		return aidgrp;
	}
	public void setAidgrp(String aidgrp) {
		this.aidgrp = aidgrp;
	}
	public String getAcdprt() {
		return acdprt;
	}
	public void setAcdprt(String acdprt) {
		this.acdprt = acdprt;
	}
	public String getAcealia() {
		return acealia;
	}
	public void setAcealia(String acealia) {
		this.acealia = acealia;
	}
	public String getAdtaprt() {
		return adtaprt;
	}
	public void setAdtaprt(String adtaprt) {
		this.adtaprt = adtaprt;
	}

}

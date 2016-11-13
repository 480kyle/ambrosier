package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class AromalistInfoVo {
	private int a_code, a_wcode, a_tcode;
	private String a_memail, a_aroma;
	
	public int getA_code() {
		return a_code;
	}
	public void setA_code(int a_code) {
		this.a_code = a_code;
	}
	public int getA_wcode() {
		return a_wcode;
	}
	public void setA_wcode(int a_wcode) {
		this.a_wcode = a_wcode;
	}
	public int getA_tcode() {
		return a_tcode;
	}
	public void setA_tcode(int a_tcode) {
		this.a_tcode = a_tcode;
	}
	public String getA_memail() {
		return a_memail;
	}
	public void setA_memail(String a_memail) {
		this.a_memail = a_memail;
	}
	public String getA_aroma() {
		return a_aroma;
	}
	public void setA_aroma(String a_aroma) {
		this.a_aroma = a_aroma;
	}
}

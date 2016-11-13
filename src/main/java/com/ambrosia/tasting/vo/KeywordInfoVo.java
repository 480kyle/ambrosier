package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class KeywordInfoVo {
	int k_code, k_mcode;
	String k_keyword, k_category, k_dateandtime;
	
	public int getK_code() {
		return k_code;
	}
	public void setK_code(int k_code) {
		this.k_code = k_code;
	}
	public int getK_mcode() {
		return k_mcode;
	}
	public void setK_mcode(int k_mcode) {
		this.k_mcode = k_mcode;
	}
	public String getK_keyword() {
		return k_keyword;
	}
	public void setK_keyword(String k_keyword) {
		this.k_keyword = k_keyword;
	}
	public String getK_category() {
		return k_category;
	}
	public void setK_category(String k_category) {
		this.k_category = k_category;
	}
	public String getK_dateandtime() {
		return k_dateandtime;
	}
	public void setK_dateandtime(String k_dateandtime) {
		this.k_dateandtime = k_dateandtime;
	}
}

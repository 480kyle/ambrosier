package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class LikeInfoVo {
	private int l_code, l_tcode, l_mcode;
	private String l_dateandtime, al_from_mnick;
	
	public int getL_code() {
		return l_code;
	}
	public void setL_code(int l_code) {
		this.l_code = l_code;
	}
	public int getL_tcode() {
		return l_tcode;
	}
	public void setL_tcode(int l_tcode) {
		this.l_tcode = l_tcode;
	}
	public int getL_mcode() {
		return l_mcode;
	}
	public void setL_mcode(int l_mcode) {
		this.l_mcode = l_mcode;
	}
	public String getL_dateandtime() {
		return l_dateandtime;
	}
	public void setL_dateandtime(String l_dateandtime) {
		this.l_dateandtime = l_dateandtime;
	}
	public String getAl_from_mnick() {
		return al_from_mnick;
	}
	public void setAl_from_mnick(String al_from_mnick) {
		this.al_from_mnick = al_from_mnick;
	}
}

package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class ReplyVo {
	int r_code, r_tcode;
	String r_mnick, r_comment, r_dateandtime, m_profile;
	
	public int getR_code() {
		return r_code;
	}
	public void setR_code(int r_code) {
		this.r_code = r_code;
	}
	public int getR_tcode() {
		return r_tcode;
	}
	public void setR_tcode(int r_tcode) {
		this.r_tcode = r_tcode;
	}
	public String getR_mnick() {
		return r_mnick;
	}
	public void setR_mnick(String r_mnick) {
		this.r_mnick = r_mnick;
	}
	public String getR_comment() {
		return r_comment;
	}
	public void setR_comment(String r_comment) {
		this.r_comment = r_comment;
	}
	public String getR_dateandtime() {
		return r_dateandtime;
	}
	public void setR_dateandtime(String r_dateandtime) {
		this.r_dateandtime = r_dateandtime;
	}
	public String getM_profile() {
		return m_profile;
	}
	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}
}

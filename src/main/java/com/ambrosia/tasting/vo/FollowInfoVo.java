package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class FollowInfoVo {
	private int f_code, f_followingcode, f_followedbycode;
	private String f_dateandtime;
	
	public int getF_code() {
		return f_code;
	}
	public void setF_code(int f_code) {
		this.f_code = f_code;
	}
	public int getF_followingcode() {
		return f_followingcode;
	}
	public void setF_followingcode(int f_followingcode) {
		this.f_followingcode = f_followingcode;
	}
	public int getF_followedbycode() {
		return f_followedbycode;
	}
	public void setF_followedbycode(int f_followedbycode) {
		this.f_followedbycode = f_followedbycode;
	}
	public String getF_dateandtime() {
		return f_dateandtime;
	}
	public void setF_dateandtime(String f_dateandtime) {
		this.f_dateandtime = f_dateandtime;
	}
}

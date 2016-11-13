package com.ambrosia.tasting.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AlarmInfoVo {
	private int al_code, al_tcode;
	private String al_to_mnick, al_from_mnick, al_event, al_read, al_timeAgo;
	private Date al_dateandtime;
	private String m_profile;
	
	public int getAl_code() {
		return al_code;
	}
	public void setAl_code(int al_code) {
		this.al_code = al_code;
	}
	public int getAl_tcode() {
		return al_tcode;
	}
	public void setAl_tcode(int al_tcode) {
		this.al_tcode = al_tcode;
	}
	public String getAl_to_mnick() {
		return al_to_mnick;
	}
	public void setAl_to_mnick(String al_to_mnick) {
		this.al_to_mnick = al_to_mnick;
	}
	public String getAl_from_mnick() {
		return al_from_mnick;
	}
	public void setAl_from_mnick(String al_from_mnick) {
		this.al_from_mnick = al_from_mnick;
	}
	public String getAl_event() {
		return al_event;
	}
	public void setAl_event(String al_event) {
		this.al_event = al_event;
	}
	public String getAl_read() {
		return al_read;
	}
	public void setAl_read(String al_read) {
		this.al_read = al_read;
	}
	public String getAl_timeAgo() {
		return al_timeAgo;
	}
	public void setAl_timeAgo(String al_timeAgo) {
		this.al_timeAgo = al_timeAgo;
	}
	public Date getAl_dateandtime() {
		return al_dateandtime;
	}
	public void setAl_dateandtime(Date al_dateandtime) {
		this.al_dateandtime = al_dateandtime;
	}
	public String getM_profile() {
		return m_profile;
	}
	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}
}

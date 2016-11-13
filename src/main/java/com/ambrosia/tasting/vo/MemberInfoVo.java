package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MemberInfoVo {
	private String m_email, m_password, m_nick, m_major, m_preference, m_activity, m_stdId, m_year, m_month, m_date,
			m_phone, m_profile, m_auth, m_regdateandtime, m_userwants;
	private int m_code, m_gender;
	private MultipartFile m_picture;

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getM_major() {
		return m_major;
	}

	public void setM_major(String m_major) {
		this.m_major = m_major;
	}

	public String getM_preference() {
		return m_preference;
	}

	public void setM_preference(String m_preference) {
		this.m_preference = m_preference;
	}

	public String getM_activity() {
		return m_activity;
	}

	public void setM_activity(String m_activity) {
		this.m_activity = m_activity;
	}

	public String getM_stdId() {
		return m_stdId;
	}

	public void setM_stdId(String m_stdId) {
		this.m_stdId = m_stdId;
	}

	public String getM_year() {
		return m_year;
	}

	public void setM_year(String m_year) {
		this.m_year = m_year;
	}

	public String getM_month() {
		return m_month;
	}

	public void setM_month(String m_month) {
		this.m_month = m_month;
	}

	public String getM_date() {
		return m_date;
	}

	public void setM_date(String m_date) {
		this.m_date = m_date;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_profile() {
		return m_profile;
	}

	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}

	public String getM_auth() {
		return m_auth;
	}

	public void setM_auth(String m_auth) {
		this.m_auth = m_auth;
	}

	public String getM_regdateandtime() {
		return m_regdateandtime;
	}

	public void setM_regdateandtime(String m_regdateandtime) {
		this.m_regdateandtime = m_regdateandtime;
	}
	
	public String getM_userwants() {
		return m_userwants;
	}
	
	public void setM_userwants(String m_userwants) {
		this.m_userwants = m_userwants;
	}

	public int getM_code() {
		return m_code;
	}

	public void setM_code(int m_code) {
		this.m_code = m_code;
	}

	public int getM_gender() {
		return m_gender;
	}

	public void setM_gender(int m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_birthday() {
		return m_year + "-" + m_month + "-" + m_date;
	}
	public MultipartFile getM_picture() {
		return m_picture;
	}
	public void setM_picture(MultipartFile m_picture) {
		this.m_picture = m_picture;
	}
}

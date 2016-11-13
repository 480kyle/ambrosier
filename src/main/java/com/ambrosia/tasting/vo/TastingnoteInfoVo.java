package com.ambrosia.tasting.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class TastingnoteInfoVo {
	private int t_code, t_wcode, t_body, t_acidity, t_sweetness, t_preference, t_like, t_price, m_code;
	private String t_memail, t_vintage, t_category, t_comment, t_aromas, t_pname, t_wname, w_name;
	private String t_dateandtime;
	private String m_nick, m_profile;
	private ArrayList<ReplyVo> reply;
	private MultipartFile t_picture;
	
	public int getT_code() {
		return t_code;
	}
	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
	public int getT_wcode() {
		return t_wcode;
	}
	public void setT_wcode(int t_wcode) {
		this.t_wcode = t_wcode;
	}
	public int getT_body() {
		return t_body;
	}
	public void setT_body(int t_body) {
		this.t_body = t_body;
	}
	public int getT_acidity() {
		return t_acidity;
	}
	public void setT_acidity(int t_acidity) {
		this.t_acidity = t_acidity;
	}
	public int getT_sweetness() {
		return t_sweetness;
	}
	public void setT_sweetness(int t_sweetness) {
		this.t_sweetness = t_sweetness;
	}
	public int getT_preference() {
		return t_preference;
	}
	public void setT_preference(int t_preference) {
		this.t_preference = t_preference;
	}
	public int getT_like() {
		return t_like;
	}
	public void setT_like(int t_like) {
		this.t_like = t_like;
	}
	public int getT_price() {
		return t_price;
	}
	public void setT_price(int t_price) {
		this.t_price = t_price;
	}
	public int getM_code() {
		return m_code;
	}
	public void setM_code(int m_code) {
		this.m_code = m_code;
	}
	public String getT_memail() {
		return t_memail;
	}
	public void setT_memail(String t_memail) {
		this.t_memail = t_memail;
	}
	public String getT_category() {
		return t_category;
	}
	public void setT_category(String t_category) {
		this.t_category = t_category;
	}
	public String getT_comment() {
		return t_comment;
	}
	public void setT_comment(String t_comment) {
		this.t_comment = t_comment;
	}
	public String getT_vintage() {
		return t_vintage;
	}
	public void setT_vintage(String t_vintage) {
		this.t_vintage = t_vintage;
	}
	public String getT_aromas() {
		return t_aromas;
	}
	public void setT_aromas(String t_aromas) {
		this.t_aromas = t_aromas;
	}
	public String getT_pname() {
		return t_pname;
	}
	public void setT_pname(String t_pname) {
		this.t_pname = t_pname;
	}
	public String getT_wname() {
		return t_wname;
	}
	public void setT_wname(String t_wname) {
		this.t_wname = t_wname;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getT_dateandtime() {
		return t_dateandtime;
	}
	public void setT_dateandtime(Date t_dateandtime) {
		DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.t_dateandtime = dateForm.format(t_dateandtime);
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getM_profile() {
		return m_profile;
	}
	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}
	public ArrayList<ReplyVo> getReply() {
		return reply;
	}
	public void setReply(ArrayList<ReplyVo> reply) {
		this.reply = reply;
	}
	public MultipartFile getT_picture() {
		return t_picture;
	}
	public void setT_picture(MultipartFile t_picture) {
		this.t_picture = t_picture;
	}
}

package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class WineInfoVo {
	int w_code;
	String w_name,w_vintage, w_region, w_maker, w_importer, w_price, w_varieties, w_dateandtime;
	
	public int getW_code() {
		return w_code;
	}
	public void setW_code(int w_code) {
		this.w_code = w_code;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_vintage() {
		return w_vintage;
	}
	public void setW_vintage(String w_vintage) {
		this.w_vintage = w_vintage;
	}
	public String getW_region() {
		return w_region;
	}
	public void setW_region(String w_region) {
		this.w_region = w_region;
	}
	public String getW_maker() {
		return w_maker;
	}
	public void setW_maker(String w_maker) {
		this.w_maker = w_maker;
	}
	public String getW_importer() {
		return w_importer;
	}
	public void setW_importer(String w_importer) {
		this.w_importer = w_importer;
	}
	public String getW_price() {
		return w_price;
	}
	public void setW_price(String w_price) {
		this.w_price = w_price;
	}
	public String getW_varieties() {
		return w_varieties;
	}
	public void setW_varieties(String w_varieties) {
		this.w_varieties = w_varieties;
	}
	public String getW_dateandtime() {
		return w_dateandtime;
	}
	public void setW_dateandtime(String w_dateandtime) {
		this.w_dateandtime = w_dateandtime;
	}
}

package com.ambrosia.tasting.vo;

import org.springframework.stereotype.Component;

@Component
public class FollowLoadMoreVo {
	int m_code, t_code;

	public int getM_code() {
		return m_code;
	}

	public void setM_code(int m_code) {
		this.m_code = m_code;
	}

	public int getT_code() {
		return t_code;
	}

	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
}

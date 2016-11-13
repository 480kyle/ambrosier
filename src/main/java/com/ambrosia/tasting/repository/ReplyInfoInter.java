package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import com.ambrosia.tasting.vo.ReplyVo;

public interface ReplyInfoInter {
	public boolean replyInfoIns(ReplyVo reply);
	public ArrayList<ReplyVo> selectRepliesByPost(int t_code);
	public ArrayList<ReplyVo> selectMoreRepliesByPost(int t_code);
}

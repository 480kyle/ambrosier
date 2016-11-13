package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.ReplyVo;

@Repository
public class ReplyInfoImpl implements ReplyInfoInter {
	
	@Autowired
	private ReplyInfoDao replyDao;
	
	@Override
	public boolean replyInfoIns(ReplyVo reply) {
		return replyDao.replyInfoIns(reply);
	}
	
	@Override
	public ArrayList<ReplyVo> selectRepliesByPost(int t_code) {
		return replyDao.selectRepliesByPost(t_code);
	}
	
	@Override
	public ArrayList<ReplyVo> selectMoreRepliesByPost(int t_code) {
		return replyDao.selectMoreRepliesByPost(t_code);
	}
}

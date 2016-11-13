package com.ambrosia.tasting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.LikeInfoVo;

@Repository
public class LikeInfoImpl implements LikeInfoInter {
	
	@Autowired
	private LikeInfoDao likeDao;
	
	@Override
	public boolean likeInfoIns(LikeInfoVo like) {
		return likeDao.likeInfoIns(like);
	}
	
	@Override
	public int countLikesByTcode(int code) {
		return likeDao.countLikesByTcode(code);
	}
	
	@Override
	public boolean likeInfoDel(LikeInfoVo like) {
		return likeDao.likeInfoDel(like);
	}
}

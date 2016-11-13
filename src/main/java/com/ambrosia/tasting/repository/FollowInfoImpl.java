package com.ambrosia.tasting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.FollowInfoVo;

@Repository
public class FollowInfoImpl implements FollowInfoInter {
	
	@Autowired
	private FollowInfoDao followDao;
	
	@Override
	public boolean followInfoIns(FollowInfoVo follow) {
		return followDao.followInfoIns(follow);
	}
	
	@Override
	public boolean followInfoDel(FollowInfoVo follow) {
		return followDao.followInfoDel(follow);
	}
	
	@Override
	public int selectFollowByUserCode(FollowInfoVo follow) {
		return followDao.selectFollowByUserCode(follow);
	}
	
	@Override
	public String followerCountByUserCode(int code) {
		return followDao.followerCountByUserCode(code);
	}
	
	@Override
	public String followingCountByUserCode(int code) {
		return followDao.followingCountByUserCode(code);
	}
}

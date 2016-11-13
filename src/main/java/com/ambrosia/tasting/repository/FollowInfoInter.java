package com.ambrosia.tasting.repository;

import com.ambrosia.tasting.vo.FollowInfoVo;

public interface FollowInfoInter {
	public boolean followInfoIns(FollowInfoVo follow);
	public boolean followInfoDel(FollowInfoVo follow);
	public int selectFollowByUserCode(FollowInfoVo follow);
	public String followerCountByUserCode(int code);
	public String followingCountByUserCode(int code);
}

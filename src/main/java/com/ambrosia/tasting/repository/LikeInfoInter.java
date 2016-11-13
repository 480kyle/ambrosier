package com.ambrosia.tasting.repository;

import com.ambrosia.tasting.vo.LikeInfoVo;

public interface LikeInfoInter {
	public boolean likeInfoIns(LikeInfoVo like);
	public int countLikesByTcode(int code);
	public boolean likeInfoDel(LikeInfoVo like);
}

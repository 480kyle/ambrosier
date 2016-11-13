package com.ambrosia.tasting.repository;

import com.ambrosia.tasting.vo.MemberInfoVo;

public interface MemberInfoInter {
	boolean insertMemInfo(MemberInfoVo member);
	public MemberInfoVo memberSignin(MemberInfoVo member);
	public String memberEmailCheck(String userId);
	public String memberNickCheck(String userNick);
	public MemberInfoVo memberProfile(String userId);
	public MemberInfoVo memberProfileByCode(int code);
	public boolean memberInfoUpdate(MemberInfoVo member);
	public boolean memberPictureUpdate(MemberInfoVo member);
}

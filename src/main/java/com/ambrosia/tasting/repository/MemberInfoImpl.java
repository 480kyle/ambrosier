package com.ambrosia.tasting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.MemberInfoVo;

@Repository
public class MemberInfoImpl implements MemberInfoInter {

	@Autowired
	private MemberInfoDao memberDao;
	
	@Override
	public boolean insertMemInfo(MemberInfoVo member) {
		return memberDao.memberInfoIns(member);
	}
	
	@Override
	public MemberInfoVo memberSignin(MemberInfoVo member) {
		return memberDao.memberSignin(member);
	}
	
	@Override
	public String memberEmailCheck(String userId) {
		return memberDao.memberEmailCheck(userId);
	}
	
	@Override
	public String memberNickCheck(String userNick) {
		return memberDao.memberNickCheck(userNick);
	}
	
	@Override
	public MemberInfoVo memberProfile(String userId) {
		return memberDao.memberProfile(userId);
	}
	
	@Override
	public MemberInfoVo memberProfileByCode(int code) {
		return memberDao.memberProfileByCode(code);
	}
	
	@Override
	public boolean memberInfoUpdate(MemberInfoVo member) {
		return memberDao.memberInfoUpdate(member);
	}
	
	@Override
	public boolean memberPictureUpdate(MemberInfoVo member) {
		return memberDao.memberPictureUpdate(member);
	}
}

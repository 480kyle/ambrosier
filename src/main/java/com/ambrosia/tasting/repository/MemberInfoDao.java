package com.ambrosia.tasting.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ambrosia.tasting.vo.MemberInfoVo;

public interface MemberInfoDao {
	
	@Insert("insert into amb_member(m_code, m_email, m_password, m_nick, m_gender, m_birth, m_profile, m_phone, m_preference, m_userwants, m_auth, m_regdateandtime) values(#{m_code}, #{m_email}, #{m_password}, #{m_nick}, #{m_gender}, #{m_birthday}, #{m_profile}, #{m_phone}, #{m_preference}, #{m_userwants}, #{m_auth}, now())")
	public boolean memberInfoIns(MemberInfoVo member);
	
	@Select("select max(m_code) as maxcode from amb_member")
	public int selectMaxCode();
	
	@Select("select * from amb_member where m_email=#{m_email} and m_password=#{m_password}")
	public MemberInfoVo memberSignin(MemberInfoVo member);
	
	@Select("select m_email from amb_member where m_email=#{userId}")
	public String memberEmailCheck(String userId);
	
	@Select("select m_nick from amb_member where m_nick=#{userNick}")
	public String memberNickCheck(String userNick);
	
	@Select("select m_code, m_email, m_nick, m_profile from amb_member where m_email=#{userId}")
	public MemberInfoVo memberProfile(String userId);
	
	@Select("select m_code, m_email, m_nick, m_profile from amb_member where m_code=#{code}")
	public MemberInfoVo memberProfileByCode(int code);
	
	@Update("update amb_member set m_phone=#{m_phone}, m_userwants=#{m_userwants} where m_email=#{m_email}")
	public boolean memberInfoUpdate(MemberInfoVo member);
	
	@Update("update amb_member set m_profile=#{m_profile} where m_email=#{m_email}")
	public boolean memberPictureUpdate(MemberInfoVo member);
}

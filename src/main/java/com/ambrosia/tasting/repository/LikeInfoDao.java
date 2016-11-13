package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ambrosia.tasting.vo.LikeInfoVo;

public interface LikeInfoDao {
	
	@Insert("insert into amb_likes(l_code, l_tcode, l_mcode, l_dateandtime) values(#{l_code}, #{l_tcode}, #{l_mcode}, now())")
	public boolean likeInfoIns(LikeInfoVo like);
	
	@Select("select max(l_code) as maxcode from amb_likes")
	public int selectMaxCode();
	
	@Select("select count(l_code) as count from amb_likes where l_tcode=#{code}")
	public int countLikesByTcode(int code);
	
	@Select("select * from amb_likes where l_mcode=#{m_code}")
	public ArrayList<LikeInfoVo> selectLikeByMemberCode(int m_code);
	
	@Delete("delete amb_alarm, amb_likes from amb_alarm inner join amb_likes on amb_alarm.al_tcode = amb_likes.l_tcode where al_from_mnick=#{al_from_mnick} and l_code=#{l_code} and al_event='like';")
	public boolean likeInfoDel(LikeInfoVo like);
}

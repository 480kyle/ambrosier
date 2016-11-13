package com.ambrosia.tasting.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ambrosia.tasting.vo.FollowInfoVo;

public interface FollowInfoDao {
	
	@Insert("insert into amb_follow(f_code, f_followingcode, f_followedbycode, f_dateandtime) values(#{f_code}, #{f_followingcode}, #{f_followedbycode}, now())")
	public boolean followInfoIns(FollowInfoVo follow);
	
	@Select("select max(f_code) from amb_follow")
	public int maxCodeFollow();
	
	@Select("select count(f_code) from amb_follow where f_followingcode=#{f_followingcode} and f_followedbycode=#{f_followedbycode}")
	public int selectFollowByUserCode(FollowInfoVo follow);
	
	@Select("select count(f_code) from amb_follow where f_followingcode=#{code}")
	public String followerCountByUserCode(int code);
	
	@Select("select count(f_code) from amb_follow where f_followedbycode=#{code}")
	public String followingCountByUserCode(int code);
	
	@Delete("delete amb_follow, amb_alarm from amb_alarm inner join amb_follow on amb_alarm.al_tcode = amb_follow.f_followingcode where f_followingcode=#{f_followingcode} and f_followedbycode=#{f_followedbycode}")
	public boolean followInfoDel(FollowInfoVo follow);
}

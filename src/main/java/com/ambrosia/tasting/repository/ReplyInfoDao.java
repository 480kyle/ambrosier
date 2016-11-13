package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ambrosia.tasting.vo.ReplyVo;

public interface ReplyInfoDao {
	@Insert("insert into amb_reply(r_code, r_tcode, r_mnick, r_comment, r_dateandtime) values(#{r_code}, #{r_tcode}, #{r_mnick}, #{r_comment}, now())")
	public boolean replyInfoIns(ReplyVo reply);

	@Select("select * from amb_reply where r_tcode=#{t_code}")
	public ArrayList<ReplyVo> selectRepliesByPost(int t_code);
	
	@Select("select r_code, r_mnick, r_comment, r_dateandtime, m_profile from amb_reply inner join amb_member on amb_reply.r_mnick=amb_member.m_nick where r_tcode=#{t_code}")
	public ArrayList<ReplyVo> selectMoreRepliesByPost(int t_code);
	
	@Select("select max(r_code) as maxcode from amb_reply")
	public int selectMaxReplyCode();
}

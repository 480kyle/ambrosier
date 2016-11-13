package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ambrosia.tasting.vo.AromalistInfoVo;
import com.ambrosia.tasting.vo.FollowLoadMoreVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

public interface TastingnoteInfoDao {
	
	@Insert("insert into amb_tastingnote(t_code, t_pname, t_wcode, t_memail, t_category, t_body, t_acidity, t_sweetness, t_aromas, t_price, t_preference, t_dateandtime) values(#{t_code}, #{t_pname}, #{t_wcode}, #{t_memail}, #{t_category}, #{t_body}, #{t_acidity}, #{t_sweetness}, #{t_aromas}, #{t_price}, #{t_preference}, now())")
	public boolean tastingnoteInfoIns(TastingnoteInfoVo tasting);
	
	@Insert("insert into amb_aromalist(a_code, a_wcode, a_tcode, a_memail, a_aroma) values(#{a_code}, #{a_wcode}, #{a_tcode}, #{a_memail}, #{a_aroma})")
	public boolean aromaInfoIns(AromalistInfoVo aroma);
	
	@Select("select max(t_code) as maxcode from amb_tastingnote")
	public int selectMaxTastingnoteCode();
	
	@Select("select max(a_code) as maxcode from amb_aromalist")
	public int selectMaxAromaCode();
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_memail=#{m_email} order by t_dateandtime desc")
	public ArrayList<TastingnoteInfoVo> searchTastingnoteById(MemberInfoVo member);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email order by t_dateandtime desc limit 0, 7")
	public ArrayList<TastingnoteInfoVo> searchTastingnoteAll();
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email order by t_dateandtime desc limit 0, 18")
	public ArrayList<TastingnoteInfoVo> searchTastingImgAll();
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_aromas like #{keyword} order by t_dateandtime desc limit 0, 18")
	public ArrayList<TastingnoteInfoVo> searchTastingImgByAroma(String keyword);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_code < #{code} order by t_dateandtime desc limit 0, 7")
	public ArrayList<TastingnoteInfoVo> searchTastingnoteAllLoadMore(int code);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_memail in (select m_email from amb_follow inner join amb_member on amb_follow.f_followingcode=amb_member.m_code where f_followedbycode=#{code}) order by t_dateandtime desc limit 0, 7")
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByFollow(int code);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_memail in (select m_email from amb_follow inner join amb_member on amb_follow.f_followingcode=amb_member.m_code where f_followedbycode=#{code}) order by t_dateandtime desc limit 0, 18")
	public ArrayList<TastingnoteInfoVo> searchTastingImgByFollow(int code);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_code < #{code} order by t_dateandtime desc limit 0, 18")
	public ArrayList<TastingnoteInfoVo> searchTastingImgAllLoadMore(int code);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_memail in (select m_email from amb_follow inner join amb_member on amb_follow.f_followingcode=amb_member.m_code where f_followedbycode=#{m_code}) and t_code < #{t_code} order by t_dateandtime desc limit 0, 18")
	public ArrayList<TastingnoteInfoVo> searchTastingImgByFollowLoadMore(FollowLoadMoreVo follow);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_memail in (select m_email from amb_follow inner join amb_member on amb_follow.f_followingcode=amb_member.m_code where f_followedbycode=#{m_code}) and t_code < #{t_code} order by t_dateandtime desc limit 0, 7")
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByFollowLoadMore(FollowLoadMoreVo follow);
	
	@Select("select t_code, t_wcode, t_pname, t_preference, t_aromas, t_price, t_dateandtime, m_code, m_nick, m_profile from amb_tastingnote inner join amb_member on amb_tastingnote.t_memail=amb_member.m_email where t_code=#{code}")
	public TastingnoteInfoVo selectTastingnoteByCode(int code);
}

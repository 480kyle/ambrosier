package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ambrosia.tasting.vo.KeywordInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;
import com.ambrosia.tasting.vo.WineInfoVo;

public interface SearchInfoDao {
	
	@Insert("insert into amb_keyword(k_code, k_keyword, k_category, k_mcode, k_dateandtime) values(#{k_code}, #{k_keyword}, #{k_category}, #{k_mcode}, now())")
	public boolean searchInfoIns(KeywordInfoVo keyword);
	
	@Select("select max(k_code) as maxcode from amb_keyword")
	public int maxCodeSearch();
	
	@Select("select t_code, t_pname, t_category, t_aromas, t_preference, w_name, w_region, w_vintage from amb_winelist inner join amb_tastingnote on amb_winelist.w_code=amb_tastingnote.t_wcode where w_name like #{keyword} or w_region like #{keyword} or w_vintage like #{keyword}")
	public ArrayList<WineInfoVo> searchWineByKeyword(String keyword);
	
	@Select("select m_code, m_profile, m_email, m_nick, m_userwants from amb_member where m_email like #{keyword} or m_nick like #{keyword} or m_userwants like #{keyword}")
	public ArrayList<MemberInfoVo> searchMemberByKeyword(String keyword);
	
	@Select("select * from amb_keyword where k_mcode=#{mcode}")
	public ArrayList<KeywordInfoVo> recentKeywordByMember(int mcode);
	
	@Select("select t_code, t_pname, t_category, t_aromas, t_preference, w_name from amb_tastingnote inner join amb_winelist on amb_tastingnote.t_wcode=amb_winelist.w_code where t_aromas like #{keyword}")
	public ArrayList<TastingnoteInfoVo> searchAromaByKeyword(String keyword);
	
	@Select("select * from amb_winelist where w_name like #{keyword}")
	public ArrayList<WineInfoVo> searchWineNameWhenTastingnoteIns(String keyword);
}

package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import com.ambrosia.tasting.vo.KeywordInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;
import com.ambrosia.tasting.vo.WineInfoVo;

public interface SearchInfoInter {
	public boolean searchInfoIns(KeywordInfoVo keyword);
	public ArrayList<WineInfoVo> searchWineByWineName(String keyword);
	public ArrayList<KeywordInfoVo> recentKeywordByMember(int mcode);
	public ArrayList<MemberInfoVo> searchMemberByKeyword(String keyword);
	public ArrayList<TastingnoteInfoVo> searchAromaByKeyword(String keyword);
}

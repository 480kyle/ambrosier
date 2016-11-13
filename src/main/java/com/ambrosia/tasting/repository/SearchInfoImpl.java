package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.KeywordInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;
import com.ambrosia.tasting.vo.WineInfoVo;

@Repository
public class SearchInfoImpl implements SearchInfoInter {
	
	@Autowired
	private SearchInfoDao searchDao;
	
	@Override
	public boolean searchInfoIns(KeywordInfoVo keyword) {
		return searchDao.searchInfoIns(keyword);
	}
	
	@Override
	public ArrayList<WineInfoVo> searchWineByWineName(String keyword) {
		return searchDao.searchWineByKeyword(keyword);
	}
	
	@Override
	public ArrayList<KeywordInfoVo> recentKeywordByMember(int mcode) {
		return searchDao.recentKeywordByMember(mcode);
	}
	
	@Override
	public ArrayList<MemberInfoVo> searchMemberByKeyword(String keyword) {
		return searchDao.searchMemberByKeyword(keyword);
	}
	
	@Override
	public ArrayList<TastingnoteInfoVo> searchAromaByKeyword(String keyword) {
		return searchDao.searchAromaByKeyword(keyword);
	}
}

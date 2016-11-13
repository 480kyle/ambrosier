package com.ambrosia.tasting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.SearchInfoDao;
import com.ambrosia.tasting.vo.KeywordInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;
import com.ambrosia.tasting.vo.WineInfoVo;

@Service
public class SearchInfoService {

	@Autowired
	private SearchInfoDao searchDao;
	
	public boolean searchInfoIns(KeywordInfoVo keyword){
		boolean b = false;
		
		keyword.setK_code(searchDao.maxCodeSearch() + 1);
		
		b = searchDao.searchInfoIns(keyword);
		
		return b;
	}
	
	public ArrayList<WineInfoVo> searchWineByKeyword(String keyword){
		ArrayList<WineInfoVo> list = new ArrayList<WineInfoVo>();
		
		keyword = "%" + keyword + "%";
		
		list = searchDao.searchWineByKeyword(keyword);
		
		return list;
	}
	
	public ArrayList<KeywordInfoVo> recentKeywordByMember(int mcode){
		ArrayList<KeywordInfoVo> keyword = new ArrayList<KeywordInfoVo>();
		
		keyword = searchDao.recentKeywordByMember(mcode);
		
		return keyword;
	}
	
	public ArrayList<MemberInfoVo> searchMemberByKeyword(String keyword){
		ArrayList<MemberInfoVo> memberList = new ArrayList<MemberInfoVo>();
		
		keyword = "%" + keyword + "%";
		
		memberList = searchDao.searchMemberByKeyword(keyword);
		
		return memberList;
	}
	
	public ArrayList<TastingnoteInfoVo> searchAromaByKeyword(String keyword){
		ArrayList<TastingnoteInfoVo> aromaList = new ArrayList<TastingnoteInfoVo>();
		
		keyword = "%" + keyword + "%";
		
		aromaList = searchDao.searchAromaByKeyword(keyword);
		
		return aromaList;
	}
	
	public ArrayList<WineInfoVo> searchWineNameWhenTastingnoteIns(String keyword){
		ArrayList<WineInfoVo> wineList = new ArrayList<WineInfoVo>();
		
		keyword = "%" + keyword + "%";
		
		wineList = searchDao.searchWineNameWhenTastingnoteIns(keyword);
		
		return wineList;
	}
}

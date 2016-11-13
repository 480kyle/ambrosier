package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.AromalistInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

@Repository
public class TastingnoteInfoImpl implements TastingnoteInfoInter {
	
	@Autowired
	private TastingnoteInfoDao tastingDao;
	
	@Override
	public boolean tastingnoteInfoIns(TastingnoteInfoVo tasting) {
		return tastingDao.tastingnoteInfoIns(tasting);
	}
	
	@Override
	public boolean aromaInfoIns(AromalistInfoVo aroma) {
		return tastingDao.aromaInfoIns(aroma);
	}
	
	@Override
	public ArrayList<TastingnoteInfoVo> searchTastingnoteById(MemberInfoVo member) {
		return tastingDao.searchTastingnoteById(member);
	}
	
	@Override
	public TastingnoteInfoVo selectTastingnoteByCode(int code) {
		return tastingDao.selectTastingnoteByCode(code);
	}
	
	@Override
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByFollow(int code) {
		return tastingDao.searchTastingnoteByFollow(code);
	}
}

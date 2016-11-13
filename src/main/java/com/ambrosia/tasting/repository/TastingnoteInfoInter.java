package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import com.ambrosia.tasting.vo.AromalistInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

public interface TastingnoteInfoInter {
	public boolean tastingnoteInfoIns(TastingnoteInfoVo tasting);
	public boolean aromaInfoIns(AromalistInfoVo aroma);
	public ArrayList<TastingnoteInfoVo> searchTastingnoteById(MemberInfoVo member);
	public TastingnoteInfoVo selectTastingnoteByCode(int code);
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByFollow(int code);
}

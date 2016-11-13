package com.ambrosia.tasting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.AlarmDao;
import com.ambrosia.tasting.repository.LikeInfoDao;
import com.ambrosia.tasting.repository.MemberInfoDao;
import com.ambrosia.tasting.repository.TastingnoteInfoDao;
import com.ambrosia.tasting.vo.AlarmInfoVo;
import com.ambrosia.tasting.vo.LikeInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

@Service
public class LikeInfoService {

	@Autowired
	private LikeInfoDao likeDao;
	
	@Autowired
	private AlarmDao alarmDao;
	
	@Autowired
	private MemberInfoDao memberDao;
	
	@Autowired
	private TastingnoteInfoDao tastingDao;
	
	public int likeInfoIns(LikeInfoVo like){
		int l_code = 0;
		boolean b = false;
		AlarmInfoVo alarm = new AlarmInfoVo();
		MemberInfoVo member = memberDao.memberProfileByCode(like.getL_mcode());
		TastingnoteInfoVo tasting = tastingDao.selectTastingnoteByCode(like.getL_tcode());
		
		l_code=likeDao.selectMaxCode() + 1;
		like.setL_code(l_code);
		alarm.setAl_code(alarmDao.alarmMaxCode() + 1);
		alarm.setAl_from_mnick(member.getM_nick());
		alarm.setAl_tcode(like.getL_tcode());
		alarm.setAl_to_mnick(tasting.getM_nick());
		alarm.setAl_event("like");
		
		b = likeDao.likeInfoIns(like);
		b = alarmDao.alarmInfoIns(alarm);
		
		if(b){
			return l_code;
		}
		
		return 0;
	}
	
	public boolean likeInfoDel(int l_code, String al_from_mnick){
		boolean b = false;
		LikeInfoVo like = new LikeInfoVo();
		
		like.setL_code(l_code);
		like.setAl_from_mnick(al_from_mnick);
		
		b = likeDao.likeInfoDel(like);
		
		return b;
	}
	
	public ArrayList<LikeInfoVo> selectLikeByMemberCode(String m_code){
		ArrayList<LikeInfoVo> like = new ArrayList<LikeInfoVo>();
		
		like = likeDao.selectLikeByMemberCode(Integer.parseInt(m_code));
		
		return like;
	}
	
	public int likeCountByPost(int code){
		int count = 0;
		
		count = likeDao.countLikesByTcode(code);
		
		return count;
	}
}

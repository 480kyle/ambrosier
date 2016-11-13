package com.ambrosia.tasting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.AlarmDao;
import com.ambrosia.tasting.repository.ReplyInfoDao;
import com.ambrosia.tasting.repository.TastingnoteInfoDao;
import com.ambrosia.tasting.vo.AlarmInfoVo;
import com.ambrosia.tasting.vo.ReplyVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

@Service
public class ReplyInfoService {

	@Autowired
	private ReplyInfoDao replyDao;
	
	@Autowired
	private AlarmDao alarmDao;
	
	@Autowired
	private TastingnoteInfoDao tastingDao;
	
	public ArrayList<ReplyVo> selectRepliesByPost(int t_code){
		ArrayList<ReplyVo> replyDatas = new ArrayList<ReplyVo>();
		
		replyDatas = replyDao.selectRepliesByPost(t_code);
		
		return replyDatas;
	}
	
	public ArrayList<ReplyVo> selectMoreRepliesByPost(int t_code){
		ArrayList<ReplyVo> replyDatas = new ArrayList<ReplyVo>();
		
		replyDatas = replyDao.selectMoreRepliesByPost(t_code);
		
		return replyDatas;
	}
	

	public boolean replyInfoIns(ReplyVo reply){
		boolean isInserted = false;
		AlarmInfoVo alarm = new AlarmInfoVo();
		TastingnoteInfoVo tasting = tastingDao.selectTastingnoteByCode(reply.getR_tcode());
		
		isInserted = replyDao.replyInfoIns(reply);
		
		alarm.setAl_code(alarmDao.alarmMaxCode() + 1);
		alarm.setAl_tcode(tasting.getT_code());
		alarm.setAl_to_mnick(tasting.getM_nick());
		alarm.setAl_from_mnick(reply.getR_mnick());
		alarm.setAl_event("commented");
		isInserted = alarmDao.alarmInfoIns(alarm);
		
		return isInserted;
	}
	
	public int selectMaxCode(){
		int maxCode;
		
		maxCode = replyDao.selectMaxReplyCode();
		
		return maxCode;
	}
}

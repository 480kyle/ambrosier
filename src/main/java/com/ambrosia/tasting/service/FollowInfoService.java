package com.ambrosia.tasting.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.AlarmDao;
import com.ambrosia.tasting.repository.FollowInfoDao;
import com.ambrosia.tasting.repository.MemberInfoDao;
import com.ambrosia.tasting.vo.AlarmInfoVo;
import com.ambrosia.tasting.vo.FollowInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;

@Service
public class FollowInfoService {
	
	@Autowired
	private FollowInfoDao followDao;
	
	@Autowired
	private AlarmDao alarmDao;
	
	@Autowired
	private MemberInfoDao memberDao;
	
	public boolean followInfoIns(FollowInfoVo follow, String nick){
		boolean b = false;
		AlarmInfoVo alarm = new AlarmInfoVo();
		MemberInfoVo member = memberDao.memberProfileByCode(follow.getF_followingcode());
		
		follow.setF_code(followDao.maxCodeFollow() + 1);
		
		alarm.setAl_code(alarmDao.alarmMaxCode() + 1);
		alarm.setAl_tcode(follow.getF_followingcode());
		alarm.setAl_to_mnick(member.getM_nick());
		alarm.setAl_from_mnick(nick);
		alarm.setAl_event("follow");
		
		b = followDao.followInfoIns(follow);
		b = alarmDao.alarmInfoIns(alarm);
		
		return b;
	}
	
	public boolean followInfoDel(FollowInfoVo follow){
		boolean b = false;
		
		b = followDao.followInfoDel(follow);
		
		return b;
	}
	
	public boolean selectFollowByUserCode(FollowInfoVo follow){
		boolean b = false;
		int f_code = 0;
		
		f_code = followDao.selectFollowByUserCode(follow);
		
		if(f_code > 0){
			b = true;
		}
		
		return b;
	}
	
	public HashMap<String, String> followersCount(int code){
		HashMap<String, String> counts = new HashMap<String, String>();
		
		counts.put("followers", followDao.followerCountByUserCode(code));
		counts.put("followings", followDao.followingCountByUserCode(code));
		
		return counts;
	}
}

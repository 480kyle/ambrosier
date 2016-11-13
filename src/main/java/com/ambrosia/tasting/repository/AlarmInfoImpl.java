package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.AlarmInfoVo;

@Repository
public class AlarmInfoImpl implements AlarmInfoInter {

	@Autowired
	private AlarmDao alarmDao;
	
	@Override
	public boolean alarmInfoIns(AlarmInfoVo alarm) {
		return alarmDao.alarmInfoIns(alarm);
	}
	
	@Override
	public ArrayList<AlarmInfoVo> alarmInfoByNick(String nick) {
		return alarmDao.alarmInfoByNick(nick);
	}
	
	@Override
	public int alarmCountByUserNick(String nick) {
		return alarmDao.alarmCountByUserNick(nick);
	}
	
	@Override
	public boolean alarmUpdateToRead(String nick) {
		return alarmDao.alarmUpdateToRead(nick);
	}
}

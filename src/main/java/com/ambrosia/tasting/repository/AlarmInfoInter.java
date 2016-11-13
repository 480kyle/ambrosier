package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import com.ambrosia.tasting.vo.AlarmInfoVo;

public interface AlarmInfoInter {
	public boolean alarmInfoIns(AlarmInfoVo alarm);
	public ArrayList<AlarmInfoVo> alarmInfoByNick(String nick);
	public int alarmCountByUserNick(String nick);
	public boolean alarmUpdateToRead(String nick);
}

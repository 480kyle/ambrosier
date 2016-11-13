package com.ambrosia.tasting.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ambrosia.tasting.vo.AlarmInfoVo;

public interface AlarmDao {

	@Insert("insert into amb_alarm(al_code, al_tcode, al_to_mnick, al_from_mnick, al_event, al_read, al_dateandtime) values(#{al_code}, #{al_tcode}, #{al_to_mnick}, #{al_from_mnick}, #{al_event}, 'n', now())")
	public boolean alarmInfoIns(AlarmInfoVo alarm);
	
	@Select("select max(al_code) as maxcode from amb_alarm")
	public int alarmMaxCode();
	
	@Select("select al_code, al_to_mnick, al_from_mnick, al_event, al_read, al_dateandtime, al_tcode, m_profile from amb_alarm left join amb_member on amb_alarm.al_from_mnick=amb_member.m_nick where al_to_mnick=#{nick} order by al_dateandtime desc")
	public ArrayList<AlarmInfoVo> alarmInfoByNick(String nick);
	
	@Select("select count(al_code) from amb_alarm where al_to_mnick=#{nick} and al_read='n'")
	public int alarmCountByUserNick(String nick);
	
	@Update("update amb_alarm set al_read='y' where al_to_mnick=#{nick}")
	public boolean alarmUpdateToRead(String nick);
}

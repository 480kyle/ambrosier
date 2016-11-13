package com.ambrosia.tasting.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.AlarmDao;
import com.ambrosia.tasting.vo.AlarmInfoVo;

@Service
public class AlarmInfoService {

	@Autowired
	private AlarmDao alarmDao;
	
	public ArrayList<AlarmInfoVo> alarmInfoByNick(String userNick){
		ArrayList<AlarmInfoVo> alarm = alarmDao.alarmInfoByNick(userNick);
		
		alarmDao.alarmUpdateToRead(userNick);
		
		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
//		String formattedDate = format.format(date);
		
		for(AlarmInfoVo a: alarm){
			long diff = date.getTime() - a.getAl_dateandtime().getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
//			System.out.println(diff);
//			System.out.print(diffDays + " days, ");
//			System.out.print(diffHours + " hours, ");
//			System.out.print(diffMinutes + " minutes, ");
//			System.out.print(diffSeconds + " seconds.");
			if(diffDays > 0){
				a.setAl_timeAgo(diffDays + "일전");
			}else if(diffHours > 0){
				a.setAl_timeAgo(diffHours + "시간전");
			}else if(diffMinutes > 0){
				a.setAl_timeAgo(diffMinutes + "분전");
			}else if(diffSeconds > 0){
				a.setAl_timeAgo(diffSeconds + "초전");
			}
			System.out.println(a.getAl_timeAgo());
		}
		
		return alarm;
	}
	
	public int alarmCountByUserCode(String nick){
		int count = 0;

		count = alarmDao.alarmCountByUserNick(nick);
		
		return count;
	}
	
	public boolean alarmUpdateToRead(String nick){
		boolean b = false;
		
		b = alarmDao.alarmUpdateToRead(nick);
		
		return b;
	}
}

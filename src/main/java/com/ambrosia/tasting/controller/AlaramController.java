package com.ambrosia.tasting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ambrosia.tasting.repository.AlarmDao;
import com.ambrosia.tasting.service.AlarmInfoService;
import com.ambrosia.tasting.vo.AlarmInfoVo;

@Controller
public class AlaramController {
	
	@Autowired
	private AlarmInfoService alarmService;
	
	@RequestMapping("alarmLoad")
	public ModelAndView alarmLoad(HttpSession session){
		ModelAndView model = new ModelAndView();
		
		if(session.getAttribute("userSigninNick") == null){
			model.setViewName("home");
			return model;
		}
		
		String userNick = session.getAttribute("userSigninNick").toString(); 
		
		ArrayList<AlarmInfoVo> alarm = alarmService.alarmInfoByNick(userNick);
		
		model.addObject("alarm", alarm);
		model.setViewName("signedinAlarm");
		
		return model;
	}
	
	@RequestMapping("alarmCount")
	@ResponseBody
	public int alarmCountByUserCode(HttpSession session){
		int count = 0;
		String userNick = session.getAttribute("userSigninNick").toString();
		
		count = alarmService.alarmCountByUserCode(userNick);
		
		return count;
	}
}

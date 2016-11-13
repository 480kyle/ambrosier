package com.ambrosia.tasting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ambrosia.tasting.service.WineInfoService;
import com.ambrosia.tasting.vo.WineInfoVo;

@Controller
public class WineController {
	
	@Autowired
	private WineInfoService wineService;
	
	@RequestMapping("w_update")
	public String wineInfoUpdate(WineInfoVo wine){
		String direction = "";
		boolean b = false;
		
		b = wineService.wineInfoUpdate(wine);
		
		if(b){
			direction = "redirect:target?go=home";
		}
		
		return direction;
	}
	
}

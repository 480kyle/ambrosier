package com.ambrosia.tasting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.WineInfoDao;
import com.ambrosia.tasting.vo.WineInfoVo;

@Service
public class WineInfoService {
	
	@Autowired
	private WineInfoDao wineDao;
	
	public int selectMaxWineCode(String wineName){
		//와인 정보가 들어갈 공간을 만듦
		int wineCode = 0;
		WineInfoVo wine = new WineInfoVo();
		
		wineCode = wineDao.selectMaxWineCode() + 1;
		
		wine.setW_code(wineCode);
		wine.setW_name(wineName);
		
		wineDao.getPlaceForNewWine(wine);
		
		return wineCode;
	}
	
	public boolean wineInfoUpdate(WineInfoVo wine){
		boolean b = false;
		
		b = wineDao.wineInfoUpdate(wine);
		
		return b;
	}
}

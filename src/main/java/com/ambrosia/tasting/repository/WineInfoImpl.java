package com.ambrosia.tasting.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ambrosia.tasting.vo.WineInfoVo;

@Repository
public class WineInfoImpl implements WineInfoInter{

	@Autowired
	private WineInfoDao wineDao;
	
	@Override
	public int selectMaxWineCode() {
		return wineDao.selectMaxWineCode();
	}
	
	@Override
	public boolean getPlaceForNewWine(WineInfoVo wine) {
		return wineDao.getPlaceForNewWine(wine);
	}
	
	@Override
	public boolean wineInfoUpdate(WineInfoVo wine) {
		return wineDao.wineInfoUpdate(wine);
	}
}

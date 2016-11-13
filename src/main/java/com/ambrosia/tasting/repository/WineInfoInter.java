package com.ambrosia.tasting.repository;

import com.ambrosia.tasting.vo.WineInfoVo;

public interface WineInfoInter {
	public int selectMaxWineCode();
	public boolean getPlaceForNewWine(WineInfoVo wine);
	public boolean wineInfoUpdate(WineInfoVo wine);
}

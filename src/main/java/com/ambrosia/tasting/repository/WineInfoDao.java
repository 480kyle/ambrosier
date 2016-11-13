package com.ambrosia.tasting.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ambrosia.tasting.vo.WineInfoVo;

public interface WineInfoDao {
	
	@Select("select max(w_code) as w_code from amb_winelist")
	public int selectMaxWineCode();
	
	@Insert("insert into amb_winelist(w_code, w_name, w_dateandtime) values(#{w_code}, #{w_name}, now())")
	public boolean getPlaceForNewWine(WineInfoVo wine);
	
	@Update("update amb_winelist set w_vintage=#{w_vintage}, w_region=#{w_region}, w_varieties=#{w_varieties}, w_maker=#{w_maker}, w_importer=#{w_importer} where w_code=#{w_code}")
	public boolean wineInfoUpdate(WineInfoVo wine);
}

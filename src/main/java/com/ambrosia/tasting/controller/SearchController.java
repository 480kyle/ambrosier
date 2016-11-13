package com.ambrosia.tasting.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ambrosia.tasting.service.MemberInfoService;
import com.ambrosia.tasting.service.SearchInfoService;
import com.ambrosia.tasting.service.TastingnoteService;
import com.ambrosia.tasting.vo.AromalistInfoVo;
import com.ambrosia.tasting.vo.KeywordInfoVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;
import com.ambrosia.tasting.vo.WineInfoVo;

@Controller
public class SearchController {
	
	@Autowired
	private SearchInfoService searchService;
	
	@Autowired
	private TastingnoteService tastingService;
	
	@RequestMapping("searchPage")
	public ModelAndView searchPageLoad(HttpSession session){
		ModelAndView model = new ModelAndView();
		ArrayList<KeywordInfoVo> keyword = new ArrayList<KeywordInfoVo>();
		int mcode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		
		keyword = searchService.recentKeywordByMember(mcode);
		
		model.addObject("datas", keyword);
		model.addObject("arrive", "search");
		model.setViewName("signedinSearchPage");
		
		return model;
	}
	
	@RequestMapping("search")
	@ResponseBody
	public HashMap<String, Object> serachDataByKeyword(@RequestParam("w") String keyword, @RequestParam("c") String category, HttpSession session){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int mcode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		
		if(category.equals("recent")){
			ArrayList<KeywordInfoVo> list = new ArrayList<KeywordInfoVo>();
			//최근키워드
			list = searchService.recentKeywordByMember(mcode);
			
			map.put("result", list);
		}else if(category.equals("people")){
			ArrayList<MemberInfoVo> list = new ArrayList<MemberInfoVo>();
			//멤버검색
			list = searchService.searchMemberByKeyword(keyword);

			map.put("result", list);
		}else if(category.equals("wine")){
			ArrayList<WineInfoVo> list = new ArrayList<WineInfoVo>();
			//와인을 검색해서 테이스팅노트를 검색
			list = searchService.searchWineByKeyword(keyword);
			
			map.put("result", list);
		}else if(category.equals("aroma")){
			ArrayList<TastingnoteInfoVo> list = new ArrayList<TastingnoteInfoVo>();
			//아로마검색
			
			list = searchService.searchAromaByKeyword(keyword);
			
			map.put("result", list);
		}
		
		map.put("category", category);
		
		return map;
	}
	
	@RequestMapping("searchWineName")
	@ResponseBody
	public ArrayList<WineInfoVo> searchWineByName(@RequestParam("k") String keyword){
		ArrayList<WineInfoVo> wineList = new ArrayList<WineInfoVo>();
		
		wineList = searchService.searchWineByKeyword(keyword);
		
		return wineList;
	}
	
	@RequestMapping("searchWineNameWhenTasting")
	@ResponseBody
	public ArrayList<WineInfoVo> searchWineWhenTasting(@RequestParam("k") String keyword){
		ArrayList<WineInfoVo> wineList = new ArrayList<WineInfoVo>();
		
		wineList = searchService.searchWineNameWhenTastingnoteIns(keyword);
		
		return wineList;
	}
	
	@RequestMapping("aromaLink")
	public ModelAndView searchAromaByAromaLink(@RequestParam("k") String keyword){
		ModelAndView model = new ModelAndView();
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		System.out.println(keyword);
		
		tastingDatas = tastingService.searchTastingImgByAroma(keyword);
		
		model.addObject("datas", tastingDatas);
		model.setViewName("signedinSearchAromaPage");
		
		return model;
	}
}

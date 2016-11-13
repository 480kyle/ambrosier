package com.ambrosia.tasting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambrosia.tasting.service.AlarmInfoService;
import com.ambrosia.tasting.service.LikeInfoService;
import com.ambrosia.tasting.vo.LikeInfoVo;

@Controller
public class LikeController {
	
	@Autowired
	private LikeInfoService likeService;
	
	@Autowired
	private AlarmInfoService alarmService;
	
	@RequestMapping("like")
	@ResponseBody
	public int likeInfoIns(@RequestParam("tc")int tc, HttpSession session){
		int l_code = 0;
		int userCode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		LikeInfoVo like = new LikeInfoVo();
		
		like.setL_tcode(tc);
		like.setL_mcode(userCode);
		
		l_code = likeService.likeInfoIns(like);
		
		return l_code;
	}
	
	@RequestMapping("unlike")
	@ResponseBody
	public boolean likeInfoDel(@RequestParam("lc")int lc, HttpSession session){
		boolean b = false;
		String userNick = session.getAttribute("userSigninNick").toString();
		
		b = likeService.likeInfoDel(lc, userNick);
		
		return b;
	}
	
	@RequestMapping("likeLoad")
	@ResponseBody
	public ArrayList<LikeInfoVo> selectLikeByMember(HttpSession session){
		ArrayList<LikeInfoVo> like = new ArrayList<LikeInfoVo>();
		
		like = likeService.selectLikeByMemberCode(session.getAttribute("userSigninCode").toString());
		
		return like;
	}
	
	@RequestMapping("likeCount")
	@ResponseBody
	public int likeCountByPost(@RequestParam("tc")int code){
		int count = 0;
		
		count = likeService.likeCountByPost(code);
		
		return count;
	}
}

package com.ambrosia.tasting.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambrosia.tasting.service.FollowInfoService;
import com.ambrosia.tasting.vo.FollowInfoVo;

@Controller
public class FollowController {
	
	@Autowired
	private FollowInfoService followService;
	
	@RequestMapping("follow")
	@ResponseBody
	public boolean followInfoIns(@RequestParam("fl")int followCode, HttpSession session){
		boolean b = false;
		FollowInfoVo follow = new FollowInfoVo();
		String userNick = session.getAttribute("userSigninNick").toString();
		
		follow.setF_followingcode(followCode);
		follow.setF_followedbycode(Integer.parseInt(session.getAttribute("userSigninCode").toString()));
		
		b = followService.followInfoIns(follow, userNick);
		
		return b;
	}
	
	@RequestMapping("unfollow")
	@ResponseBody
	public boolean followInfoDel(@RequestParam("fl")int followCode, HttpSession session){
		boolean b = false;
		int userCode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		FollowInfoVo follow = new FollowInfoVo();
		
		System.out.println("unfollow!!");
		
		follow.setF_followingcode(followCode);
		follow.setF_followedbycode(userCode);
		
		b = followService.followInfoDel(follow);
		
		return b;
	}
	
	@RequestMapping("followingCheck")
	@ResponseBody
	public boolean followingCheck(@RequestParam("fl")int followCode, HttpSession session){
		boolean b = false;
		int userCode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		FollowInfoVo follow = new FollowInfoVo();
		
		follow.setF_followingcode(followCode);
		follow.setF_followedbycode(userCode);
		b = followService.selectFollowByUserCode(follow);
		
		return b;
	}
	
	@RequestMapping("followers")
	@ResponseBody
	public HashMap<String, String> followersCount(@RequestParam("c")int code){
		HashMap<String, String> counts = new HashMap<String, String>();
		
		counts = followService.followersCount(code);
		
		return counts;
	}
}

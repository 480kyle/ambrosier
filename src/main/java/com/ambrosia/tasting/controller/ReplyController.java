package com.ambrosia.tasting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ambrosia.tasting.service.ReplyInfoService;
import com.ambrosia.tasting.vo.ReplyVo;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyInfoService replyService;
	
	@RequestMapping("commentLoadMore")
	public ModelAndView replyMore(int code){
		ModelAndView model = new ModelAndView();
		ArrayList<ReplyVo> reply = new ArrayList<ReplyVo>();
		
		reply = replyService.selectMoreRepliesByPost(code);
		
		model.addObject("reply", reply);
		model.addObject("code", code);
		model.setViewName("replyPage");
		
		return model;
	}
	
	@RequestMapping("commentLoad")
	@ResponseBody
	public ArrayList<ReplyVo> reply(int t_code){
		ArrayList<ReplyVo> reply = new ArrayList<ReplyVo>();
		
		reply = replyService.selectRepliesByPost(t_code);
		
		return reply;
	}
	
	@RequestMapping("commentIns")
	@ResponseBody
	public ArrayList<ReplyVo> replyIns(String comment, int code, HttpSession session){
		ArrayList<ReplyVo> replyList = new ArrayList<ReplyVo>();
		
		if(session.getAttribute("userSigninNick") == null){
			replyList = replyService.selectMoreRepliesByPost(code);
			return replyList;
		}
		if(comment.isEmpty()){
			replyList = replyService.selectMoreRepliesByPost(code);
			return replyList;
		}
		if(code == 0){
			replyList = replyService.selectMoreRepliesByPost(code);
			return replyList;
		}
		
		int maxCode = replyService.selectMaxCode() + 1;
		ReplyVo reply = new ReplyVo();
		
		reply.setR_code(maxCode);
		reply.setR_comment(comment);
		reply.setR_tcode(code);
		reply.setR_mnick(session.getAttribute("userSigninNick").toString());
		
		replyService.replyInfoIns(reply);
		
		replyList = replyService.selectMoreRepliesByPost(code);
		
		return replyList;
	}
}

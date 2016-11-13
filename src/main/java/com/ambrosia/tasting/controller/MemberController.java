package com.ambrosia.tasting.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.ambrosia.tasting.service.MemberInfoService;
import com.ambrosia.tasting.service.TastingnoteService;
import com.ambrosia.tasting.view.ProfilePicView;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(TastingnoteController.class);
	
	@Autowired
	MemberInfoService memberService;
	
	@Autowired
	TastingnoteService tastingService;
	
	@Resource
	private ProfilePicView profileView;
	
	@RequestMapping(value="m_join", method = RequestMethod.POST)
	public String memberJoin(MemberInfoVo member, HttpServletResponse response) throws IOException{
		boolean b = false;
		String url = "fail";
		
		b = memberService.insertMemInfo(member);
		
		if(b == true) {
			url = "joinSuccess";
		}else{
			url = "joinFail";
		}
		
		return url;
	}
	
	@RequestMapping(value="m_signin", method = RequestMethod.POST)
	public ModelAndView memberSignin(MemberInfoVo member, HttpSession session){
		ModelAndView model = new ModelAndView();
		
		member = memberService.memberSignin(member);
		if(member == null || member.equals(null)) {
			model.setViewName("redirect:/");
		}else{
//			Cookie userid = new Cookie("userSigninId", member.getM_email());
//			Cookie userpwd = new Cookie("userSigninPass", member.getM_password());
//			Cookie isValid = new Cookie("validation", "valid");
//			response.addCookie(userid);
//			response.addCookie(userpwd);
//			response.addCookie(isValid);
			
			session.removeAttribute("userSigninId");
			session.removeAttribute("userSigninPass");
			session.removeAttribute("userSigninNick");
			session.removeAttribute("userSigninCode");
			session.removeAttribute("signin");
			
			session.setAttribute("userSigninId", member.getM_email());
			session.setAttribute("userSigninPass", member.getM_password());
			session.setAttribute("userSigninNick", member.getM_nick());
			session.setAttribute("userSigninCode", member.getM_code());
			session.setAttribute("signin", "userIsValid");
			session.setMaxInactiveInterval(365 * 24 * 60 * 60); //365 day * 24 hours
			
			model.setViewName("redirect:/target?go=home");
		}
		return model;
	}
	
	@RequestMapping("logout")
	public ModelAndView memberLogout(HttpSession session){
		ModelAndView model = new ModelAndView();
		
		session.removeAttribute("userSigninId");
		session.removeAttribute("userSigninPass");
		session.removeAttribute("userSigninNick");
		session.removeAttribute("userSigninCode");
		session.removeAttribute("signin");
		
		session.invalidate();
		
		
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value="userIdCheck")
	@ResponseBody
	public boolean userEmailChecking(@RequestParam("userId") String userId){
		boolean isAvailable = false;
		
		isAvailable = memberService.memberEmailCheck(userId);
		
		return isAvailable;
	}
	
	@RequestMapping(value="userNickCheck")
	@ResponseBody
	public boolean userNickChecking(@RequestParam("userNick") String userNick){
		boolean isAvailable = false;
		
		isAvailable = memberService.memberNickCheck(userNick);
		
		return isAvailable;
	}
	
	@RequestMapping("otherProfile")
	public ModelAndView selectOtherProfile(@RequestParam("c") int code, HttpSession session){
		ModelAndView model = new ModelAndView();
		MemberInfoVo member = memberService.memberProfileByCode(code);
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		String id = session.getAttribute("userSigninId").toString();
		
		if(member.getM_email().equals(id)){
			
			member = memberService.memberProfileByCode(code);
			tastingDatas = tastingService.searchTastingnoteById(member);
			model.addObject("datas", tastingDatas);
			model.addObject("member", member);
			model.addObject("arrive", "profile");
			model.setViewName("signedinProfile");
			
			return model;
		}
		
		tastingDatas = tastingService.searchTastingnoteById(member);

		model.addObject("datas", tastingDatas);
		model.addObject("member", member);
		model.setViewName("signedinProfileOther");
		
		return model;
	}
	
	@RequestMapping("/profileImages/{fileName}.{ext}")
	public ModelAndView tastingImageMapper(@PathVariable("fileName") String fileName, @PathVariable("ext") String ext, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		model.setView(this.profileView);
		
		File profile = new File(fileName + "." + ext);
		model.addObject("profilePic", profile);
		
		return model;
	}
	
	@RequestMapping("profileUpdate")
	public ModelAndView memberInfoUpdate(MemberInfoVo member, HttpSession session){
		ModelAndView model = new ModelAndView();
		boolean b = false;
		
		b = memberService.memberInfoUpdate(member, session);
		
		if(b){
			model.setViewName("signedinProfile");
		}else{
			model.setViewName("joinFail");
		}
		
		return model;
	}
	
	@RequestMapping(value="profilePicUpdate", method=RequestMethod.POST)
	@ResponseBody
	public String memberProfPicUpdate(@RequestParam("pic")MultipartFile m_picture, HttpSession session){
		String data = "";
		System.out.println(m_picture);
		data = memberService.memberProfUpdate(m_picture, session);
		
		return data;
	}
	
	@RequestMapping("profileEdit")
	public ModelAndView memberProfileView(HttpSession session){
		ModelAndView model = new ModelAndView();
		MemberInfoVo member = new MemberInfoVo();
		int code = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		
		member = memberService.memberProfileByCode(code);
		
		model.addObject("member", member);
		model.setViewName("signedinProfileEdit");
		
		return model;
	}
	
	@RequestMapping(value = "m_update", method=RequestMethod.POST)
	public String memberProfileUpdate(MemberInfoVo member, HttpSession session){
		
		memberService.memberInfoUpdate(member, session);
		
		return "redirect:target?go=home";
	}
}

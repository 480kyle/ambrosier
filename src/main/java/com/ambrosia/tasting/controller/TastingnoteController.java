package com.ambrosia.tasting.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ambrosia.tasting.service.AlarmInfoService;
import com.ambrosia.tasting.service.MemberInfoService;
import com.ambrosia.tasting.service.ReplyInfoService;
import com.ambrosia.tasting.service.TastingnoteService;
import com.ambrosia.tasting.service.WineInfoService;
import com.ambrosia.tasting.view.ImageView;
import com.ambrosia.tasting.vo.AlarmInfoVo;
import com.ambrosia.tasting.vo.FollowLoadMoreVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.ReplyVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

@Controller
public class TastingnoteController {
	
	private static final Logger logger = LoggerFactory.getLogger(TastingnoteController.class);
	Calendar calendar;
	
	@Autowired
	private TastingnoteService tastingService;
	
	@Autowired
	private MemberInfoService memberService;
	
	@Autowired
	private AlarmInfoService alarmService;
	
	@Autowired
	private WineInfoService wineService;
	
	@Resource
	private ImageView imageView;
	
	@RequestMapping("target")
	public ModelAndView signedRedirect(@RequestParam("go")String go, HttpSession session){
		ModelAndView model = new ModelAndView();
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		MemberInfoVo member = new MemberInfoVo();
		String filePath = "file:/" + System.getProperty("catalina.home");
		
		if(session.getAttribute("userSigninId") == null){
			model.setViewName("redirect:/");
			return model;
		}
		
		String userId = session.getAttribute("userSigninId").toString();
		int userCode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		String arrive = go;
		
//		System.out.println(session.isNew());
		
//		if(session.isNew() == false){
//			go = "redirect:/";
//			model.setViewName(go);
//			return model;
//		}
		
//		if(session.getAttribute("userSigninId").toString().equals(null) || session.getAttribute("userSigninId").toString().equals("")){
//			go = "redirect:/";
//			model.setViewName(go);
//			return model;
//		}else{
//			userId = session.getAttribute("userSigninId").toString();
//		}
//		
//		if(!session.getAttribute("signin").toString().equals("userIsValid")){
//			go="redirect:/";
//			model.setViewName(go);
//			return model;
//		}
		
		if(go.equals("home")){
			member.setM_email(userId);
//			tastingDatas = tastingService.searchTastingnoteById(member);
//			if(tastingDatas == null){
//				tastingDatas = tastingService.searchTastingnoteAll();
//			}
			tastingDatas = tastingService.searchTastingnoteByFollow(userCode);
			
			if(tastingDatas.isEmpty()){
				tastingDatas = tastingService.searchTastingnoteAll();
			}
			
//			for(TastingnoteInfoVo tasting: tastingDatas){
//				System.out.println(tasting.getM_nick() + tasting.getM_profile());
//			}
			
			model.addObject("tastingDatas", tastingDatas);
			go = "signedinMain";
		}else if(go.equals("search")){
			tastingDatas = tastingService.searchTastingImgAll();
//			for(TastingnoteInfoVo tasting: tastingDatas){
//				System.out.println(tasting.getT_code());
//			}
			model.addObject("datas", tastingDatas);
			go = "signedinSearch";
		}else if(go.equals("writing")){
			go = "signedinWriting";
		}else if(go.equals("alarm")){
			if(session.getAttribute("userSigninNick") == null){
				model.setViewName("home");
				return model;
			}
			
			String userNick = session.getAttribute("userSigninNick").toString(); 
			
			ArrayList<AlarmInfoVo> alarm = alarmService.alarmInfoByNick(userNick);
			
			model.addObject("alarm", alarm);
			go = "signedinAlarm";
		}else if(go.equals("profile")){
			member = memberService.memberProfile(userId);
			tastingDatas = tastingService.searchTastingnoteById(member);
//			for(TastingnoteInfoVo tasting: tastingDatas){
//				System.out.println(tasting.getT_code());
//			}
			model.addObject("datas", tastingDatas);
			model.addObject("member", member);
			go = "signedinProfile";
		}
		
//		System.out.println(go);
		
		model.addObject("arrive", arrive);
		model.setViewName(go);
		
		return model;
	}
	
	@RequestMapping(value="t_share")
	public ModelAndView tastingnoteShare(TastingnoteInfoVo tasting, HttpSession session){
		ModelAndView model = new ModelAndView();
		boolean isInserted = false;
		String direction = "";
		ReplyVo reply = new ReplyVo();
		
		if(session.getAttribute("userSigninId") == null){
			model.setViewName("redirect:/");
			return model;
		}
		
		if(tasting.getT_wcode() == 0){
			//After get wine code and set view
			//와인코드 받고 공간을 확보한 다음 와인 정보를 업데이트 할 것!
			
			int wineCode = wineService.selectMaxWineCode(tasting.getT_wname());
			direction = "signedinNewWine";
			model.addObject("wineCode", wineCode);
			model.addObject("wineName", tasting.getT_wname());
			tasting.setT_wcode(wineCode);
		}else{
			direction = "redirect:target?go=home";
		}
		
		isInserted = tastingService.tastingnoteIns(tasting, session);
		
//		if(isInserted == true){
//			direction = "redirect:target?go=home";
//		}
		
		model.setViewName(direction);
		
		return model;
	}
	
	@RequestMapping("/tastingImages/{fileName}.{ext}")
	public ModelAndView tastingImageMapper(@PathVariable("fileName") String fileName, @PathVariable("ext") String ext, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		model.setView(this.imageView);
		
		File showFile = new File(fileName + "." + ext);
		model.addObject("showFile", showFile);
		
		return model;
//	       ServletContext cntx = new getServletContext();
//	      // Get the absolute path of the image
//	      String filename = cntx.getRealPath("Images/button.png");
//	      // retrieve mimeType dynamically
//	      String mime = cntx.getMimeType(filename);
//	      if (mime == null) {
//	        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	        return;
//	      }
//
//	      resp.setContentType(mime);
//	      File file = new File(filename);
//	      resp.setContentLength((int)file.length());
//
//	      FileInputStream in = new FileInputStream(file);
//	      OutputStream out = resp.getOutputStream();
//
//	      // Copy the contents of the file to the output stream
//	       byte[] buf = new byte[1024];
//	       int count = 0;
//	       while ((count = in.read(buf)) >= 0) {
//	         out.write(buf, 0, count);
//	      }
//	    out.close();
//	    in.close();
	}
	
	@RequestMapping("/tastingnote")
	public ModelAndView tastingnoteLoad(@RequestParam("c")int code){
		ModelAndView model = new ModelAndView();
		
		TastingnoteInfoVo tastingnote = tastingService.selectTastingnoteByCode(code);
		model.addObject("data", tastingnote);
		model.addObject("code", code);
		model.setViewName("signedinPost");
		
		return model;
	}
	
	@RequestMapping("tnoteLoadMore")
	@ResponseBody
	public ArrayList<TastingnoteInfoVo> tastingnoteLoadMore(@RequestParam("c") int lastTcode, HttpSession session){
		ArrayList<TastingnoteInfoVo> tastingnoteList = new ArrayList<TastingnoteInfoVo>();
		
		int userCode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		FollowLoadMoreVo follow = new FollowLoadMoreVo();
		
		follow.setM_code(userCode);
		follow.setT_code(lastTcode);
		
		tastingnoteList = tastingService.searchTastingnoteByFollowLoadMore(follow);
		
		if(tastingnoteList.isEmpty()){
			tastingnoteList = tastingService.searchTastingnoteAllLoadMore(lastTcode);
		}
		
		
		return tastingnoteList;
	}
	
	@RequestMapping("tsearchImgLoadMore")
	@ResponseBody
	public ArrayList<TastingnoteInfoVo> tastingnoteImgLadMore(@RequestParam("c") int lastTcode, HttpSession session){
		ArrayList<TastingnoteInfoVo> tastingnoteList = new ArrayList<TastingnoteInfoVo>();
		
		int userCode = Integer.parseInt(session.getAttribute("userSigninCode").toString());
		FollowLoadMoreVo follow = new FollowLoadMoreVo();
		
		follow.setM_code(userCode);
		follow.setT_code(lastTcode);
		
		tastingnoteList = tastingService.searchTastingImgByFollowLoadMore(follow);
		
		if(tastingnoteList.isEmpty()){
			tastingnoteList = tastingService.searchTastingImgAllLoadMore(lastTcode);
		}
		
		
		return tastingnoteList;
	}
}

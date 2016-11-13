package com.ambrosia.tasting.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ambrosia.tasting.repository.MemberInfoDao;
import com.ambrosia.tasting.vo.MemberInfoVo;

@Service
public class MemberInfoService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MemberInfoService.class);
	private Calendar calendar;
	
	@Autowired
	private MemberInfoDao memberDao;
	
	public boolean insertMemInfo(MemberInfoVo member){
		calendar = Calendar.getInstance();
		boolean b = false;
		
		int maxCode = memberDao.selectMaxCode();
		System.out.println(maxCode);
		member.setM_code(maxCode + 1);
		member.setM_auth("no");
		member.setM_profile("no_primg.png");
		
		try{
			b = memberDao.memberInfoIns(member);
		}catch(Exception e){
			System.out.println("MemberInsertErr: " + e);
			b = false;
		}
//		System.out.println(b);
		return b;
	}
	
	public MemberInfoVo memberSignin(MemberInfoVo member){
		MemberInfoVo signedinMember = memberDao.memberSignin(member);
		return signedinMember;
	}
	
	public String memberSignin(HttpSession session){
		MemberInfoVo member = new MemberInfoVo();
		
		String id = session.getAttribute("userSigninId").toString();
		String pass = session.getAttribute("userSigninPass").toString();
		String direction = "redirect:/";
		
//		for(int i = 0; i < request.getCookies().length; i++){
//			if(request.getCookies()[i].getName().equals("userSigninId")){
//				id = request.getCookies()[i].getValue();
//			}
//			if(request.getCookies()[i].getName().equals("userSigninPass")){
//				pass = request.getCookies()[i].getValue();
//			}
//			if(request.getCookies()[i].getName().equals("validation")){
//				valid = request.getCookies()[i].getValue();
//			}
//		}
		
		member.setM_email(id);
		member.setM_password(pass);
		
		MemberInfoVo signedinMember = memberDao.memberSignin(member);
		if(signedinMember != null){
			direction = "redirect:/target?go=home";
		}
		return direction;
	}
	
	public boolean memberEmailCheck(String userId){
		boolean isAvalible = false;
		
		userId = memberDao.memberEmailCheck(userId);
		
		if(userId == null){
			System.out.println("EmailCheckTrue");
			isAvalible = true;
		}
		
		return isAvalible;
	}
	
	public boolean memberNickCheck(String userNick){
		boolean isAvalible = false;
		
		userNick = memberDao.memberNickCheck(userNick);
		
		if(userNick == null){
			System.out.println("NickCheckTrue");
			isAvalible = true;
		}
		
		return isAvalible;
	}
	
	public MemberInfoVo memberProfile(String userId){
		MemberInfoVo member = new MemberInfoVo();
		
		member = memberDao.memberProfile(userId);
		
		return member;
	}
	
	public MemberInfoVo memberProfileByCode(int code){
		MemberInfoVo member = memberDao.memberProfileByCode(code);
		
		return member;
	}
	
	public boolean memberInfoUpdate(MemberInfoVo member, HttpSession session){
		calendar = Calendar.getInstance();
		boolean b = false;
		String userId = session.getAttribute("userSigninId").toString();
		
//		if(!member.getM_picture().isEmpty()){
//			try {
//				byte[] bytes = member.getM_picture().getBytes();
//				
//				//Create the directory to store file
//				String rootPath = System.getProperty("catalina.home");
//				File dir = new File(rootPath + File.separator + "data" + File.separator + "ambrosia" + File.separator + "profilePics");
////				String rootPath = servletContext.getRealPath("/resources/tastingPics");
//				System.out.println(rootPath);
////				File dir = new File(rootPath);
//				
//				if(!dir.exists()){
//					dir.mkdirs();
//				}
//				
//				//Create the file on server
//				String[] email = userId.split("@");
//				String fileName = email[0] + calendar.get(Calendar.YEAR) + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DATE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
//				File memberPic = new File(dir.getAbsolutePath() + File.separator + fileName + ".png");
//				System.out.println(dir.getAbsolutePath() + File.separator + fileName);
//				BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(memberPic));
//				
//				outStream.write(bytes);
//				outStream.close();
//				member.setM_profile(fileName);
//				
//			} catch (Exception e) {
//				LOGGER.info("File Upload Err: " + e);
//			}
//		}
//		
//		try {
//		} catch (Exception e) {
//			LOGGER.info("File Upload Err: " + e);
//		}
		
		b = memberDao.memberInfoUpdate(member);
		
		return b;
	}
	
	public String memberProfUpdate(MultipartFile m_picture, HttpSession session){
		boolean b = false;
		calendar = Calendar.getInstance();
		String userId = session.getAttribute("userSigninId").toString();
		String m_profile = "";
		
		if(!m_picture.isEmpty()){
			try {
				byte[] bytes = m_picture.getBytes();
				
				//Create the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "data" + File.separator + "ambrosia" + File.separator + "profilePics");
//				String rootPath = servletContext.getRealPath("/resources/tastingPics");
				System.out.println(rootPath);
//				File dir = new File(rootPath);
				
				if(!dir.exists()){
					dir.mkdirs();
				}
				
				//Create the file on server
				String[] email = userId.split("@");
				String fileName = "prof_" + email[0] + calendar.get(Calendar.YEAR) + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DATE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND) + ".png";
				File memberPic = new File(dir.getAbsolutePath() + File.separator + fileName);
				System.out.println(dir.getAbsolutePath() + File.separator + fileName);
				BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(memberPic));
				
				outStream.write(bytes);
				outStream.close();
				m_profile = fileName;
				
			} catch (Exception e) {
				LOGGER.info("File Upload Err: " + e);
			}
		}
		
		try {
		} catch (Exception e) {
			LOGGER.info("File Upload Err: " + e);
		}
		
		MemberInfoVo member = new MemberInfoVo();
		member.setM_profile(m_profile);
		member.setM_email(userId);
		
		b = memberDao.memberPictureUpdate(member);
		
		if(b){
			return m_profile;
		}
		
		return "no_primg.svg";
	}
	
	public ArrayList<MemberInfoVo> searchMemberByKeyword(String keyword){
		ArrayList<MemberInfoVo> data = new ArrayList<MemberInfoVo>();
		
		
		
		return data;
	}
}

package com.ambrosia.tasting.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class ProfilePicView extends AbstractView {
	public ProfilePicView() {
		setContentType("image/png");
	}
	
@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		try{
			response.setContentType(getContentType());
			
			File fileName = (File)model.get("profilePic");
			
			if(logger.isDebugEnabled()){
				logger.debug("profilePic" + fileName);
			}
			
			String userAgent = request.getHeader("User-Agent");
			boolean isle = userAgent.indexOf("MSIE") != -1;
			String rootPath = System.getProperty("catalina.home");
			
			OutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(rootPath + "/data/ambrosia/profilePics/" + fileName);
			
			logger.info("FileInputStream: " + in);
			
			try {
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (Exception e) {
				throw e;
			} finally {
				try { if (in != null) in.close(); } catch (IOException ioe) {}
		        try { if (out != null) out.close(); } catch (IOException ioe) {}
			}
		    
		} catch (Exception e) {
			throw e;
		}
	}
}

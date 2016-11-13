package com.ambrosia.tasting.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class ImageView extends AbstractView{
	public ImageView() {
		setContentType("image/png");
	}
	
//	private void setFileName(String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
//		String userAgent = request.getHeader("User-Agent");
//		boolean isle = userAgent.indexOf("MSIE") != -1;
//		
//		if(isle){
//			fileName = URLEncoder.encode(fileName, "utf-8");
//		}else{
//			fileName = new String(fileName.getBytes("utf-8"));
//		}
//		
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
//	    response.setHeader("Content-Transfer-Encoding", "binary");
//	}
//	
//	private void showFile(File showFile, HttpServletRequest request, HttpServletResponse response) throws Exception{
//		OutputStream out = response.getOutputStream();
////		FileInputStream in = new FileInputStream(showFile);
//		FileInputStream in = new FileInputStream("/Users/kyle/Documents/apache-tomcat-8.0.28/data/ambrosia/tastingnotePics/" + showFile.getName());
//		
//		logger.info("FileInputStream: " + in);
//		
//		try {
//			FileCopyUtils.copy(in, out);
//			out.flush();
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			try { if (in != null) in.close(); } catch (IOException ioe) {}
//	        try { if (out != null) out.close(); } catch (IOException ioe) {}
//		}
//	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			response.setContentType(getContentType());
			
			File fileName = (File)model.get("showFile");
			
			if(logger.isDebugEnabled()){
				logger.debug("showFile: " + fileName);
			}
			
			String userAgent = request.getHeader("User-Agent");
			boolean isle = userAgent.indexOf("MSIE") != -1;
//			File fileName = new File(showFile);
			String rootPath = System.getProperty("catalina.home");
//			
//			if(isle){
//				fileName = URLEncoder.encode(fileName, "utf-8");
//			}else{
//				fileName = new String(fileName.getBytes("utf-8"));
//			}
//			
//			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
//		    response.setHeader("Content-Transfer-Encoding", "binary");
//		    
			OutputStream out = response.getOutputStream();
	//		FileInputStream in = new FileInputStream(showFile);
			FileInputStream in = new FileInputStream(rootPath + "/data/ambrosia/tastingPicsComp/" + fileName);
			
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

package com.ambrosia.tasting.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambrosia.tasting.repository.LikeInfoDao;
import com.ambrosia.tasting.repository.ReplyInfoDao;
import com.ambrosia.tasting.repository.TastingnoteInfoDao;
import com.ambrosia.tasting.vo.AromalistInfoVo;
import com.ambrosia.tasting.vo.FollowLoadMoreVo;
import com.ambrosia.tasting.vo.MemberInfoVo;
import com.ambrosia.tasting.vo.ReplyVo;
import com.ambrosia.tasting.vo.TastingnoteInfoVo;

@Service
public class TastingnoteService {

	private final static Logger LOGGER = LoggerFactory.getLogger(MemberInfoService.class);
	private Calendar calendar;
	
	@Autowired
	private TastingnoteInfoDao tastingDao;
	
	@Autowired
	private ReplyInfoDao replyDao;
	
	@Autowired
	private LikeInfoDao likeDao;
	
	public boolean tastingnoteIns(TastingnoteInfoVo tasting, HttpSession session){
		calendar = Calendar.getInstance();
		boolean ba = false, bt = false;
		int maxTastingnoteCode = 0, maxAromaCode = 0;
		String userId = session.getAttribute("userSigninId").toString();
		
		if(!tasting.getT_picture().isEmpty()){
			try {
				byte[] bytes = tasting.getT_picture().getBytes();
				long fileSize = tasting.getT_picture().getSize();
				
				//Create the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "data" + File.separator + "ambrosia" + File.separator + "tastingPics");
				File dirComp = new File(rootPath + File.separator + "data" + File.separator + "ambrosia" + File.separator + "tastingPicsComp");
//				String rootPath = servletContext.getRealPath("/resources/tastingPics");
				LOGGER.info("File rootPath: " + rootPath);
//				File dir = new File(rootPath);
				
				if(!dir.exists()){
					dir.mkdirs();
				}
				
				if(!dirComp.exists()){
					dirComp.mkdirs();
				}
				
				//Create the file on server
				String[] email = userId.split("@");
				String fileName = email[0] + calendar.get(Calendar.YEAR) + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DATE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
				File tastingnotePic = new File(dir.getAbsolutePath() + File.separator + fileName + ".png");
				LOGGER.info("Create File: " + dir.getAbsolutePath() + File.separator + fileName + ".png");
				File tastingnotePicComp = new File(dirComp.getAbsolutePath() + File.separator + fileName + "_comp" + ".png");
				LOGGER.info("Create File: " + dirComp.getAbsolutePath() + File.separator + fileName + "_comp" + ".png");
				
				BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(tastingnotePic));
				BufferedOutputStream outStreamComp = new BufferedOutputStream(new FileOutputStream(tastingnotePicComp));
				
				//Resize an image
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				
				
				try {
					BufferedImage bimg = ImageIO.read(bais);
//					Image scaledImg = null;
//					BufferedImage buffImg = null;
//					float imgRatio = bimg.getWidth() / bimg.getHeight();
//					
					if(fileSize > 500000){
						Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
						ImageWriter writer = (ImageWriter) writers.next();
						
						ImageOutputStream ios = ImageIO.createImageOutputStream(outStreamComp);
						writer.setOutput(ios);
						
						ImageWriteParam iwp = writer.getDefaultWriteParam();
						
						iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
						iwp.setCompressionQuality(0.3f);
						
						writer.write(null, new IIOImage(bimg, null, null), iwp);
						
						outStream.write(bytes);
						
						tasting.setT_pname(fileName + "_comp");
					}else{
						outStream.write(bytes);
						outStreamComp.write(bytes);
						
						tasting.setT_pname(fileName + "_comp");
					}
					
				} finally {
					outStream.close();
					outStreamComp.close();
				}
					
					
//					System.out.println(fileSize);
//					if(bimg.getWidth() > 470){
//						scaledImg = bimg.getScaledInstance(470, (int)(470 * imgRatio), Image.SCALE_SMOOTH);
//						buffImg = new BufferedImage(470, (int)(470 * imgRatio), BufferedImage.TYPE_INT_RGB);
//						
//					}else if(bimg.getHeight() > 470){
//						scaledImg = bimg.getScaledInstance((int)(470 * imgRatio), 470, Image.SCALE_SMOOTH);
//						buffImg = new BufferedImage((int)(470 * imgRatio), 470, BufferedImage.TYPE_INT_RGB);
//					}
//					
//					buffImg.getGraphics().drawImage(scaledImg, 0, 0, new Color(0, 0, 0), null);
//					
//					ImageIO.write(buffImg, "png", baos);
//					baos.flush();
//					
//					
//				} catch (Exception e) {
//					LOGGER.info("image resizing err: " + e);
//				}
//				System.out.println("bytes: " + bytes);
//				System.out.println("toByteArray: " + baos.toByteArray());
//				outStream.write(baos.toByteArray());
				
//				baos.close();
				
//				outStream.write(bytes);
//				outStreamComp.write(bytes);
//				
//				outStream.close();
//				outStreamComp.close();
//				
//				tasting.setT_pname(fileName + "_comp");
				
			} catch (Exception e) {
				LOGGER.info("File Upload Err: " + e);
			}
		}
//		/**
//		 * Upload multiple file using Spring Controller
//		 */
//		@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
//		public @ResponseBody
//		String uploadMultipleFileHandler(@RequestParam("name") String[] names,
//				@RequestParam("file") MultipartFile[] files) {
//
//			if (files.length != names.length)
//				return "Mandatory information missing";
//
//			String message = "";
//			for (int i = 0; i < files.length; i++) {
//				MultipartFile file = files[i];
//				String name = names[i];
//				try {
//					byte[] bytes = file.getBytes();
//
//					// Creating the directory to store file
//					String rootPath = System.getProperty("catalina.home");
//					File dir = new File(rootPath + File.separator + "tmpFiles");
//					if (!dir.exists())
//						dir.mkdirs();
//
//					// Create the file on server
//					File serverFile = new File(dir.getAbsolutePath()
//							+ File.separator + name);
//					BufferedOutputStream stream = new BufferedOutputStream(
//							new FileOutputStream(serverFile));
//					stream.write(bytes);
//					stream.close();
//
//					logger.info("Server File Location="
//							+ serverFile.getAbsolutePath());
//
//					message = message + "You successfully uploaded file=" + name
//							+ "
//	";
//				} catch (Exception e) {
//					return "You failed to upload " + name + " => " + e.getMessage();
//				}
//			}
//			return message;
		
		maxAromaCode = tastingDao.selectMaxAromaCode() + 1;
		maxTastingnoteCode = tastingDao.selectMaxTastingnoteCode() + 1;
		
		String[] strArr = null;
		
		strArr = tasting.getT_aromas().split(",");
		
		for (int i = 0; i < strArr.length; i++) {
			AromalistInfoVo aroma = new AromalistInfoVo();
			aroma.setA_code(maxAromaCode + i);
			aroma.setA_tcode(maxTastingnoteCode);
			aroma.setA_wcode(5);
			aroma.setA_memail(userId);
			aroma.setA_aroma(strArr[i]);
			
			ba = tastingDao.aromaInfoIns(aroma);
			if(ba == false){
				return ba;
			}
		}
		
		tasting.setT_code(maxTastingnoteCode);
		tasting.setT_memail(userId);
		
		try {
		} catch (Exception e) {
			LOGGER.info("File Upload Err: " + e);
		}
		
		if(ba == true){
			bt = tastingDao.tastingnoteInfoIns(tasting);

			if(tasting.getT_comment() != null || tasting.getT_comment() != ""){
				int maxCode = replyDao.selectMaxReplyCode() + 1;
				ReplyVo reply = new ReplyVo();
				reply.setR_code(maxCode);
				reply.setR_comment(tasting.getT_comment());
				reply.setR_tcode(maxTastingnoteCode);
				reply.setR_mnick(session.getAttribute("userSigninNick").toString());
				
				replyDao.replyInfoIns(reply);
			}
		}
		
		return bt;
	}

	public ArrayList<TastingnoteInfoVo> searchTastingnoteById(MemberInfoVo member){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingnoteById(member);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code()); 
			data.setReply(reply);
		}
		
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingnoteAll(){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingnoteAll();
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByFollow(int code){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingnoteByFollow(code);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingImgAll(){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingImgAll();
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingImgByAroma(String keyword){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		keyword = "%" + keyword + "%";
		
		tastingDatas = tastingDao.searchTastingImgByAroma(keyword);
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingImgByFollow(int code){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingImgByFollow(code);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByFollowLoadMore(FollowLoadMoreVo follow){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingnoteByFollowLoadMore(follow);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingnoteAllLoadMore(int code){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingnoteAllLoadMore(code);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingImgByFollowLoadMore(FollowLoadMoreVo follow){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingImgByFollowLoadMore(follow);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingImgAllLoadMore(int code){
		ArrayList<TastingnoteInfoVo> tastingDatas = new ArrayList<TastingnoteInfoVo>();
		
		tastingDatas = tastingDao.searchTastingImgAllLoadMore(code);
		
		for (TastingnoteInfoVo data: tastingDatas) {
			ArrayList<ReplyVo> reply = replyDao.selectRepliesByPost(data.getT_code());
			data.setT_like(likeDao.countLikesByTcode(data.getT_code()));
			data.setReply(reply);
		}
		
		return tastingDatas;
	}
	
	public TastingnoteInfoVo selectTastingnoteByCode(int code){
		
		TastingnoteInfoVo tasting = tastingDao.selectTastingnoteByCode(code);
		tasting.setReply(replyDao.selectMoreRepliesByPost(code));
		
		return tasting;
	}
	
	public ArrayList<TastingnoteInfoVo> searchTastingnoteByKeyword(String keyword){
		ArrayList<TastingnoteInfoVo> data = new ArrayList<TastingnoteInfoVo>();
		
		
		
		return data;
	}
	
//	private static BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, Object hint,
//			boolean higherQuality) {
//		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
//				: BufferedImage.TYPE_INT_ARGB;
//		BufferedImage ret = (BufferedImage) img;
//		if (ret.getHeight() < targetHeight || ret.getWidth() < targetWidth) {
//			higherQuality = false;
//		}
//		int w, h;
//		if (higherQuality) {
//			// Use multi-step technique: start with original size, then
//			// scale down in multiple passes with drawImage()
//			// until the target size is reached
//			w = img.getWidth();
//			h = img.getHeight();
//		} else {
//			// Use one-step technique: scale directly from original
//			// size to target size with a single drawImage() call
//			w = targetWidth;
//			h = targetHeight;
//		}
//
//		do {
//			if (higherQuality && w > targetWidth) {
//				w /= 2;
//				if (w < targetWidth) {
//					w = targetWidth;
//				}
//			}
//
//			if (higherQuality && h > targetHeight) {
//				h /= 2;
//				if (h < targetHeight) {
//					h = targetHeight;
//				}
//			}
//
//			BufferedImage tmp = new BufferedImage(w, h, type);
//			Graphics2D g2 = tmp.createGraphics();
//			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
//			g2.drawImage(ret, 0, 0, w, h, null);
//			g2.dispose();
//
//			ret = tmp;
//		} while (w != targetWidth || h != targetHeight);
//
//		return ret;
//	}
//	
//	 private BufferedImage scaleImage(final BufferedImage bufferedImage,
//		        final int size) {
//		        final double boundSize = size;
//
//		        final int origWidth = bufferedImage.getWidth();
//		        final int origHeight = bufferedImage.getHeight();
//
//		        double scale;
//
//		        if (origHeight > origWidth)
//		            scale = boundSize / origHeight;
//		        else
//		            scale = boundSize / origWidth;
//
//		        /*
//		         * Don't scale up small images.
//		         */
//		        if (scale > 1.0)
//		            return (null);
//
//		        final int scaledWidth = (int) (scale * origWidth);
//		        final int scaledHeight = (int) (scale * origHeight);
//
//		        final Image scaledImage =
//		            bufferedImage.getScaledInstance(scaledWidth, scaledHeight,
//		                Image.SCALE_SMOOTH);
//
//		        // new ImageIcon(image); // load image
//		        // scaledWidth = scaledImage.getWidth(null);
//		        // scaledHeight = scaledImage.getHeight(null);
//
//		        final BufferedImage scaledBI =
//		            new BufferedImage(scaledWidth, scaledHeight,
//		                BufferedImage.TYPE_INT_RGB);
//
//		        final Graphics2D g = scaledBI.createGraphics();
//
//		        g.drawImage(scaledImage, 0, 0, null);
//
//		        g.dispose();
//
//		        return (scaledBI);
//		    }
	 
//	 public byte[] scale(byte[] fileData, int width, int height) {
//	    	ByteArrayInputStream in = new ByteArrayInputStream(fileData);
//	    	try {
//	    		BufferedImage img = ImageIO.read(in);
//	    		if(height == 0) {
//	    			height = (width * img.getHeight())/ img.getWidth(); 
//	    		}
//	    		if(width == 0) {
//	    			width = (height * img.getWidth())/ img.getHeight();
//	    		}
//	    		Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//	    		BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//	    		imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0,0,0), null);
//
//	    		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//
//	    		ImageIO.write(imageBuff, "jpg", buffer);
//
//	    		return buffer.toByteArray();
//	    	} catch (IOException e) {
////	    		throw new ApplicationException("IOException in scale");
//	    	}
//	    }
}

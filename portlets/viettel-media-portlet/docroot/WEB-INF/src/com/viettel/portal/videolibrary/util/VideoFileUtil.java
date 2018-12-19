package com.viettel.portal.videolibrary.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.PortletPreferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.viettel.portal.videolibrary.ImageFileSizeException;
import com.viettel.portal.videolibrary.ImageFileTypeException;
import com.viettel.portal.videolibrary.VideoFileSizeException;
import com.viettel.portal.videolibrary.VideoFileTypeException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class VideoFileUtil {
	
	public static String getEmbedYoutubeVideoURL(int frameWidth, int frameHeight,String videoId){
		
		if(frameWidth <=0){
			frameWidth = VideoConstants.DEFAULT_VIDEO_FRAME_WIDTH;
		}
		
		if(frameHeight <=0){
			frameHeight = VideoConstants.DEFAULT_VIDEO_FRAME_HEIGHT;
		}

		return "<iframe width=\"" + frameWidth + "\" height=\"" 
				+ frameHeight + "\" src=\"//www.youtube.com/embed/" 
				+ videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
	}
	

	public static String getEmbedYoutubeVideoURL(String frameWidth, String frameHeight,String videoId){
		return "<iframe width=\"" + frameWidth + "\" height=\"" 
				+ frameHeight + "\" src=\"//www.youtube.com/embed/" 
				+ videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
	}
	
	public static String getVideoIdFromYoutubeURL(String url){
		
		String pattern = "(?<=v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/)[^#\\&\\?\"]*";

		Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = compiledPattern.matcher(url);
		
		if(matcher.find()){
			return matcher.group();
		}else{
			return StringPool.BLANK;
		}
	}
	
	public static String getVideoPreviewURL(ThemeDisplay themeDisplay,FileEntry videoEntry){
		
		if(videoEntry != null){
			
			StringBundler stringBundler = new StringBundler();

			stringBundler.append(themeDisplay.getPortalURL());
			stringBundler.append(themeDisplay.getPathContext());
			stringBundler.append("/documents/");
			stringBundler.append(videoEntry.getRepositoryId());
			stringBundler.append(StringPool.SLASH);
			stringBundler.append(videoEntry.getFolderId());
			stringBundler.append(StringPool.SLASH);
			stringBundler.append(HttpUtil.encodeURL(HtmlUtil.unescape(videoEntry.getTitle()), true));
			
			String videoPreviewURL = stringBundler.toString();

			if (themeDisplay.isAddSessionIdToURL()) {
				return PortalUtil.getURLWithSessionId(
					videoPreviewURL, themeDisplay.getSessionId());
			}

			return videoPreviewURL;
			
		}else{
			
			return StringPool.BLANK;
		}
	}
	
	public static String getVideoThumbnailURL(ThemeDisplay themeDisplay,FileEntry thumbnailEntry){
		
		if(thumbnailEntry != null){
			
			StringBundler stringBundler = new StringBundler();

			stringBundler.append(themeDisplay.getPortalURL());
			stringBundler.append(themeDisplay.getPathContext());
			stringBundler.append("/documents/");
			stringBundler.append(thumbnailEntry.getRepositoryId());
			stringBundler.append(StringPool.SLASH);
			stringBundler.append(thumbnailEntry.getFolderId());
			stringBundler.append(StringPool.SLASH);
			stringBundler.append(HttpUtil.encodeURL(HtmlUtil.unescape(thumbnailEntry.getTitle()), true));
			
			String videoPreviewURL = stringBundler.toString();

			if (themeDisplay.isAddSessionIdToURL()) {
				return PortalUtil.getURLWithSessionId(
					videoPreviewURL, themeDisplay.getSessionId());
			}

			return videoPreviewURL;
			
		}else{
			
			return StringPool.BLANK;
		}
	}
	
	public static boolean validateImageThumbnail(String imageFileName,long imageFileSize,
			PortletPreferences preferences)throws ImageFileTypeException, ImageFileSizeException{
		
		boolean flag = false;
		
		String[] validImageExtensions = preferences.getValues("imageThumbnailExtensions",
				VideoConstants.DEFAULT_IMAGE_THUMBNAIL_EXTENSIONS);
		
		//Validate upload file extension
		for (int i = 0; i < validImageExtensions.length; i++){
			
			String validExtension = validImageExtensions[i].toLowerCase();
			
			if(!Validator.equals(validExtension, StringPool.STAR) 
					&& StringUtil.endsWith(imageFileName, validExtension)){
				
				flag = true;
				break;
			}
		}
		
		if(!flag){
			
			throw new ImageFileTypeException();
		}
		
		long imageThumbnailMaxSize = GetterUtil.getLong(preferences.getValue("imageThumbnailMaxSize",
				String.valueOf(VideoConstants.DEFAULT_IMAGE_THUMBNAIL_MAX_SIZE))) * VideoConstants.FILE_SIZE_COEFFICENT;
		
		//Validate upload file size
		if ((imageThumbnailMaxSize > 0)
			&& (imageFileSize > imageThumbnailMaxSize)) {

			//flag = false;
			
			throw new ImageFileSizeException();
		}
		
		return flag;
	}
	
	public static boolean validateVideoFile(String videoFileName, byte[] videoFileBytes) 
			throws VideoFileTypeException, VideoFileSizeException {
		
		boolean flag = false;

		String[] validFileExtensions = PortletPropsValues.VIDEO_FILE_EXTENSIONS;
		System.err.println("validFileExtensions");
		for (String s : validFileExtensions) {
			System.err.println(s);
		}
		// Validate upload file extension
		for (int i = 0; i < validFileExtensions.length; i++) {

			String validExtension = validFileExtensions[i].toLowerCase();

			if (!Validator.equals(validExtension, StringPool.STAR)
					&& StringUtil.endsWith(videoFileName, validExtension)) {

				flag = true;
				break;
			}
		}

		if (!flag) {

			throw new VideoFileTypeException();
		}
		
		//System.out.println(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE));

		//long fileMaxSize = GetterUtil.getLong(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE));
		
		long fileMaxSize = PortletPropsValues.VIDEO_FILE_MAX_SIZE;
		System.err.println("fileMaxSize");
		System.err.println(fileMaxSize);

		// Validate upload file size
		if (videoFileBytes != null) {

			if(videoFileBytes.length > 0 && videoFileBytes.length > fileMaxSize) {
				//flag = false;
	
				throw new VideoFileSizeException();
			}
		}

		return flag;
	}
	
	public static String getFriendlyFileName(String fileName){
		
		String formatedFileName = fileName.toLowerCase().trim();
		
		formatedFileName = replaceMsWordCharacters(formatedFileName);

		char[] formatedCharArray = formatedFileName.toCharArray();

		for (int i = 0; i < formatedCharArray.length; i++) {
			
			char oldChar = formatedCharArray[i];
			
			char newChar = oldChar;

			if (contains(SPECIAL_CHARS, oldChar)) {
				newChar = '-';
			}

			int temp = UTF_8_STR.indexOf(oldChar);

			if (temp > -1) {
				newChar = UTF_8_REPLACE_STR.charAt(temp);
			}

			if (oldChar != newChar) {
				formatedCharArray[i] = newChar;
			}

			formatedFileName = new String(formatedCharArray);

			while (formatedFileName.contains("-" + "-")) {
				formatedFileName = replace(formatedFileName, "--", "-", 0);
			}

			if (formatedFileName.startsWith("-")) {
				formatedFileName = formatedFileName.substring(1, formatedFileName.length());
			}

			if (formatedFileName.endsWith("-")) {
				formatedFileName = formatedFileName.substring(0, formatedFileName.length() - 1);
			}
		}
		
		return formatedFileName;
	}
	
	private static boolean contains(char[] charArray, char character) {
		if ((charArray == null) || (charArray.length == 0)) {
			return false;
		} else {
			for (int i = 0; i < charArray.length; i++) {
				if (character == charArray[i]) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	private static String replaceMsWordCharacters(String content){
		
		return replace(content, _MS_WORD_UNICODE, _MS_WORD_HTML);
	}
	
	private static String replace(String s, String[] oldSubs, String[] newSubs) {
		if ((s == null) || (oldSubs == null) || (newSubs == null)) {
			return null;
		}

		if (oldSubs.length != newSubs.length) {
			return s;
		}

		for (int i = 0; i < oldSubs.length; i++) {
			s = replace(s, oldSubs[i], newSubs[i]);
		}

		return s;
	}

	private static String replace(String s, String oldSub, String newSub) {
		return replace(s, oldSub, newSub, 0);
	}
	
	private static String replace(String s, String oldSub, String newSub,
			int fromIndex) {

		if ((s == null) || (oldSub == null) || (newSub == null)) {
			return null;
		}

		int y = s.indexOf(oldSub, fromIndex);

		if (y >= 0) {

			// The number 5 is arbitrary and is used as extra padding to reduce
			// buffer expansion

			StringBuilder sb = new StringBuilder(s.length() + 5 * newSub.length());

			int length = oldSub.length();
			int x = 0;

			while (x <= y) {
				sb.append(s.substring(x, y));
				sb.append(newSub);

				x = y + length;
				y = s.indexOf(oldSub, x);
			}

			sb.append(s.substring(x));

			return sb.toString();
		} else {
			return s;
		}
	}
	
	public static boolean isValidYouTubeURL(String url) {

		if (Validator.isUrl(url)) {
			String pattern = "https?:\\/\\/(?:[0-9A-Z-]+\\.)?(?:youtu\\.be\\/|youtube\\.com\\S*[^\\w\\-\\s])([\\w\\-]{11})(?=[^\\w\\-]|$)(?![?=&+%\\w]*(?:['\"][^<>]*>|<\\/a>))[?=&+%\\w]*";

			Pattern compiledPattern = Pattern.compile(pattern,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = compiledPattern.matcher(url);

			return matcher.matches();

		} else {
			return false;
		}
	}

	private static final String UTF_8_STR = "Ã½á»³á»µá»·á»¹Ã¡áº£Ã Ã£áº¡Äƒáº¯áº³áº±áºµáº·Ã¢áº¥áº©áº§áº«áº­Ã©áº»Ã¨áº½áº¹Ãªáº¿á»ƒá»�á»…á»‡Ã­á»‰Ã¬Ä©á»‹Ã³á»�Ã²Ãµá»�Ã´á»‘á»•á»“á»—á»™Æ¡á»›á»Ÿá»�á»¡á»£Ãºá»§Ã¹Å©á»¥Æ°á»©á»­á»«á»¯á»±Ä‘";
	
	private static final String UTF_8_REPLACE_STR = "yyyyyaaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuud";
	
	private static final char[] SPECIAL_CHARS = new char[] { ' ', ',', '\\',
			'\'', '\"', '(', ')', ':', '/', '^', '|', '{', '}', '?', '#', '@',
			'+', '*', '&', '<', '>', '=', '~', ';', '$', '%', '.','!', '[', ']', '!', '`'};

	private static final String[] _MS_WORD_UNICODE = new String[] {
		"\u00ae", "\u2019", "\u201c", "\u201d"
	};

	private static final String[] _MS_WORD_HTML = new String[] {
		"&reg;", StringPool.APOSTROPHE, StringPool.QUOTE, StringPool.QUOTE
	};
	
	private static Log _log = LogFactory.getLog(VideoFileUtil.class);
}

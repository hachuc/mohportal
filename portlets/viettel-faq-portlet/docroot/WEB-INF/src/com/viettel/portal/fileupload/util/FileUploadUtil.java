package com.viettel.portal.fileupload.util;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class FileUploadUtil {
	
	public static String getFileThumbnailURL(ThemeDisplay themeDisplay,FileEntry thumbnailEntry){
		if(thumbnailEntry != null){
			
			StringBundler stringBundler = new StringBundler();

			stringBundler.append(themeDisplay.getPortalURL());
			stringBundler.append(themeDisplay.getPathContext());
			stringBundler.append("/fileupload/");
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
	
public static String getFilePreviewURL(ThemeDisplay themeDisplay,FileEntry fileEntry){
		
		if(fileEntry != null){
			
			StringBundler stringBundler = new StringBundler();

			stringBundler.append(themeDisplay.getPortalURL());
			stringBundler.append(themeDisplay.getPathContext());
			stringBundler.append("/documents/");
			stringBundler.append(fileEntry.getRepositoryId());
			stringBundler.append(StringPool.SLASH);
			stringBundler.append(fileEntry.getFolderId());
			stringBundler.append(StringPool.SLASH);
			stringBundler.append(HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()), true));
			
			String filePreviewURL = stringBundler.toString();

			if (themeDisplay.isAddSessionIdToURL()) {
				return PortalUtil.getURLWithSessionId(
						filePreviewURL, themeDisplay.getSessionId());
			}

			return filePreviewURL;
			
		}else{
			
			return StringPool.BLANK;
		}
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
}

/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.viettel.portal.vbpq.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;

import com.viettel.portal.vbpq.VanBanFileException;
import com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness;
import com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness;
import com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness;
import com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan;
import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.model.VanBanPhapQuy;
import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class VanBanPhapQuyUtils {
	
	public static final String FORMAT_DATE_PATTERN = "dd/MM/yyyy";
	
	public static Date parseStringToDate(String strDate) {
		
		Date date = null;
		
		if(Validator.isNotNull(strDate)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_PATTERN);
				
				date = sdf.parse(strDate);
			} catch(Exception e) {
				_log.error(e);
			}
		}
		
		return date;
	}
	
	public static long getLinkedLayoutId(HttpServletRequest request) {
		long linkedLayoutId = 0L;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences preferences = PortalUtil.getPreferences(request);

			String linkToLayoutUuid = GetterUtil.getString(preferences
					.getValue("portletSetupLinkToLayoutUuid", null));

			if (Validator.isNotNull(linkToLayoutUuid)) {
				Layout linkedLayout = LayoutLocalServiceUtil
						.getLayoutByUuidAndGroupId(linkToLayoutUuid,
								themeDisplay.getScopeGroupId(), false);

				linkedLayoutId = linkedLayout.getPlid();
			}
		} catch (Exception e) {
			if (!(e instanceof NoSuchLayoutException)) {
				_log.error(e);
			}
		}

		return linkedLayoutId;
	}

	public static String getLinhVuc(VanBanPhapQuy vbpq) {

		String name = StringPool.BLANK;

		LinhVucVanBan linhvuc = LinhVucVanBanBusiness.getLinhVucVanBan(vbpq
				.getLinhVucVanBan());

		if (Validator.isNotNull(linhvuc)) {
			name = linhvuc.getTen();
		}

		return name;
	}

	public static String getLoaiVanBan(VanBanPhapQuy vbpq) {

		String name = StringPool.BLANK;

		LoaiVanBan loaiVb = LoaiVanBanBusiness.getLoaiVanBan(vbpq
				.getLoaiVanBan());

		if (Validator.isNotNull(loaiVb)) {
			name = loaiVb.getTen();
		}

		return name;
	}

	public static String getCoQuanBanHanh(VanBanPhapQuy vbpq) {

		String name = StringPool.BLANK;

		CoQuanBanHanhVanBan coquanbanhanh = CoQuanBanHanhBusiness
				.getCoQuanBanHanh(vbpq.getCoQuanBanHanh());

		if (Validator.isNotNull(coquanbanhanh)) {
			name = coquanbanhanh.getTen();
		}

		return name;
	}

	public static String getExtensionFile(String fileName) {

		String extensionFile = StringPool.BLANK;
		
		if (StringUtil.endsWith(fileName, ".rar")
				|| StringUtil.endsWith(fileName, ".RAR")) {
			extensionFile = "RAR";
		}
		if (StringUtil.endsWith(fileName, ".rip")
				|| StringUtil.endsWith(fileName, ".ZIP")) {
			extensionFile = "ZIP";
		}
		
		if (StringUtil.endsWith(fileName, ".pdf")
				|| StringUtil.endsWith(fileName, ".PDF")) {
			extensionFile = "PDF";
		}

		if (StringUtil.endsWith(fileName, ".doc")
				|| StringUtil.endsWith(fileName, ".DOC")) {
			extensionFile = "DOC";
		}

		if (StringUtil.endsWith(fileName, ".docx")
				|| StringUtil.endsWith(fileName, ".DOCX")) {
			extensionFile = "DOC";
		}

		if (StringUtil.endsWith(fileName, ".xls")
				|| StringUtil.endsWith(fileName, ".XLS")) {
			extensionFile = "XLS";
		}

		if (StringUtil.endsWith(fileName, ".xlsx")
				|| StringUtil.endsWith(fileName, ".XLSX")) {
			extensionFile = "XLS";
		}

		return extensionFile;
	}

	public static boolean validateFile(String fileName,
			byte[] vanBanFileBytes)
			throws VanBanFileException {

		boolean flag = false;

		String[] validFileExtensions = PortletPropsValues.VAN_BAN_FILE_EXTENSIONS;

		// Validate upload file extension
		for (int i = 0; i < validFileExtensions.length; i++) {

			String validExtension = validFileExtensions[i].toLowerCase();
			//System.out.println("###################################### " + validFileExtensions[i] + "|" + fileName);
			if (StringUtil.endsWith(fileName, validExtension)) {
				//System.out.println("###################################### " + StringUtil.endsWith(fileName, validExtension));
				flag = true;
				break;
			}
		}

		if (!flag) {

			throw new VanBanFileException();
		}

		long fileMaxSize = PortletPropsValues.VAN_BAN_FILE_MAX_SIZE;

		// Validate upload file size
		if (vanBanFileBytes != null) {

			if(vanBanFileBytes.length > 0 && fileMaxSize > 0 && vanBanFileBytes.length > fileMaxSize) {
				flag = false;
	
				throw new VanBanFileException();
			}
		}

		return flag;
	}

	public static String getFriendlyFileName(String fileName) {

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
				formatedFileName = formatedFileName.substring(1,
						formatedFileName.length());
			}

			if (formatedFileName.endsWith("-")) {
				formatedFileName = formatedFileName.substring(0,
						formatedFileName.length() - 1);
			}
		}

		return formatedFileName;
	}
	
	/**
	 * Lay folderId dung de luu file bao cao, dua vao nam bao cao
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public static long getFolderId(long userId, long groupId) {
		
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);

		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		String nameFolder = String.valueOf(currentYear) + "_" + String.valueOf(currentMonth);
		
		long folderId = 0;
		boolean addFolder = false;
		DLFolder dlFolder = null;
		
		try {
			dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, 0, nameFolder);
		} catch(Exception e) {
			if(e instanceof NoSuchFolderException) {
				addFolder = true;
			} else {
				_log.error(e);
			}
		}
		
		if(addFolder) {
			try {
				ServiceContext serviceContext = new ServiceContext();
				
				serviceContext.setAddGroupPermissions(true);
				serviceContext.setAddGuestPermissions(true);
				
				dlFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId,
						groupId, true, 0, nameFolder,
					StringPool.BLANK, true, serviceContext);
			} catch(PortalException e) {
				_log.error(e);
			} catch(SystemException e) {
				_log.error(e);
			}
		}
		
		if(dlFolder != null) {
			folderId = dlFolder.getFolderId();
		}
		
		return folderId;
	}
	
	public static List<Group> getSiteAvailables(ThemeDisplay themeDisplay) {
		List<Group> sites = new ArrayList<Group>();
		
		try {
			LinkedHashMap<String, Object> groupParams =
				new LinkedHashMap<String, Object>();

			groupParams.put("site", Boolean.TRUE);
			groupParams.put("active", Boolean.TRUE);

			sites = GroupLocalServiceUtil.search(themeDisplay.getCompanyId(), groupParams, 0, 50);
		} catch(SystemException e) {
			_log.error(e);
		}
		
		return sites;
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

	private static String replaceMsWordCharacters(String content) {

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

			StringBuilder sb = new StringBuilder(s.length() + 5
					* newSub.length());

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

	private static final String UTF_8_STR = "ýỳỵỷỹáảàãạăắẳằẵặâấẩầẫậéẻèẽẹêếểềễệíỉìĩịóỏòõọôốổồỗộơớởờỡợúủùũụưứửừữựđ";

	private static final String UTF_8_REPLACE_STR = "yyyyyaaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuud";

	private static final char[] SPECIAL_CHARS = new char[] { ' ', ',', '\\',
			'\'', '\"', '(', ')', ':', '/', '^', '|', '{', '}', '?', '#', '@',
			'+', '*', '&', '<', '>', '=', '~', ';', '$', '%', '.', '!', '[',
			']', '!', '`' };

	private static final String[] _MS_WORD_UNICODE = new String[] { "\u00ae",
			"\u2019", "\u201c", "\u201d" };

	private static final String[] _MS_WORD_HTML = new String[] { "&reg;",
			StringPool.APOSTROPHE, StringPool.QUOTE, StringPool.QUOTE };

	private static final Log _log = LogFactoryUtil
			.getLog(VanBanPhapQuyUtils.class);
}

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

package com.viettel.portal.vbpq.admin.search;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.viettel.portal.vbpq.util.VanBanPhapQuyUtils;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletRequest;

/**
 * @author ChucHV
 */
public class VanBanDisplayTerms extends DisplayTerms {

	public static final String GROUP_ID = "groupId";
	
	public static final String CO_QUAN_BAN_HANH_ID = "coQuanBanHanhId";
	
	public static final String LINH_VUC_VAN_BAN_ID = "linhVucVanBanId";
	
	public static final String LOAI_VAN_BAN_ID = "loaiVanBanId";
	
	public static final String START_DATE = "startDate";
	
	public static final String END_DATE = "endDate";
	
	public static final String STATUS = "status";
	
	public VanBanDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Date now = new Date();

		Calendar startCalendar = Calendar.getInstance();
		startCalendar.set(Calendar.DATE, 1);
		startCalendar.set(Calendar.MONTH, 0);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat(VanBanPhapQuyUtils.FORMAT_DATE_PATTERN);
		
		groupId = ParamUtil.getLong(portletRequest, GROUP_ID, themeDisplay.getScopeGroupId());
		
		coQuanBanHanhId = ParamUtil.getLong(portletRequest, CO_QUAN_BAN_HANH_ID);
		
		if(coQuanBanHanhId > 0) {
			setCoQuanBanHanhIds(new long[]{coQuanBanHanhId});
		} else {
			setCoQuanBanHanhIds(null);
		}
		
		linhVucVanBanId = ParamUtil.getLong(portletRequest, LINH_VUC_VAN_BAN_ID);
		
		if(linhVucVanBanId > 0) {
			setLinhVucVanBanIds(new long[]{linhVucVanBanId});
		} else {
			setLinhVucVanBanIds(null);
		}
		
		loaiVanBanId = ParamUtil.getLong(portletRequest, LOAI_VAN_BAN_ID);
		
		if(loaiVanBanId > 0) {
			setLoaiVanBanIds(new long[]{loaiVanBanId});
		} else {
			setLoaiVanBanIds(null);
		}
		
		startDate = ParamUtil.getString(portletRequest, START_DATE, sdf.format(startCalendar.getTime()));
		
		startDateObj = VanBanPhapQuyUtils.parseStringToDate(startDate);
		
		endDate = ParamUtil.getString(portletRequest, END_DATE, sdf.format(endCalendar.getTime()));
		
		endDateObj = VanBanPhapQuyUtils.parseStringToDate(endDate);
		
		status = ParamUtil.getInteger(portletRequest, STATUS, -1);
		
		if(status < 0) {
			setStatusObj(null);
		} else {
			setStatusObj(status);
		}
	}
	
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	public Date getEndDateObj() {
		return endDateObj;
	}

	public void setEndDateObj(Date endDateObj) {
		this.endDateObj = endDateObj;
	}

	public Date getStartDateObj() {
		return startDateObj;
	}

	public void setStartDateObj(Date startDateObj) {
		this.startDateObj = startDateObj;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getCoQuanBanHanhId() {
		return coQuanBanHanhId;
	}

	public void setCoQuanBanHanhId(long coQuanBanHanhId) {
		this.coQuanBanHanhId = coQuanBanHanhId;
	}

	public long getLinhVucVanBanId() {
		return linhVucVanBanId;
	}

	public void setLinhVucVanBanId(long linhVucVanBanId) {
		this.linhVucVanBanId = linhVucVanBanId;
	}

	public long getLoaiVanBanId() {
		return loaiVanBanId;
	}

	public void setLoaiVanBanId(long loaiVanBanId) {
		this.loaiVanBanId = loaiVanBanId;
	}

	public Integer getStatusObj() {
		return statusObj;
	}

	public void setStatusObj(Integer statusObj) {
		this.statusObj = statusObj;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long[] getCoQuanBanHanhIds() {
		return coQuanBanHanhIds;
	}

	public void setCoQuanBanHanhIds(long[] coQuanBanHanhIds) {
		this.coQuanBanHanhIds = coQuanBanHanhIds;
	}

	public long[] getLinhVucVanBanIds() {
		return linhVucVanBanIds;
	}

	public void setLinhVucVanBanIds(long[] linhVucVanBanIds) {
		this.linhVucVanBanIds = linhVucVanBanIds;
	}

	public long[] getLoaiVanBanIds() {
		return loaiVanBanIds;
	}

	public void setLoaiVanBanIds(long[] loaiVanBanIds) {
		this.loaiVanBanIds = loaiVanBanIds;
	}

	private long groupId;
	private long coQuanBanHanhId;
	private long linhVucVanBanId;
	private long loaiVanBanId;
	private String startDate;
	private Date startDateObj;
	private String endDate;
	private Date endDateObj;
	private int status;
	private Integer statusObj;
	private long[] coQuanBanHanhIds;
	private long[] linhVucVanBanIds;
	private long[] loaiVanBanIds;
}
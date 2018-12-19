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

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.viettel.portal.vbpq.model.VanBanPhapQuy;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author ChucHV
 */
public class VanBanSearch extends SearchContainer<VanBanPhapQuy> {

	public VanBanSearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		this(portletRequest, DEFAULT_CUR_PARAM, iteratorURL);
	}

	public VanBanSearch(
		PortletRequest portletRequest, String curParam,
		PortletURL iteratorURL) {

		super(
			portletRequest, new VanBanDisplayTerms(portletRequest),
			new VanBanDisplayTerms(portletRequest), curParam,
			DEFAULT_DELTA, iteratorURL, null, null);

		VanBanDisplayTerms displayTerms =
			(VanBanDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.GROUP_ID,
			String.valueOf(displayTerms.getGroupId()));
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.CO_QUAN_BAN_HANH_ID,
			String.valueOf(displayTerms.getCoQuanBanHanhId()));
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.LINH_VUC_VAN_BAN_ID,
			String.valueOf(displayTerms.getLinhVucVanBanId()));
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.LOAI_VAN_BAN_ID,
			String.valueOf(displayTerms.getLoaiVanBanId()));
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.STATUS,
			String.valueOf(displayTerms.getStatus()));
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.START_DATE,
			displayTerms.getStartDate());
		
		iteratorURL.setParameter(
			VanBanDisplayTerms.END_DATE,
			displayTerms.getEndDate());

		String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
		String orderByType = ParamUtil.getString(portletRequest, "orderByType");

		OrderByComparator orderByComparator = getOrderByComparator(
			orderByCol, orderByType);

		setOrderByCol(orderByCol);
		setOrderByType(orderByType);
		setOrderByComparator(orderByComparator);
	}

	//TODO:
	protected OrderByComparator getOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		

		return orderByComparator;
	}

}
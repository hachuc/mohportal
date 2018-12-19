
package com.viettel.portal.banner.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class BannerDisplayTerms extends DisplayTerms{

	public static final String BANNER_NAME = "bannerName";
	/**
	 * @param portletRequest
	 */
	public BannerDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		bannerName = ParamUtil.getString(portletRequest, BANNER_NAME);
	}

	public String getName() {

		return bannerName;
	}
	
	protected String bannerName;
}

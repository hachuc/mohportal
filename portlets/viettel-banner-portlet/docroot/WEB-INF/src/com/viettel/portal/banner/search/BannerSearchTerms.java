package com.viettel.portal.banner.search;

import javax.portlet.PortletRequest;

import com.viettel.portal.banner.util.BannerUtil;

public class BannerSearchTerms extends BannerDisplayTerms {

	/**
	 * @param portletRequest
	 */
	public BannerSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		bannerName = BannerUtil.getLike(portletRequest, BANNER_NAME);
	}
}

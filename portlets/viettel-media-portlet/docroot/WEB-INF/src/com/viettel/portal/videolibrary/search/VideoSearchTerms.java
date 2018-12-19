package com.viettel.portal.videolibrary.search;

import javax.portlet.PortletRequest;

import com.viettel.portal.videolibrary.util.VideoUtil;

public class VideoSearchTerms extends VideoDisplayTerms {

	/**
	 * @param portletRequest
	 */
	public VideoSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);

		videoName = VideoUtil.getLike(portletRequest, VIDEO_NAME);
	}
}

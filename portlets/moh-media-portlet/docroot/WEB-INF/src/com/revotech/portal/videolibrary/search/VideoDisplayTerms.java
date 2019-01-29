
package com.revotech.portal.videolibrary.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class VideoDisplayTerms extends DisplayTerms{

	public static final String VIDEO_NAME = "videoName";
	/**
	 * @param portletRequest
	 */
	public VideoDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		videoName = ParamUtil.getString(portletRequest, VIDEO_NAME);
	}

	public String getName() {

		return videoName;
	}
	
	protected String videoName;
}

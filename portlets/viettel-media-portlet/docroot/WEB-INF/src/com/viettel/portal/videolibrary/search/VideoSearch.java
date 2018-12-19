
package com.viettel.portal.videolibrary.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.viettel.portal.videolibrary.model.VLVideo;
import com.viettel.portal.videolibrary.util.VideoUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class VideoSearch extends SearchContainer<VLVideo>{

	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";

	public VideoSearch(PortletRequest portletRequest,PortletURL iteratorURL){

		super(portletRequest, new VideoDisplayTerms(portletRequest), new VideoSearchTerms(portletRequest),
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		VideoDisplayTerms displayTerms = (VideoDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(VideoDisplayTerms.VIDEO_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = VideoUtil.getVideoOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static final String VIDEO_ADMIN_PORTLET_NAMESPACE = "_1_WAR_viettelmediaportlet";

	private static Log _log = LogFactoryUtil.getLog(VideoSearch.class);
}

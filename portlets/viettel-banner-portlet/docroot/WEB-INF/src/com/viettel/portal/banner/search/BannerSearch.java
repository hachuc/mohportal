
package com.viettel.portal.banner.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.viettel.portal.banner.model.Banner;
import com.viettel.portal.banner.util.BannerUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class BannerSearch extends SearchContainer<Banner>{

	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";

	public BannerSearch(PortletRequest portletRequest,PortletURL iteratorURL){

		super(portletRequest, new BannerDisplayTerms(portletRequest), new BannerSearchTerms(portletRequest),
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		BannerDisplayTerms displayTerms = (BannerDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(BannerDisplayTerms.BANNER_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(BANNER_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(BANNER_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(BANNER_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(BANNER_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = BannerUtil.getVideoOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static final String BANNER_ADMIN_PORTLET_NAMESPACE = "_1_WAR_viettelbannerportlet";

	private static Log _log = LogFactoryUtil.getLog(BannerSearch.class);
}

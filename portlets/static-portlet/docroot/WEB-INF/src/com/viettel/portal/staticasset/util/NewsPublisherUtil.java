package com.viettel.portal.staticasset.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.permission.LayoutPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.NoSuchCategoryPropertyException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

public class NewsPublisherUtil {
	public static AssetEntryQuery getAssetEntryQuery(PortletPreferences preferences, long[] groupIds, HttpServletRequest req) {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

		assetEntryQuery.setGroupIds(groupIds);

		try {
			String end = (String)req.getAttribute("page_end");
			
			String start = (String)req.getAttribute("page_start");
		
			String[] tagNameValues = preferences.getValues("tagNameValues", new String[0]);

			String[] categoryIdValues = preferences.getValues("categoryIdValues", new String[0]);

			String orderByColumn1 = GetterUtil.getString(preferences.getValue("orderByColumn1", "publishDate"));

			String orderByColumn2 = GetterUtil.getString(preferences.getValue("orderByColumn2", "title"));
			
			String displayStyle = GetterUtil.getString(preferences.getValue("displayStyle", null));
			
			String orderByType1 = GetterUtil.getString(preferences.getValue("orderByType1", "desc"));

			String orderByType2 = GetterUtil.getString(preferences.getValue("orderByType2", "asc"));

			int displayItem = GetterUtil.getInteger(preferences.getValue("displayItem", null), 5);

			boolean tagQueryContains = GetterUtil.getBoolean(preferences.getValue("tagQueryContains", null), true);

			boolean tagQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("tagQueryAndOperator", null), false);

			boolean categoryQueryContains = GetterUtil.getBoolean(preferences.getValue("categoryQueryContains", null), true);

			boolean categoryQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("categoryQueryAndOperator", null), false);

			setAssetEntryQuery(assetEntryQuery, groupIds, tagNameValues, categoryIdValues, tagQueryContains, tagQueryAndOperator, categoryQueryContains, categoryQueryAndOperator);

			assetEntryQuery.setClassName(JournalArticle.class.getName());
			//assetEntryQuery.set
			assetEntryQuery.setOrderByCol1(orderByColumn1);
			assetEntryQuery.setOrderByType1(orderByType1);
			assetEntryQuery.setOrderByCol2(orderByColumn2);
			assetEntryQuery.setOrderByType2(orderByType2);
			
			if (start !=null && end !=null && displayStyle.equals("abstract")){
				int start1 = Integer.parseInt(start);
				
				int end1 = Integer.parseInt(end);
				
				assetEntryQuery.setStart(start1);
				assetEntryQuery.setEnd(end1);
			} else{
				assetEntryQuery.setStart(0);
				assetEntryQuery.setEnd(displayItem);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return assetEntryQuery;
	}
	
	public static void setAssetEntryQuery(AssetEntryQuery assetEntryQuery, long[] groupIds, String[] tagNameValues, String[] categoryIdValues, boolean tagQueryContains, boolean tagQueryAndOperator, boolean categoryQueryContains, boolean categoryQueryAndOperator) throws PortalException, SystemException {

		if (assetEntryQuery != null) {
			long[] allAssetCategoryIds = new long[0];
			long[] anyAssetCategoryIds = new long[0];
			long[] notAllAssetCategoryIds = new long[0];
			long[] notAnyAssetCategoryIds = new long[0];

			String[] allAssetTagNames = new String[0];
			String[] anyAssetTagNames = new String[0];
			String[] notAllAssetTagNames = new String[0];
			String[] notAnyAssetTagNames = new String[0];

			long[] assetCategoryIds = GetterUtil.getLongValues(categoryIdValues);

			if (categoryQueryContains && categoryQueryAndOperator) {
				allAssetCategoryIds = assetCategoryIds;
			} else if (categoryQueryContains && !categoryQueryAndOperator) {
				anyAssetCategoryIds = assetCategoryIds;
			} else if (!categoryQueryContains && categoryQueryAndOperator) {
				notAllAssetCategoryIds = assetCategoryIds;
			} else {
				notAnyAssetCategoryIds = assetCategoryIds;
			}

			if (tagQueryContains && tagQueryAndOperator) {
				allAssetTagNames = tagNameValues;
			} else if (tagQueryContains && !tagQueryAndOperator) {
				anyAssetTagNames = tagNameValues;
			} else if (!tagQueryContains && tagQueryAndOperator) {
				notAllAssetTagNames = tagNameValues;
			} else {
				notAnyAssetTagNames = tagNameValues;
			}

			assetEntryQuery.setAllCategoryIds(allAssetCategoryIds);
			assetEntryQuery.setAnyCategoryIds(anyAssetCategoryIds);
			assetEntryQuery.setNotAllCategoryIds(notAllAssetCategoryIds);
			assetEntryQuery.setNotAnyCategoryIds(notAnyAssetCategoryIds);

			long[] allAssetTagIds = AssetTagLocalServiceUtil.getTagIds(groupIds, allAssetTagNames);
			long[] anyAssetTagIds = AssetTagLocalServiceUtil.getTagIds(groupIds, anyAssetTagNames);
			long[] notAllAssetTagIds = AssetTagLocalServiceUtil.getTagIds(groupIds, notAllAssetTagNames);
			long[] notAnyAssetTagIds = AssetTagLocalServiceUtil.getTagIds(groupIds, notAnyAssetTagNames);

			assetEntryQuery.addAllTagIdsArray(allAssetTagIds);
			assetEntryQuery.addNotAllTagIdsArray(notAllAssetTagIds);
			assetEntryQuery.setAnyTagIds(anyAssetTagIds);
			assetEntryQuery.setNotAnyTagIds(notAnyAssetTagIds);
		}
	}
	
	private static Log	_log	= LogFactoryUtil.getLog(NewsPublisherUtil.class.getName());
}

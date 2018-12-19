package com.viettel.portal.vbpq.util;

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

	public static String buildLayoutsToSelect(String selLayoutUuid, boolean showHiddenPages, ThemeDisplay themeDisplay) {

		long groupId = themeDisplay.getScopeGroupId();

		List<Layout> layoutsPublic = new ArrayList<Layout>();
		try {
			layoutsPublic = LayoutLocalServiceUtil.getLayouts(groupId, false);
		} catch (Exception e) {
			_log.warn(e);
		}
		List<Layout> rootLayouts = new ArrayList<Layout>();

		rootLayouts.addAll(layoutsPublic);

		StringBuilder sb = new StringBuilder();

		buildLayoutsToSelect(selLayoutUuid, rootLayouts, new ArrayList<String>(), showHiddenPages, 0, themeDisplay, sb);

		return sb.toString();
	}
	
	
	public static String buildLayoutsToSelect1(String selLayoutUuid, boolean showHiddenPages, ThemeDisplay themeDisplay) {

		long groupId = themeDisplay.getScopeGroupId();

		List<Layout> layoutsPublic = new ArrayList<Layout>();
		try {
			layoutsPublic = LayoutLocalServiceUtil.getLayouts(groupId, false);
		} catch (Exception e) {
			_log.warn(e);
		}
		List<Layout> rootLayouts = new ArrayList<Layout>();

		rootLayouts.addAll(layoutsPublic);

		StringBuilder sb = new StringBuilder();

		buildLayoutsToSelect(selLayoutUuid, rootLayouts, new ArrayList<String>(), showHiddenPages, 0, themeDisplay, sb);

		return sb.toString();
	}

	public static void buildLayoutsToSelect(String selLayoutUuid, List<Layout> layouts, List<String> hasAppend, boolean showHiddenPages, int curDepth, ThemeDisplay themeDisplay, StringBuilder sb) {

		if (layouts.size() == 0) {
			return;
		}

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		for (int i = 0; i < layouts.size(); i++) {
			Layout curLayout = layouts.get(i);
			if (hasAppend.contains(curLayout.getUuid())) {
				continue;
			}
			try {
				if ((showHiddenPages || !curLayout.isHidden()) && LayoutPermissionUtil.contains(permissionChecker, curLayout, ActionKeys.VIEW)) {
					String seld = StringPool.BLANK;

					if (curLayout.getUuid().equals(selLayoutUuid)) {
						seld = "selected";
					}

					String name = curLayout.getName(themeDisplay.getLocale());

					for (int j = 0; j < curDepth; j++) {
						name = "-&nbsp;" + name;
					}

					sb.append("<option " + seld + " value=\"" + curLayout.getUuid() + "\">");
					sb.append(name);
					sb.append("</option>");

					hasAppend.add(curLayout.getUuid());
					List<Layout> childrens = curLayout.getChildren();

					buildLayoutsToSelect(selLayoutUuid, childrens, hasAppend, showHiddenPages, curDepth + 1, themeDisplay, sb);
				}
			} catch (Exception e) {
				_log.warn(e);
			}
		}
	}

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

	/**
	 * @todo LAY GIA TRI THUOC TINH DONG CUA CATEGORY THEO PROPERTY-KEY
	 * @author TrungNT
	 * @date Nov 17, 2014
	 * @return String
	 * @param categoryId
	 *            Id cua Category can lay thuoc tinh
	 * @param propertyKey
	 *            Ten thuoc tinh dong cua Category
	 * @param defaultValue
	 *            Gia tri mac dinh tra ve khi khong ton tai thuoc tinh tuong ung
	 *            voi propertyKey
	 * @return
	 */
	public static String getCategoryPropertyValue(long categoryId, String propertyKey, String defaultValue) {
		try {
			// Lay danh sach tat ca cac thuoc tinh dong cua Category theo
			// categoryId
			List<AssetCategoryProperty> propertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);

			if (propertyList.isEmpty()) {
				// Truong hop Category khong co thuoc tinh dong thi method se
				// tra
				// ve gia tri mac dinh

				return defaultValue;
			} else {
				String propertyValue = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey).getValue();

				return propertyValue;
			}
		} catch (Exception e) {
			if (e instanceof NoSuchCategoryPropertyException) {
				// Truong hop ko tim thay thuoc tinh tuong ung voi PropertyKey
				// truyen vao
				_log.info("[" + NewsPublisherUtil.class.getName() + "]" + "No such categoryProperty exist with propertyKey = " + propertyKey);
			} else {
				_log.error(e);
			}
			return defaultValue;
		}
	}

	/**
	 * @todo LAY NOI DUNG MO TA NGAN (ABSTRACT) CUA TIN BAI
	 * @author TrungNT
	 * @date Nov 17, 2014
	 * @return String
	 * @param request
	 * @param classPK
	 *            classPK cua Asset
	 * @param abstractLength
	 * @return
	 */
	public static String getContentSummary(HttpServletRequest request, long classPK, int abstractLength) {
		String contentSummary = StringPool.BLANK;

		try {
			String languageId = LanguageUtil.getLanguageId(request);

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

			JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(), articleResource.getArticleId(), null, null, languageId, themeDisplay);

			contentSummary = articleDisplay.getDescription();

			if (Validator.equals(contentSummary, StringPool.BLANK)) {
				contentSummary = StringUtil.shorten(HtmlUtil.stripHtml(articleDisplay.getContent()), abstractLength);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return contentSummary;
	}

	public static List<AssetEntry> getAssetEntries(AssetEntryQuery entryQuery) {

		List<AssetEntry> assetEntries = new ArrayList<AssetEntry>();

		try {
			assetEntries = AssetEntryLocalServiceUtil.getEntries(entryQuery);
		} catch (Exception e) {
			_log.error(e);
		}

		return assetEntries;
	}

	public static int getAssetEntriesCount(AssetEntryQuery entryQuery) {

		int assetEntriesCount = 0;

		try {
			assetEntriesCount = AssetEntryLocalServiceUtil.getEntriesCount(entryQuery);
		} catch (Exception e) {
			_log.error(e);
		}

		return assetEntriesCount;
	}

	public static List<String[]> getCategoriesName(String[] categoryIds) {
		List<String[]> categoryNames = new ArrayList<String[]>();

		try {
			for (String categoryId : categoryIds) {
				long categoryId_ = GetterUtil.getLong(categoryId);

				if (categoryId_ > 0) {
					AssetCategory category = AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId_);

					if (category != null) {
						categoryNames.add(new String[] { String.valueOf(categoryId_), category.getName() });
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return categoryNames;
	}

	/**
	 * Get layoutId that configured in look and feel
	 * 
	 * @param request
	 * @return
	 */
	public static long getLinkedLayoutId(HttpServletRequest request) {
		long linkedLayoutId = 0L;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences preferences = PortalUtil.getPreferences(request);

			String linkToLayoutUuid = GetterUtil.getString(preferences.getValue("portletSetupLinkToLayoutUuid", null));

			if (Validator.isNotNull(linkToLayoutUuid)) {
				Layout linkedLayout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(linkToLayoutUuid, themeDisplay.getScopeGroupId(), false);

				linkedLayoutId = linkedLayout.getPlid();
			}
		} catch (Exception e) {
			if (!(e instanceof NoSuchLayoutException)) {
				_log.error(e);
			}
		}

		return linkedLayoutId;
	}

	public static long getLinkedLayoutId(HttpServletRequest request, String layoutUuid) {
		long linkedLayoutId = 0L;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			if (Validator.isNotNull(layoutUuid)) {
				Layout linkedLayout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(layoutUuid, themeDisplay.getScopeGroupId(), false);

				linkedLayoutId = linkedLayout.getPlid();
			}
		} catch (Exception e) {
			if (!(e instanceof NoSuchLayoutException)) {
				_log.error(e);
			}
		}

		return linkedLayoutId;
	}

	

	public static List<Group> getSiteAvailables(ThemeDisplay themeDisplay) {
		List<Group> sites = new ArrayList<Group>();

		try {
			LinkedHashMap<String, Object> groupParams = new LinkedHashMap<String, Object>();

			groupParams.put("site", Boolean.TRUE);
			groupParams.put("active", Boolean.TRUE);

			sites = GroupLocalServiceUtil.search(themeDisplay.getCompanyId(), groupParams, 0, 50);

			// add sites global
			Group globalGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyGroupId());
			sites.add(globalGroup);
		} catch (Exception e) {
			_log.error(e);
		}

		return sites;
	}
	
	public static boolean isNewArticle(Date date){
		long time = new Date().getTime() - date.getTime();
		return time <= 3 * 24 * 60 * 60 * 1000;
	}

	private static Log	_log	= LogFactoryUtil.getLog(NewsPublisherUtil.class.getName());
}

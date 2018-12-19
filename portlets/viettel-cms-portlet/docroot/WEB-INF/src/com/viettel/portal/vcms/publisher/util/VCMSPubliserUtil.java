package com.viettel.portal.vcms.publisher.util;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.permission.LayoutPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.viettel.portal.vcms.publisher.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
//import com.viettel.portal.vcms.service.persistence.ContentQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionLocalService;
import com.viettel.portal.vcms.service.DistributionLocalServiceUtil;
import com.viettel.portal.vcms.util.CmsConstants;

public class VCMSPubliserUtil {
	
	private static boolean showPrivatePage = false;
	public static String buildLayoutsToSelect(String selLayoutUuid, boolean showHiddenPages, ThemeDisplay themeDisplay) {
		return buildLayoutsToSelect(selLayoutUuid, showHiddenPages, themeDisplay, showPrivatePage);
	}
	public static String buildLayoutsToSelect1(String selLayoutUuid, boolean showHiddenPages, ThemeDisplay themeDisplay){
		return buildLayoutsToSelect1(selLayoutUuid, showHiddenPages, themeDisplay, showPrivatePage);
	}
	public static String buildLayoutsToSelect(String selLayoutUuid, boolean showHiddenPages, ThemeDisplay themeDisplay, boolean showPrivateLaout){
		long groupId = themeDisplay.getScopeGroupId();

		List<Layout> layoutsPublic = new ArrayList<Layout>();
		try {
			layoutsPublic = LayoutLocalServiceUtil.getLayouts(groupId, showPrivateLaout);
		} catch (Exception e) {
			_log.warn(e);
		}
		List<Layout> rootLayouts = new ArrayList<Layout>();

		rootLayouts.addAll(layoutsPublic);

		StringBuilder sb = new StringBuilder();

		buildLayoutsToSelect(selLayoutUuid, rootLayouts, new ArrayList<String>(), showHiddenPages, 0, themeDisplay, sb);

		return sb.toString();
	}	
	
	public static String buildLayoutsToSelect1(String selLayoutUuid, boolean showHiddenPages, ThemeDisplay themeDisplay, boolean showPrivateLaout) {

		long groupId = themeDisplay.getScopeGroupId();

		List<Layout> layoutsPublic = new ArrayList<Layout>();
		try {
			layoutsPublic = LayoutLocalServiceUtil.getLayouts(groupId, showPrivateLaout);
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
	
	public static List<Content> getContents(long groupId, long categoryIds,int version, int status, int start, int end) throws PortalException, SystemException{
		return ContentLocalServiceUtil.findByG_CA_V_S(groupId, categoryIds, version, status, start, end);
	}
	
	public static int getContentCount(long groupId, long categoryIds, int version, int status) throws PortalException, SystemException{
		return ContentLocalServiceUtil.countByG_CA_V_S(groupId, categoryIds, version, status);
	}
	
	public static List<Distribution> getContents(long groupId, long[] categoryIds, int start, int end) throws PortalException, SystemException{
		return DistributionLocalServiceUtil.getByGroupAndCategory(groupId, categoryIds, start, end);
	}
	
	public static List<Distribution> getContentsByDate(long groupId, long[] categoryIds, String publishDate, int start, int end) throws PortalException, SystemException{
		return DistributionLocalServiceUtil.findByPubishedDate(groupId, categoryIds, publishDate, start, end);
	}
	
	public static int countByPublishedDate(long groupId, long[] categoryIds, String publishedDate) throws PortalException, SystemException{
		return DistributionLocalServiceUtil.countByPubishedDate(groupId, categoryIds, publishedDate);
	}
	
	public static int getDistributionCount(long groupId, long[] categoryIds) throws PortalException, SystemException{
		return DistributionLocalServiceUtil.getCountByGroupAndCategory(groupId, categoryIds);
	}

	public static String getViewCommentURL(HttpServletRequest request, long distributionId, Layout layout) {

	
		String viewContentURL = StringPool.BLANK;
		LiferayPortletURL viewFullContentURL = null;

		if (layout != null) {
			try {
				
				String assetPublisherPortletId = PortletKeys.VCMS_COMMENT_PORTLET_NAME;

				if (assetPublisherPortletId != null) {
					viewFullContentURL = PortletURLFactoryUtil.create(request, assetPublisherPortletId, layout.getPlid(), PortletRequest.RENDER_PHASE);

					viewFullContentURL.setWindowState(WindowState.NORMAL);

					viewFullContentURL.setPortletMode(PortletMode.VIEW);


					viewFullContentURL.setParameter("mvcPath", "/html/admin/comment/view.jsp");
					
					viewFullContentURL.setParameter("distributionId", String.valueOf(distributionId));
					
				}

			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (viewFullContentURL != null) {
			viewContentURL = viewFullContentURL.toString();
		}

		return viewContentURL;
	}
	public static String getViewCommentURL(HttpServletRequest request, PortletPreferences portletPreferences, ThemeDisplay themeDisplay, long distributionId, String linkToPage) throws SystemException {
		Layout linkedLayout = null;

		String linkedLayoutUuid = portletPreferences.getValue(linkToPage, StringPool.BLANK);
		if(Validator.isNotNull(linkedLayoutUuid)){
			linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(linkedLayoutUuid, themeDisplay.getScopeGroupId(), true);
		}
		
		String viewContentURL = StringPool.BLANK;
		LiferayPortletURL viewFullContentURL = null;

		if (linkedLayout != null) {
			try {
				
				String assetPublisherPortletId = PortletKeys.VCMS_COMMENT_PORTLET_NAME;

				if (assetPublisherPortletId != null) {
					viewFullContentURL = PortletURLFactoryUtil.create(request, assetPublisherPortletId, linkedLayout.getPlid(), PortletRequest.RENDER_PHASE);

					viewFullContentURL.setWindowState(WindowState.NORMAL);

					viewFullContentURL.setPortletMode(PortletMode.VIEW);


					viewFullContentURL.setParameter("mvcPath", "/html/admin/comment/view.jsp");
					
					viewFullContentURL.setParameter("distributionId", String.valueOf(distributionId));
					
				}

			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (viewFullContentURL != null) {
			viewContentURL = viewFullContentURL.toString();
		}

		return viewContentURL;
	}
	public static String getViewContentURL(HttpServletRequest request, Distribution dist, Layout layout) {

		long groupId = dist.getGroupId();

		String viewContentURL = StringPool.BLANK;
		LiferayPortletURL viewFullContentURL = null;

		if (dist != null && layout != null) {
			try {

				long distId = dist.getDistributionId();
				
				String assetPublisherPortletId = PortletKeys.VCMS_PUBLISHER;

				if (assetPublisherPortletId != null) {
					viewFullContentURL = PortletURLFactoryUtil.create(request, assetPublisherPortletId, layout.getPlid(), PortletRequest.RENDER_PHASE);

					viewFullContentURL.setWindowState(WindowState.NORMAL);

					viewFullContentURL.setPortletMode(PortletMode.VIEW);


					viewFullContentURL.setParameter("mvcPath", "/html/frontend/publisher/view_content.jsp");
					
					viewFullContentURL.setParameter("distId", String.valueOf(distId));
					
					Content content = ContentLocalServiceUtil.fecthLastestContent(groupId, dist.getContentId(), CmsConstants.PUBLISHED_NEWS, CmsConstants.FINAL_STATUS);
					
					if(Validator.isNotNull(content)){
						viewFullContentURL.setParameter("urlTitle", covertStringToURL(content.getTitle()));
					}
				}

			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (viewFullContentURL != null) {
			viewContentURL = viewFullContentURL.toString();
		}

		return viewContentURL;
	}
	
	public static String getViewContentURL(HttpServletRequest request, String distId, String title, Layout layout) {

		String viewContentURL = StringPool.BLANK;
		LiferayPortletURL viewFullContentURL = null;

		if (Validator.isNotNull(distId) && layout != null) {
			try {

				
				String assetPublisherPortletId = PortletKeys.VCMS_PUBLISHER;

				if (assetPublisherPortletId != null) {
					viewFullContentURL = PortletURLFactoryUtil.create(request, assetPublisherPortletId, layout.getPlid(), PortletRequest.RENDER_PHASE);

					viewFullContentURL.setWindowState(WindowState.NORMAL);

					viewFullContentURL.setPortletMode(PortletMode.VIEW);


					viewFullContentURL.setParameter("mvcPath", "/html/frontend/publisher/view_content.jsp");
					
					viewFullContentURL.setParameter("distId", distId);
					
					if(Validator.isNotNull(title)){
						viewFullContentURL.setParameter("urlTitle", covertStringToURL(title));
					}
				}

			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (viewFullContentURL != null) {
			viewContentURL = viewFullContentURL.toString();
		}

		return viewContentURL;
	}
	
	
	public static String getPrivatePageUrl(HttpServletRequest request, Layout layout, ThemeDisplay themeDisplay){
		String linkedLayoutURL = StringPool.BLANK;
		if(layout != null){
			
			linkedLayoutURL = "/group" +themeDisplay.getScopeGroup().getFriendlyURL() + layout.getFriendlyURL();
		}
		return linkedLayoutURL;
	}
	
	public static String viewPageUrl(HttpServletRequest request, Layout layout){
		String viewContentURL = StringPool.BLANK;
		LiferayPortletURL viewFullContentURL = null;
		if (layout != null) {
			try {
				
				String assetPublisherPortletId = PortletKeys.VCMS_PUBLISHER;

				if (assetPublisherPortletId != null) {
					viewFullContentURL = PortletURLFactoryUtil.create(request, assetPublisherPortletId, layout.getPlid(), PortletRequest.RENDER_PHASE);

					viewFullContentURL.setWindowState(WindowState.NORMAL);

					viewFullContentURL.setPortletMode(PortletMode.VIEW);
				}

			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (viewFullContentURL != null) {
			viewContentURL = viewFullContentURL.toString();
		}

		return viewContentURL;
	}
	public static String covertStringToURL(String str) {
	   try {
	       String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
	       Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	       return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
	   } catch (Exception e) {
	       e.printStackTrace(); 
	   }
	   return "";
	}
	
	public static String getRedirectUrl(HttpServletRequest request, PortletPreferences portletPreferences, ThemeDisplay themeDisplay, String linkToPage)throws PortalException, SystemException{
		Layout linkedLayout = null;

		String linkedLayoutUuid = portletPreferences.getValue(linkToPage, StringPool.BLANK);
		if(Validator.isNotNull(linkedLayoutUuid)){
			linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(linkedLayoutUuid, themeDisplay.getScopeGroupId(), true);
		}
		

		// @HUYMQ FIX RIENG CHO LONG BIEN: TIN CHI TIET NEU TRONG CAU HINH KHONG CO, SE TIM THEO CAU HINH "GIAO DIEN"
		// CON DANH SACH TIN VAN DE NGUYEN LAY CAU HINH TRONG PORTLET (linkedLayoutURL)

		if(linkedLayout == null) {
			String portletSetupLink = portletPreferences.getValue("portletSetupLinkToLayoutUuid", StringPool.BLANK);
			
			if(Validator.isNotNull(portletSetupLink)) {
				linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(portletSetupLink, themeDisplay.getScopeGroupId(), true);
			}
		}

		if(linkedLayout == null) {
			linkedLayout = themeDisplay.getLayout();
		}
		return getPrivatePageUrl(request, linkedLayout, themeDisplay);
	}
	private static Log	_log	= LogFactoryUtil.getLog(VCMSPubliserUtil.class.getName());
}

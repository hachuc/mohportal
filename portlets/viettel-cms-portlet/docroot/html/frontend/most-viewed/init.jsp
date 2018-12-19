<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@ page import="com.viettel.portal.vcms.model.Content"%>
<%@ include file="/html/frontend/init.jsp" %>

<%
	int itemDisplay = GetterUtil.getInteger(portletPreferences.getValue("itemDisplay", "10"));
	int filterByDate = GetterUtil.getInteger(portletPreferences.getValue("filterByDate", "30"));
	int titleLength = GetterUtil.getInteger(portletPreferences.getValue("titleLength", "100"));
	
	boolean showPublishDate = GetterUtil.getBoolean(portletPreferences.getValue("showPublishDate", String.valueOf(false)));
	boolean showViewCount = GetterUtil.getBoolean(portletPreferences.getValue("showViewCount", String.valueOf(false)));
	
	String layoutUuid = portletPreferences.getValue("layoutUuid", StringPool.BLANK);
	String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
	String[] categoryIds = portletPreferences.getValues("categoryIds", new String[0]);
	String displayStyle = portletPreferences.getValue("displayStyle", "list_title_style");
	long[] assetCategoryIds = GetterUtil.getLongValues(categoryIds);
	int[] filterByDates = new int[] {7, 10, 15, 20, 25, 30, 31 };
	Layout linkedLayout = null;
	
	String linkedLayoutURL = StringPool.BLANK;
	
	if(Validator.isNotNull(layoutUuid)){
	
		linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, themeDisplay.getScopeGroupId(), false);
	}
	if(linkedLayout != null){
		linkedLayoutURL = "/web" +themeDisplay.getScopeGroup().getFriendlyURL() + linkedLayout.getFriendlyURL();
	}

	if(linkedLayout == null) {
		String portletSetupLink = portletPreferences.getValue("portletSetupLinkToLayoutUuid", StringPool.BLANK);
		if(Validator.isNotNull(portletSetupLink)) {
			linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(portletSetupLink, themeDisplay.getScopeGroupId(), false);
		}
	}
	
	if(linkedLayout == null) {
		linkedLayout = themeDisplay.getLayout();
	}
%>
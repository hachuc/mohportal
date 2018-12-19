<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@ page import="com.viettel.portal.vcms.model.Content"%>
<%@ include file="/html/frontend/init.jsp" %>

<%
	int itemDisplay = GetterUtil.getInteger(portletPreferences.getValue("itemDisplay", "10"));
	int titleLength = GetterUtil.getInteger(portletPreferences.getValue("titleLength", "100"));
	//long selectedCategoryId = GetterUtil.getLong(portletPreferences.getValue("selectedCategoryId", "0"));
	
	String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", "abstract"));
	boolean showPublishDate = GetterUtil.getBoolean(portletPreferences.getValue("showPublishDate", String.valueOf(false)));
	String layoutUuid = portletPreferences.getValue("layoutUuid", StringPool.BLANK);
	String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);
	
	String[] categoryIds = portletPreferences.getValues("categoryIds", new String[0]);
	
	long[] assetCategoryIds = GetterUtil.getLongValues(categoryIds);
	//long[] categoryIds = new long[]{selectedCategoryId};
	
	Layout linkedLayout = null;
	
	String linkedLayoutURL = StringPool.BLANK;
	
	if(Validator.isNotNull(layoutUuid)){
	
		linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, themeDisplay.getScopeGroupId(), false);
	}
	//Local time zone   
	//SimpleDateFormat dateFormatLocal = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	if(linkedLayout != null){
		
		linkedLayoutURL = "/web" +themeDisplay.getScopeGroup().getFriendlyURL() + linkedLayout.getFriendlyURL();
	}
	
	// @HUYMQ FIX RIENG CHO LONG BIEN: TIN CHI TIET NEU TRONG CAU HINH KHONG CO, SE TIM THEO CAU HINH "GIAO DIEN"
	// CON DANH SACH TIN VAN DE NGUYEN LAY CAU HINH TRONG PORTLET (linkedLayoutURL)
	
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
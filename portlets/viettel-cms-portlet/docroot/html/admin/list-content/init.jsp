<%@ include file="/html/admin/init.jsp" %>

<%
String layoutUuid = portletPreferences.getValue("layoutUuid", StringPool.BLANK);
Layout linkedLayout = null;

String linkedLayoutURL = StringPool.BLANK;

if(Validator.isNotNull(layoutUuid)){
	linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, themeDisplay.getScopeGroupId(), true);
}
//Local time zone   
if(linkedLayout != null){	
	linkedLayoutURL = "/group" +themeDisplay.getScopeGroup().getFriendlyURL() + linkedLayout.getFriendlyURL();
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



%>
<%@ include file="/html/frontend/init.jsp" %>

<%
int itemDisplay = GetterUtil.getInteger(portletPreferences.getValue("itemDisplay", "10"));
int itemDisplayList = GetterUtil.getInteger(portletPreferences.getValue("itemDisplayList", "10"));
long selectedCategoryId = GetterUtil.getLong(portletPreferences.getValue("selectedCategoryId", "0"));

String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", "abstract"));
boolean showAuthor = GetterUtil.getBoolean(portletPreferences.getValue("showAuthor", String.valueOf(false)));
boolean showPublishDate = GetterUtil.getBoolean(portletPreferences.getValue("showPublishDate", String.valueOf(false)));
boolean showByDate = GetterUtil.getBoolean(portletPreferences.getValue("showByDate", String.valueOf(true)));
boolean showSocialBookmark = GetterUtil.getBoolean(portletPreferences.getValue("showSocialBookmark", String.valueOf(true)));
boolean allowDiscussion = GetterUtil.getBoolean(portletPreferences.getValue("allowDiscussion", String.valueOf(true)));
String paginationType = GetterUtil.getString(portletPreferences.getValue("paginationType", "none"));
String layoutUuid = portletPreferences.getValue("layoutUuid", StringPool.BLANK);
String portletTitle = portletPreferences.getValue("portletTitle", StringPool.BLANK);

long[] categoryIds = new long[]{selectedCategoryId};

Layout linkedLayout = null;

String linkedLayoutURL = StringPool.BLANK;

if(Validator.isNotNull(layoutUuid)){

	linkedLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, themeDisplay.getScopeGroupId(), false);
}

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
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.viettel.portal.photos.model.*"%>
<%@page import="com.viettel.portal.photos.service.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp"%>

<%
    HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
    int displayPage = 5;

    int photoDelta = 1;
    
    long totalPhoto = 0;
    
    long selectedCategoryId = -1;
    
    int curPhotoPage = GetterUtil.getInteger(httpRequest.getParameter("curPhotoPage"), 1);
    
    int start = (curPhotoPage - 1) * photoDelta;
    
    int totalPage = 1;
    
	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	String photoLibraryPortletResource = "photo_war_pointportalphotoportle";
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	String photoSearchKeyword = ParamUtil.getString(request, "keywords", StringPool.BLANK);
	
	long categoryId = ParamUtil.getLong(request, "categoryId", -1L);
	if(categoryId < 0){
		List<PCategory> categories = PCategoryLocalServiceUtil.findByGroup(groupId, 0, 1);
		if(categories != null && !categories.isEmpty()){
			categoryId = categories.get(0).getId();
		}else{
			categoryId = 0;
		}
	}
	selectedCategoryId = categoryId;	
	
	String styleTitle = portletPreferences.getValue("styleTitle", "");
	long numbersOfAlbumDisplay = Long.parseLong( portletPreferences.getValue("numbersOfAlbumDisplay", "-1"));
	long albumDisplay = Long.parseLong( portletPreferences.getValue("albumDisplay", "-1"));
	//String selectedPhotosId = portletPreferences.getValue("selectedPhotosId", "");
	String displayStyle = portletPreferences.getValue("displayStyle", "");
	boolean showViewMorePhotoLink = Boolean.parseBoolean( portletPreferences.getValue("showViewMorePhotoLink", "false"));
	boolean useCustomVideoFrameSize = Boolean.parseBoolean( portletPreferences.getValue("useCustomVideoFrameSize", "false"));
	String widthUnit = portletPreferences.getValue("widthUnit", "px");
	String heightUnit = portletPreferences.getValue("heightUnit", "px");
	int videoFrameWidth = GetterUtil.getInteger(portletPreferences.getValue("videoFrameWidth", "399"));
	int videoFrameHeight = GetterUtil.getInteger(portletPreferences.getValue("videoFrameHeight", "260"));
	
	long photoPageLayoutId = Long.parseLong( portletPreferences.getValue("photoPageLayoutId", "0"));
	
	String keywords = ParamUtil.getString(request, "keywords", StringPool.BLANK);
%>


<%!
	private static Log _log = LogFactory.getLog("html.videolibrary.portlet");
%>
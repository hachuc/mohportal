
<%@page import="com.viettel.portal.vbpq.permission.AdminPermission"%>
<%@ include file="init.jsp" %>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_VANBAN)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("mvcPath", templatePath + "view_vanban.jsp");
		names.add("van-ban-phap-quy");
		urls.add(portletURL.toString());
		value = names.get(names.size() - 1);
	}
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_PHANLOAIVANBAN)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("mvcPath", templatePath + "view_danhmuc.jsp");
		names.add("danh-muc-van-ban");
		urls.add(portletURL.toString());
		value = mvcPath.contains("view_danhmuc") ? names.get(names.size() - 1) : value;
	}
	
	//System.err.println("VIETTEL PORTAL value => " + value);
%>

<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="topTabs"
	url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
	url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
	value="<%= value %>"
/>
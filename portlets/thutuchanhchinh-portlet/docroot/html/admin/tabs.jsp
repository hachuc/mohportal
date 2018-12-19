
<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@ include file="/html/init.jsp" %>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_DOCUMENT)) {
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("mvcPath", "/html/admin/legaldocument/documents.jsp");
		names.add("legal-documents");
		urls.add(portletURL.toString());
		value = names.get(names.size() - 1);
	}
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_CATEGORY)) {
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("mvcPath", "/html/admin/category/categories.jsp");
		names.add("category-list");
		urls.add(portletURL.toString());
		value = mvcPath.contains("category") ? names.get(names.size() - 1) : value;
	}
	System.err.println("REVOTECH PORTAL value => " + value);
%>

<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="topTabs"
	url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
	url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
	value="<%= value %>"
/>
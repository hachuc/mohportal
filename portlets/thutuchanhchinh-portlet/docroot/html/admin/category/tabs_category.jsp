<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@ include file="/html/init.jsp" %>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	int ctype=ParamUtil.getInteger(request, "ctype",1);
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/html/admin/category/categories.jsp");
		portletURL.setParameter("ctype","1");
		names.add("co-quan-ban-hanh");
		urls.add(portletURL.toString());
		value = names.get(names.size() - 1);
	}
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
		portletURL.setParameter("mvcPath", "/html/admin/category/categories.jsp");
		portletURL.setParameter("ctype","2");
		names.add("linh-vuc");
		urls.add(portletURL.toString());
		value = ctype == 2 ? names.get(names.size() - 1) : value;
	}
%>

<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="topTabs"
	url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
	url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
	value="<%= value %>"
/>
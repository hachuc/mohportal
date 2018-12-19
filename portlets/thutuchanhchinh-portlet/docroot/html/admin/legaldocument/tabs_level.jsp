<%@page import="com.revotech.portal.tthc.util.ActionKeys"%>
<%@page import="com.revotech.portal.tthc.permission.AdminPermission"%>
<%@ include file="/html/init.jsp" %>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	int ldlevel=ParamUtil.getInteger(request, "ldlevel",2);
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/html/admin/legaldocument/documents.jsp");
		portletURL.setParameter("ldlevel","2");
		names.add("muc-do-2");
		urls.add(portletURL.toString());
		value = names.get(names.size() - 1);
	}
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CATEGORY)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
		portletURL.setParameter("mvcPath", "/html/admin/legaldocument/documents.jsp");
		portletURL.setParameter("ldlevel","3");
		names.add("muc-do-3");
		urls.add(portletURL.toString());
		value = ldlevel == 3 ? names.get(names.size() - 1) : value;
	}
%>

<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="topLevelTabs"
	url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
	url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
	value="<%= value %>"
/>
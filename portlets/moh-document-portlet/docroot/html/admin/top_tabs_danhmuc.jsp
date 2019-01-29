
<%@page import="com.revotech.portal.vbpq.permission.AdminPermission"%>
<%@ include file="init.jsp" %>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_COQUANBANHANH)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", templatePath + "view_danhmuc.jsp");
		
		names.add("co-quan-ban-hanh");
		urls.add(portletURL.toString());
		value = names.get(names.size() - 1);
	}
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_LINHVUC)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
		portletURL.setParameter("mvcPath", templatePath + "view_danhmuc_linhvuc.jsp");
		
		names.add("linh-vuc-van-ban");
		urls.add(portletURL.toString());
		value = mvcPath.contains("danhmuc_linhvuc") ? names.get(names.size() - 1) : value;
	}
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_LOAIVANBAN)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
		portletURL.setParameter("mvcPath", templatePath + "view_danhmuc_loaivanban.jsp");
		
		names.add("loai-van-ban");
		urls.add(portletURL.toString());
		value = mvcPath.contains("danhmuc_loaivanban") ? names.get(names.size() - 1) : value;
	}
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_LOAIVANBAN)) {
		
		PortletURL portletURL = renderResponse.createRenderURL();
		
		portletURL.setParameter("mvcPath", templatePath + "view_danhmuc_nhom_van_ban.jsp");
		names.add(LanguageUtil.get(themeDisplay.getLocale(), "nhom-van-ban"));
		urls.add(portletURL.toString());
		value = mvcPath.contains("view_danhmuc_nhom_van_ban") ? names.get(names.size() - 1) : value;
	}
%>

<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="topTabs"
	url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
	url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
	url2="<%= (urls.size() > 2) ? urls.get(2) : null %>"
	url3="<%= (urls.size() > 3) ? urls.get(3) : null %>"
	value="<%= value %>"
/>
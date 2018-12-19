
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/html/migrate/init.jsp"%>
<%
	
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;
	
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("mvcPath", templatePath + "migrate_articles.jsp");
	
	names.add("migrate-articles");
	urls.add(portletURL.toString());
	value = names.get(names.size() - 1);
	
	portletURL = renderResponse.createRenderURL();
	
	portletURL.setParameter("mvcPath", templatePath + "migrate_category.jsp");
	
	names.add("migrate-category");
	urls.add(portletURL.toString());
	value = mvcPath.contains("migrate_category") ? names.get(names.size() - 1) : value;
	
%>

<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="topTabs"
	url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
	url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
	value="<%= value %>"
/>
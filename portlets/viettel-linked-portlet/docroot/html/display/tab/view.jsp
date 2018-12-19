<%@page import="com.viettel.portal.links.model.LCategory"%>
<%@page import="com.viettel.portal.links.model.VLink"%>
<%@page
	import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.service.VLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ include file="/html/display/tab/init.jsp"%>

<portlet:defineObjects />
<%
	String tabNames = "";
	String tabValues = "";
	for(Long categoryId : categoryIds){
		if("0".equals("" + categoryId)){
			tabNames += ("".equals(tabNames) ? LanguageUtil.get(locale, "other-category").replace(",", "") : "," + LanguageUtil.get(locale, "other-category").replace(",", ""));
			tabValues += ("".equals(tabValues) ? "0" : ",0");
		}
		else{
			LCategory cate = LCategoryLocalServiceUtil.getLCategory(categoryId);
			if(cate != null){
				tabNames += ("".equals(tabNames) ? cate.getCategoryName().replace(",", "") : "," + cate.getCategoryName().replace(",", ""));
				tabValues += ("".equals(tabValues) ? cate.getCategoryId() : "," + cate.getCategoryId());
			}
		}
	}
%>

<liferay-ui:tabs names="<%=tabNames %>" refresh="false" tabsValues="<%=tabNames %>">

	<% for(Long categoryId : categoryIds){ 
	List<VLink> links = VLinkLocalServiceUtil.findByGroupAndCateActive(scopeGroupId, categoryId , true);
%>
	<liferay-ui:section>
		<div class="tab-pane fade bdr-box clearfix item active in">
			<div class="col-sm-12">
				<ul class="li-btm col-sm-12">
					<% if(links != null && !links.isEmpty()) { %>

					<% for(VLink link : links){ %>
					<li class="col-sm-6"><a
						href='<%= link.getUrl() == null ? "#" : (!link.getUrl().toLowerCase().trim().startsWith("http") ? "http://" + link.getUrl() : link.getUrl()) %>'
								target="_blank"><%= HtmlUtil.escape(link.getLinkName()) %></a></li>
					<%} %>

					<% } %>
				</ul>
			</div>
		</div>
	</liferay-ui:section>
	<% } %>

</liferay-ui:tabs>
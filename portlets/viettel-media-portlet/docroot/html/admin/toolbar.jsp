<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/admin/init.jsp" %>
<aui:nav-bar cssClass="custom-toolbar">
	<aui:nav id="toolbarContainer" >
		<liferay-util:include page="/html/admin/add_button.jsp" servletContext="<%=application %>"/>
	</aui:nav>
	
	<aui:nav-bar-search cssClass="pull-right">
			<liferay-portlet:renderURL var="searchVideoURL">
				<liferay-portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
			</liferay-portlet:renderURL>
			
		<div class="form-search">
			<aui:form action="<%= searchVideoURL %>" method="post" name="fm">
				<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
			</aui:form>
		</div>
	</aui:nav-bar-search>
</aui:nav-bar>

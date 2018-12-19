<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@include file="/html/admin/phongban/init.jsp"%>
<aui:nav-bar cssClass="custom-toolbar">
	<aui:nav id="toolbarContainer" >
		<liferay-util:include page="/html/admin/phongban/add_button.jsp" servletContext="<%=application %>"/>
	</aui:nav>
	
	<aui:nav-bar-search cssClass="pull-right">
		<liferay-portlet:renderURL var="searchPhongbanURL">
			<liferay-portlet:param name="mvcPath" value="/html/admin/phongban/view.jsp"/>
		</liferay-portlet:renderURL>
			
		<div class="form-search">
			<aui:form action="<%= searchPhongbanURL %>" method="post" name="fm">
				<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>'  />
			</aui:form>
		</div>
	</aui:nav-bar-search>
</aui:nav-bar>

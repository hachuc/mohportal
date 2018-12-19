<%@page import="com.viettel.portal.links.permission.LCategoryPermission"%>
<%@page import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.model.LCategory"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.util.List"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	List<LCategory> categories = LCategoryLocalServiceUtil.findByGroup(scopeGroupId);	
	int total = LCategoryLocalServiceUtil.countByGroup(scopeGroupId);
%>
<style type="text/css">
	.selected a {
		color:Red;
	}
</style>
<div class="list-category">
	<div class="category-header">
		<liferay-ui:message key="categories"/>
	</div>
	
	<div id="category"></div>
	<ul>
		<aui:input name="start" type="hidden" value="0"/>
		<c:if test="<%=categories != null && !categories.isEmpty()%>">
			<%
				selectedCategoryId = categoryId;
			
				if(selectedCategoryId < 0){
					selectedCategoryId = categories.get(0).getCategoryId();
				}
			
				for(LCategory category: categories){
					
				%>
					<portlet:renderURL var="editCategoryURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/edit_category.jsp" />
						<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
						<portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId()) %>" />
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
					</portlet:renderURL>
					
					<portlet:actionURL var="deleteCategoryURL" name="deleteCategory">
						<portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId()) %>" />
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
						<portlet:param name="redirectURL" value="<%=adminHomePageURL %>" />
					</portlet:actionURL>	
					<li class='<%=selectedCategoryId == category.getCategoryId()?"selected":StringPool.BLANK%>'>
						<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "categoryId=" + category.getCategoryId()%>'>
							<%=HtmlUtil.escape(category.getCategoryName())  %>
						</a>
						<span class="icon edit">
							<c:if test="<%=LCategoryPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">	
								<a href="javascript:;" onclick='updateLCategoryForm("<%=editCategoryURL.toString() %>");'>											
									<liferay-ui:icon image="edit"/>
								</a>
							</c:if>
						</span>
								
						<span class="icon delete">
							<c:if test="<%=LCategoryPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE) %>">												
								<liferay-ui:icon-delete url="<%=deleteCategoryURL.toString() %>" />		
							</c:if>
						</span>
					</li>
					
				<%
				}
			%>
			
		</c:if>
		<li class='<%=(selectedCategoryId == categoryId &&  selectedCategoryId == 0) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "categoryId=0"%>'>
				<liferay-ui:message key="other-category"/>
			</a>
		</li>
	</ul>
</div>


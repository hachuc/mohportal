<%@page import="com.viettel.portal.photos.model.PCategory"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.util.List"%>
<%@ include file="/html/admin/init.jsp" %>

<%
	List<PCategory> categories = PCategoryLocalServiceUtil.findByGroup(scopeGroupId);	
	int total = PCategoryLocalServiceUtil.countByGroup(scopeGroupId);
%>
<div class="list-pcategory">
	<div class="bcategory-header">
		<liferay-ui:message key="photo-categories"/>
	</div>
	
	<div id="category"></div>
	<ul>
		<aui:input name="start" type="hidden" value="0"/>
		<c:if test="<%=categories != null && !categories.isEmpty()%>">
			<%
				selectedCategoryId = categoryId;
			
				if(selectedCategoryId < 0){
					selectedCategoryId = categories.get(0).getId();
				}
			
				for(PCategory category: categories){
					
				%>
					<portlet:renderURL var="editCategoryURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/edit_category.jsp" />
						<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
						<portlet:param name="categoryId" value="<%=String.valueOf(category.getId()) %>" />
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
					</portlet:renderURL>
					
					<portlet:actionURL var="deletePCategoryURL" name="deletePCategory">
						<portlet:param name="categoryId" value="<%=String.valueOf(category.getId()) %>" />
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
						<portlet:param name="redirectURL" value="<%=adminHomePageURL %>" />
					</portlet:actionURL>	
					<li class='<%=selectedCategoryId == category.getId()?"selected":StringPool.BLANK%>'>
						<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "categoryId=" + category.getId()%>'>
							<%=HtmlUtil.escape( category.getName() ) %>
						</a>
						<span class="icon edit">
								<a href="javascript:;" onclick='updatePCategoryForm("<%=editCategoryURL.toString() %>");'>											
									<liferay-ui:icon image="edit"/>
								</a>
						</span>
								
						<span class="icon delete">
							<liferay-ui:icon-delete url="<%=deletePCategoryURL.toString() %>" />	
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


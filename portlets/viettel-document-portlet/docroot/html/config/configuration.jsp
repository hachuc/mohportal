
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@include file="/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="menuVbpqPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="menu-vbpq-config-form" method="post" action="<%=menuVbpqPortletConfigURL %>">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<aui:row>
		<%
			List<Group> groups = GroupLocalServiceUtil.getUserGroups(themeDisplay.getUserId());
		%>
		<aui:select name="scopeId" label="scope">
			<%for(Group group : groups) { %>
				<aui:option value="<%= group.getGroupId() %>" label="<%=HtmlUtil.escape( group.getName()) %>" selected="<%= scopeId == group.getGroupId()%>"/>
			<%} %>
		</aui:select>
	</aui:row>
	
	<aui:select name="typeContent" label="select-type">
		<%
			for (int i = 1; i < 4; i++)
			{
		%>
			<aui:option value="<%= i %>" selected='<%=Validator.equals(typeContent, Integer.toString(i)) %>' label='<%= "type-content-" + i %>'/>	
		<%
			}
		%>
	</aui:select>
	
	<aui:input type="text" name="dmPortletTitle" label="portlet-title" value="<%=dmPortletTitle %>"/>

	<aui:row>
		<aui:col width="30">
			<aui:select name="lienKetTrang" label="Chọn liên kết trang:">
			<%				
				List<Layout> lls = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
				for (Layout lt : lls) {
					boolean select = (layoutId == lt.getPlid() ? true:false);
			%>
			<aui:option label="<%= lt.getName(themeDisplay.getLocale()) %>" selected="<%= select %>" value="<%= String.valueOf(lt.getPlid()) %>"></aui:option>
			<% } %>
		</aui:select>
		</aui:col>
		
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button type="cancel"/>
	</aui:button-row>
</aui:form>
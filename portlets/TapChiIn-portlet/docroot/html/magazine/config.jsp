<%@ include file="/html/magazine/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<liferay-portlet:actionURL portletConfiguration="true" var="menuVbpqPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="fm" method="post" action="<%=menuVbpqPortletConfigURL%>">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<aui:row>
		<aui:col width="30">
			<aui:select name="preferences--lienKetTrang--"
				label="choose-page-link">
				<%
					long llayoutId = Long.parseLong(portletPreferences
											.getValue("lienKetTrang", "0"));
									List<Layout> lls = LayoutLocalServiceUtil
											.getLayouts(themeDisplay.getScopeGroupId(),
													false);
									for (Layout lt : lls) {
										boolean select = (llayoutId == lt.getPlid() ? true
												: false);
				%>
				<aui:option label="<%=lt.getName(themeDisplay
											.getLocale())%>"
					selected="<%=select%>"
					value="<%=String.valueOf(lt.getPlid())%>"></aui:option>
				<%
					}
				%>
			</aui:select>
		</aui:col>

	</aui:row>

	<aui:button-row>
		<aui:button type="submit" value="save" />
		<aui:button type="cancel" />
	</aui:button-row>

</aui:form>
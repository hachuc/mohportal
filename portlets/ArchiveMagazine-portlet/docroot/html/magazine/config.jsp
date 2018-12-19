<%@ include file="/html/magazine/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<aui:form name="fm" method="post" action="<%=configurationActionURL%>">
	<aui:field-wrapper>
		<aui:fieldset>
			<aui:row>
				<aui:input name="portletTitle" value="<%=portletTitle%>" />
			</aui:row>
			<aui:row>
				<aui:select name="lienKetTrang" label="choose-page-link">
					<%
						List<Layout> lls = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(),
													false);
											for (Layout lt : lls) {
												boolean select = (layoutId == lt.getPlid() ? true : false);
					%>
					<aui:option label="<%=HtmlUtil.escape(lt.getName(themeDisplay.getLocale()))%>"
						selected="<%=select%>" value="<%=String.valueOf(lt.getPlid())%>"></aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:row>
			<aui:button-row>
				<aui:button type="submit" value="save" />
				<aui:button type="cancel" />
			</aui:button-row>
		</aui:fieldset>
	</aui:field-wrapper>
</aui:form>
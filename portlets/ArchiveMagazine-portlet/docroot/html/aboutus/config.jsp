<%@include file="/html/aboutus/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="menuVbpqPortletConfigURL">
	<liferay-portlet:param name="portletResource"
		value="<%=portletResource%>" />
</liferay-portlet:actionURL>

<aui:form name="fm" method="post" action="<%=menuVbpqPortletConfigURL%>">
	<aui:fieldset>
		<aui:input name="<%=Constants.CMD%>" type="hidden"
			value="<%=Constants.UPDATE%>" />
	</aui:fieldset>
	<aui:fieldset>
		<aui:input type="text" name="preferences--portletTitle--"
			label="portlet-title" value="<%=portletTitle%>" />
	</aui:fieldset>
	<aui:fieldset>
		<aui:input type="text" name="preferences--portletTitle2--"
			label="portlet-title-2" value="<%=portletTitle2%>" />
	</aui:fieldset>
	<aui:fieldset>
		<aui:select name="preferences--lienKetTrang--"
			label="Chọn liên kết trang:">
			<%				
							List<Layout> lls = LayoutLocalServiceUtil.getLayouts(
									themeDisplay.getScopeGroupId(), false);
							for (Layout lt : lls) {
								boolean select = (layoutId == lt.getPlid() ? true
										: false);
			%>
			<aui:option
				label="<%=HtmlUtil.escape(lt.getName(themeDisplay.getLocale()))%>"
				selected="<%=select%>" value="<%=String.valueOf(lt.getPlid())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	<aui:fieldset>
		<aui:input type="text" name="preferences--job1Title--"
			label="job1-title" value="<%=HtmlUtil.escape(job1Title)%>" /> 
	</aui:fieldset>
	<aui:fieldset>
		<aui:input type="text" name="preferences--job2Title--"
			label="job2-title" value="<%=HtmlUtil.escape(job2Title)%>" />
	</aui:fieldset>
	<aui:fieldset>
		<aui:input type="text" name="preferences--job3Title--"
			label="job3-title" value="<%=HtmlUtil.escape(job3Title)%>" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="save" />
		<aui:button type="cancel" />
	</aui:button-row>
</aui:form>

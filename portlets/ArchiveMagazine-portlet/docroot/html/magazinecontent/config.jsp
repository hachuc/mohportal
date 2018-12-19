<%@ include file="/html/magazinecontent/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<aui:form name="fm" method="post" action="<%=configurationActionURL%>">
	<aui:field-wrapper>
		<aui:fieldset>
			<aui:row>
				<aui:input name="portletTitle" value="<%=portletTitle%>" />
			</aui:row>
			<aui:row>
				<aui:input name="imageFolderPath" value="<%=imageFolderPath%>" /> 
			</aui:row>
			<aui:button-row>
				<aui:button type="submit" value="save" />
				<aui:button type="cancel" />
			</aui:button-row>
		</aui:fieldset>
	</aui:field-wrapper>
</aui:form>
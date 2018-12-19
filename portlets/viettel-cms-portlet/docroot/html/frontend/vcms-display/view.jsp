<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/frontend/vcms-display/init.jsp"%> 
<c:if test="<%=Validator.isNotNull(displayStyle) %>">
	<%
			PortletURL portletURL = renderResponse.createRenderURL();
		
			SearchContainer<Distribution> searchContainer = new SearchContainer<Distribution>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, itemDisplay, portletURL, null, null);
			
			searchContainer.setDelta(itemDisplay);
			searchContainer.setDeltaConfigurable(false);
			
			List<Distribution> results = VCMSPubliserUtil.getContents(scopeGroupId, assetCategoryIds, searchContainer.getStart(), searchContainer.getEnd());//(scopeGroupId, selectedCategoryId, 4, 8192, searchContainer.getStart(), searchContainer.getEnd());
			
			int total = VCMSPubliserUtil.getDistributionCount(scopeGroupId, assetCategoryIds);
			
			searchContainer.setTotal(total);
			searchContainer.setResults(results);
	
			request.setAttribute("view.jsp-searchContainer", searchContainer);
			request.setAttribute("view.jsp-total", total);
			request.setAttribute("view.jsp-results", results);
		%>
		
		<liferay-util:include page='<%="/html/frontend/vcms-display/display/" + TextFormatter.format(displayStyle, TextFormatter.N) + ".jsp" %>' servletContext="<%= application %>" />
</c:if>
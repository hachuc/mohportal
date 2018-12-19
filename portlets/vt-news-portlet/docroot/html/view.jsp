
<%@ include file="/html/init.jsp" %>

<c:if test="<%=Validator.isNotNull(displayStyle) %>">
	<div class='news-wrapper clearfix <%= "NP_" + HtmlUtil.escape(StringUtil.toUpperCase(displayStyle)) + " " + HtmlUtil.escape(portletClass) %>'>
		<%
			PortletURL portletURL = renderResponse.createRenderURL();
		
			SearchContainer<AssetEntry> searchContainer = 
				new SearchContainer<AssetEntry>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, displayItem, portletURL, null, null);
			
			if (!paginationType.equals("none")) {
				searchContainer.setDelta(displayItem);
				searchContainer.setDeltaConfigurable(false);
			}
			
			List<AssetEntry> results = NewsPublisherUtil.getAssetEntries(assetEntryQuery);
			
			int total = NewsPublisherUtil.getAssetEntriesCount(assetEntryQuery);
			
			searchContainer.setTotal(total);
			
			searchContainer.setResults(results);
	
			request.setAttribute("view.jsp-searchContainer", searchContainer);
			request.setAttribute("view.jsp-total", total);
			request.setAttribute("view.jsp-results", results);
			
			
		%>
		
		<liferay-util:include page='<%="/html/display/" + TextFormatter.format(displayStyle, TextFormatter.N) + ".jsp" %>' servletContext="<%= application %>" />
	</div>
</c:if>

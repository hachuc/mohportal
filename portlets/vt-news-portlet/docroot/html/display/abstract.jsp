
<%@page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil"%>
<%@include file="/html/init.jsp"%>

<ul class="news-abstract">

<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("view.jsp-searchContainer");

	List<AssetEntry> results = (List<AssetEntry>)searchContainer.getResults();
	
	int total = searchContainer.getTotal();
	
	for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
		AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
	
		long classPK = assetEntry.getClassPK();
		
		AssetRenderer assetRenderer = assetEntry.getAssetRenderer();
		
		if ((assetRenderer == null) || !assetRenderer.isDisplayable()) {
			continue;
		}
		
		String title = StringUtil.shorten(assetRenderer.getTitle(locale), titleLength);
		
		String displayDate = dateFormat.format(assetRenderer.getDisplayDate());
		
		SimpleDateFormat dateFormatmonth = new SimpleDateFormat( "MM");
		SimpleDateFormat dateFormatday = new SimpleDateFormat( "dd");

		String monthdate =    dateFormatmonth.format(assetRenderer.getDisplayDate());

		String daydate =    dateFormatday.format(assetRenderer.getDisplayDate());
		
		boolean isNewArticle = NewsPublisherUtil.isNewArticle(assetRenderer.getDisplayDate());
		
		String summary = StringUtil.shorten(assetRenderer.getSummary(locale), summaryLength);
		
		String viewContentURL = NewsPublisherUtil.getViewContentURL(request, assetEntry, linkedLayout);
		
		String modifiedDate = dateFormat.format(assetEntry.getModifiedDate());
		
		String smallImagePath = NewsPublisherUtil.getSmallImagePath(request, classPK);
		
		if(Validator.isNull(smallImagePath) && useImageDefault){
			smallImagePath = assetRenderer.getThumbnailPath(renderRequest);
		}
		
		StringBuffer itemClass = new StringBuffer(StringPool.BLANK);
		
		if(assetEntryIndex % 2 == 0) {
			itemClass.append("even");
		} else {
			itemClass.append("odd");
		}
		
		if(assetEntryIndex == 0) {
			itemClass.append(" first");
		}else if(assetEntryIndex == (results.size() - 1)) {
			itemClass.append(" last");
		}
%>
	<li class="news-line <%=itemClass.toString() %>">
		<div class="news-content">
			<div class="img2">
				<c:if test="<%= showSmallImage && Validator.isNotNull(smallImagePath) %>">
					<div class="news-simage">
						<a href="<%=viewContentURL %>" title="<%= HtmlUtil.escape(title) %>">
							<img src="<%= smallImagePath %>" alt="" />
						</a>
					</div>
				</c:if>
				<div class="news-title">
					<a href="<%=viewContentURL%>" title="<%= HtmlUtil.escape(title) %>"><%= HtmlUtil.escape(title) %>
						<c:if test="<%= displayPublishedDate %>">
							(<%=
		
							displayDate %>)
						</c:if> 
					</a> 
					<c:if test="<%= displayIconNew && isNewArticle %>">
						<span class="social hot tooltipstered"></span>
					</c:if>
				</div>
			</div>
				
			<div class="news-summary" >
				<%= HtmlUtil.escape(summary) %>
			</div>
			<div class="viewmore-panel">
				<a href="<%=viewContentURL%>">
					<liferay-ui:message key="detail"/> &raquo;
				</a>
			</div>
		</div>
	</li>
	
	<%
	}
%>

</ul>

<c:if test="<%= showMore %>">
	<a class="icon-detail" title='<liferay-ui:message key="show-all"/>' href="<%= linkedLayoutURL %>">
		<liferay-ui:message key="show-all"/>
	</a>
</c:if>

<c:if test='<%= !paginationType.equals("none") && (total > results.size()) %>'>
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= HtmlUtil.escape(paginationType) %>" />
</c:if>
<%!
	private static Log _log = LogFactoryUtil.getLog("html.display.abstract_jsp");
%>
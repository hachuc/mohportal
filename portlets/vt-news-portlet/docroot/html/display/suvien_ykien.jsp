
<%@include file="/html/init.jsp"%>
<div class="mt10 bacday">
	<div class="title-tinnoibat">
		<c:choose>
			<c:when test="<%=Validator.isNotNull(linkedLayoutURL)%>">
				<a href="<%=linkedLayoutURL%>"
					title="<%=HtmlUtil.escape(portletTitle)%>"><%=HtmlUtil.escape(portletTitle)%></a>
			</c:when>
			<c:otherwise>
				<a href="#" title="<%=HtmlUtil.escape(portletTitle)%>"><%=HtmlUtil.escape(portletTitle)%></a>
			</c:otherwise>
		</c:choose>
	</div>
	<%
	List<AssetEntry> results = (List<AssetEntry>) request
			.getAttribute("view.jsp-results");

	for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
		AssetEntry assetEntry = (AssetEntry) results
				.get(assetEntryIndex);

		long classPK = assetEntry.getClassPK();

		AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil
				.getAssetRendererFactoryByClassName(className);

		if (assetRendererFactory == null) {
			continue;
		}

		AssetRenderer assetRenderer = null;

		try {
			assetRenderer = assetRendererFactory
					.getAssetRenderer(classPK);
		} catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}
		}

		if ((assetRenderer == null) || !assetRenderer.isDisplayable()) {
			continue;
		}

		String title = StringUtil.shorten(
				assetRenderer.getTitle(locale), titleLength);

		SimpleDateFormat sdf = new SimpleDateFormat(
				"dd/MM/yyyy hh:mm aaa");

		String displayDate = sdf.format(assetRenderer.getDisplayDate());

		String summary = StringUtil.shorten(
				assetRenderer.getSummary(locale), summaryLength);

		String viewContentURL = NewsPublisherUtil.getViewContentURL(
				request, assetEntry, linkedLayout);

		String modifiedDate = dateFormat.format(assetEntry
				.getModifiedDate());

		String smallImagePath = NewsPublisherUtil.getSmallImagePath(
				request, classPK);

		if (Validator.isNull(smallImagePath) && useImageDefault) {
			smallImagePath = assetRenderer
					.getThumbnailPath(renderRequest);
		}		
		if(StringUtil.endsWith(smallImagePath, "file_system/large/article.png"))
			smallImagePath = "/vt-news-portlet/images/no_image.png";
%>
	<c:if test='<%= assetEntryIndex == 0 %>'>
		<div class="img-tag"><a href="<%= viewContentURL%>"><img class="img-responsive" src="<%= smallImagePath %>" alt=""/></a></div>
     		<div class="bg-grey p15">
				<h5><a href="<%= viewContentURL%>" class="font-s01 text-bold"><%= HtmlUtil.escape(title) %></a></h5>
				<p> <%= HtmlUtil.escape(summary) %></p>
         		<ul class="othernews">
	</c:if>
	<c:if test='<%= assetEntryIndex > 0 %>'>
		<li><a href="<%=viewContentURL%>"> <%=HtmlUtil.escape(title)%></a></li>
	</c:if>
	<c:if test='<%= assetEntryIndex == results.size() - 1%>'>
		</ul></div>
	</c:if>
	<%  } %>
</div>
<%!private static Log _log = LogFactoryUtil
			.getLog("html.display.suviec_ykien_jsp");%>
<%@include file="/html/init.jsp"%>
<div class="mb20 Boxtintuc">
	<div class="tieudebox">
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
		<% if (assetEntryIndex == 0) { %>
		<div class="row itemNews mt25">
			<div class="col-md-5 pr0s1">
				<a href="<%=viewContentURL%>"><img src="<%=smallImagePath%>"
					width="" height="" alt="" /></a>
			</div>
			<div class="col-md-7">
				<a href="<%=viewContentURL%>"><%=HtmlUtil.escape(title)%></a>
			</div>
		</div>
		<ul class="othernewsBox">
			<% } else{ %>
			<li><a href="<%= viewContentURL%>"><%= HtmlUtil.escape(title)%></a>
			</li>
			<% } %>
			<% if (assetEntryIndex == results.size() - 1) { %>
		</ul>
		<% } } %>
</div>
<%!private static Log _log = LogFactoryUtil
			.getLog("html.display.category_news_tyle_jsp");%>
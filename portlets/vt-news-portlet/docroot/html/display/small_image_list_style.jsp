
<%@include file="/html/init.jsp"%>
<div class="mt15">
	<div class="headerBox headerlongText" style="line-height: 21px;">
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
	<div class="containerBox bdr-box p15">
		<ul class="LatestNews">
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
%>
			<li class="clearfix"><a href="<%=viewContentURL%>"> <c:if
						test="<%=Validator.isNotNull(smallImagePath)%>">
						<img src="<%= smallImagePath %>" alt="" width="" height="">
					</c:if> <%=HtmlUtil.escape(title)%>
			</a></li>

			<%  } %>
		</ul>
	</div>
</div>
<%!private static Log _log = LogFactoryUtil
			.getLog("html.display.small_image_list_style_jsp");%>
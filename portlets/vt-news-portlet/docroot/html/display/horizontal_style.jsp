
<%@include file="/html/init.jsp"%>
<div class="row mt10">
	<div class="box4news">
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

		<div class="col-sm-3 col-xs-6 item-list">
			<c:if test="<%=Validator.isNotNull(smallImagePath)%>">
				<div class=""> <a href="<%=viewContentURL%>"><img class="img-responsive" src="<%=smallImagePath%>" alt=""/></a> </div>
			</c:if>
			<div class="">
				<h5 class="titleNews"><a href="<%=viewContentURL%>"><%=HtmlUtil.escape(title)%></a></h5>
			</div>   
		</div>

<%
	}
%>
	</div>
</div>
<%!private static Log _log = LogFactoryUtil
			.getLog("html.display.horizontal_style_jsp");%>
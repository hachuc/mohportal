
<%@ include file="/html/init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request.getAttribute("view.jsp-searchContainer");

	List<AssetEntry> assetEntries = (List<AssetEntry>) searchContainer.getResults();

	StringBuilder newsItems = new StringBuilder();
	if (assetEntries != null && !assetEntries.isEmpty()) {
%>
<div class="mt15">
	<div class="headerBox">
		<c:choose>
			<c:when test="<%=Validator.isNotNull(linkedLayoutURL)%>">
				<a href="<%=linkedLayoutURL%>"
					title="<%=HtmlUtil.escape(portletTitle)%>"><%=HtmlUtil.escape(portletTitle)%></a>
			</c:when>
			<c:otherwise>
				<span><%=HtmlUtil.escape(portletTitle)%></span>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="gallery1" class="ad-gallery1 clearfix">
		<div class="owl-two owl-carousel owl-theme">
			<%
						for (AssetEntry assetEntry : assetEntries) {
								AssetRenderer assetRenderer = assetEntry.getAssetRenderer();
								String title = assetRenderer.getTitle(locale);
								title = StringUtil.shorten(title, titleLength);

								String displayDate = dateFormat.format(assetRenderer
										.getDisplayDate());
								boolean isNewArticle = NewsPublisherUtil
										.isNewArticle(assetRenderer.getDisplayDate());

								String smallImagePath = NewsPublisherUtil
										.getSmallImagePath(request, assetEntry.getClassPK());
								if (Validator.isNull(smallImagePath)) {
									smallImagePath = assetRenderer
											.getThumbnailPath(renderRequest);
								}

								String summary = assetRenderer.getSummary(locale);
								summary = StringUtil.shorten(summary, summaryLength);

								String viewContentURL = NewsPublisherUtil
										.getViewContentURL(request, assetEntry,
												linkedLayout);
								if(StringUtil.endsWith(smallImagePath, "file_system/large/article.png"))
									smallImagePath = "/vt-news-portlet/images/no_image.png";
					
					%>
			<div class="item">
				<a href="<%= viewContentURL %>"><img class="img-responsive"
					src="<%= smallImagePath %>" alt="" /></a>
				<div class="">
					<h5 class="titleNews text-center">
						<a href="<%= viewContentURL %>"><%= HtmlUtil.escapeAttribute(title)%></a>
					</h5>
				</div>
			</div>

			<%
						}
					%>
		</div>
	</div>
</div>
<%
	}
%>


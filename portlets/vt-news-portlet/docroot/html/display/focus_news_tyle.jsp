
<%@ include file="/html/init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request.getAttribute("view.jsp-searchContainer");

	List<AssetEntry> assetEntries = (List<AssetEntry>) searchContainer.getResults();

	StringBuilder newsItems = new StringBuilder();
	if (assetEntries != null && !assetEntries.isEmpty()) {
%>
<div class="owl-zero owl-carousel owl-theme">
	<%
						int i = 0;
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
								if(StringUtil.endsWith(smallImagePath, "file_system/large/article.png")){
									smallImagePath = "/vt-news-portlet/images/no_image.png";
								}
					%>
	<div class="item <c:if test='<%= i==0 %>'>active</c:if>">
		<c:choose>
			<c:when
				test='<%= !StringUtil.endsWith(smallImagePath, "file_system/large/article.png") %>'>
				<a href="<%= viewContentURL%>"> <img class="img-responsive"
					src="<%= smallImagePath %>" alt="" />
				</a>
			</c:when>
			<c:otherwise>
				<a href="<%= viewContentURL%>"> <img class="img-responsive"
					src="/vt-news-portlet/images/no_image.png" alt="" />
				</a>
			</c:otherwise>
		</c:choose>
		<div class="">
			<h4 class="titleHotNews">
				<a href="<%=viewContentURL%>"><%=HtmlUtil.escape(title)%></a>
			</h4>
			<p class=""><%=HtmlUtil.escape(summary)%></p>

		</div>
	</div>
	<%
		i++;
			}
	%>
</div>
<%
	}
%>

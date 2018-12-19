
<%@include file="/html/init.jsp"%>

<div class="columns">
                <div class="owl-one owl-carousel owl-theme">
		<%
			SearchContainer searchContainer = (SearchContainer)request.getAttribute("view.jsp-searchContainer");
		
			List<AssetEntry> results = (List<AssetEntry>)searchContainer.getResults();
			
			for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
				AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
			
				long classPK = assetEntry.getClassPK();
				
				AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
			
				if (assetRendererFactory == null) {
					continue;
				}
			
				AssetRenderer assetRenderer = null;
			
				try {
					assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
				}
				catch (Exception e) {
					if (_log.isWarnEnabled()) {
						_log.warn(e, e);
					}
				}
			
				if ((assetRenderer == null) || !assetRenderer.isDisplayable()) {
					continue;
				}
				
				String title = assetRenderer.getTitle(locale);
				
				String viewContentURL = NewsPublisherUtil.getViewContentURL(request, assetEntry, linkedLayout);
				
				String smallImagePath = NewsPublisherUtil.getSmallImagePath(request, classPK);
				
				if(Validator.isNull(smallImagePath)){
					smallImagePath = assetRenderer.getThumbnailPath(renderRequest);
				}
		%>

		<div class="item">
			<div class="">
				<a href="<%=viewContentURL %>"> <c:choose>
						<c:when
							test='<%= !StringUtil.endsWith(smallImagePath, "file_system/large/article.png") %>'>
							<img class="img-responsive" src="<%= smallImagePath %>" alt="" />
						</c:when>
						<c:otherwise>
							<img class="img-responsive"
								src="/vt-news-portlet/images/no_image.png" alt="" />
						</c:otherwise>
					</c:choose></a>
			</div>
			<div class="">
				<h5 class="titleNews">
					<a href="<%=viewContentURL %>"><%= HtmlUtil.escape(title) %></a>
				</h5>
			</div>
		</div>
		<%
			}
		%>
	</div>
</div>
<%!
	private static Log _log = LogFactoryUtil.getLog("html_display_slider_show.jsp");
%>
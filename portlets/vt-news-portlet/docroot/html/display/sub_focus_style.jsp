	
<%@include file="/html/init.jsp"%>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("view.jsp-searchContainer");

List<AssetEntry> results = (List<AssetEntry>)searchContainer.getResults();
%>
<div class="title-tinnoibat">
       	 	<c:choose>
				<c:when test="<%= Validator.isNotNull(linkedLayoutURL) %>">
					<a href="<%= linkedLayoutURL %>" title="<%= HtmlUtil.escape(portletTitle) %>"><%= HtmlUtil.escape(portletTitle) %></a>
				</c:when>
				<c:otherwise>
					<%= HtmlUtil.escape(portletTitle) %>
				</c:otherwise>
			</c:choose>
       	 </div>
		 <ul class="othernews bg-grey">
			<%
			for(int index = 0; index < results.size(); index++)
			{	
				AssetEntry assetEntry = results.get(index);
				
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
				
				String title = StringUtil.shorten(assetRenderer.getTitle(locale), titleLength);
				
				String displayDate = dateFormat.format(assetRenderer.getDisplayDate());
				boolean isNewArticle = NewsPublisherUtil.isNewArticle(assetRenderer.getDisplayDate());
				
				String viewContentURL = NewsPublisherUtil.getViewContentURL(request, assetEntry, linkedLayout);
			%>
				<li>
					<a href="<%=viewContentURL%>" title="<%= HtmlUtil.escape(title) %>">
						<%= HtmlUtil.escape(title) %>
					</a>
				</li>
			<%
			}
			%>
		</ul>
<%!
	private static Log _log = LogFactoryUtil.getLog("html.display.sub_focus_style_jsp");
%>


<%@ include file="/html/init.jsp" %>
<div class="mb5  Boxtintuc clearfix">
<%
	String style = StringPool.BLANK;

	String[] indexs = StringUtil.split(blockIndex);
	
	if(indexs != null && indexs.length > 0){
		int countItem = 0;
		for(String index:indexs){
			
			if(Validator.isNumber(index)){
				
				countItem ++;
				
				String[] tagNameValuesBlock = portletPreferences.getValues("tagNameValues" + index, new String[0]);
				
				String[] categoryIdValuesBlock = portletPreferences.getValues("categoryIdValues" +  index, new String[0]);
			
				String blockTitle = HtmlUtil.escape(portletPreferences.getValue("blockTitle" + index, StringPool.BLANK));
				
				boolean tagQueryContainsBlock = true;
				boolean tagQueryAndOperatorBlock = false;
				boolean categoryQueryContainsBlock = true;
				boolean categoryQueryAndOperatorBlock = false;
				
				NewsPublisherUtil.setAssetEntryQuery(assetEntryQuery, arrGroupIds, tagNameValuesBlock, 
					categoryIdValuesBlock, tagQueryContainsBlock, tagQueryAndOperatorBlock, categoryQueryContainsBlock, 
					categoryQueryAndOperatorBlock);
				
				List<AssetEntry> assetEntries = NewsPublisherUtil.getAssetEntries(assetEntryQuery);
				
				String css = StringPool.BLANK;
				
				String layoutUuidIndex = portletPreferences.getValue("layoutUuid" + index, StringPool.BLANK);
				
				Layout blockLayout = themeDisplay.getLayout();
				
				String blockLayoutURL = StringPool.BLANK;
				
				if(Validator.isNotNull(layoutUuidIndex)){
					blockLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuidIndex, themeDisplay.getScopeGroupId(), false);
				}
				
				if(blockLayout != null){
					blockLayoutURL = PortalUtil.getLayoutFullURL(blockLayout, themeDisplay);
				}
				
				if(indexs.length > 1){
					if(countItem % 2 == 0){
						css = "pr0s1";
					}else{
						css = "pl0s1";
					}
				}
				
				%>
					<div class="col-sm-6 mt10 <%= css %>">
						
						<div class="tieudebox"><a href="<%= blockLayoutURL%>"><%= HtmlUtil.escape(blockTitle) %></a></div>
							<%
								if(assetEntries != null){
									int count = 0;
									for(AssetEntry assetEntry:assetEntries){
										count ++;
										
										try {
											AssetRenderer assetRenderer = assetEntry.getAssetRenderer();
										
										
										String title = StringUtil.shorten(assetRenderer.getTitle(locale), titleLength);
										
										String displayDate = dateFormat.format(assetRenderer.getDisplayDate());
										boolean isNewArticle = NewsPublisherUtil.isNewArticle(assetRenderer.getDisplayDate());
										
										String smallImagePath = NewsPublisherUtil.getSmallImagePath(request, assetEntry.getClassPK());
										
										if(Validator.isNull(smallImagePath) && useImageDefault){
											smallImagePath = assetRenderer.getThumbnailPath(renderRequest);
										}
										
										String viewContentURL = NewsPublisherUtil.getViewContentURL(request, assetEntry, blockLayout);
										
										if(count == 1){
											String summary = StringUtil.shorten(assetRenderer.getSummary(locale), summaryLength);
											summary = HtmlUtil.escape(summary);
											%>
											<div class="row itemNews mt10">
												<div class="col-md-5 pr0s1">
													<a href="<%= viewContentURL%>"><img src="<%= smallImagePath %>" width="" height="" alt=""/></a>
												</div>
												<div class="col-md-7">
													<a href="<%= viewContentURL%>"><%= HtmlUtil.escape(title)%></a>
												</div>										    
										    </div>
										    <ul class="othernews">
											<%
										}else{
											%>
												<li> <a href="<%= viewContentURL%>"><%= HtmlUtil.escape(title)%></a> </li>
											<%
										}
										
										} catch (Exception e) {
										}
										
									}
								}
							%>
							</ul>
					</div>
				<%
			}
		  }
		} %>
</div>
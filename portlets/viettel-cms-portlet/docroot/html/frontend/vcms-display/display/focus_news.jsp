<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@include file="/html/frontend/vcms-display/init.jsp"%>

<div class="owl-zero owl-carousel owl-theme">
		<%
			SearchContainer searchContainer = (SearchContainer) request.getAttribute("view.jsp-searchContainer");

			List<Distribution> results = (List<Distribution>) searchContainer.getResults();

			int total = searchContainer.getTotal();
			if (results != null && !results.isEmpty()) {
				for (int i = 0; i < results.size(); i++) {
					Distribution distribution = (Distribution) results.get(i);
					Date publishDate = distribution.getDistributedDate();
					Content entry = ContentLocalServiceUtil.findByContentId(distribution.getContentId(), scopeGroupId, 
							CmsConstants.PUBLISHED_NEWS, CmsConstants.FINAL_STATUS);
					if (entry == null)
						continue;
					String viewURL = VCMSPubliserUtil.getViewContentURL(request, distribution, linkedLayout);
					String title = entry.getTitle();
					String summary = entry.getSummary();
					String smallImageURL = entry.getSmallImageUrl();
// 					if(Validator.isNull(smallImageURL)){
// 						smallImageURL = "/viettel-cms-portlet/images/no_image.png";
// 					}
		%>
		<div class="item <c:if test='<%= i==0 %>'>active</c:if>">
			<div class="hot-news">
				<c:if test='<%= Validator.isNotNull(smallImageURL) %>'>
					<a href="<%= viewURL%>">
						<img class="img-responsive" src="<%= smallImageURL %>" alt="" />
					</a>
				</c:if>
			</div>
			<div class="">
				<h4 class="titleHotNews">
					<a href="<%= viewURL%>"><%= HtmlUtil.escape(title) %></a>
				</h4>
				<p align="justify">
					<%= HtmlUtil.escape(summary) %>
				</p>
	
			</div>
	  </div>
		
		<% }} %>
		
</div>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@include file="/html/frontend/vcms-display/init.jsp"%>
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
						if(Validator.isNull(smallImageURL)){
							smallImageURL = "/viettel-cms-portlet/images/no_image.png";
						}
			%>
			<c:if test='<%= i == 0 %>'>
				<div class="img-tag"><a href="<%= viewURL%>"><img class="img-responsive" src="<%= smallImageURL %>" alt=""/></a></div>
		     		<div class="bg-grey p15">
						<h5><a href="<%= viewURL%>" class="font-s01 text-bold"><%= HtmlUtil.escape(title) %></a></h5>
						<p> <%= HtmlUtil.escape(summary) %></p>
		         		<ul class="othernews">
			</c:if>
			<c:if test='<%= i > 0 %>'>
				<li><a href="<%=viewURL%>"> <%=HtmlUtil.escape(title)%></a></li>
			</c:if>
			<c:if test='<%= i == results.size() - 1%>'>
				</ul></div>
			</c:if>
			
			<% }} %>
</div>
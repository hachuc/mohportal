<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@include file="/html/frontend/vcms-display/init.jsp"%>

<div class="title-tinnoibat">
	<c:choose>
		<c:when test="<%=Validator.isNotNull(linkedLayoutURL)%>">
			<a href="<%=linkedLayoutURL%>"
				title="<%=HtmlUtil.escape(portletTitle)%>"><%=HtmlUtil.escape(portletTitle)%></a>
		</c:when>
		<c:otherwise>
			<%=HtmlUtil.escape(portletTitle)%>
		</c:otherwise>
	</c:choose>
</div>
<ul class="othernews bg-grey">
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
					if (Validator.isNull(smallImageURL)) {
						smallImageURL = "/viettel-cms-portlet/images/no_image.png";
					}
		%>
		<li>
			<a href="<%=viewURL%>" title="<%= HtmlUtil.escape(title) %>">
				<%= HtmlUtil.escape(title) %>
			</a>
		</li>
		<%
			}
			}
		%>
	</ul>
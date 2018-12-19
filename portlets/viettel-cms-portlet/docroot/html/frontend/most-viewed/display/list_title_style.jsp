<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@include file="/html/frontend/most-viewed/init.jsp"%>

<div class="headerBox">
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
			List results = (List) request.getAttribute("view.jsp-searchContainer");
			String serilizeString=null;
			JSONArray commentDataJsonArray=null;
			if (results != null && !results.isEmpty()) {
				for (int i = 0; i < results.size(); i++) {
					Object content = results.get(i);
					serilizeString=JSONFactoryUtil.serialize(content);
					commentDataJsonArray=JSONFactoryUtil.createJSONArray(serilizeString);
					int viewCount = commentDataJsonArray.getInt(0);
					String distId = commentDataJsonArray.getString(1);
					String publishDate = commentDataJsonArray.getString(3);
					String title = commentDataJsonArray.getString(4);
					String smallImageUrl = commentDataJsonArray.getString(5);
					String viewURL = VCMSPubliserUtil.getViewContentURL(request, distId, title, linkedLayout);
					
		%>
		<li>
			<a href="<%=viewURL%>" title="<%= HtmlUtil.escape(title) %>">
				<%= HtmlUtil.escape(title) %>
				<c:if test='<%= showPublishDate %>'>
					<i><%= publishDate %></i>
				</c:if>
				<c:if test='<%= showViewCount %>'>
					<span class="badge"><%= String.valueOf(viewCount) %></span>
				</c:if>
			</a>
		</li>
		<%
			}
			}
		%>
	</ul>
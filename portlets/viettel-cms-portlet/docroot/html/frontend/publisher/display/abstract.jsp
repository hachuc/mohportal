<%@page import="java.text.Normalizer"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@include file="/html/frontend/publisher/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<div class="zonebar">
	<span><%=portletTitle%></span>
</div>
<div class="horzrule"></div>
		<%
			SearchContainer searchContainer = (SearchContainer) request.getAttribute("view.jsp-searchContainer");

			List<Distribution> results = (List<Distribution>) searchContainer.getResults();
			List<Distribution> lstAbstract = (List<Distribution>) request.getAttribute("view.jsp-other-results");
			
			int day = (Integer) request.getAttribute("view.day");
			
			int month = (Integer) request.getAttribute("view.month");
			
			int year = (Integer) request.getAttribute("view.year");
			
			int total = searchContainer.getTotal();
			
			SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd/MM/yyyy");
			dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT+7"));
			
			//Local time zone   
			SimpleDateFormat dateFormatLocal = new SimpleDateFormat("dd/MM/yyyy");

			Date currentDate = dateFormatLocal.parse(dateFormatGmt.format(new Date()));
			
			Calendar c = Calendar.getInstance();
			
			c.setTime(currentDate);
			
			if(!results.isEmpty()){
			for (int i = 0; i < results.size(); i++) {
				Distribution distribution = (Distribution) results.get(i);
				Date publishDate = distribution.getDistributedDate();
				Content entry = ContentLocalServiceUtil.findByContentId(distribution.getContentId(), scopeGroupId, CmsConstants.PUBLISHED_NEWS, CmsConstants.FINAL_STATUS);
				String viewURL = VCMSPubliserUtil.getViewContentURL(request, distribution, linkedLayout);
		%>
		<c:if test='<%= Validator.isNotNull(entry) %>'>
			<div class="article-abstract clearfix">
				<c:if test='<%= Validator.isNotNull(entry.getSmallImageUrl()) %>'>
					<a href="<%= viewURL%>"><img class="img-responsive" alt="" src="<%=entry.getSmallImageUrl()%>" /></a>
					<h2 class="title-new">
						<a href="<%= viewURL%>"><%=HtmlUtil.escape(entry.getTitle())%></a>
					</h2>
					<c:if test="<%= showPublishDate%>">
						<span class="time"><%=dateTimeFormat.format(publishDate)%></span>
					</c:if>
					<p class="hidden-xs" align="justify"><%=HtmlUtil.escape(entry.getSummary())%></p>
					
				</c:if>
				<c:if test='<%= Validator.isNull(entry.getSmallImageUrl())%>'>
					<h2 class="title-new">
						<a href="<%= viewURL%>"><%=HtmlUtil.escape(entry.getTitle())%></a>
					</h2>
					<c:if test="<%= showPublishDate%>">
						<span class="time"><%=dateTimeFormat.format(publishDate)%></span>
					</c:if>
					<p class="hidden-xs" align="justify"><%=HtmlUtil.escape(entry.getSummary())%></p>
				</c:if>
			</div>
		</c:if>
		<%
			}
		%>
	<c:if test='<%= !StringUtil.equalsIgnoreCase(paginationType, "none") && total > results.size() %>'>
		<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" type="<%= paginationType %>"/>
		<h2 class="other-news-title"><liferay-ui:message key="other-news-title" /></h2>
		<ul class="othernews">
			<%
			if(!lstAbstract.isEmpty()){
				for (int i = 0; i < lstAbstract.size(); i++) {
				Distribution newdistribt = (Distribution) lstAbstract.get(i);
				Date publishDate = newdistribt.getDistributedDate();
				Content entry = ContentLocalServiceUtil.findByContentId(newdistribt.getContentId(), scopeGroupId, CmsConstants.PUBLISHED_NEWS, CmsConstants.FINAL_STATUS);
				String viewURL = VCMSPubliserUtil.getViewContentURL(request, newdistribt, linkedLayout);
				
			%>
				<li><a href="<%= viewURL%>"><%= HtmlUtil.escape(entry.getTitle()) %></a>
			<% }} %>
		</ul>
	</c:if>
	<div class="view-by-date pull-right">
		<h6 class="fl_l"><liferay-ui:message key="view-by-date" /></h6> &nbsp;
		<aui:select name="vdate" label="" inlineField="true">
			
			<% for(int i = 1; i<= 31; i++) {%>
			<c:choose>
				<c:when test='<%= day > 0 && day == i%>'>
					<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" selected="true" />
				</c:when>
				<c:when test='<%= day == 0 && i == currentDate.getDate()%>'>
					<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" selected="true" />
				</c:when>
				<c:otherwise>
					<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" />
				</c:otherwise>
			</c:choose>
			<% } %>
		</aui:select>
		&nbsp;/&nbsp;
		<aui:select name="vmonth" label="" inlineField="true">
			<% for(int i = 1; i<= 12; i++) {%>
				<c:choose>
					<c:when test='<%= month > 0 && month == i%>'>
						<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" selected="true" />
					</c:when>
					<c:when test='<%= month == 0 && i == currentDate.getMonth() + 1%>'>
						<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" selected="true" />
					</c:when>
					<c:otherwise>
						<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" />
					</c:otherwise>
				</c:choose>
			<% } %>
		</aui:select> 
		&nbsp;/&nbsp;
		<aui:select name="vyear" label="" inlineField="true">
			<% for(int i = 2009; i<= c.get(Calendar.YEAR); i++) {%>
			<c:choose>
				<c:when test='<%= year > 0 && year == i%>'>
					<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" selected="true" />
				</c:when>
				<c:when test='<%= year == 0 && i == c.get(Calendar.YEAR)%>'>
					<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" selected="true" />
				</c:when>
				<c:otherwise>
					<aui:option value="<%= i%>" label="<%= String.valueOf(i)%>" />
				</c:otherwise>
			</c:choose>
			<% } %>
		</aui:select>
		<portlet:renderURL var="viewByDate">
			<portlet:param name="mvcPath" value='/html/frontend/publisher/display/abstract.jsp" %>' />
			<portlet:param name="day" value="<%= String.valueOf(currentDate.getDate()) %>"/>
			<portlet:param name="month" value="<%= String.valueOf(currentDate.getMonth()) %>"/>
			<portlet:param name="year" value="<%= String.valueOf(currentDate.getYear()) %>"/>
		</portlet:renderURL>
		<a href="javascript:void(0);" class="href-detail"><liferay-ui:message key="view-detail" /></a>
	</div>
	<aui:script use="aui-base,node">
		var A = AUI();
		var filderDate = A.one('.href-detail');
		if(filderDate){
			filderDate.on('click', function(){
				var myRenderURL =Liferay.PortletURL.createRenderURL();
				myRenderURL.setPortletId('contentpublisher_WAR_viettelcmsportlet') 
				myRenderURL.setWindowState('Normal');
				myRenderURL.setParameter('publishDay',A.one("#<portlet:namespace/>vdate").val());
				myRenderURL.setParameter('publishMonth',A.one("#<portlet:namespace/>vmonth").val());
				myRenderURL.setParameter('publishYear',A.one("#<portlet:namespace/>vyear").val());
				window.location.href = myRenderURL.toString();
			})
		}
	</aui:script>
	<% } %>
	
<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.view_jsp");
%>
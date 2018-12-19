<%@page import="com.viettel.portal.vcms.util.CmsUtil"%>
<%@page import="com.viettel.portal.vcms.service.DistributionLocalServiceUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/frontend/most-viewed/init.jsp"%> 
<c:if test="<%=Validator.isNotNull(displayStyle) %>">
	<%
			
			Date startDate = CmsUtil.getStartDate(filterByDate);
			Date endDate = CmsUtil.getEndDate();
			
			System.out.println("start-date: " + dateFormat.format(startDate) + " -->>  end-date:" + dateFormat.format(endDate));
			
			List results = DistributionLocalServiceUtil.getMostViewedNews(scopeGroupId, assetCategoryIds, startDate, endDate, 0, itemDisplay);
	
			request.setAttribute("view.jsp-searchContainer", results);
		%>
		
		<liferay-util:include page='<%="/html/frontend/most-viewed/display/" + TextFormatter.format(displayStyle, TextFormatter.N) + ".jsp" %>' servletContext="<%= application %>" />
</c:if>
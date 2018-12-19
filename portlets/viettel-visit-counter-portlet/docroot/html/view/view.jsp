<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.viettel.portal.visitcounter.model.util.VisitCounterUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<style type="text/css">

	.visit-counter-data-container{
		margin: 0px;
		padding: 0px;
		color: #434343;
		text-shadow: 1px 1px white;
	}
	
	.visit-counter-data-container .total-visit-counter{
		padding-bottom: 5px;
	}
		
	.visit-counter-data-container .counter-value{
		color: #BC0000;
		font-weight: bold;
	}
	
</style>

<%@include file="/html/init.jsp"%>

<%

	String visitorIp = com.liferay.portal.util.PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();
	
	String sessionIp = (String)session.getAttribute("visitorIp");
	
	//VisitCounterUtil.updateCounter(companyId, groupId, userId, userName);

	if(Validator.isNull(sessionIp) || !Validator.equals(sessionIp, visitorIp)){
		
		session.setAttribute("visitorIp", visitorIp);
		
		VisitCounterUtil.updateCounter(companyId, groupId, userId, userName);
		
		long lastAccessPageId = themeDisplay.getPlid();
		
		VisitCounterUtil.updateCounterLog(companyId, groupId, userId, userName, visitorIp, lastAccessPageId);
	}

	int totalCounterValue = VisitCounterUtil.getTotalVisitCounter(groupId);
	
	int onlineVisitorCounterValue = VisitCounterUtil.getOnlineVisiterCounter();
%>
<br>
<div class="visit-counter-data-container">
	<div class="total-visit-counter">
		<span><liferay-ui:message key="total-visit-counter"/>:</span>
		<span class="counter-value"><%=totalCounterValue %></span>
	</div>
	
	<div class="online-visitor-counter">
		<span><liferay-ui:message key="online-visitor-counter"/>:</span>
		<span class="counter-value"><%=onlineVisitorCounterValue %></span>
	</div>
</div>

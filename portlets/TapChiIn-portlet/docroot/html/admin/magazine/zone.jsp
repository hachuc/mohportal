<%@page import="com.viettel.portal.magazine.util.NotAloneException"%>
<%@page import="com.viettel.portal.magazine.service.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.viettel.portal.magazine.model.*" %>
<%@ include file="/html/admin/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	int magazineId = ParamUtil.getInteger(request, "magazineId",-1);
%>

<liferay-ui:search-container emptyResultsMessage="no-found-magazine-zone" delta="100">
	<%
		List<MagazineZone> list = MagazineZoneLocalServiceUtil.findByMagazineID(magazineId, searchContainer.getStart(), searchContainer.getEnd());
		total = MagazineZoneLocalServiceUtil.countByMagazineID(magazineId);
	%>
		<liferay-ui:search-container-results results="<%=list %>" total="<%=total %>"/>
		<liferay-ui:search-container-row className="MagazineZone" keyProperty="id" modelVar="mz" escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text name="name" value="<%= mz.getName()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="sortOrder" value='<%= String.valueOf( mz.getSortOrder() )%>' 
				orderable="<%=false %>"
			/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
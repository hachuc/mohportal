<%@page import="com.viettel.portal.magazine.util.NotAloneException"%>
<%@page import="com.viettel.portal.magazine.service.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.viettel.portal.magazine.model.*" %>
<%@ include file="/html/admin/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	int magazineId = ParamUtil.getInteger(request, "magazineId",-1);
	List<MagazineZone> zones = MagazineZoneLocalServiceUtil.findByMagazineID(magazineId, 0, Integer.MAX_VALUE);
%>
<liferay-ui:search-container emptyResultsMessage="no-found-magazine-content" delta="100">
	<%
		List<MagazineContent> list = MagazineContentLocalServiceUtil.findByMagazineID(magazineId, searchContainer.getStart(), searchContainer.getEnd());
		total = MagazineContentLocalServiceUtil.countByMagazineID(magazineId);
	%>
		<liferay-ui:search-container-results results="<%=list %>" total="<%=total %>"/>
		<liferay-ui:search-container-row className="MagazineContent" keyProperty="id" modelVar="mc" escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text name="name" value="<%= mc.getHeadline()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="author" value="<%= mc.getAuthor()%>" 
				orderable="<%=false %>"
			/>
			<%
				String zoneName = "";
				for(MagazineZone mz : zones){
					if (mc.getMagazineZoneID() == mz.getID()){
						zoneName = mz.getName();
						break;
					}
				}
			%>
			<liferay-ui:search-container-column-text name="magazineZoneID" value="<%= zoneName %>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="sortOrder" value='<%= String.valueOf( mc.getSortOrder() )%>' 
				orderable="<%=false %>"
			/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
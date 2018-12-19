<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@ page import="com.viettel.portal.vcms.model.Content"%>
<%@ include file="/html/frontend/publisher/init.jsp" %>

<c:if test="<%=Validator.isNotNull(displayStyle) %>">
	<%
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			int year = cal.get(Calendar.YEAR);
	
			PortletURL portletURL = renderResponse.createRenderURL();
			
			SearchContainer<Distribution> searchContainer = new SearchContainer<Distribution>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, itemDisplay, portletURL, null, null);
			searchContainer.setDelta(itemDisplay);
			searchContainer.setDeltaConfigurable(false);
			List<Distribution> results = null;
			List<Distribution> otherList = null;
			int total = 0;
			
			
	
			int publishDay = ParamUtil.getInteger(request, "publishDay");
			int publishMonth = ParamUtil.getInteger(request, "publishMonth");
			int publishYear = ParamUtil.getInteger(request, "publishYear");

			PortletURL searchURL = searchContainer.getIteratorURL();
			searchURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
			String searchURLStr = searchURL.toString();
			
			if(publishDay > 0 && publishMonth > 0 && publishYear > 0){
				PortletURL iteratorURL = searchContainer.getIteratorURL();
				iteratorURL.setParameter("publishDay", String.valueOf(publishDay));
				iteratorURL.setParameter("publishMonth", String.valueOf(publishMonth));
				iteratorURL.setParameter("publishYear", String.valueOf(publishYear));
				searchContainer.setIteratorURL(iteratorURL);
				cal.set(publishYear, publishMonth - 1, publishDay, 0, 0);
				String publishDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
				results = VCMSPubliserUtil.getContentsByDate(scopeGroupId, categoryIds, publishDate, searchContainer.getStart(), searchContainer.getEnd());
				total = VCMSPubliserUtil.countByPublishedDate(scopeGroupId, categoryIds, publishDate);
				request.setAttribute("view.jsp-date-filter", publishDate);
			}else{
				results = VCMSPubliserUtil.getContents(scopeGroupId, categoryIds, searchContainer.getStart(), searchContainer.getEnd());
				otherList = VCMSPubliserUtil.getContents(scopeGroupId, categoryIds, searchContainer.getStart() + itemDisplay, searchContainer.getEnd() + itemDisplay);
				total = VCMSPubliserUtil.getDistributionCount(scopeGroupId, categoryIds);
			}
			
			searchContainer.setTotal(total);
			searchContainer.setResults(results);
			
			request.setAttribute("view.jsp-searchContainer", searchContainer);
			request.setAttribute("view.jsp-total", total);
			request.setAttribute("view.jsp-results", results);
			request.setAttribute("view.jsp-other-results", otherList);
		%>
		
		<liferay-util:include page='<%="/html/frontend/publisher/display/" + TextFormatter.format(displayStyle, TextFormatter.N) + ".jsp" %>' servletContext="<%= application %>" />
</c:if>

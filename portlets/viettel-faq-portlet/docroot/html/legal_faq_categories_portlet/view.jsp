<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@include file="/html/legal_faq_categories_portlet/init.jsp"%>
<%
	List<LegalFAQCategory> legalFAQCategoryList = new ArrayList<LegalFAQCategory>();
	
	if(numbersOfCategoriesDisplay <= 0){
		
		legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByGroup(scopeGroupId);
	}else{
		
		legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByGroup(scopeGroupId, 0, numbersOfCategoriesDisplay);
	}
%>


<div class="legal_faq_categories_default_style">
	<ul>
		<%
			for(LegalFAQCategory legalFAQCategory : legalFAQCategoryList)
			{
				long categoryId = legalFAQCategory.getCategoryId();
				
				String categoryName = legalFAQCategory.getCategoryName();
		%>
				<liferay-portlet:renderURL var="viewCategoryURL">
					<liferay-portlet:param  name="legalFAQCategoryId" value="<%=String.valueOf(categoryId)%>"/>
				</liferay-portlet:renderURL>
											
				<li>
					<a href="<%= viewCategoryURL%>"><%=categoryName%></a>
					
		  		    <c:if test="<%=displayFAQCounter %>">
		  		    	<%
		  		    	int faqCounterValue = LegalFAQEntryLocalServiceUtil.countByCategory(scopeGroupId, categoryId,
		  		    		LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE, LegalFAQConstants.LEGAL_FAQ_ENTRY_ANSWERED_STATUS_VALUE);
		  		    	%>
		  		    	<span class="faq-counter-value">
		  		    		(<%=faqCounterValue %>)
		  		    	</span>
		  		    </c:if>
			    </li>
		<%
			}
		%>
	</ul>
</div>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="sun.security.acl.GroupImpl"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<style type="text/css">
	.aui .faq-search .form-group, .aui .control-group{
		margin-bottom: 0px;
	}
	.aui .faq-search .breadcrumb {
	     padding: unset;
	     margin-bottom: unset;
	     list-style: unset;
	     background-color: unset;
	     border-radius: unset;
	    font-size: 18px;
	    color: rgba(255, 255, 255, 0.7);
	}
	.aui .faq-search nav a.breadcrumb {
	    color: #757575;
	    font-size: 14px;
	}
	.aui .faq-search .breadcrumb:first-child:before {
	    display: none;
	}
	.aui .faq-search nav a.breadcrumb:before {
	    color: #757575;
	    font-size: 16px;
	}
	.aui .faq-search .breadcrumb:before {
	    content: '/';
	    color: rgba(255, 255, 255, 0.7);
	    vertical-align: top;
	    display: inline-block;
	    font-weight: normal;
	    font-style: normal;
	    font-size: 25px;
	    margin: 0 10px 0 8px;
	    -webkit-font-smoothing: antialiased;
	}
	.aui .faq-search nav a.breadcrumb:last-child {
	    color: #757575;
	}
	.aui .faq-search nav a.breadcrumb {
	    color: #757575;
	    font-size: 14px;
	}
	.faq-search label {
	    font-size: 0.8rem;
	    color: #9e9e9e;
	}
</style>

<%
	//Tu khoa tim kiem FAQ Entry
	String faqSearchKeyword = ParamUtil.getString(request, "faqSearchKeyword",StringPool.BLANK);

	//Danh sach linh vuc hoi dap
	List<LegalFAQCategory> legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByGroup(scopeGroupId);

	//Id cua FAQ Category chon tu select box trong form search
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);

	//Id cua FAQ Category lay tu URL lien ket voi portlet Viettel FAQ Categories
	long legalFAQCategoryId = ParamUtil.getLong(request, "legalFAQCategoryId",0L);

	if(legalFAQCategoryId > 0){

		categoryId = legalFAQCategoryId;
	}

	//Ket qua tim kiem FAQ Entry
	List<LegalFAQEntry> legalFAQEntryList = LegalFAQEntryLocalServiceUtil.findByKeywordAndStatus(scopeGroupId, categoryId, faqSearchKeyword, 0, -1);

%>

	<liferay-portlet:renderURL var="FAQHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
		<liferay-portlet:param name="legalFAQCategoryId" value="0" />
	</liferay-portlet:renderURL>
<div class="page-content boxed faq-search">
	<div class="row">
		<div class="col-md-12">
			<nav class="nav_breadcrumb mag_row">
				<div class="nav-wrapper">
					<div class="col s12">
						<a href="/" class="breadcrumb">Trang chủ</a>
						<a href="<%=themeDisplay.getLayoutTypePortlet().getLayout().getFriendlyURL() %>" class="breadcrumb"><liferay-ui:message key="legal-faq-search-form"/> </a>
			  		</div>
				</div>
		  	</nav>
	  	</div>
	  	</div>
		<div class="row mt20">
			<div class="mag_row">
				<aui:form name="faq_search_form" method="post" action="<%=FAQHomePageURL %>">
					<div class="form-group col-md-12">
						<div class="input-field col-md-6">
							<aui:input label="" type="text" name="faqSearchKeyword" value="<%=faqSearchKeyword%>" placeholder="search-faq-content"/>
						</div>
						<div class="input-field col-md-6">
							<aui:select name="categoryId" label="" >
								<aui:option value="0" selected="<%=(categoryId == 0L) %>" label="faq-categories" />
								<%
								for(LegalFAQCategory searchCategory : legalFAQCategoryList){
								%>
									<aui:option value="<%=searchCategory.getCategoryId()%>" label="<%=searchCategory.getCategoryName() %>"
												selected="<%=(categoryId == searchCategory.getCategoryId())%>" />
								<%
								}
								%>
							</aui:select>
						</div>
					</div>
					<div class="form-group col-md-12 mt10 " style="text-align: center;">
						<aui:button cssClass="btn light-blue" type="submit" value="search"/>
					</div>
				</aui:form>
			</div>
		</div>

		<c:if test='<%=legalFAQCategoryId > 0L %>'>
			<%
				String selectedCategoryName = "";

				LegalFAQCategory selectedFAQCategory = LegalFAQCategoryLocalServiceUtil.getCategory(legalFAQCategoryId);

				if(selectedFAQCategory != null){

					selectedCategoryName = selectedFAQCategory.getCategoryName();
				}
			%>
			<div class="col-md-12 category-faqs-title">
				<c:choose>
					<c:when test="<%=legalFAQEntryList.size() > 0 %>">
						<liferay-ui:message arguments="<%= selectedCategoryName %>" key="faq-entries-with-category-x" />
					</c:when>

					<c:otherwise>
						<liferay-ui:message arguments="<%= selectedCategoryName %>" key="no-faq-entry-exist-with-category-x" />
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>

		<div class="col-md-12" style="text-align: right;">
			<liferay-portlet:renderURL var="giveAskURL" >
				<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/give_ask_form.jsp" />
			</liferay-portlet:renderURL>
			<aui:a cssClass="faq-link" value="" href="<%=giveAskURL %>"><liferay-ui:message key="give-ask"/></aui:a>
		</div>

	<div class="col-md-12 legal-faq-entries-list">

		<liferay-portlet:renderURL varImpl="FAQHomePageImplURL">
			<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
			<liferay-portlet:param name="faqSearchKeyword" value="<%=faqSearchKeyword %>" />
			<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container emptyResultsMessage="no-search-result-found" delta="10" iteratorURL="<%=FAQHomePageImplURL %>" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(legalFAQEntryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=legalFAQEntryList.size() %>"
			>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row className="LegalFAQEntry" keyProperty="entryId" modelVar="legalFAQEntry" >
			<%
				//Tieu de cau hoi
				String askTitle = legalFAQEntry.getAskTitle();

				//Noi dung cau hoi
				String askContent = legalFAQEntry.getAskContent();

				if(askContent.length() > 300){
					askContent = StringUtil.shorten(askContent, 300) + "...";
				}

				String senderName = legalFAQEntry.getCitizenName();

				String sendDate = dateFormat.format(legalFAQEntry.getCreateDate());

				String cateName = "";
				if(legalFAQEntry.getCategoryId() > 0){
					for(LegalFAQCategory cate : legalFAQCategoryList){
						if(cate.getCategoryId() == legalFAQEntry.getCategoryId()){
							cateName = cate.getCategoryName();
							break;
						}
					}
				}
			%>

				<liferay-portlet:renderURL var="viewEntryURL" >
					<liferay-portlet:param name="legalFAQEntryId" value="<%=String.valueOf(legalFAQEntry.getEntryId())%>"/>
					<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view_faq_entry.jsp" />
				</liferay-portlet:renderURL>

				<div class="faq-entry">
					<div class="ask-title">
						<a href="<%=viewEntryURL%>"><%=askTitle %></a>
					</div>

					<div style="clear: both;"></div>

					<div class="ask-content"><%=askContent %></div>

					<div style="clear: both;"></div>

					<div class="ask-metadata">
						<liferay-ui:message key="send-by"/> :&nbsp; <%=senderName %>
						<br/>
						<liferay-ui:message key="FAQCategories"/> :&nbsp; <%=cateName%>	&nbsp; <liferay-ui:message key="send-date"/> :&nbsp; <%=sendDate %>
					</div>
				</div>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
	</div>
	<liferay-portlet:renderURL var="giveAskFormURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/give_ask_form.jsp" />
	</liferay-portlet:renderURL>

	<script type="text/javascript">

		AUI().ready('aui-base',function(A){

			var faqSearchKeywordInput = A.one('#<portlet:namespace/>faqSearchKeywordInput');

			if(faqSearchKeywordInput){

				faqSearchKeywordInput.focus();
			}
		});
	</script>

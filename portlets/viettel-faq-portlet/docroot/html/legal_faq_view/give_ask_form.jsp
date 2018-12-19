<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<style type="text/css">
	.aui .faq-form .breadcrumb {
	     padding: unset;
	     margin-bottom: unset;
	     list-style: unset;
	     background-color: unset;
	     border-radius: unset;
	    font-size: 18px;
	    color: rgba(255, 255, 255, 0.7);
	}
	.aui .faq-form nav a.breadcrumb {
	    color: #757575;
	    font-size: 14px;
	}
	.aui .faq-form .breadcrumb:first-child:before {
	    display: none;
	}
	.aui .faq-form nav a.breadcrumb:before {
	    color: #757575;
	    font-size: 16px;
	}
	.aui .faq-form .breadcrumb:before {
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
	.aui .faq-form nav a.breadcrumb:last-child {
	    color: #757575;
	}
	.aui .faq-form nav a.breadcrumb {
	    color: #757575;
	    font-size: 14px;
	}
	.faq-form .note{
		text-align: right;
	    font-size: 0.85rem;
	    font-style: italic;
	}
</style>

<%
	//Danh sach linh vuc hoi dap
	List<LegalFAQCategory> legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByCompany(companyId);

	String askContent = "";

	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitGiveAskForm();";
%>

<div class="page-content boxed faq-form">
	<div class="row">
		<div class="col-md-12">
			<nav class="nav_breadcrumb mag_row">
				<div class="nav-wrapper">
					<div class="col s12">
						<a href="/" class="breadcrumb">Trang chủ</a>
						<a href="<%=themeDisplay.getLayoutTypePortlet().getLayout().getFriendlyURL() %>" class="breadcrumb"><liferay-ui:message key="ndlh-gui-hien-ke"/></a>
			  		</div>
				</div>
		  	</nav>
	  	</div>
	  	</div>
		<div class="row mt15">
			<div class="mag_row">

	<liferay-ui:error key="give-ask-unsuccess" message="error-when-send-ask-content" />

	<liferay-ui:success key="give-ask-success" message="thank-you-for-your-ask-content" />

	<liferay-ui:error key="invalid-captcha" message="invalid-captcha"/>

	<liferay-portlet:resourceURL var="captchaURL"/>

	<liferay-portlet:renderURL var="FAQHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
	</liferay-portlet:renderURL>

	<liferay-portlet:actionURL name="updateAskContent"  var="updateAskContentActionURL">
		<liferay-portlet:param name="entryCommand" value="updateAskContent" />
		<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>" />
	</liferay-portlet:actionURL>

		<aui:form name="legal_faq_give_ask_form" method="post" action="<%=updateAskContentActionURL %>" onSubmit="<%=taglibOnSubmit %>">
			<div class="sub-title note col-md-12">
				<liferay-ui:message key="please-enter-valid-information-into-this-application-form"/>
			</div>
			<div class="mt15">
				<div class="form-group col-md-12">
					<div class="input-field">
						<aui:input type="text" name="citizenName" label="full-name">
							<aui:validator name="required"/>
						</aui:input>
					</div>
				</div>
				<div class="form-group col-md-12">
					<div class="input-field col-md-6 pl0">
						<aui:input type="text" name="citizenPhone" label="phone-numbers"/>
					</div>

					<div class="input-field col-md-6 pr0">
						<aui:input type="text" name="citizenEmail" label="email-address"/>
					</div>
				</div>

				<div class="form-group col-md-12">
					<div class="input-field">
						<aui:select name="categoryId" label="faq-category" >
							<aui:option label="other-faq-category" value="0"/>
							<%
							for(LegalFAQCategory faqCategory : legalFAQCategoryList){
							%>
								<aui:option label="<%=faqCategory.getCategoryName() %>" value="<%=faqCategory.getCategoryId()%>" />
							<%
							}
							%>
						</aui:select>
					</div>
				</div>

				<div class="form-group col-md-12">
					<div class="input-field">
						<aui:input type="text" name="askTitle">
							<aui:validator name="required"/>
						</aui:input>
					</div>
				</div>

				<div class="col-md-12" style="padding-top:5px;padding-bottom:5px; display: block;font-weight: bold; text-align: center;  text-transform: uppercase;">
					<liferay-ui:message key="ask-content"/> (<liferay-ui:message key="required"/>)
				</div>

				<div class="col-md-12 form-group ">
					<liferay-ui:input-editor name="askContentEditor" width="60%" height="60%"/>
				</div>
				<div class="col-md-12">
					<aui:layout>
					  <aui:column>
					    <liferay-ui:captcha url="<%=captchaURL %>"/>
					  </aui:column>
					</aui:layout>
				</div>
			</div>

			<div class="form-group col-md-12 aui-button-holder mb15 pl0" style="text-align: center;">
				<aui:button cssClass="btn" type="submit" value="give-ask"/>
				<aui:button cssClass="btn other-button" value="cancel" href="<%=FAQHomePageURL %>"/>
			</div>

			<aui:input  type="hidden" name="askContent" />
			<aui:input type="hidden" name="<%=LegalFAQConstants.FAQ_ENTRY_COMMAND %>" value="<%=LegalFAQConstants.UPDATE_ASK_CONTENT %>"/>
		</aui:form>
	</div>
</div>
</div>

<script type="text/javascript">
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){

		var citizenNameInput = A.one('#<portlet:namespace/>citizenName');

		if(citizenNameInput){
			citizenNameInput.focus();
		}

		
		var reloadCaptchaBtn = A.one(".captcha_reload");

		if(reloadCaptchaBtn){

			reloadCaptchaBtn.on('click', function(){

				var captchaValue = A.one(".captcha");

				captchaValue.setAttribute("src", "<%= captchaURL %>&force=" + new Date().getMilliseconds());
			});
		}

		Liferay.provide(
			window,
			'<portlet:namespace />submitGiveAskForm',
			function() {

				window.validator = new A.FormValidator({

			        boundingBox: document.<portlet:namespace />legal_faq_give_ask_form,

			        rules: {
			            <portlet:namespace />citizenName: {
			                required: true,
			                rangeLength: ['3','75']
			            },
			            <portlet:namespace />citizenPhone: {
			                required: false,
			                digits: true,
			                rangeLength: ['0','75']
			            },
			           	<portlet:namespace />citizenEmail: {
			                required: false,
			                email: true,
			                rangeLength: ['0','75']
			            },
			           	<portlet:namespace />askTitle: {
			                required: true,
			                rangeLength: ['3','300']
			            }
			        }
			    });

				window.validator.validate();

				if (!window.validator.hasErrors()) {

					var askContent = window.<portlet:namespace />askContentEditor.getHTML();

					if(askContent.length > 0){

						document.<portlet:namespace />legal_faq_give_ask_form.<portlet:namespace />askContent.value = askContent;

						document.<portlet:namespace />legal_faq_give_ask_form.submit();

					}else{

						alert('<%= UnicodeLanguageUtil.get(pageContext, "please-enter-ask-content") %>');
					}
				}
			},
			['aui-base']
		);
	});
</script>

<aui:script>

	function <portlet:namespace />initEditor() {

		return "<%= UnicodeFormatter.toString(askContent) %>";
	}
</aui:script>

<%@page import="com.viettel.portal.feedback.FeedbackPortlet"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page
	import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Danh sach linh vuc hoi dap
	//List<LegalFAQCategory> legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByCompany(companyId);
	String askContent = "";
	String visitorIp = com.liferay.portal.util.PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();
%>



<div class="page-content boxed faq-form">
	<liferay-ui:error key="give-ask-unsuccess"
		message="error-when-send-ask-content" />
	<liferay-ui:success key="give-ask-success"
		message="thank-you-for-your-ask-content" />

	<liferay-ui:error key="invalid-captcha" message="invalid-captcha" />

	<liferay-portlet:resourceURL var="captchaURL" />

	<liferay-portlet:actionURL name="addFeedback"
		var="updateAskContentActionURL">
		<liferay-portlet:param name="entryCommand" value="addFeedback" />
		<liferay-portlet:param name="redirectURL"
			value="<%=PortalUtil.getCurrentURL(request)%>" />
	</liferay-portlet:actionURL>
</div>
<div class="ct-pakn">
	<div class="title-pakn">PHẢN ÁNH KIẾN NGHỊ</div>
	<div id="Danh-sach-comment">
		<div>
		<form name="legal_faq_give_survey_form" method="post" class="form-horizontal"
			action="<%=updateAskContentActionURL%>" enctype="multipart/form-data">
			<div class="form-group message"></div>
			<aui:input type="hidden" name="fileId"/>
			<aui:input type="hidden" name="fileURL"/>
			<aui:input type="hidden" name="visitorIp" value="<%= visitorIp %>"/>
			<div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />title">Tiêu đề <span class="star">*</span></label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="<portlet:namespace />title" placeholder="<liferay-ui:message key='nhap-tieu-de' />" name="<portlet:namespace />title" required />
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />summary">Tóm tắt nội dung <span class="star">*</span></label>
		      <div class="col-sm-9">
		        <textarea class="form-control" id="<portlet:namespace />summary" name="<portlet:namespace />summary" required></textarea>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />body">Soạn thảo nội dung <span class="star">*</span></label>
		      <div class="col-sm-9">
		        <textarea class="form-control" id="<portlet:namespace />body" name="<portlet:namespace />body" required></textarea>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />title">Họ tên<span class="star">*</span></label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="<portlet:namespace />fullName" placeholder="<liferay-ui:message key='nhap-ho-ten' />" name="<portlet:namespace />fullName" required />
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />workFor">Họ tên<span class="star">*</span></label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="<portlet:namespace />workFor" 
		        	placeholder="<liferay-ui:message key='don-vi-cong-tac' />" name="<portlet:namespace />workFor" required />
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />phone">Điện thoại <span class="star">*</span></label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="<portlet:namespace />phone" 
		        	placeholder="<liferay-ui:message key='don-vi-cong-tac' />" name="<portlet:namespace />phone" required />
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />Email"> Email<span class="star">*</span></label>
		      <div class="col-sm-9">
		        <input type="email" class="form-control" id="<portlet:namespace />Email" placeholder="<liferay-ui:message key='nhap-email' />" name="<portlet:namespace />Email" required />
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />address"> Địa chỉ <span class="star">*</span></label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="<portlet:namespace />address" placeholder="<liferay-ui:message key='nhap-dia-chi' />" 
		        name="<portlet:namespace />address" required />
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />address"></label>
		      <div class="col-sm-9">
		        <liferay-ui:captcha url="<%=captchaURL%>"/>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="<portlet:namespace />address"></label>
		      <div class="col-sm-9">
		        <aui:button cssClass="btn btn-primary" type="submit"
					value="Gửi phản ánh" name="btnSubmit" />
		      </div>
		    </div>
		</form>
	</div>
</div>
</div>

<script type="text/javascript">	
	$(function () {

		var reloadCaptchaBtn = $(".captcha_reload");

		if(reloadCaptchaBtn){

			reloadCaptchaBtn.on('click', function(){

				var captchaValue = $(".captcha");
				
				captchaValue.attr("src",'<%=captchaURL + "&force="%>
	'
						+ new Date().getMilliseconds());
			});
		}
		window.verifyRecaptchaCallback = function(response) {
			$('input[data-recaptcha]').val(response).trigger('change');
		}

		window.expiredRecaptchaCallback = function() {
			$('input[data-recaptcha]').val("").trigger('change');
		}

		$("#legal_faq_give_survey_form").validator();

		$("#legal_faq_give_survey_form")
				.on(
						'submit',
						function(e) {
							if (!e.isDefaultPrevented()) {
								var alertBox = '<div class="alert ' + messageAlert + ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>';
								$(
										'#<portlet:namespace/>legal_faq_give_ask_form')
										.find('.messages').html(alertBox);
								return false;
							}
						})

		$("#legal_faq_give_survey_form input[type='radio']")
				.on('click', function() {
					if ($(this).val() == 6) {
						$("#otherComment").removeClass("hidden");
					} else {
						if (!$("#otherComment").hasClass("hidden"))
							$("#otherComment").addClass("hidden");
						$("#<portlet:namespace />message").val($(this)parent().text());
					}
				});
	});
</script>
<style type="text/css">
	
    .ct-pakn { margin-left: 10px;}
     .title-pakn {
         font-size: 19px;
         font-weight: bold;
         text-align: center;
         text-transform: uppercase;
         padding: 10px;
    	margin-bottom: 15px;
     }
    #Danh-sach-comment,.title-pakn {
        background: #EAF0F6;
    }
    #popup {
        background: #fff;
        border-radius: 10px;
        padding: 60px 35px;
    }
    
   .aui .control-group.input-text-wrapper{
    	margin-bottom: 0px !important;
    }
    
    .form-comment
    {
        
    }
    
    span.star {
	    color: Red;
	    font-weight: bold;
	}
    
    .form-comment li
    {
        display: inline-block;
        clear: both;
        width: 100%;
        padding: 5px 0px;
    }
    .form-comment li span.label2 {
        color: #333;
        display: block;
        float: left;
        font: 12px Arial,Helvetica,sans-serif;
        padding-top: 2px;
        width: 120px;
        padding-left: 10px;
        font-weight: bold;
    }
    .form-comment li input[type=text], .form-comment li select, .form-comment li textarea
    {
        border: 1px solid #ccc;
        font: 12px Arial,Helvetica,sans-serif;
        padding: 3px;
        width: 540px;
    }
    .form-comment li textarea
    {
        height: 100px;
    }
    .form-comment li.submit
    {
        text-align: center;
        margin-left:-6px !important;
    }
    #CaptchaImage
    {
        border: 1px solid #CCCCCC;
        float: left;
        margin-right: 10px;
    }
    .captcha
    {
        float: left;
        margin-right: 5px;
        width: 100px !important;
        margin-top: 26px;
    }
    a.captcha
    {
        margin: 26px 0 0 4px;
    }
    .ms-WPBody
    {
        font-family: arial,helvetica,sans-serif;
        font-size: 8pt;
    }
    .button.b-close, .button.bClose {
        border-radius: 7px;
        box-shadow: none;
        font: bold 131% sans-serif;
        padding: 0 6px 2px;
        position: absolute;
        right: -7px;
        top: -7px;
    }
    .button {
        background-color: #2b91af;
        border-radius: 10px;
        box-shadow: 0 2px 3px rgba(0, 0, 0, 0.3);
        color: #fff;
        cursor: pointer;
        display: inline-block;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
    }
    #popup p {
        font-size: 15px;
        font-weight: bold;
    }
</style>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page
	import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page
	import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Danh sach linh vuc hoi dap
	List<LegalFAQCategory> legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByCompany(companyId);

	String askContent = "";
%>

<div class="page-content boxed faq-form">
	<liferay-ui:error key="give-ask-unsuccess"
		message="error-when-send-ask-content" />
	<liferay-ui:success key="give-ask-success"
		message="thank-you-for-your-ask-content" />

	<liferay-ui:error key="invalid-captcha" message="invalid-captcha" />

	<liferay-portlet:resourceURL var="captchaURL" />

	<liferay-portlet:actionURL name="updateAskContent"
		var="updateAskContentActionURL">
		<liferay-portlet:param name="entryCommand" value="updateAskContent" />
		<liferay-portlet:param name="redirectURL"
			value="<%=PortalUtil.getCurrentURL(request)%>" />
	</liferay-portlet:actionURL>
	
	<div class="row">
    <h1 class="header-title"> CỤC SỞ HỮU TRÍ TUỆ </h1>
    <hr>
    <div class="col-sm-12" id="parent">
    	<div class="col-sm-6">    	
    	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.997653347368!2d105.80838586658155!3d20.99273118398859!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135accf3a503a6b%3A0xb1f8fddace4f2590!2zQ-G7pWMgU-G7nyBI4buvdSBUcsOtIFR14buHIC0gQuG7mSBLSCBWw6AgQ8O0bmcgTmdo4buH!5e0!3m2!1svi!2s!4v1527489420179" width="100%" height="320px;" frameborder="0" style="border:0" allowfullscreen></iframe>
    	</div>

    	<div class="col-sm-6">
    		<div class="form-area">
				<aui:form name="legal_faq_give_ask_form" method="post" action="<%=updateAskContentActionURL%>">
						<div class="form-group">
							<input type="text" class="form-control"
								name="<portlet:namespace />name" placeholder="Họ và Tên"
								required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								name="<portlet:namespace />email" placeholder="Email" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								name="<portlet:namespace />address" placeholder="Địa chỉ">
						</div>
						<div class="form-group">
							<textarea class="form-control" type="textarea"
								name="<portlet:namespace />message"
								placeholder="Nội dung phản hồi" maxlength="140" rows="7"
								required></textarea>
						</div>
						<div class="form-group">
							<aui:column>
							    <liferay-ui:captcha url="<%=captchaURL %>"/>
							</aui:column>
						</div>
						<aui:button cssClass="btn btn-primary pull-right" type="submit" value="Gửi đi" name="btnSubmit"/>
				</aui:form>
			</div>
    	</div>
    </div>
  </div>
</div>

<script type="text/javascript">	
	$(function () {

		var reloadCaptchaBtn = $(".captcha_reload");

		if(reloadCaptchaBtn){

			reloadCaptchaBtn.on('click', function(){

				var captchaValue = $(".captcha");
				
				captchaValue.attr("src","<%= captchaURL %>&force=" + new Date().getMilliseconds());
			});
		}
	    window.verifyRecaptchaCallback = function (response) {
	        $('input[data-recaptcha]').val(response).trigger('change');
	    }

	    window.expiredRecaptchaCallback = function () {
	        $('input[data-recaptcha]').val("").trigger('change');
	    }

	    $("#<portlet:namespace/>legal_faq_give_ask_form").validator();

	    $("#<portlet:namespace/>legal_faq_give_ask_form").on('submit', function (e) {
	        if (!e.isDefaultPrevented()) {
	            var url = "contact.php";

	            $.ajax({
	                type: "POST",
	                url: url,
	                data: $(this).serialize(),
	                success: function (data) {
	                    var messageAlert = 'alert-' + data.type;
	                    var messageText = data.message;

	                    var alertBox = '<div class="alert ' + messageAlert + ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>' + messageText + '</div>';
	                    if (messageAlert && messageText) {
	                        $('#contact-form').find('.messages').html(alertBox);
	                        $('#contact-form')[0].reset();
	                        grecaptcha.reset();
	                    }
	                }
	            });
	            return false;
	        }
	    })
	});
</script>

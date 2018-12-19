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
		<h1 class="header-title">ĐÁNH GIÁ MỨC ĐỘ PHỤC VỤ CỦA CÁC ĐƠN VỊ
			TRỰC THUỘC CỤC SỞ HỮU TRÍ TUỆ</h1>
		<hr>
		<div class="col-sm-10 col-md-offset-1" id="parent">
			<div class="form-area">
				<aui:form name="legal_faq_give_survey_form" method="post"
					action="<%=updateAskContentActionURL%>">
					<div class="form-group message"></div>
					<div class="form-group">
						<label class="label-control">Họ và Tên <span
							calss="required">*</span></label> <input type="text" class="form-control"
							name="<portlet:namespace />name" placeholder="Họ và Tên" required>
					</div>
					<div class="form-group">
						<label class="label-control">Email <span calss="required">*</span></label>
						<input type="text" class="form-control"
							name="<portlet:namespace />email" placeholder="Email" required>
					</div>
					<div class="form-group">
						<label class="label-control">Địa chỉ</label> <input type="text"
							class="form-control" name="<portlet:namespace />address"
							placeholder="Địa chỉ">
					</div>
					<div class="form-group">
						<aui:select name="categoryId" label="faq-dept">
							<aui:option label="other-faq-category" value="0" />
							<%
								for(LegalFAQCategory faqCategory : legalFAQCategoryList){
							%>
							<aui:option label="<%=faqCategory.getCategoryName()%>"
								value="<%=faqCategory.getCategoryId()%>" />
							<%
								}
							%>
						</aui:select>
					</div>
					<div class="form-group clearfix">
						<table class="table table-borderless">
							<tr>
								<td><label class="radio-inline"> <input
										type="radio" name="optradio" value="1">Rất hài lòng
								</label></td>
								<td><label class="radio-inline"> <input
										type="radio" name="optradio" value="2">Hài lòng
								</label></td>
								<td><label class="radio-inline"> <input
										type="radio" name="optradio" value="3">Bình thường
								</label></td>
							</tr>
							<tr>
								<td><label class="radio-inline"> <input
										type="radio" name="optradio" value="4">Không hài lòng
								</label></td>
								<td><label class="radio-inline"> <input
										type="radio" name="optradio" value="5">Rất không hài
										lòng
								</label></td>
								<td><label class="radio-inline"> <input
										type="radio" name="optradio" value="6">Ý kiến khác
								</label></td>
							</tr>
						</table>
					</div>
					<div class="form-group hidden" id="otherComment">
						<label class="label-control">Ý kiến khác</label>
						<textarea class="form-control" type="textarea"
							name="<portlet:namespace />message"
							placeholder="Nội dung phản hồi" maxlength="140" rows="7" required></textarea>
					</div>
					<div class="form-group">
						<aui:column>
							<liferay-ui:captcha url="<%=captchaURL%>" />
						</aui:column>
					</div>
					<aui:button cssClass="btn btn-primary pull-right" type="submit"
						value="Gửi ý kiến" name="btnSubmit" />
				</aui:form>
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

		$("#<portlet:namespace/>legal_faq_give_survey_form").validator();

		$("#<portlet:namespace/>legal_faq_give_survey_form")
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

		$("#<portlet:namespace/>legal_faq_give_survey_form input[type='radio']")
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

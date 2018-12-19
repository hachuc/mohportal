<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@page import="com.viettel.portal.vcms.permission.CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.viettel.portal.vcms.model.Category"%>
<%@ page
	import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@include file="/html/admin/list-content/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	System.out.println("reject_content");
	Content content = null;
	String createByUserName = StringPool.BLANK;
	long autoId = ParamUtil.getLong(request, "autoId", 0);
	int version= ParamUtil.getInteger(request, "version", 0);
	int status= ParamUtil.getInteger(request, "status", 0);
	String redirectURL = ParamUtil.getString(request, "redirectURL");

	String backURL = ParamUtil.getString(request, "backURL");
	String viewPageUrl = VCMSPubliserUtil.viewPageUrl(request, linkedLayout);
	if(autoId > 0){
		Content detectContent = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
		if(detectContent!=null){
	content = detectContent;
	createByUserName = content.getCreatedByUserName();
		}
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitContentForm();";
	boolean isValid = true;
	
	if(content.getVersion()==2 && content.getStatus()==16 && content!=null && (content.getEditedByUserId() > 0 && content.getEditedByUserId() != userId)){
		isValid = false;
		SessionMessages.add(request, "err");
	}
	
	if(content.getVersion()==3 && content.getStatus()==512 && content!=null && (content.getReviewedByUserId() > 0 && content.getReviewedByUserId() != userId)){
		isValid = false;
		SessionMessages.add(request, "err");
	}
	
	if(content.getVersion()==3 && content.getStatus()==128 && content!=null && (content.getEditedByUserId() > 0 && content.getEditedByUserId() != userId)){
		isValid = false;
		SessionMessages.add(request, "err");
	}
	
	if(content.getVersion()==4 && content.getStatus()==64 && content!=null && (content.getEditedByUserId() > 0 && content.getEditedByUserId() != userId)){
		isValid = false;
		SessionMessages.add(request, "err");
	}
	
	if(content.getVersion()==4 && content.getStatus()==4096 && content!=null && (content.getPublishedByUserId() > 0 && content.getPublishedByUserId() != userId)){
		isValid = false;
		SessionMessages.add(request, "err");
	}
%>
<c:if test='<%= !isValid %>'>
	<div class="alert danger"><liferay-ui:message key="khong-co-quyen-tra-bai" /></div>
</c:if>
<aui:form name="fm" method="post" action="" cssClass="form-horizontal"
	onSubmit='<%= taglibOnSubmit %>' enctype="multipart/form-data">
	<aui:input name="redirect" type="hidden" value="<%=redirectURL%>" />
	<aui:input name="groupId" type="hidden" value="<%=scopeGroupId%>" />
	<aui:input name="autoId" type="hidden" value="<%=content!=null?content.getAutoId():0%>" />
	<aui:input name="version" type="hidden" value="<%=content!=null?content.getVersion():0%>" />
	
	<aui:model-context bean="<%=content%>" model="<%=Content.class%>" />
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12">
			<liferay-ui:message	key="title" /> (<liferay-ui:message key="*" />)
		</label>
		<div class="col-sm-7 col-xs-12">
			<liferay-portlet:renderURL var="viewContent">

			</liferay-portlet:renderURL>
			<a href=""><%=content!=null? HtmlUtil.escape(content.getTitle()) : StringPool.BLANK%></a>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message
				key="reject-by-user" /> :</label>
		<div class="col-sm-7 col-xs-12">
			<aui:select name="status" label="">
				<c:if test='<%=version==2%>'>
					<aui:option value="4" label="tra-ve-cho-tac-gia" />
				</c:if>
				<c:if test='<%=version==3 && status==128%>'>
					<aui:option value="4" label="tra-ve-cho-tac-gia" />
				</c:if>
				<c:if test='<%=version==4 && status==64%>'>
					<aui:option value="4" label="tra-ve-cho-tac-gia" />
				</c:if>
				<c:if test='<%=version==3 && status!=128%>'>
					<aui:option value="128" label="tra-ve-cho-bien-tap" />
				</c:if>
				<c:if test='<%=version==4 && status!=64%>'>
					<aui:option value="64" label="tra-ve-cho-bien-tap" />
				</c:if>
			</aui:select>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message
				key="reject-comment" /> :</label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="textarea" name="comment" label="" rows="5">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>

	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12">&nbsp;</label>
		<div class="col-sm-10 col-xs-12">
		<c:if test='<%= isValid %>'>
			<aui:button type="submit" value='create-reject-comment'/>
		</c:if>		
		<c:if test='<%= !isValid %>'>
			<aui:button type="submit" disabled="true" value='create-reject-comment'  />
		</c:if>
		<a href="<%= backURL %>" class="btn btn-default"><liferay-ui:message key='cancel-reject' /></a>
		</div>
	</div>
	<aui:input type="hidden" name="version" value="<%=version%>" />
</aui:form>
<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel,aui-io-request,aui-node,aui-loading-mask-deprecated',function(A){
		var version = '<%= version%>';
		var status = '<%= status%>';
		Liferay.provide(
                window,
                '<portlet:namespace />submitContentForm',
                function() {

                        window.validator = new A.FormValidator({

                        boundingBox: "#<portlet:namespace />fm",
                        rules: {
                                <portlet:namespace />comment: {
                                    required: true
                            	}
                        }
                    });
                    window.validator.validate();
                    if (!window.validator.hasErrors()) {
                    	if(version && status && (version=='2'  || (version=='3' && status == '128') || (version=='4' && status == '64'))){
                    	submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="rejectContentToAuthor"/>');
                    	}
                    	else{
                    		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="rejectContentToEditor"/>');
                    	}
                    }
                },
				['aui-base']
		);		
	});
</aui:script>
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
<%@include file="/html/admin/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
	Content content = null;
	String createByUserName = StringPool.BLANK;
	long autoId = ParamUtil.getLong(request, "autoId", 0);
	int version= ParamUtil.getInteger(request, "version", 0);
	String redirectURL = ParamUtil.getString(request, "redirectURL");
	if(autoId > 0){
		Content detectContent = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
		if(detectContent!=null && (detectContent.getCreatedByUserId() == user.getUserId())){
	content = detectContent;
	createByUserName = content.getCreatedByUserName();
		}
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitContentForm();";
%>

<aui:form name="fm" method="post" action="" cssClass="form-horizontal"
	onSubmit='<%= taglibOnSubmit %>' enctype="multipart/form-data">
	<aui:input name="redirect" type="hidden" value="<%=redirectURL%>" />
	<aui:input name="groupId" type="hidden" value="<%=scopeGroupId%>" />
	<aui:input name="autoId" type="hidden"
		value="<%=content!=null?content.getAutoId():0%>" />

	<aui:model-context bean="<%=content%>" model="<%=Content.class%>" />


	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message
				key="title" /> (<liferay-ui:message key="*" />)</label>
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
				<c:if test='<%=version==3%>'>
					<aui:option value="128" label="tra-ve-cho-bien-tap" />
				</c:if>
				<c:if test='<%=version==4%>'>
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
			<aui:button type="submit" value='create-reject-comment' />			
			<aui:button type="button" value='cancel-reject' href="<%= redirectURL %>" />
		</div>
	</div>
	<aui:input type="hidden" name="version" value="<%=version%>" />
</aui:form>
<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel,aui-io-request,aui-node,aui-loading-mask-deprecated',function(A){
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
                    	submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="rejectContent"/>');
                    }
                },
				['aui-base']
		);		
	});
</aui:script>
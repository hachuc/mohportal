<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
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
	String bodyContent = StringPool.BLANK;
	String subContent = StringPool.BLANK;
	String editUserName = StringPool.BLANK;
	long editByUserId = 0L;
	List<Category> categories = new ArrayList<Category>();
	long autoId = ParamUtil.getLong(request, "autoId", 0);
	long contentId = ParamUtil.getLong(request, "contentId", 0);
	boolean editStatus = true;
	if(autoId > 0){
		content = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
		bodyContent = content !=null? content.getContent():"";
		subContent =  content !=null? content.getSubContent() : "";
	}else{
		autoId = CounterLocalServiceUtil.increment();
	}
	try{
		categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	}catch(Exception e){}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitContentForm();";
%>

<liferay-portlet:actionURL var="updateContent" name="updateContent" />
<liferay-portlet:renderURL portletName="<%=PortletKeys.DYNAMIC_DATA_MAPPING %>" var="selectFileURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="struts_action" value='/dynamic_data_mapping/select_document_library' />
</liferay-portlet:renderURL>
<aui:form name="fm" method="post" action="" cssClass="form-horizontal" onSubmit='<%= taglibOnSubmit %>' enctype="multipart/form-data">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	
	<aui:input name="backURL" type="hidden" value="<%=currentURL%>" />
	
	<aui:input name="groupId" type="hidden" value="<%=scopeGroupId%>" />
	<c:choose>
		<c:when test='<%= content!=null && (content.getVersion()==1 || content.getVersion() == 2 && (content.getStatus() == 4)) && userId!=content.getCreatedByUserId() %>'>
			<% editStatus = false; %>
			<div class="alert alert-danger">
				<liferay-ui:message key="content-is-being-created-by" /> : <%= content.getCreatedByUserName() %>
			</div>
		</c:when>
		<c:when test='<%= content!=null && ((content.getVersion()==2 && content.getStatus()!=4)  || ( content.getVersion() == 3 && content.getStatus() == 128) || (content.getVersion() == 4 && content.getStatus() == 64)) && userId!=content.getEditedByUserId() %>'>
			<% editStatus = false; %>
			<div class="alert alert-danger">
				<liferay-ui:message key="content-is-being-edited-by" /> : <%= content.getEditedByUserName() %>
			</div>
		</c:when>
		<c:when test='<%= content!=null && content.getVersion()==3 && userId!=content.getReviewedByUserId() %>'>
			<div class="alert alert-danger">
				<liferay-ui:message key="content-is-being-reviewed-by" /> : <%= content.getReviewedByUserName() %>
			</div>
			<% editStatus = false; %>
		</c:when>
		<c:when test='<%= content!=null && content.getVersion()==4 && userId!=content.getPublishedByUserId() %>'>
			<div class="alert alert-danger">
				<liferay-ui:message key="content-is-being-edited-by" /> : <%= content.getPublishedByUserName() %>
			</div>
			<% editStatus = false; %>
		</c:when>
	</c:choose>
	<aui:input name="autoId" type="hidden" value="<%=editStatus ? content!=null?content.getAutoId(): autoId : autoId%>" />
	<aui:input name="contentId" type="hidden" value="<%=editStatus ? content!=null?content.getContentId():0:0%>" />
	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "view_content.jsp" %>' />
		<portlet:param name="autoId" value="<%=String.valueOf(autoId) %>"/>
		<portlet:param name="editable" value="<%= String.valueOf(false)%>" />
	</portlet:renderURL>
	<aui:input name="redirect" type="hidden" value="<%=viewURL%>" />
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="sub-title" /></label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="text" name="subTitle" label="" value='<%= editStatus ? content.getSubTitle() : "" %>' />
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="title" /> (<liferay-ui:message key="*" />)</label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="text" name="title" label="" autoFocus="true" value='<%= editStatus ? content.getTitle() : "" %>'>
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-summary" /></label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="textarea" name="summary" label="" rows="5" value='<%= editStatus ? content.getSummary() : "" %>'>
			</aui:input>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-category" /> (<liferay-ui:message key="*" />)</label>
		<div class="col-sm-7 col-xs-12">
			<aui:select name="categoryId" label="">
				<%
					if(categories != null){
								for(Category cat: categories){
						String selected = editStatus && cat.getCategoryId() == content.getCategoryId() ? "selected" : "";
						
				%>
				<c:if test='<%= editStatus && cat.getCategoryId() == content.getCategoryId() %>'>
					<aui:option value="<%=cat.getCategoryId()%>" selected="true"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
				</c:if>
				<c:if test='<%= !editStatus || cat.getCategoryId() != content.getCategoryId() %>'>
					<aui:option value="<%=cat.getCategoryId()%>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
				</c:if>
				<%
					}
							}
				%>
			</aui:select>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="sub-content" /></label>
		<div class="col-sm-7 col-xs-12">
			<liferay-ui:input-editor name="subContent" initMethod="initSubContent" />
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="body-content" /></label>
		<div class="col-sm-7 col-xs-12">
			<liferay-ui:input-editor name="content" initMethod="initContent" height="300px" />
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">		
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="file-attach" /></label>
		<div class="col-md-5 col-xs-9">
            <aui:input name="fileId" type="hidden" value="<%= content.getSmallImageId() %>" />
            <aui:input name="fileUuId" type="hidden" />
            <aui:input name="fileName" type="text" readonly="true" label="" value="<%= content.getSmallImageUrl() %>"/>
        </div>
        <div class="col-md-5 col-xs-3">
        	<aui:button name="openFileSelectorButton" value="select-image" cssClass="btn btn-default" />
        	<aui:button name="removeImageButton" value="remove-image" cssClass="btn btn-danger" />
        </div>
        <div class="col-md-3 hidden-xs align-left">
			
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="source-content" /></label>
		<div class="col-sm-7 col-xs-12"><aui:input type="text" name="copyRight" label="" value='<%= editStatus ? content.getCopyRight() : "" %>' /></div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-author" /></label>
		<div class="col-sm-7 col-xs-12"><aui:input type="text" name="author" label="" value='<%= editStatus ? content.getAuthor() : "" %>' /></div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-jobtitle" /></label>
		<div class="col-sm-7 col-xs-12"><aui:input type="text" name="jobTitle" label="" value='<%= editStatus ? content.getJobTitle() : "" %>' /></div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-type" /></label>
		<div class="col-sm-7 col-xs-12">
			<aui:select name="newsType" label="">
				<aui:option value="2"><liferay-ui:message key="news-type2" /></aui:option>
				<aui:option value="1"><liferay-ui:message key="news-type1" /></aui:option>
				<aui:option value="3"><liferay-ui:message key="news-type3" /></aui:option>
				<aui:option value="4"><liferay-ui:message key="news-type4" /></aui:option>
			</aui:select>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>	
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12">&nbsp;</label>
		<div class="col-sm-10 col-xs-12 pl0">
			<c:if test='<%= editStatus && content.getVersion() > 1 %>'>
				<portlet:renderURL var="rejectURL">
					<portlet:param name="mvcPath" value='<%=templatePath + "reject_content.jsp"%>' />
					<portlet:param name="autoId" value="<%=String.valueOf(content.getAutoId())%>" />
					<portlet:param name="version" value="<%=String.valueOf(content.getVersion())%>" />
					<portlet:param name="redirectURL" value="<%=currentURL%>" />								
				</portlet:renderURL>
				<a class="btn btn-small" href="<%= rejectURL.toString() %>" role="button" onclick="return confirm('Bạn muốn trả lại bài viết này?');"><i class="glyphicon icon-circle-arrow-left"></i> <liferay-ui:message key="tra-bai-viet-nay" /></a>
			</c:if>
			<c:if test='<%= editStatus %>'>
				<aui:button type="submit" cssClass="btn btn-small" icon="edit" value="bien-tap-bai-viet-nay" />					
			</c:if>
			<c:if test='<%= !editStatus %>'>
				<aui:button type="submit" cssClass="btn btn-small" icon="edit" value="thay-doi-bai-viet-nay" />		
				<%-- <input type="submit" class="btn btn-small" value='<liferay-ui:message key="thay-doi-bai-viet-nay" />' /> --%>
			</c:if>
			<portlet:actionURL var="forwardActionURL" name="sendToNextStep">
				<portlet:param name="autoId" value="<%= String.valueOf(content.getAutoId()) %>"/>
				<portlet:param name="version" value="<%= String.valueOf(content.getVersion()) %>"/>
				<portlet:param name="status" value="<%= String.valueOf(content.getStatus()) %>"/>
				<portlet:param name="redirect" value="<%= redirect %>"/>
			</portlet:actionURL>
			<a class="btn btn-small" href="<%= forwardActionURL.toString() %>" role="button" ><i class="glyphicon icon-circle-arrow-right"></i> <liferay-ui:message key='<%= content.getVersion() < 4 ?"gui-bai-viet-nay":"dang-bai-viet-nay" %>' /></a>
		</div>
	</div>
	<aui:input  type="hidden" name="hidenContent" />
</aui:form>
<aui:script>	
	function <portlet:namespace />initContent(){
		return '<%= editStatus ? UnicodeFormatter.toString(bodyContent) : "" %>';
	}
	function <portlet:namespace />initSubContent(){
		return '<%= editStatus ? UnicodeFormatter.toString(subContent) : "" %>';
	}
	function <portlet:namespace />updateContent() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (content == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateContent"/>');
	}
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel,aui-io-request,aui-node,aui-loading-mask-deprecated',function(A){
		Liferay.provide(
                window,
                '<portlet:namespace />submitContentForm',
                function() {

                        window.validator = new A.FormValidator({

                        boundingBox: "#<portlet:namespace />fm",
                        rules: {
                                <portlet:namespace />title: {
                                    required: true
                            	}
                        }
                    });
                    window.validator.validate();
                    if (!window.validator.hasErrors()) {
                    	var askContent = window.<portlet:namespace />content.getHTML();

    					if(askContent.length > 0){

    						document.<portlet:namespace />fm.<portlet:namespace />hidenContent.value = askContent;

    						document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (content == null) ? Constants.ADD : Constants.UPDATE %>";
    						submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateContent"/>');

    					}else{
    						alert('<%= UnicodeLanguageUtil.get(pageContext, "please-enter-body-content") %>');
    					}
                    }
                },
				['aui-base']
		);	
		A.one('#<portlet:namespace />openFileSelectorButton').on(
		        'click',
		        function(event) {
		            Liferay.Util.selectEntity(
		                {
		                    dialog: {
		                        constrain: true,
		                        modal: true,
		                        width: '80%'
		                    },
		                    id: '<portlet:namespace />selectFileFromDocumentLibrary',
		                    title: '<liferay-ui:message arguments="file" key="select-x" />',
		                    uri: '<%= selectFileURL.toString() %>'
		                },
		                _166_selectDocumentLibrary = function(url, uuid, groupId, fileName, version){
		                     document.getElementById("<portlet:namespace/>fileName").value = url;
		                     document.getElementById("<portlet:namespace/>fileId").value = '0';
		                     document.getElementById("<portlet:namespace/>fileUuId").value = uuid;
		                     
		                }
		            );
		        }
		);
		A.one('#<portlet:namespace />removeImageButton').on(
		        'click',
		        function(event) {
		        	document.getElementById("<portlet:namespace/>fileName").value = '';
                    document.getElementById("<portlet:namespace/>fileId").value = '0';
                    document.getElementById("<portlet:namespace/>fileUuId").value = '';
		        }
		);
	});
</aui:script>
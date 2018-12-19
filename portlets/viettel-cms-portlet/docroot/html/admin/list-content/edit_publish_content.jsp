<%@page import="com.viettel.portal.vcms.service.DistributionLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.service.impl.DistributionLocalServiceImpl"%>
<%@page import="com.viettel.portal.vcms.model.ContentType"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@page import="com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil"%>
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
	System.out.println("editor_publish_content");	
	String bodyContent = StringPool.BLANK;
	String subContent = StringPool.BLANK;
	String editUserName = StringPool.BLANK;
	long editByUserId = 0L;
	List<Category> categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	long autoId = ParamUtil.getLong(request, "autoId", 0);
	long distributionId = ParamUtil.getLong(request, "distributionId", 0);
	long contentId = ParamUtil.getLong(request, "contentId", 0);
	Content content = ContentLocalServiceUtil.fetchByAutoId(autoId, scopeGroupId);
	if(content != null){ 
		bodyContent = content !=null? content.getContent():"";
		subContent =  content !=null? content.getSubContent() : "";
	}
	String redirectURL = ParamUtil.getString(request, "redirect");
	List<ContentType> lstContentTypes = ContentTypeLocalServiceUtil.getAllContentType(scopeGroupId);
	Distribution dist = DistributionLocalServiceUtil.fetchDistribution(distributionId);
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitContentForm();";
%>

<liferay-portlet:actionURL var="updateContent" name="updateContent" />
<liferay-portlet:renderURL portletName="<%=PortletKeys.DYNAMIC_DATA_MAPPING %>" var="selectFileURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="struts_action" value='/dynamic_data_mapping/select_document_library' />
</liferay-portlet:renderURL>
<c:if test='<%= content!=null && dist !=null %>'>
<aui:form name="fm" method="post" action="" cssClass="form-horizontal" onSubmit='<%= taglibOnSubmit %>' enctype="multipart/form-data">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	<aui:input name="groupId" type="hidden" value="<%= scopeGroupId%>" />
	<aui:input name="autoId" type="hidden" value="<%= content.getAutoId()%>" />
	<aui:input name="contentId" type="hidden" value="<%= content.getContentId()%>" />
	<aui:input name="distributionId" type="hidden" value="<%= distributionId %>" />
	<aui:input name="redirect" type="hidden" value="<%=redirectURL%>" />
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="sub-title" /></label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="text" name="subTitle" label="" value='<%= content.getSubTitle() %>' />
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="title" /> (<liferay-ui:message key="*" />)</label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="text" name="title" label="" autoFocus="true" value='<%= content.getTitle() %>'>
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-summary" /></label>
		<div class="col-sm-7 col-xs-12">
			<aui:input type="textarea" name="summary" label="" rows="5" value='<%= content.getSummary() %>'>
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
						String selected = cat.getCategoryId() == content.getCategoryId() ? "selected" : "";
						
				%>
				<c:if test='<%= cat.getCategoryId() == content.getCategoryId() %>'>
					<aui:option value="<%=cat.getCategoryId()%>" selected="true"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
				</c:if>
				<c:if test='<%= cat.getCategoryId() != content.getCategoryId() %>'>
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
		<div class="col-sm-7 col-xs-12"><aui:input type="text" name="copyRight" label="" value='<%= content.getCopyRight() %>' /></div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-author" /></label>
		<div class="col-sm-7 col-xs-12"><aui:input type="text" name="author" label="" value='<%= content.getAuthor() %>' /></div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-jobtitle" /></label>
		<div class="col-sm-7 col-xs-12"><aui:input type="text" name="jobTitle" label="" value='<%= content.getJobTitle() %>' /></div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-type" /></label>
		<div class="col-sm-7 col-xs-12">
			<aui:select name="newsType" label="">
				<%
					if(lstContentTypes != null){
								for(ContentType cat: lstContentTypes){
				%>
				<c:if test='<%= cat.getContenTypeId() == content.getNewsType() %>'>
					<aui:option value="<%=cat.getContenTypeId()%>" selected="true"><%=HtmlUtil.escape(cat.getName())%></aui:option>
				</c:if>
				<c:if test='<%= cat.getContenTypeId() != content.getNewsType() %>'>
					<aui:option value="<%=cat.getContenTypeId()%>"><%=HtmlUtil.escape(cat.getName())%></aui:option>
				</c:if>
				<%
					}
							}
				%>
			</aui:select>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12">
			<liferay-ui:message key="phan-hoi" />
		</label>
		<div class="col-sm-7 col-xs-12">
			<c:if test='<%= dist.getAllowDiscussion() %>'>
				<aui:input type="checkbox" name="allowDiscussion" checked="true" label="yes" />
			</c:if>
			<c:if test='<%= !dist.getAllowDiscussion() %>'>
				<aui:input type="checkbox" name="allowDiscussion" label="yes" />
			</c:if>
		</div>
		<div class="col-sm-3 hidden-xs hidden-sm">
		</div>
	</div>	
	<div class="form-group">
		<label class="label-control col-md-2 col-xs-12">&nbsp;</label>
		<div class="col-sm-10 col-xs-12 pl0">
			<aui:button type="submit" cssClass="btn btn-small" icon="edit" value="bien-tap-bai-viet-nay" />	
		</div>
	</div>
	<aui:input  type="hidden" name="hidenContent" />
</aui:form>
<aui:script>	
	function <portlet:namespace />initContent(){
		return '<%= UnicodeFormatter.toString(bodyContent) %>';
	}
	function <portlet:namespace />initSubContent(){
		return '<%= UnicodeFormatter.toString(subContent) %>';
	}
	function <portlet:namespace />updateContent() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (content == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updatePublishContent"/>');
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
    						submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updatePublishContent"/>');

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
</c:if>
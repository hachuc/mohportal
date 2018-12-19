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
<%
	Content content = null;
	String bodyContent = StringPool.BLANK;
	String subContent = StringPool.BLANK;
	List<Category> categories = new ArrayList<Category>();
	long autoId = ParamUtil.getLong(request, "autoId", 0);
	if(autoId > 0){
		content = ContentLocalServiceUtil.fetchContent(autoId);
		if(content!=null){
			bodyContent = content.getContent();
			subContent = content.getSubContent();
		}
	}
	try{
		categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	}catch(Exception e){}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitContentForm();";
%>

<liferay-portlet:actionURL var="updateContent" name="updateContent" />
<aui:form name="fm" method="post" action="" cssClass="form-horizontal" onSubmit='<%= taglibOnSubmit %>' enctype="multipart/form-data">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
	<aui:input name="backURL" type="hidden" value="<%=currentURL%>" />
	<aui:input name="groupId" type="hidden" value="<%=scopeGroupId%>" />
	<aui:input name="autoId" type="hidden" value="<%=content!=null?content.getAutoId():0%>" />
	
	<aui:model-context bean="<%=content%>" model="<%=Content.class%>" />
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="sub-title" /></label>
		<div class="col-sm-6 col-xs-12">
			<aui:input type="text" name="subTitle" label="" />
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="title" /> (<liferay-ui:message key="*" />)</label>
		<div class="col-sm-6 col-xs-12">
			<aui:input type="text" name="title" label="" autoFocus="true">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="news-summary" /></label>
		<div class="col-sm-6 col-xs-12">
			<aui:input type="textarea" name="summary" label="" rows="5" >
			</aui:input>
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="news-category" /> (<liferay-ui:message key="*" />)</label>
		<div class="col-sm-6 col-xs-12">
			<aui:select name="categoryId" label="">
				<%
					if(categories != null){
								for(Category cat: categories){
				%>
				<aui:option value="<%=cat.getCategoryId()%>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
				<%
					}
							}
				%>
			</aui:select>
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="sub-content" /></label>
		<div class="col-sm-6 col-xs-12">
			<liferay-ui:input-editor name="subContent" initMethod="initSubContent" />
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="body-content" /></label>
		<div class="col-sm-6 col-xs-12">
			<liferay-ui:input-editor name="content" initMethod="initContent" height="300px" />
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="file-attach" /></label>
		<div class="col-sm-6 col-xs-12">
			<aui:input autoFocus="<%=true%>" name="smallImage" style="width: auto;" type="file" multiple="false" accept=".jpg,.jpeg,.png" label="">
				<aui:validator name="acceptFiles"> '<%=StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA))%>'
				</aui:validator>
			</aui:input>
		</div>
		<div class="col-sm-5 hidden-xs hidden-sm">
		
		</div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="source-content" /></label>
		<div class="col-sm-6 col-xs-12"><aui:input type="text" name="copyRight" label="" /></div>
		<div class="col-sm-5 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="news-author" /></label>
		<div class="col-sm-6 col-xs-12"><aui:input type="text" name="author" label="" /></div>
		<div class="col-sm-5 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="news-jobtitle" /></label>
		<div class="col-sm-6 col-xs-12"><aui:input type="text" name="jobTitle" label="" /></div>
		<div class="col-sm-5 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12"><liferay-ui:message key="news-type" /></label>
		<div class="col-sm-6 col-xs-12"><aui:select name="newsType" label="">
					<aui:option value="2" selected="true"><liferay-ui:message key="news-type2" /></aui:option>
					<aui:option value="1"><liferay-ui:message key="news-type1" /></aui:option>
					<aui:option value="3"><liferay-ui:message key="news-type3" /></aui:option>
					<aui:option value="4"><liferay-ui:message key="news-type4" /></aui:option>
				</aui:select></div>
		<div class="col-sm-5 hidden-xs hidden-sm"></div>
	</div>
	<div class="form-group">
		<label class="label-control col-md-1 col-xs-12">&nbsp;</label>
		<div class="col-sm-11 col-xs-12">
			<aui:button type="submit" value='<%= content != null ? "update-content" : "create-content" %>'/>
		</div>
	</div>
	<aui:input  type="hidden" name="hidenContent" />
</aui:form>
<aui:script>
	function <portlet:namespace />initContent(){
		return "<%= UnicodeFormatter.toString(bodyContent) %>";
	}
	function <portlet:namespace />initSubContent(){
		return "<%= UnicodeFormatter.toString(subContent) %>";
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
	});
</aui:script>
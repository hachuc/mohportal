<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
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
	System.out.println("new_content");	
	Content content = null;
	String bodyContent = StringPool.BLANK;
	String subContent = StringPool.BLANK;
	List<Category> categories = new ArrayList<Category>();
	long autoId = CounterLocalServiceUtil.increment();
	try{
		categories = CategoryLocalServiceUtil.getAllCategories(scopeGroupId);
	}catch(Exception e){}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitContentForm();";
	
	long dlScopeGroupId = themeDisplay.getScopeGroupId();
	LiferayPortletURL documentLibURL = PortletURLFactoryUtil.create(request,          
	PortletKeys.DYNAMIC_DATA_MAPPING, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	documentLibURL.setWindowState(LiferayWindowState.POP_UP);
	documentLibURL.setPortletMode(PortletMode.VIEW);
	/* Struts action path is taken from server/../root/web-inf/struts-config.xml */
	documentLibURL.setParameter("struts_action","/dynamic_data_mapping/select_document_library");
	documentLibURL.setParameter("groupId", String.valueOf(dlScopeGroupId));
%>
<liferay-portlet:renderURL portletName="<%=PortletKeys.DYNAMIC_DATA_MAPPING %>" var="selectFileURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <portlet:param name="struts_action" value='/dynamic_data_mapping/select_document_library' />
</liferay-portlet:renderURL>
<liferay-ui:panel-container cssClass="basic-info" id="basic-info-container" extended="true"> 
	<liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>" id="basic-info" persistState="<%=true%>" title='action.ADD_CONTENT' iconCssClass="glyphicon icon-file">
		<portlet:renderURL var="viewURL">
			<portlet:param name="mvcPath" value='<%= templatePath + "view_content.jsp" %>' />
			<portlet:param name="autoId" value="<%=String.valueOf(autoId) %>"/>
			<portlet:param name="editable" value="<%= String.valueOf(false)%>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:renderURL>
		<aui:form name="fm" method="post" action="" cssClass="form-horizontal" onSubmit='<%= taglibOnSubmit %>' enctype="multipart/form-data">
			<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" />
			<aui:input name="redirect" type="hidden" value="<%=viewURL.toString()%>" />
			<aui:input name="autoId" type="hidden" value="<%= String.valueOf(autoId) %>" />
			<aui:model-context bean="<%=content%>" model="<%=Content.class%>" />
			
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="sub-title" /></label>
				<div class="col-sm-7 col-xs-12">
					<aui:input type="text" name="subTitle" label="" />
				</div>
				<div class="col-sm-3 hidden-xs hidden-sm">
				
				</div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="title" /> (<liferay-ui:message key="*" />)</label>
				<div class="col-sm-7 col-xs-12">
					<aui:input type="text" name="title" label="" autoFocus="true">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
				<div class="col-sm-3 hidden-xs hidden-sm">
				
				</div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-summary" /></label>
				<div class="col-sm-7 col-xs-12">
					<aui:input type="textarea" name="summary" label="" rows="5" >
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
						%>
						<aui:option value="<%=cat.getCategoryId()%>"><%=HtmlUtil.escape(cat.getCategoryName())%></aui:option>
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
		            <aui:input name="fileId" type="hidden"/>
		            <aui:input name="fileName" type="text" readonly="true" label=""/>
		        </div>
		        <div class="col-md-2 col-xs-3">
		        	<aui:button name="openFileSelectorButton" value="select-image" cssClass="btn btn-default" />
		        	<aui:button name="removeImageButton" value="remove-image" cssClass="btn btn-danger" />
		        </div>
		        <div class="col-md-3 hidden-xs">
					
				</div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="source-content" /></label>
				<div class="col-sm-7 col-xs-12"><aui:input type="text" name="copyRight" label="" /></div>
				<div class="col-sm-3 hidden-xs hidden-sm"></div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-author" /></label>
				<div class="col-sm-7 col-xs-12"><aui:input type="text" name="author" label="" /></div>
				<div class="col-sm-3 hidden-xs hidden-sm"></div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-jobtitle" /></label>
				<div class="col-sm-7 col-xs-12"><aui:input type="text" name="jobTitle" label="" /></div>
				<div class="col-sm-3 hidden-xs hidden-sm"></div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12"><liferay-ui:message key="news-type" /> (<liferay-ui:message key="*" />)</label>
				<div class="col-sm-7 col-xs-12"><aui:select name="newsType" label="">
							<aui:option value="2" selected="true"><liferay-ui:message key="news-type2" /></aui:option>
							<aui:option value="1"><liferay-ui:message key="news-type1" /></aui:option>
							<aui:option value="3"><liferay-ui:message key="news-type3" /></aui:option>
							<aui:option value="4"><liferay-ui:message key="news-type4" /></aui:option>
						</aui:select></div>
				<div class="col-sm-3 hidden-xs hidden-sm"></div>
			</div>
			<div class="form-group">
				<label class="label-control col-md-2 col-xs-12">&nbsp;</label>
				<div class="col-sm-10 col-xs-12">
					<aui:button type="submit" value='create-content'/>
				</div>
			</div>
			<aui:input type="hidden" name="hidenContent" />
		</aui:form>
	</liferay-ui:panel>
</liferay-ui:panel-container>
<aui:script>
	function <portlet:namespace />initContent(){
		return "<%= UnicodeFormatter.toString(bodyContent) %>";
	}
	function <portlet:namespace />initSubContent(){
		return "<%= UnicodeFormatter.toString(subContent) %>";
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
    						submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="addContent"/>');

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
		                        modal: true
		                    },
		                    id: '<portlet:namespace />selectFileFromDocumentLibrary',
		                    title: '<liferay-ui:message arguments="file" key="select-x" />',
		                    uri: '<%= selectFileURL.toString() %>'
		                },
		                _166_selectDocumentLibrary = function(url, uuid, groupId, fileName, version){
		                     document.getElementById("<portlet:namespace/>fileName").value = url;
		                     document.getElementById("<portlet:namespace/>fileId").value = uuid;
		                }
		            );
		        }
		);
		A.one('#<portlet:namespace />removeImageButton').on(
		        'click',
		        function(event) {
		        	document.getElementById("<portlet:namespace/>fileName").value = '';
	                document.getElementById("<portlet:namespace/>fileId").value = 0;
		        }
		);
	});
</aui:script>
<%@page import="com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.archive.model.Content"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	String cmd = ParamUtil.getString(request, Constants.CMD);

	Content content = null;
	
	String categoryName = StringPool.BLANK;
	String Author =  StringPool.BLANK;
	String AuthorTitle =  StringPool.BLANK;
	String FileUrl =  StringPool.BLANK;
	
	
	if(contentId > 0){
		
		content = ContentLocalServiceUtil.getContent(contentId);
		
		if(content != null){
	
			categoryName = content.getSubject();
			Author = content.getAuthor();
			AuthorTitle = content.getAuthorTitle();
			FileUrl = content.getFileUrl();
		}
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateContent();";
%>

<div class="category-update-form">

		<liferay-ui:success key="content-saved-successfully" message="content-saved-successfully" />	
		<liferay-ui:error key="save-failed" message="update-content-error" />
	<portlet:actionURL name="updateContent" var="updateContentURL">
		<portlet:param name="contentId" value="<%=String.valueOf(contentId)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>" />
	</portlet:actionURL>
	
	<aui:form name="fm_update_video_category" method="post" action="<%=updateContentURL%>">
		<aui:input type="hidden" name='contentId' value='<%= contentId %>' />
		<aui:fieldset>
			<aui:input name="Subject" label="Subject"
                value="<%=categoryName%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="Author" label="Author"
                value="<%=Author%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="AuthorTitle" label="AuthorTitle"
                value="<%=AuthorTitle%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="FileUrl" label="FileUrl"
                value="<%=FileUrl%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:button-row>
				<aui:button type="submit" value="save" />
				<aui:button name="closeVideoCategoryUpdateFormBtn" value="cancel"/>
			</aui:button-row>
		</aui:fieldset>
	</aui:form>
</div>


<script type="text/javascript">

    AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
    	//opener.refresh();
        var categoryNameInput = A.one('#<portlet:namespace/>Subject');

	    if (categoryNameInput) {
	        categoryNameInput.focus();
	    }
        var success = A.one('.category-update-form .alert-success');
        if(success){
        	Liferay.Util.getWindow().destroy();
        }
        window.validator = new A.FormValidator({
        
            boundingBox: document.<portlet:namespace />fm_update_video_category,
        
            rules: {
                    <portlet:namespace />categoryName: {
                        required: true,
                        rangeLength: ['3','300']
                    },
                    <portlet:namespace />FileUrl: {
                        required: true,
                        rangeLength: ['3','300']
                    }
            }
        });
        
        var closeVideoCategoryUpdateFormBtn = A.one('#<portlet:namespace/>closeVideoCategoryUpdateFormBtn');
        
        if(closeVideoCategoryUpdateFormBtn){
            
            closeVideoCategoryUpdateFormBtn.on('click',function(){
                
                Liferay.Util.getWindow().destroy();
                
            });
        }
       
    });

</script>
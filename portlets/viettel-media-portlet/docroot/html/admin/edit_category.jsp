<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
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

	VLCategory category = null;
	
	String categoryName = StringPool.BLANK;
	
	boolean invisible = false;
	
	if(categoryId > 0){
		
		category = VLCategoryLocalServiceUtil.getVLCategory(categoryId);
		
		if(category != null){
	
			categoryName = category.getCategoryName();
			invisible = category.getInvisible();
		}
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateCategory();";
%>

<div class="category-update-form">
	<liferay-ui:success key="category-saved-successfully" message="category-saved-successfully" />		
	
		<liferay-ui:error key="save-failed" message="update-vlcategory-error" />
	
	<portlet:actionURL name="updateVLCategory" var="updateVLCategoryURL">
		<portlet:param name="categoryId" value="<%=String.valueOf(categoryId)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=cmd%>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>" />
	</portlet:actionURL>

	<aui:form name="fm_update_video_category" method="post" action="<%=updateVLCategoryURL%>">
		<aui:fieldset>
			<%-- <aui:input name="categoryName" label="vl-category-name"
				value="<%=categoryName%>" size="100">
				<aui:validator name="required" />
			</aui:input> --%>
			<aui:input name="categoryName" label="vl-category-name"
                value="<%=categoryName%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="invisible" label="vl-invisible-category"
				value="<%=invisible%>" type="checkbox" helpMessage="invisible-category-help-msg"/>
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
        var categoryNameInput = A.one('#<portlet:namespace/>categoryName');

	    if (categoryNameInput) {
	        categoryNameInput.focus();
	    }
         
        window.validator = new A.FormValidator({
        
            boundingBox: document.<portlet:namespace />fm_update_video_category,
        
            rules: {
                    <portlet:namespace />categoryName: {
                        required: true,
                        rangeLength: ['3','250']
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
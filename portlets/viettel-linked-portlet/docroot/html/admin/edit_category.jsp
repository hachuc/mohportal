<%@page import="com.viettel.portal.links.DuplicateCategoryNameException"%>
<%@page import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.model.LCategory"%>
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
	LCategory category = null;
	String categoryName = StringPool.BLANK;
	int corder = 0;
	boolean isActive = true;
	if(categoryId > 0){
		category = LCategoryLocalServiceUtil.getLCategory(categoryId);
		if(category != null){
			categoryName = category.getCategoryName();
			isActive = category.getIsActive();
			corder = category.getCorder();
		}
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateLCategory();";
%>

<div class="category-update-form">
	<liferay-ui:success key="category-saved-successfully" message="category-saved-successfully" />
		
	<liferay-ui:error key="<%=DuplicateCategoryNameException.class.getName() %>" message="duplicate-category-name" />
	
		<liferay-ui:error key="save-failed" message="update-category-error" />
	
	<portlet:actionURL name="updateLCategory" var="updateLCategoryURL">
		<portlet:param name="categoryId" value="<%=String.valueOf(categoryId)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=cmd%>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>" />
	</portlet:actionURL>

	<aui:form name="fm_update_contact_category" method="post" action="<%=updateLCategoryURL%>">
		<aui:fieldset>
			<aui:input name="categoryName" label="category-name"
                value="<%=categoryName%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="corder" label="order-category"
				value="<%=corder%>">
				<aui:validator name="required" />
				<aui:validator name="maxLength">11</aui:validator>
				<aui:validator name="number">true</aui:validator>
				</aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="isActive" label="isActive-category"
				value="<%=isActive%>" type="checkbox" />
		</aui:fieldset>
		<aui:fieldset>

			<aui:button-row>
				<aui:button type="submit" value="save" />
				<aui:button name="closeLinkCategoryUpdateFormBtn" value="cancel"/>
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
        
            boundingBox: document.<portlet:namespace />fm_update_contact_category,
        
            rules: {
                    <portlet:namespace />categoryName: {
                        required: true,
                        rangeLength: ['3','250']
                    }
            }
        });
        
        var closeLinkCategoryUpdateFormBtn = A.one('#<portlet:namespace/>closeLinkCategoryUpdateFormBtn');
        
        if(closeLinkCategoryUpdateFormBtn){
            
            closeLinkCategoryUpdateFormBtn.on('click',function(){
                
                Liferay.Util.getWindow().destroy();
                
            });
        }
       
    });

</script>
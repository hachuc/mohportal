<%@page import="com.viettel.portal.photos.DuplicateCategoryNameException"%>
<%@page import="com.viettel.portal.photos.service.PCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.photos.model.PCategory"%>
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
	PCategory category = null;
	String categoryName = StringPool.BLANK;
	int corder = 0;
	boolean status = true;
	categoryId = ParamUtil.getLong(request, "categoryId", -1L);
	if(categoryId > 0){
		category = PCategoryLocalServiceUtil.getPCategory(categoryId);
		if(category != null){
			categoryName = category.getName();
			status = category.getStatus();
			corder = category.getOrder_();
		}
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updatePCategory();";
%>

<div class="category-update-form">
	<liferay-ui:success key="category-saved-successfully" message="category-saved-successfully" />
		
	<liferay-ui:error key="<%=DuplicateCategoryNameException.class.getName() %>" message="duplicate-category-name" />
	
		<liferay-ui:error key="save-failed" message="update-category-error" />
	
	<portlet:actionURL name="updatePCategory" var="updatePCategoryURL">
		<portlet:param name="categoryId" value="<%=String.valueOf(categoryId)%>" />
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=cmd%>" />
		<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>" />
	</portlet:actionURL>

	<aui:form name="fm_update_photo_category" method="post" action="<%=updatePCategoryURL%>">
		<aui:fieldset>
			<aui:input name="name" label="photo-category-name"
                value="<%=categoryName%>" size="100">
            </aui:input>
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="order_" label="order-category"
				value="<%=corder%>">
				<aui:validator name="required" />
				 <aui:validator name="digits"></aui:validator>
				</aui:input>
		</aui:fieldset>
		<span style="display: none;">
		<aui:fieldset>
			<aui:input name="status" label="status-category"
				value="<%=status%>" type="checkbox" />
		</aui:fieldset>
		</span>
		<aui:fieldset>

			<aui:button-row>
				<aui:button type="submit" value="save" />
				<aui:button name="closePCategoryUpdateFormBtn" value="cancel"/>
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
        
            boundingBox: document.<portlet:namespace />fm_update_photo_category,
        
            rules: {
                    <portlet:namespace />categoryName: {
                        required: true,
                        rangeLength: ['3','300']
                    }
            }
        });
        
        var closePCategoryUpdateFormBtn = A.one('#<portlet:namespace/>closePCategoryUpdateFormBtn');
        
        if(closePCategoryUpdateFormBtn){
            
            closePCategoryUpdateFormBtn.on('click',function(){
                
                Liferay.Util.getWindow().destroy();
                
            });
        }
       
    });

</script>
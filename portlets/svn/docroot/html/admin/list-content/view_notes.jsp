<%@page import="com.viettel.portal.vcms.service.persistence.NotesPK"%>
<%@page import="com.viettel.portal.vcms.service.NotesLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Notes"%>
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
	Notes note = null;
	long contentId = ParamUtil.getLong(request, "contentId", 0);
	int version= ParamUtil.getInteger(request, "version", 0);
	String redirectURL = ParamUtil.getString(request, "redirectURL");
	if(contentId > 0 && version > 0){
		note = NotesLocalServiceUtil.fetchNotes(new NotesPK(contentId, version));
	}
%>
<aui:field-wrapper>
	<aui:fieldset>
	<c:if test='<%= note!=null %>'>
	<form action="#">
        <div class="row">
	        <div class="col-xs-12">
	        	<div class="form-group form-group-sm">
	                 <label for="firstname" class="control-label"><liferay-ui:message key="nguoi-gui" /></label>
	                 <input type="text" class="form-control" id="firstname" readonly="readonly" value="<%= note.getUserName() %>" />
	             </div>
	             <div class="form-group form-group-sm">
	                 <label for="firstname" class="control-label"><liferay-ui:message key="send-date" /></label>
	                 <input type="text" class="form-control" id="firstname" readonly="readonly" value="<%= dateFormat.format(note.getCreateDate()) %>" />
	             </div>
	             <div class="form-group-sm">
	                 <textarea class="form-control" rows="5"><%= note.getContent() %></textarea>
	             </div>
	         </div>
        </div>
        <div class="row">
             <div class="col-xs-3">
                 <button type="submit" id="<portlet:namespace />closeUpdateFormBtn" name="<portlet:namespace />closeUpdateFormBtn" class="btn btn-default"><liferay-ui:message key="close-button" /></button>
             </div>
             <div class="col-xs-9">
             
             </div>
        </div>
        <aui:input type="hidden" name="version" value="<%=version%>" />
    </form>		
	</c:if>
	</aui:fieldset>
</aui:field-wrapper>
<aui:script>
	AUI().ready(function(A){
		
		var closeUpdateFormBtn = A.one('#<portlet:namespace/>closeUpdateFormBtn');
        
		if(closeUpdateFormBtn){
            
			closeUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>

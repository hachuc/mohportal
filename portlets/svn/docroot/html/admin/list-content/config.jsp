<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/admin/init.jsp"%>
<%
LiferayPortletURL resourceURL = (LiferayPortletURL) renderResponse.createResourceURL();
resourceURL.setPortletId(ParamUtil.getString(request, "portletResource"));
//resourceURL.setParameter(arg0, arg1)
resourceURL.setResourceID("yourId");
%>
<liferay-portlet:resourceURL var="serverURL">
	<liferay-portlet:param name="portletResource" value="<%=portletResource%>" />
</liferay-portlet:resourceURL>
<liferay-portlet:actionURL portletConfiguration="true"
	var="tthcConfigURL">
	<liferay-portlet:param name="portletResource"
		value="<%=portletResource%>" />
</liferay-portlet:actionURL>
<liferay-ui:panel-container cssClass="basic-info"
	id="basic-info-container" extended="true">
	<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
		id="basic-info" persistState="<%=true%>" title="search-info">
		<aui:field-wrapper label="">
			<aui:fieldset>
				<aui:form name="fm" method="post" action="<%=tthcConfigURL%>"
					class="form-horizontal">
					<aui:input name="<%=Constants.CMD%>" type="hidden"
						value="<%=Constants.UPDATE%>" />
					<div class="form-group">
						<label class="label-control col-md-1"><liferay-ui:message key="view-mode" /></label>
						<aui:select name="viewMode" label="">
							<aui:option value="1" label="new-content" selected="<%=viewMode == 1%>" />
							<aui:option value="2" label="content-list" selected="<%=viewMode == 2%>" />
						</aui:select>
					</div>
					<div class="form-group <%= viewMode==1 ? "hidden":"" %>" id="view-list">
						<label class="label-control col-md-1"><liferay-ui:message
								key="version-key" /></label>
						<div class="col-sm-3">
							<aui:select name="roleVersion" label="">
								<aui:option value="1" label="phong-vien"
									selected="<%=roleVersion == 1%>" />
								<aui:option value="2" label="thu-ky-toa-soan"
									selected="<%=roleVersion == 2%>" />
								<aui:option value="3" label="pho-tong-bien-tap"
									selected="<%=roleVersion == 3%>" />
								<aui:option value="4" label="tong-bien-tap"
									selected="<%=roleVersion == 4%>" />
							</aui:select>
						</div>
						<label class="label-control col-md-1"><liferay-ui:message
								key="state-config" /></label>
						<div class="col-sm-3">
							<aui:select name="contentListState" label="">

							</aui:select>
						</div>

						<div class="col-sm-4">
							<div id="cbk8192">
								<aui:input type="checkbox" name="showForAuthor" label="Hiển-thị-tại-vai-trò-biên-tập-viên" checked="<%= showForAuthor %>" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="label-control col-md-1">&nbsp;</label>
						<div class="col-sm-11">
							<aui:button type="submit" value="save" />
							<aui:button type="cancel" />
						</div>
					</div>
				</aui:form>
			</aui:fieldset>
		</aui:field-wrapper>
	</liferay-ui:panel>
</liferay-ui:panel-container>
<aui:script>
AUI().use('aui-base','liferay-portlet-url','aui-node','aui-io-request', function(A) {
	var cver = A.one("#<portlet:namespace />roleVersion").val();
	var sval = parseInt('<%= stateValue%>');
	var statusCombo = A.one("#<portlet:namespace />contentListState");
	
	getData(cver, sval);
	
	A.one("#<portlet:namespace/>roleVersion").on("change", function(){
		getData(this.val(), sval);
	});
	A.one("#<portlet:namespace/>viewMode").on("change", function(){
		var viewList = A.one("#view-list");
		view-list.removeClass('hidden');
		if(this.val()==1){
			viewList.addClass('hidden');
		}else{
			viewList.removeClass('hidden');
		}
	});
	A.one("#<portlet:namespace/>contentListState").on("change", function(){
		if(this.val()==8192)
			A.one("#cbk8192").show();
		else
			A.one("#cbk8192").hide();
	});
	function getData(cver, cval){
		if(statusCombo.val() == 8192)
			A.one("#cbk8192").show();
		else
			A.one("#cbk8192").hide();
		var myResourceURL =Liferay.PortletURL.createResourceURL();
		myResourceURL.setResourceId('fileDownload');
		myResourceURL.setPortletId('<%= ParamUtil.getString(request, "portletResource") %>');
		myResourceURL.setParameter('version', cver);
		statusCombo.empty();		
		A.io.request(myResourceURL.toString(), {
		 method: 'post',
		 dataType: 'json',
		 data: {},
		 on: {
			success: function(data){
				data = this.get("responseData");
				if (data == null || (data != null && data.length == 0)) return;
				for(var i = 0; i < data.length; i++) {
					 var selected = "";
					 if (cval == data[i].Status) selected = " selected ";
					 var op = '<option value="' + data[i].Status + '" ' + selected + '>' + data[i].Message + '</option>';
					 statusCombo.append(op);
				 }
			},
			error: function(){
				alert("error");
			}
		 }
		});
	}
	
}); 
</aui:script>

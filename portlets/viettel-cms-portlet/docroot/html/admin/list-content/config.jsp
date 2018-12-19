<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/admin/list-content/init.jsp"%>
<%
System.out.println("config");
LiferayPortletURL resourceURL = (LiferayPortletURL) renderResponse.createResourceURL();
resourceURL.setPortletId(ParamUtil.getString(request, "portletResource"));
//resourceURL.setParameter(arg0, arg1)
resourceURL.setResourceID("yourId");
HashMap<Integer, Key> statusMap = new HashMap<Integer, Key>();
statusMap.put(1, new Key(1, "page-title-v1s1"));
statusMap.put(2, new Key(2, "page-title-v1s2"));
statusMap.put(4, new Key(4, "page-title-v2s4"));
statusMap.put(8, new Key(8, "page-title-v2s8"));
statusMap.put(16, new Key(16, "page-title-v2s16"));
statusMap.put(32, new Key(32, "page-title-v2s32"));
statusMap.put(128, new Key(128, "page-title-v3s128"));
statusMap.put(256, new Key(256, "page-title-v3s256"));
statusMap.put(512, new Key(512, "page-title-v3s512"));
statusMap.put(1024, new Key(1024, "page-title-v4s1024"));
statusMap.put(64, new Key(64, "page-title-v4s64"));
statusMap.put(2048, new Key(2048, "page-title-v4s2048"));
statusMap.put(4096, new Key(4096, "page-title-v4s4096"));
statusMap.put(8192, new Key(8192, "page-title-v41s8192"));
statusMap.put(1000, new Key(1000, "page-title-v41s1000"));
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
					<div class="form-group clearfix">
						<label class="label-control col-md-1"><liferay-ui:message key="view-mode" /></label>
						<aui:select name="viewMode" label="">
							<aui:option value="1" label="new-content" selected="<%=viewMode == 1%>" />
							<aui:option value="2" label="content-list" selected="<%=viewMode == 2%>" />
						</aui:select>
					</div>
					<div class="form-group clearfix">
						<aui:input type="checkbox" name="showOnlyOwnContent" label="hien-thi-bai-viet-cua-tac-gia" checked='<%= showOnlyOwnContent%>' />
					</div>
					<div class="form-group clearfix <%= viewMode==1 ? "hidden":"" %>" id="view-list">
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
					<div class="form-group clearfix">
					<%
					for(Entry<Integer, Key> entry : statusMap.entrySet()) {
					    long key = entry.getKey();
					    //if(key != selectedVideoId){
					    //	 Key statusItem = entry.getValue();
					    String layoutUuidIndex = portletPreferences.getValue("linkToPage" + key, StringPool.BLANK);
					%>
					<div class="col-md-4">
						<aui:select name='<%="linkToPage" + key %>' label='<%= "choose-status-" + key%>' showEmptyOption="<%= true %>">
							<%= VCMSPubliserUtil.buildLayoutsToSelect(layoutUuidIndex, true, themeDisplay, true) %>
						</aui:select>
					</div>
					<% } %>
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
AUI().use('aui-base','liferay-portlet-url','aui-node','aui-io-request-deprecated', function(A) {
			
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
		{	
			A.one("#cbk8192").show();
			A.one("#slLayouts").show();
		}
		
		else if(this.val() == 4096 ||  this.val() == 2048 || this.val() == 16 || this.val() == 256){
			A.one("#slLayouts").show();
			A.one("#cbk8192").hide();
		}else{
			A.one("#cbk8192").hide();
			A.one("#slLayouts").hide();
		}
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
<%!
class Key{
	 int index;
	 String Name;
	 Key(int index, String Name){
	  this.index = index;
	  this.Name = Name;
	}
}
%>
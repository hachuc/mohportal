<%@ include file="/html/admin/chamdiem/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style>
.aui .control-group {
     margin-bottom:2px;
}
.aui .navbar .btn, .aui .navbar .btn-group {
    margin-top: 0;
}
</style>
<%
String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");
long popup = ParamUtil.getLong(request, "popup",0);
String jspPage = ParamUtil.getString(request, "jspPage","");
//PortletURL portletURL = renderResponse.createRenderURL();
//portletURL.setParameter("menuId", String.valueOf(menuId));

%>
<aui:nav-bar cssClass="custom-toolbar">
    <%if(popup<=0){ %>
	<aui:nav id="toolbarContainer" >
		<liferay-util:include page="/html/admin/chamdiem/add_button.jsp" servletContext="<%=application %>"/>
	</aui:nav>
	
	<aui:nav-bar-search cssClass="pull-right">
		<liferay-portlet:renderURL var="searchPhongbanURL">
			<liferay-portlet:param name="mvcPath" value="/html/admin/chamdiem/view.jsp"/>
		</liferay-portlet:renderURL>
			
		<div class="form-search">
			<aui:form action="<%= searchPhongbanURL %>" method="post" name="fm">
			    <aui:input type="hidden" name="menuId" value="<%=menuId %>"></aui:input>
			    <aui:row>
			        <aui:column>
			            <aui:input id="fromDate" label="" name="fromDate" placeholder='<%= LanguageUtil.get(locale, "from-date") %>' type="text" value="<%=fromDate %>"></aui:input>
			        </aui:column>
			        <aui:column>
			            <aui:input id="toDate" label="" name="toDate" placeholder='<%= LanguageUtil.get(locale, "to-date") %>' type="text" value="<%=toDate %>"></aui:input>
			        </aui:column>
			    </aui:row>
			    <aui:row>
			        <aui:column>
			            <aui:input id="keywords1" label="" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' value="<%=keywords %>" />
			        </aui:column>
			       <aui:column>
			            <button class="btn btn-primary" type="submit" > <%= LanguageUtil.get(locale, "search") %> </button>
			       </aui:column>
			    </aui:row>
				
				
			    
			</aui:form>
		</div>
	</aui:nav-bar-search>
	<%}else{ %>
	<aui:nav-bar-search cssClass="">
		<liferay-portlet:renderURL var="searchPhongbanURL">
			<portlet:param name="jspPage" value="<%=jspPage %>" />
			<portlet:param name="popup" value="1" />
		</liferay-portlet:renderURL>
			
		<div class="form-search">
			<aui:form action="<%= searchPhongbanURL %>" method="post" name="fm">
			    <aui:input type="hidden" name="menuId" value="<%=menuId %>"></aui:input>
			    <aui:row>
			        <aui:column>
			            <aui:input id="fromDate" label="" name="fromDate" placeholder='<%= LanguageUtil.get(locale, "from-date") %>' type="text" value="<%=fromDate %>"></aui:input>
			        </aui:column>
			        <aui:column>
			            <aui:input id="toDate" label="" name="toDate" placeholder='<%= LanguageUtil.get(locale, "to-date") %>' type="text" value="<%=toDate %>"></aui:input>
			        </aui:column>
			  
			        <aui:column>
			            <aui:input id="keywords1" label="" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' value="<%=keywords %>" />
			        </aui:column>
			       <aui:column>
			            <button class="btn btn-primary" type="submit" > <%= LanguageUtil.get(locale, "search") %> </button>
			       </aui:column>
			    </aui:row>
				
				
			    
			</aui:form>
		</div>
	</aui:nav-bar-search>
	<%} %>
</aui:nav-bar>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$("#<portlet:namespace />toDate").datepicker({
			  monthNamesShort: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
			  dateFormat:"dd/mm/yy",
			  changeMonth: true,
			  changeYear: true,
			        //yearRange: "1950:2050",
			  onClose:function(){
			   $(this).focus().blur();
			  }
		});
		$("#<portlet:namespace />fromDate").datepicker({
			  monthNamesShort: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
			  dateFormat:"dd/mm/yy",
			  changeMonth: true,
			  changeYear: true,
			        //yearRange: "1950:2050",
			  onClose:function(){
			   $(this).focus().blur();
			  }
		});
	});
	
</script>
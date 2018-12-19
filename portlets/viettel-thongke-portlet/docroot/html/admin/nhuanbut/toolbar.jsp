<%@page import="com.viettel.portal.thongke.service.ContentTypeLocalServiceUtil"%>
<%@page import="com.viettel.portal.thongke.model.ContentType"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.viettel.portal.thongke.service.ContentProfitLocalServiceUtil"%>
<%@page import="com.viettel.portal.thongke.service.impl.ContentProfitLocalServiceImpl"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.viettel.portal.thongke.service.persistence.BaiVietNhuanButFinderUtil"%>
<%@page import="com.viettel.portal.thongke.service.persistence.BaiVietNhuanButFinderImpl"%>
<%@page import="com.viettel.portal.thongke.model.ContentProfit"%>
<%@page import="com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil"%>
<%@ include file="/html/admin/nhuanbut/init.jsp" %>
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
	String fromDate = ParamUtil.getString(request, "fromDate",null);
	String toDate = ParamUtil.getString(request, "toDate",null);
	long tinBai = ParamUtil.getLong(request, "tinBai", 0L);
	long tacGia = ParamUtil.getLong(request, "tacGia", 0L);
	List listObject = ContentProfitLocalServiceUtil.findNhuanBut(scopeGroupId, fromDate, toDate, tinBai ,tacGia);
	/* List listObject = ContentProfitLocalServiceUtil.findContentProfit(scopeGroupId, fromDate, toDate, tinBai, tacGia, (long)2, (long)2); */
	int allRecord = ContentProfitLocalServiceUtil.countTotal(scopeGroupId, fromDate, toDate, tinBai, tacGia);
%>
<liferay-portlet:renderURL var="searchNhuanButURL">
			<portlet:param name="jspPage" value="/html/admin/nhuanbut/view.jsp" />
			<portlet:param name="menuId" value="5" />
</liferay-portlet:renderURL>
<portlet:actionURL name="reportExcel" var="reportExcelActionURL">
     	 <portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		 <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
<aui:nav-bar cssClass="custom-toolbar">
    <aui:nav-bar-search cssClass="">	
		<div  class="form-search">
			<aui:form action="" method="post" name="fm">
			    <aui:input type="hidden" name="menuId" value="<%=menuId %>"></aui:input>
			    <aui:row>
			    	<aui:column  columnWidth="20">
			            <%= LanguageUtil.get(locale, "from-date")%>
			        </aui:column>
			        <aui:column columnWidth="20">
			            <%= LanguageUtil.get(locale, "to-date")%>
			        </aui:column>
			        <aui:column columnWidth="20">
			            <%= LanguageUtil.get(locale, "loai-ten-bai")%>
			        </aui:column>
			       <aui:column columnWidth="20">
			            <%= LanguageUtil.get(locale, "author-article")%>
			       </aui:column>
			       <aui:column columnWidth="20">
			       		<button  onClick="submitForm(0)" class="btn btn-primary" type="submit" > <%= LanguageUtil.get(locale, "loc") %> </button>
			       </aui:column>
			    </aui:row>
			    <aui:row>
			        <aui:column columnWidth="20">
			            <aui:input id="fromDate" label="" name="fromDate" placeholder='<%= LanguageUtil.get(locale, "from-date") %>' type="text" value="<%=fromDate %>"></aui:input>
			        </aui:column>
			        <aui:column columnWidth="20">
			            <aui:input id="toDate" label="" name="toDate" placeholder='<%= LanguageUtil.get(locale, "to-date") %>' type="text" value="<%=toDate %>"></aui:input>
			        </aui:column>
			  		<aui:column columnWidth="20">
			  			<aui:select id="tinBai" name="tinBai" label="">
			  			<aui:option  selected="true" value="0"><%=LanguageUtil.get(locale, "select-all") %></aui:option>
			  				<%List<ContentType> listConTentType = ContentTypeLocalServiceUtil.getAllContentType(); %>
			  				<%for(ContentType item : listConTentType ){ %>
			  				<aui:option value="<%=item.getContenTypeId()%>"><%=HtmlUtil.escape(item.getName())%></aui:option>
			  				<%} %>
			  			</aui:select>
			  		</aui:column>
			        <aui:column columnWidth="20">
			            <aui:select  id="tacGia" name="tacGia" label="">
			            <aui:option value="0" selected="true"><%=LanguageUtil.get(locale, "select-all") %></aui:option>
			            <% 
			            List<User> listUsers = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			            	for(User userObj: listUsers){
			            		if(!userObj.getFullName().isEmpty()){
			            %>
			           	<aui:option value="<%=userObj.getUserId()%>"><%=HtmlUtil.escape(userObj.getFullName()) %></aui:option>
			            <% }}%>
			            	
			            </aui:select>
			        </aui:column>
			       <aui:column columnWidth="20">
			       		
			            <button   onClick="excel()" class="btn btn-primary" type="button" > <%=LanguageUtil.get(locale, "xuat-bao-cao") %> </button>
			       		<aui:input name="fileName" label="" type="hidden" value="bang_ke_nhuan_but.xlsx" ></aui:input>
			       </aui:column>
			    </aui:row>
			</aui:form>
		</div>
	</aui:nav-bar-search>
	
</aui:nav-bar>
<aui:script>
	function excel(){
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="reportExcel"/>');
	}
</aui:script>
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
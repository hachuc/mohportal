<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/nhuanbut/init.jsp" %>
<style>
.aui .control-group {
     margin-bottom:2px;
}

</style>
<%

String thang = ParamUtil.getString(request, "thang",String.valueOf((new Date()).getMonth()+1));
String nam = ParamUtil.getString(request, "nam",String.valueOf((new Date()).getYear()+1900));

//System.out.println("edit_menuId: "+menuId);
//System.out.println("edit_keywords: "+keywords);
//System.out.println("edit_fromDate: "+fromDate);
//System.out.println("edit_toDate: "+toDate);


%>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>
     <liferay-portlet:renderURL varImpl="nhuanButBangKeThanhToanTongHopURL" var="">
	    <liferay-portlet:param name="jspPage" value="/html/admin/nhuanbut/view.jsp"/>
	    <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	 </liferay-portlet:renderURL>
     <portlet:actionURL name="reportExcel" var="reportExcelActionURL">
     	 <portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		 <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
    <form   method="post" action="<%=callMyUrl%>">
       <aui:input name="menuId" label="" type="hidden" value="<%=String.valueOf(menuId) %>" ></aui:input>
       <aui:row> 
           <aui:column>
	           <aui:select name='thang' label="thang">
				    <%
				        for(int i=1;i<=12;i++){
				        	%>
				        	<aui:option value="<%=String.valueOf(i)%>" selected="<%= String.valueOf(i).equals(thang) %>" ><%=String.valueOf(i)%></aui:option>
				        	<%	
				        	
				        }
				    %>
				</aui:select>
		   </aui:column>
		   <aui:column>
	           <aui:select name='nam' label="nam">
				    <%
				        int t=(new Date()).getYear()+1900;
				        for(int i=t-10;i<=t+10;i++){
				        	%>
				        	<aui:option value="<%=String.valueOf(i)%>" selected="<%= String.valueOf(i).equals(nam) %>" ><%=String.valueOf(i)%></aui:option>
				        	<%	
				        	
				        }
				    %>
				</aui:select>
		   </aui:column>
	   </aui:row>
	   <aui:row>	   
		   <aui:column>
	       
				<aui:button  type="submit" class="btn btn-primary"  value='<%= LanguageUtil.get(locale, "export-report-excel") %>'>  </aui:button>
				<aui:input name="fileName" label="" type="hidden" value="bang_ke_thanh_toan_tong_hop.xlsx" ></aui:input>
			
	       </aui:column>
	   </aui:row>
	   
   </form>	
   <script>
        document.getElementById("headerReport").innerHTML='<%= LanguageUtil.get(locale, "bang-ke-thanh-toan-tong-hop") %>';
   </script>
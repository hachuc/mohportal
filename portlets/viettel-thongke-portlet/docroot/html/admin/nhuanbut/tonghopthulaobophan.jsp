<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/nhuanbut/init.jsp" %>
<%
String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");

//System.out.println("edit_menuId: "+menuId);
//System.out.println("edit_keywords: "+keywords);
//System.out.println("edit_fromDate: "+fromDate);
//System.out.println("edit_toDate: "+toDate);


%>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>
     <liferay-portlet:renderURL varImpl="nhuanButTongHopThuLaoBoPhanURL" var="">
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
           <%if(!keywords.equals("")){ %>
           <label><%= LanguageUtil.get(locale, "keywords")+": "+HtmlUtil.escape(keywords) %> </label>
           <%} %>
           <aui:input name="keywords" label="keywords" type="hidden" value="<%=keywords %>" ></aui:input>
	       </aui:column>
		   <aui:column>
		   <%if(!fromDate.equals("")){ %>
		   <label><%= LanguageUtil.get(locale, "from-date")+": "+HtmlUtil.escape(fromDate) %> </label>
	       <%} %>
	       <aui:input name="fromDate" label="from-date" type="hidden" value="<%=fromDate %>" ></aui:input>
	       </aui:column>
		   <aui:column>
		   <%if(!toDate.equals("")){ %>
		    <label><%= LanguageUtil.get(locale, "to-date")+": "+HtmlUtil.escape(toDate) %> </label>
	       <%} %>
	       <aui:input name="toDate" label="to-date" type="hidden" value="<%=toDate %>" ></aui:input>
	       </aui:column>
		</aui:row>
		<aui:row> 
		   <aui:column>
	       
				<aui:button  type="submit" class="btn btn-primary"  value='<%= LanguageUtil.get(locale, "export-report-excel") %>'>  </aui:button>
				<aui:input name="fileName" label="" type="hidden" value="tong_hop_thu_lao_bo_phan.xlsx" ></aui:input>
			
	       </aui:column>
	   </aui:row>
	   
   </form>	
   <script>
        document.getElementById("headerReport").innerHTML='<%= LanguageUtil.get(locale, "tong-hop-thu-lao-bo-phan") %>';
   </script>
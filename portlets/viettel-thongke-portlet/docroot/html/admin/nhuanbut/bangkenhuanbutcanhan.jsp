<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/nhuanbut/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<style>
.aui .control-group {
     margin-bottom:2px;
}

</style>
<%
String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");

//System.out.println("edit_menuId: "+menuId);
//System.out.println("edit_keywords: "+keywords);
//System.out.println("edit_fromDate: "+fromDate);
//System.out.println("edit_toDate: "+toDate);
String sql="select distinct(tacGia) from portal_baivietnhuanbut";
List<Object>lstTacGia=BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButBySQL(sql, -1, -1);

%>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>
     <liferay-portlet:renderURL varImpl="nhuanButBangKeNhuanButCaNhanURL" var="">
	    <liferay-portlet:param name="jspPage" value="/html/admin/nhuanbut/view.jsp"/>
	    <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	 </liferay-portlet:renderURL>
     <portlet:actionURL name="reportExcel" var="reportExcelActionURL">
     	 <portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		 <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
    <form   method="post" action="<%=callMyUrl%>">
       <aui:input name="typeNewsString" label="" type="hidden" value="<%=typeNewsString %>" ></aui:input>
       <aui:row> 
           <aui:column>
			            <aui:input id="fromDate" label="" name="fromDate" placeholder='<%= LanguageUtil.get(locale, "from-date") %>' type="text" value="<%=fromDate %>"></aui:input>
			        </aui:column>
			        <aui:column>
			            <aui:input id="toDate" label="" name="toDate" placeholder='<%= LanguageUtil.get(locale, "to-date") %>' type="text" value="<%=toDate %>"></aui:input>
			        </aui:column>
			  
			        <aui:column>
			        <%if(lstTacGia!=null && lstTacGia.size()>0){ %>
			           <aui:select name='keywords' label="">
						    <%
						        for(int i=0;i<lstTacGia.size();i++){
						        	%>
						        	<aui:option value="<%=String.valueOf(lstTacGia.get(i))%>" selected="<%= String.valueOf(lstTacGia.get(i)).equals(keywords) %>" ><%=String.valueOf(lstTacGia.get(i))%></aui:option>
						        	<%	
						        	
						        }
						    %>
						</aui:select>
					<%}else{ %>
					   <span>Không có tác giả nào trong hệ thống </span>
					<%} %>	
			        </aui:column>
		</aui:row>
		<aui:row> 
		   <aui:column>
	       
				<aui:button  type="submit" class="btn btn-primary"  value='<%= LanguageUtil.get(locale, "export-report-excel") %>'>  </aui:button>
				<aui:input name="fileName" label="" type="hidden" value="bang_ke_nhuan_but_ca_nhan.xlsx" ></aui:input>
			
	       </aui:column>
	   </aui:row>
	   
   </form>	
   <script>
        document.getElementById("headerReport").innerHTML='<%= LanguageUtil.get(locale, "bang-ke-nhuan-but-ca-nhan") %>';
   </script>
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
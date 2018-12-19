<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/nhuanbut/init.jsp" %>
<%

String fromDate = ParamUtil.getString(request, "fromDate","");
if(fromDate.equals(""))fromDate=dateFormat.format(new Date());
//System.out.println("edit_menuId: "+menuId);
//System.out.println("edit_keywords: "+keywords);
//System.out.println("edit_fromDate: "+fromDate);
//System.out.println("edit_toDate: "+toDate);


%>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>
     <liferay-portlet:renderURL varImpl="nhuanButBangKeNhuanButNgayURL" var="">
	    <liferay-portlet:param name="jspPage" value="/html/admin/nhuanbut/view.jsp"/>
	    <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	 </liferay-portlet:renderURL>
     <portlet:actionURL name="reportExcel" var="reportExcelActionURL">
     	 <portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		 <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
    <form   id="bang_ke_nhuan_but_ngay" method="post" action="<%=callMyUrl%>">
       <aui:input name="menuId" label="" type="hidden" value="<%=String.valueOf(menuId) %>" ></aui:input>
       <aui:row> 
           <aui:column>
	           <aui:input id="fromDate" label="" name="fromDate" required="required" placeholder='<%= LanguageUtil.get(locale, "select-day") %>' type="text" value="<%=fromDate %>">
	               <aui:validator name="required" />
	           </aui:input>
		   </aui:column>
		   <aui:column>
	       
				<aui:button  type="submit" class="btn btn-primary"  value='<%= LanguageUtil.get(locale, "export-report-excel") %>'>  </aui:button>
				<aui:input name="fileName" label="" type="hidden" value="bang_ke_nhuan_but_ngay.xlsx" ></aui:input>
			
	       </aui:column>
	   </aui:row>
	   
   </form>	
   <script>
        document.getElementById("headerReport").innerHTML='<%= LanguageUtil.get(locale, "bang-ke-nhuan-but-ngay") %>';
   </script>
   <script type="text/javascript">
   function validateFieldInput(){
	   var x=document.getElementById('<portlet:namespace />fromDate').value;
	   if(x!=''){
		   if(x.length>=10){
			   var ngay = x.substring(0,x.indexOf('/'));
               var thang = x.substring(x.indexOf('/')+1,x.lastIndexOf('/'));
               var nam = x.substring(x.lastIndexOf('/')+1);
			   var d = new Date(nam+'-'+thang+'-'+ngay);
               if(!isNaN(d.getTime()))document.getElementById("bang_ke_nhuan_but_ngay").submit();
			   else alert('Khong dung du lieu ngay thang(dd/MM/yyyy)');
		   }
		   else alert('Khong dung du lieu ngay thang(dd/MM/yyyy)');
	   } else alert('Chua chon ngay');
		  
		   
   }
   $("#bang_ke_nhuan_but_ngay").on("submit", function(event){
									event.preventDefault();
										validateFieldInput();
									
								});
	jQuery(document).ready(function($) {
		
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
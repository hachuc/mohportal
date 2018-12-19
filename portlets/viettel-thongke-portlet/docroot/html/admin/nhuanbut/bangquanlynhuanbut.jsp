<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.viettel.portal.thongke.service.ContentProfitLocalServiceUtil"%>
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
<%@ include file="/html/admin/nhuanbut/toolbar.jsp" %>

	<H2>Tổng số bản ghi là: <%=allRecord %></H2>
	<strong>Tổng số: <%=listObject.size() %> bài viết. Tổng cộng: 
		<%
				String totalstr=null;
				JSONArray totalArray = null;
				int total=0;
				for(Object totalObj:listObject){
				totalstr = JSONFactoryUtil.serialize(totalObj);
				totalArray = JSONFactoryUtil.createJSONArray(totalstr);
				total += Integer.parseInt(totalArray.getString(2));
				
			}
			%>
			<%=total %> VND.
	</strong>

	<div  class="span12" style="margin: 0px !important;">
		<table style="width: 100%;">
			<thead style="background-color: #f6f6f6; border-top:1px solid #ddd; border-bottom: 1px solid #ddd; height: 30px">
				<tr>
					<th style="width:6%; border-right: 1px solid #ddd;border-left: 1px solid #ddd;"><strong>STT</strong></th>
					<th style="width:34%; border-right: 1px solid #ddd;"><strong><%= LanguageUtil.get(locale,"title-article") %></strong></th>
					<th style="width:15%; border-right: 1px solid #ddd;"><strong><%= LanguageUtil.get(locale, "author-article")%></strong></th>
					<th style="width:15%; border-right: 1px solid #ddd;" ><strong><%= LanguageUtil.get(locale, "ngay-dang") %></strong></th>
					<th style="width:15%; border-right: 1px solid #ddd;"><strong><%= LanguageUtil.get(locale, "loai-ten-bai") %></strong></th>
					<th style="width:15%; border-right: 1px solid #ddd;"" ><strong><%= LanguageUtil.get(locale, "nhuan-but") %></strong></th>
				</tr>
			</thead>
			<tbody>
				<%
					String serilizeString=null;
					JSONArray nhuanBut = null;
					int i=1;
					for(Object nhuanbutObject:listObject){
					serilizeString=JSONFactoryUtil.serialize(nhuanbutObject);
					nhuanBut =JSONFactoryUtil.createJSONArray(serilizeString);
				%>
					<tr style="border-bottom: 1px solid #ddd; <%=i%2!=0?"background-color: #fff;":"background-color: #f6f6f6;"%>" >
						<td style="width:6%;text-align:center; border-right: 1px solid #ddd;border-left: 1px solid #ddd;""><%=i++ %></td>
						<td style="width:34%; border-right: 1px solid #ddd;"> <%=nhuanBut.getString(0) %></<td>
						<td style="width:15%; border-right: 1px solid #ddd;"><%=nhuanBut.getString(1) %></td>
						<%
						String temp = nhuanBut.getString(4).substring(0,10);
						String time[] = temp.split("\\-");
						String timePublish ="";
						if(time.length>2){
								timePublish =time[2]+"/"+time[1]+"/"+time[0];
						}
						
						%>
						<td style="width:15%;text-align:center; border-right: 1px solid #ddd;"><%= HtmlUtil.escape(timePublish)%></td>
						<td style="width:15%; border-right: 1px solid #ddd;"><%=HtmlUtil.escape(nhuanBut.getString(3)) %></td>
						<td style="width:15%;text-align:right; border-right: 1px solid #ddd;"><%=HtmlUtil.escape(nhuanBut.getString(2)) %></td> 
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<div>Trang:</div>

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


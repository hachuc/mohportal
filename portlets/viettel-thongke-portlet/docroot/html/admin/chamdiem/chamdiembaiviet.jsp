<%@page import="com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.viettel.portal.thongke.model.BaiVietNhuanBut"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/chamdiem/init.jsp" %>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>

<%
String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");
Date fDate=null,tDate=null;
if(!fromDate.equals("")){
	try{
		fDate=dateFormat.parse(fromDate);
	}
	catch(Exception ex){}
}
if(!toDate.equals("")){
	try{
		tDate=dateFormat.parse(toDate);
	}
	catch(Exception ex){}
}
System.out.println("menuId: "+menuId);
//System.out.println("keywords: "+keywords);
//System.out.println("fromDate: "+fromDate);
//System.out.println("toDate: "+toDate);
%>
<liferay-portlet:renderURL varImpl="chamDiemBaiVietAdminHomePageImplURL" var="">
    <liferay-portlet:param name="jspPage" value="/html/admin/chamdiem/view.jsp"/>
    <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
</liferay-portlet:renderURL>

<div class="list-vl-chamdiembaiviet">
<liferay-ui:search-container emptyResultsMessage="no-found-chamdiembaiviet"  iteratorURL="<%= chamDiemBaiVietAdminHomePageImplURL %>">
	<%
	    total = BaiVietNhuanButLocalServiceUtil.countBaiVietNhuanButs(1,scopeGroupId, keywords, fDate, tDate);
	    int end= searchContainer.getEnd()>total?total:searchContainer.getEnd();
		List<BaiVietNhuanBut> baiViets = BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButs(1,scopeGroupId, keywords, fDate, tDate, searchContainer.getStart(), end);
		int i=0;
	%>
	
	<liferay-ui:search-container-results results="<%=baiViets %>" total="<%=total %>"/>
	
	<liferay-ui:search-container-row className="com.viettel.portal.thongke.model.BaiVietNhuanBut" keyProperty="id" modelVar="baiViet" escapedModel="<%=true %>">

		<liferay-ui:search-container-column-text name="STT" orderable="<%=false %>"	>
		   <div style="text-align:  center;"><%=(searchContainer.getStart()+(++i)) %></div>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "title-article") %>' value="<%= baiViet.getTieuDe()%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "author-article") %>' value="<%=baiViet.getTacGia()%>"
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "type-article") %>' >
			     <%= typeNews.get(String.valueOf(baiViet.getLoaiBaiViet()))%>
			</liferay-ui:search-container-column-text>	
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "publish-date") %>' value="<%=baiViet.getNgayXuatBan() != null ? dateTimeFormat.format(baiViet.getNgayXuatBan()) : null%>" 
			orderable="<%=false %>"
		/>			
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "rating") %>' >
		        <div>
				<div id='<%= "icon_rating_"+baiViet.getId()%>' style="width:15px;display: table-cell;padding-right: 3px;"></div>
				<div style="display: table-cell;">
				<aui:select name='<%= "rating_"+baiViet.getId()%>' label="" cssClass="clsRating">
				    <%
				        if(royalties.size()>0){
				        	for(String key:royalties.keySet()){
				        		
				        	%>
				        	<aui:option value="<%=royalties.get(key)%>" selected="<%= key.equals(baiViet.getRating()) %>" ><%=key%></aui:option>
				        	<%	
				        	}
				        }
				    %>
				</aui:select>
				<script type="text/javascript">
				    $('#<portlet:namespace />'+'<%= "rating_"+baiViet.getId()%>').change(function() {
					   //var x=document.getElementById('<portlet:namespace />phongBanIds');
					   var y=$(this).find(":selected").text().trim();
					   var yValue=$(this).find(":selected").val().trim();
					   yValue=parseInt(parseFloat('<%= typeNewsValues.get(String.valueOf(baiViet.getLoaiBaiViet()))%>')*parseFloat(yValue)/100);
					   AUI().use('aui-io-request-deprecated',function(A) {
					            A.io.request("<%=callMyUrl%>",
					            {
					            method:'post',
					            dataType:'text/html',
					            data:{
					            	<portlet:namespace />baiVietId:'{<%= "rating_"+baiViet.getBaiVietId()%>},'+'{<%= baiViet.getTieuDe()%>},'+'{<%= baiViet.getTacGia()%>},'+'{<%= baiViet.getDiaChi()%>},'+'{<%= dateTimeFormat.format(baiViet.getNgayXuatBan())%>},'+'{'+y+'},'+'{'+yValue+'},'+'{<%= String.valueOf(baiViet.getLoaiBaiViet())%>}',
					            	<portlet:namespace />cmd:'chamdiembaiviet',
					            },
					                on:{
					                success:function() {
					                    //alert(this.get('responseData'));
					                    //x.value=this.get('responseData');
									    if(this.get('responseData')!=''){
											$('#'+'<%= "icon_rating_"+baiViet.getId()%>').html("<i class='icon-ok-sign'></i>");
											setTimeout(function(){ $('#'+'<%= "icon_rating_"+baiViet.getId()%>').html("");}, 1000);
										   	
					                    }
					                }
					                }
					            });
					        });
					    
				    });
				</script>
				</div>
				</div>
			</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "delete") %>' align="center" cssClass="tbl_cell_action">
			<portlet:actionURL  name="deleteChamDiemBaiViet" var="deleteChamDiemBaiVietActionURL">
				<portlet:param name="id" value="<%=String.valueOf(baiViet.getId())%>"/>
				<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>   
				<portlet:param name="redirectURL" value='<%=PortalUtil.getCurrentURL(request) %>'/>
				<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>" />
			</portlet:actionURL>            
			<liferay-ui:icon-delete url="<%= deleteChamDiemBaiVietActionURL %>" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</div>




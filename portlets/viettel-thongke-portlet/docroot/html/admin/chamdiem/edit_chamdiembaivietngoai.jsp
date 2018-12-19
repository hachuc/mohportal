<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.viettel.portal.thongke.model.BaiVietNhuanBut"%>
<%@page import="com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/chamdiem/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
System.out.println("edit_menuId: "+menuId);

%>

<%
	long id = ParamUtil.getLong(request, "id");
	String tieuDe="",tacGia="",rating="",ngayXuatBans="",loaiBaiViet="";
	Date ngayXuatBan=null;
	int order_=0;
	BaiVietNhuanBut baiViet = null;
	if(id > 0){
		try{
			baiViet = BaiVietNhuanButLocalServiceUtil.getBaiVietNhuanBut(id);
		}
		catch(Exception ex){}
	}
	if(baiViet!=null){
		tieuDe=baiViet.getTieuDe();
		tacGia=baiViet.getTacGia();
		ngayXuatBan=baiViet.getNgayXuatBan();
		rating=baiViet.getRating();
		loaiBaiViet=String.valueOf(baiViet.getLoaiBaiViet());
		System.out.println("rating: "+rating);
		
		try{
			ngayXuatBans=dateFormat.format(ngayXuatBan);
		}
		catch(Exception e){}
		System.out.println("ngayXuatBans: "+ngayXuatBans);
	}
	
%>

<div class="baivietngoai-update-form">
			
	<portlet:actionURL name="updateChamDiemBaiVietNgoai" var="updateChamDiemBaiVietNgoaiActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
	
	<aui:form name="fm3" enctype="multipart/form-data" method="post" action="<%=updateChamDiemBaiVietNgoaiActionURL%>" >
			
		<aui:input name="typeNewsValuesPrice" label="typeNewsValuesPrice" type="hidden"  value="<%=typeNewsValuesPrice %>">
			
		</aui:input>	
		<aui:input name="tieuDe" label="title-article" type="text" size="255" value="<%=tieuDe %>">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="tacGia" label="author-article" type="text" size="255" value="<%=tacGia %>">
			<aui:validator name="required" />
		</aui:input>
		<aui:input id="ngayXuatBan" label="publish-date" name="ngayXuatBan" type="text" value="<%=ngayXuatBans %>">
		    <aui:validator name="required" />
		</aui:input>
		<aui:select name='loaiBaiViet' label="type-article">
		   
		    <%
		        if(typeNews.size()>0){
		        	for(String key:typeNews.keySet()){
		        		
		        	%>
		        	<aui:option value='<%=key%>' selected="<%= key.equals(loaiBaiViet) %>" ><%=typeNews.get(key)%></aui:option>
		        	<%	
		        	}
		        }
		    %>
		</aui:select>
        <aui:select name='rating' label="rating">
		    
		    <%
		        if(royalties.size()>0){
		        	for(String key:royalties.keySet()){
		        		
		        	%>
		        	<aui:option value='<%=royalties.get(key)+";"+key%>' selected="<%= key.equals(rating) %>" ><%=key%></aui:option>
		        	<%	
		        	}
		        }
		    %>
		</aui:select>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeBaiVietNhuanButUpdateFormBtn" value="cancel"/>
		</aui:button-row>	
	</aui:form>
</div>


<aui:script>
	AUI().ready(function(A){
		
		var closeBaiVietNhuanButUpdateFormBtn = A.one('#<portlet:namespace/>closeBaiVietNhuanButUpdateFormBtn');
        
		if(closeBaiVietNhuanButUpdateFormBtn){
            
			closeBaiVietNhuanButUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
	});
</aui:script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$("#<portlet:namespace />ngayXuatBan").datepicker({
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
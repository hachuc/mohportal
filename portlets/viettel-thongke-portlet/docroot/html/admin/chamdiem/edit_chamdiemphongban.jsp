<%@page import="com.viettel.portal.thongke.model.PhongBanRating"%>
<%@page import="com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil"%>
<%@page import="com.viettel.portal.thongke.model.PhongBanNhuanBut"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.viettel.portal.thongke.service.PhongBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.thongke.model.PhongBan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/html/admin/chamdiem/init.jsp" %>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>
<%
long id = ParamUtil.getLong(request, "id");
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
//String fromDateRating = ParamUtil.getString(request, "fromDateRating","");
//String toDateRating = ParamUtil.getString(request, "toDateRating","");
//System.out.println("edit_menuId: "+menuId);
//System.out.println("edit_keywords: "+keywords);
//System.out.println("edit_fromDate: "+fromDate);
//System.out.println("edit_toDate: "+toDate);

String phongBanIds = themeDisplay.getRequest().getSession().getAttribute("phongBanIds")!=null?themeDisplay.getRequest().getSession().getAttribute("phongBanIds").toString():"";
if(phongBanIds.equals(""))phongBanIds=ParamUtil.getString(request, "phongBanIds","");
String phongBanIdKhoiTaos=ParamUtil.getString(request, "phongBanIdKhoiTaos","");
String jspPage = ParamUtil.getString(request, "jspPage","");
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("menuId", String.valueOf(menuId));
portletURL.setParameter("popup", "1");
portletURL.setParameter("jspPage", jspPage);
//portletURL.setParameter("fromDateRating", fromDateRating);
//portletURL.setParameter("toDateRating", toDateRating);
//portletURL.setParameter("phongBanIds", phongBanIds);
portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
PhongBanNhuanBut phongBanNhuanBut=null;
if(id>0){
	try{
		phongBanNhuanBut = PhongBanNhuanButLocalServiceUtil.getPhongBanNhuanBut(id);
	}
	catch(Exception ex){}
}
Date fromDateRating=null;
Date toDateRating =null;
if(phongBanNhuanBut==null)id=0;
else{
	fromDateRating=phongBanNhuanBut.getFromDate();
	toDateRating=phongBanNhuanBut.getToDate();
}
HashMap<String,String>hs=new HashMap<String,String>();
%>

<aui:fieldset >
	<aui:column columnWidth="100">
		<liferay-util:include page="/html/admin/chamdiem/toolbar.jsp"  servletContext="<%=application %>" />
<div>	
    <portlet:actionURL name="updateChamDiemPhongBan" var="updateChamDiemPhongBanActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
   <aui:form name="fm1" enctype="multipart/form-data" method="post" action="<%=updateChamDiemPhongBanActionURL%>">
       <aui:row> 
		   <aui:column>
	       <aui:button-row>
				<aui:button  type="submit" class="btn btn-primary"  value='<%= LanguageUtil.get(locale, "save-rating") %>'>  </aui:button>
				<aui:button name="closeChamDiemPhongBanUpdateFormBtn" value="cancel"/>
			</aui:button-row>	
	       </aui:column>
	   </aui:row>
	   <aui:row>
	       <aui:column><label><liferay-ui:message key="rating-date"/> </label>
	       </aui:column>
		   <aui:column><aui:input id="fromDateRating" label="" name="fromDateRating"  placeholder='<%= LanguageUtil.get(locale, "from-date") %>' type="text" value="<%=fromDateRating!=null?dateFormat.format(fromDateRating):null %>">
		    <aui:validator name="required"/>
		   </aui:input>
	       </aui:column>
		   <aui:column><aui:input id="toDateRating" label="" name="toDateRating" placeholder='<%= LanguageUtil.get(locale, "to-date") %>' type="text" value="<%=toDateRating!=null?dateFormat.format(toDateRating):null %>">
		    <aui:validator name="required"/>
		   </aui:input>
	       </aui:column>
	       <aui:column><aui:input type="hidden" name="phongBanIds" label="" value='<%=phongBanIds %>'></aui:input>
	          <aui:input type="hidden" name="phongBanIdKhoiTaos" label="" ></aui:input>
	       </aui:column>
	    </aui:row>  
   </aui:form>	
</div>
<div class="list-vl-phongban">
	<liferay-ui:search-container emptyResultsMessage="no-found-phongban"  delta="0" iteratorURL="<%= portletURL %>">
		<%
		    total = (int)PhongBanLocalServiceUtil.countPhongBanRatings(id, scopeGroupId, keywords, fDate, tDate);
		    
		    int end= searchContainer.getEnd()>total?total:searchContainer.getEnd();
			//List<PhongBan> phongBans = PhongBanLocalServiceUtil.findPhongBans(scopeGroupId, phongBanSearchKeyword,  searchContainer.getStart(), end);
			List<Object> phongBanRatings = PhongBanLocalServiceUtil.findPhongBanRatings(id, scopeGroupId, keywords, fDate, tDate, searchContainer.getStart(), end);
			List<PhongBanRating>phongBans=new ArrayList<PhongBanRating>();
			Iterator itr = phongBanRatings.iterator();
			while (itr.hasNext()) {
				Object [] obj= (Object[])itr.next();
				//long phongBanId,String phonBanTen, Date ngayTao,String nguoiTao,String rating,double ratingValue
				PhongBanRating phongBanRating=new PhongBanRating(Long.parseLong(String.valueOf(obj[0])),String.valueOf(obj[1]),(Date)obj[2],String.valueOf(obj[3]),String.valueOf(obj[4]),Double.parseDouble(String.valueOf(obj[5])));
				phongBans.add(phongBanRating);
			}
			int i=0;
		%>
		
		<liferay-ui:search-container-results results="<%=phongBans %>" total="<%=total %>" />
		
		<liferay-ui:search-container-row className="com.viettel.portal.thongke.model.PhongBanRating" keyProperty="id" modelVar="phongBan" escapedModel="<%=true %>">
	
			<liferay-ui:search-container-column-text name="STT" orderable="<%=false %>"	>
			   <div style="text-align:  center;"><%=(searchContainer.getStart()+(++i)) %></div>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "ten-phongban") %>' value="<%= phongBan.getPhonBanTen()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "created-date") %>' value="<%=phongBan.getNgayTao() != null ? dateTimeFormat.format(phongBan.getNgayTao()) : null%>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "created-user") %>' value="<%= phongBan.getNguoiTao()%>" 
				orderable="<%=false %>"
			/>			
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "rating") %>' >
				<aui:select name='<%= "rating_"+phongBan.getId()%>' label="" cssClass="clsRating">
				    <aui:option value="0"></aui:option>
				    <%
				        if(royalties.size()>0){
				        	for(String key:royalties.keySet()){
				        		if(key.equals(phongBan.getRating())){
				        			if(!hs.containsKey(String.valueOf(phongBan.getId()))){
				        				hs.put(String.valueOf(phongBan.getId()), "1");
				        			%>
				        			<script type="text/javascript">
				        			      var x=document.getElementById('<portlet:namespace />phongBanIdKhoiTaos');
				        			      x.value+=(x.value=='')?'{<%= "rating_"+phongBan.getId()%>},'+'{<%= phongBan.getPhonBanTen()%>},'+'{<%= key%>},'+'{<%= royalties.get(key)%>}':';{<%= "rating_"+phongBan.getId()%>},'+'{<%= phongBan.getPhonBanTen()%>},'+'{<%= key%>},'+'{<%= royalties.get(key)%>}';
				        			      
				        			</script>
				        			<%	
				        			}
				        		}
				        	%>
				        	<aui:option value="<%=royalties.get(key)%>" selected="<%= key.equals(phongBan.getRating()) %>" ><%=key%></aui:option>
				        	<%	
				        	}
				        }
				    %>
				</aui:select>
				<script type="text/javascript">
				    $('#<portlet:namespace />'+'<%= "rating_"+phongBan.getId()%>').change(function() {
					   var x=document.getElementById('<portlet:namespace />phongBanIds');
					   var y=$(this).find(":selected").text().trim();
					   var yValue=$(this).find(":selected").val().trim();
					   <%-- x.value+=(x.value=='')?'<%= "rating_"+phongBan.getId()%>,'+y:';<%= "rating_"+phongBan.getId()%>,'+y; --%>
					   
						   AUI().use('aui-io-request-deprecated',function(A) {
					            A.io.request("<%=callMyUrl%>",
					            {
					            method:'post',
					            dataType:'text/html',
					            data:{
					            	<portlet:namespace />phongBanId:'{<%= "rating_"+phongBan.getId()%>},'+'{<%= phongBan.getPhonBanTen()%>},'+'{'+y+'},{'+yValue+'}',
					            	<portlet:namespace />cmd:'chamdiemphongban',
					            },
					                on:{
					                success:function() {
					                    //alert(this.get('responseData'));
					                    x.value=this.get('responseData');
					                                    }
					                    }
					            });
					        });
					    
				    });
				</script>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator paginate="<%=false %>"/>
		
	</liferay-ui:search-container>
</div>
	</aui:column>
</aui:fieldset>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$("#<portlet:namespace />toDateRating").datepicker({
			  monthNamesShort: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
			  dateFormat:"dd/mm/yy",
			  changeMonth: true,
			  changeYear: true,
			        //yearRange: "1950:2050",
			  onClose:function(){
			   $(this).focus().blur();
			  }
		});
		$("#<portlet:namespace />fromDateRating").datepicker({
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

<aui:script>
	AUI().ready(function(A){
		
		var closeChamDiemPhongBanUpdateFormBtn = A.one('#<portlet:namespace/>closeChamDiemPhongBanUpdateFormBtn');
		if(closeChamDiemPhongBanUpdateFormBtn){
            
			closeChamDiemPhongBanUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
        
	});
</aui:script>

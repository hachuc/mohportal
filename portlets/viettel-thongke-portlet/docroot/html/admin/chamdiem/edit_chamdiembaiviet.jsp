<%@page import="com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil"%>
<%@page import="com.viettel.portal.thongke.model.BaiVietRating"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.xml.Node"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Document"%>
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
HashMap<String,String>hs=new HashMap<String,String>();
%>

<aui:fieldset >
	<aui:column columnWidth="100">
		<liferay-util:include page="/html/admin/chamdiem/toolbar.jsp"  servletContext="<%=application %>" />
<div>	
    <portlet:actionURL name="updateChamDiemBaiViet" var="updateChamDiemBaiVietActionURL">
		<portlet:param name="id" value="<%=String.valueOf(id) %>"/>
		<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
	</portlet:actionURL>
   <aui:form name="fm2" enctype="multipart/form-data" method="post" action="<%=updateChamDiemBaiVietActionURL%>">
       <aui:row> 
		   <aui:column>
	       <aui:button-row>
				<aui:button  type="submit" class="btn btn-primary"  value='<%= LanguageUtil.get(locale, "save-rating") %>'>  </aui:button>
				<aui:button name="closeChamDiemBaiVietUpdateFormBtn" value="cancel"/>
			</aui:button-row>	
	       </aui:column>
	   </aui:row>
	   <aui:row>
	          <aui:column><aui:input type="hidden" name="phongBanIds" label="" value='<%=phongBanIds %>'></aui:input>
	          <aui:input type="hidden" name="phongBanIdKhoiTaos" label="" ></aui:input>
	       </aui:column>
	    </aui:row>  
   </aui:form>	
</div>
<div class="list-vl-phongban">
	<liferay-ui:search-container emptyResultsMessage="no-found-baivietnhuanbut"  iteratorURL="<%= portletURL %>">
		<%
		    total=BaiVietNhuanButLocalServiceUtil.countBaiVietRatings(classTypeId,1,scopeGroupId, keywords, fDate, tDate);
		    int end= searchContainer.getEnd()>total?total:searchContainer.getEnd();
			List<Object> baiVietRatings = BaiVietNhuanButLocalServiceUtil.findBaiVietRatings( classTypeId,1,scopeGroupId, keywords, fDate, tDate, searchContainer.getStart(), end);
			List<BaiVietRating>baiViets=new ArrayList<BaiVietRating>();
			Iterator itr = baiVietRatings.iterator();
			Document document=null;
			String tieuDe="",tacGia="",diaChi="",loaiVanBan="";
			while (itr.hasNext()) {
				tieuDe="";tacGia="";diaChi="";loaiVanBan="";
				Object [] obj= (Object[])itr.next();
				try{
					document = SAXReaderUtil.read(String.valueOf(obj[1]));
					Node title = document.selectSingleNode("/root/Title");
					if(title!=null)tieuDe=title.getText();
					
					document = SAXReaderUtil.read(String.valueOf(obj[3]));
					Node author = document.selectSingleNode("/root/dynamic-element[@name='strAuthor']/dynamic-content");
					if(author!=null)tacGia=author.getText();
					Node address = document.selectSingleNode("/root/dynamic-element[@name='strAuthorTitle']/dynamic-content");
					if(address!=null)diaChi=address.getText();
					Node type=document.selectSingleNode("/root/dynamic-element[@name='iNewsType']/dynamic-content");
					if(type!=null)loaiVanBan=type.getText();
					else loaiVanBan="1"; 
					if(!tieuDe.equals("") && !tacGia.equals("")){
						BaiVietRating baiVietRating=new BaiVietRating(Long.parseLong(String.valueOf(obj[0])),tieuDe,(Date)obj[2],tacGia,diaChi,String.valueOf(obj[4]),Double.parseDouble(String.valueOf(obj[5])),Integer.parseInt(loaiVanBan));
						baiViets.add(baiVietRating);
					}
					
				}
				catch(Exception ex){}
				
			}
			int i=0;
		%>
		
		<liferay-ui:search-container-results results="<%=baiViets %>" total="<%=total %>" />
		
		<liferay-ui:search-container-row className="com.viettel.portal.thongke.model.BaiVietRating" keyProperty="id" modelVar="baiViet" escapedModel="<%=true %>">
	
			<liferay-ui:search-container-column-text name="STT" orderable="<%=false %>"	>
			   <div style="text-align:  center;"><%=(searchContainer.getStart()+(++i)) %></div>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "title-article") %>' value="<%= baiViet.getTieuDe()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "author-article") %>' value="<%= baiViet.getTacGia()%>" 
				orderable="<%=false %>"
			/>
			
			<liferay-ui:search-container-column-text  name='<%= LanguageUtil.get(locale, "publish-date") %>' value="<%=baiViet.getNgayXuatBan() != null ? dateTimeFormat.format(baiViet.getNgayXuatBan()) : null%>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "type-article") %>' >
			     <%= typeNews.get(String.valueOf(baiViet.getLoaiBaiViet()))%>
			</liferay-ui:search-container-column-text>			
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "rating") %>' >
			    <div>
				<div id='<%= "icon_rating_"+baiViet.getId()%>' style="width:15px;display: table-cell;padding-right: 3px;"></div>
				<div style="display: table-cell;">
				<aui:select name='<%= "rating_"+baiViet.getId()%>' label="" cssClass="clsRating">
				    <aui:option value="0"></aui:option>
				    <%
				        if(royalties.size()>0){
				        	for(String key:royalties.keySet()){
				        		if(key.equals(baiViet.getRating())){
				        			if(!hs.containsKey(String.valueOf(baiViet.getId()))){
				        				hs.put(String.valueOf(baiViet.getId()), "1");
				        			%>
				        			<script type="text/javascript">
				        			      var x=document.getElementById('<portlet:namespace />phongBanIdKhoiTaos');
				        			      x.value+=(x.value=='')?'{<%= "rating_"+baiViet.getId()%>},'+'{<%= baiViet.getTieuDe()%>},'+'{<%= baiViet.getTacGia()%>},'+'{<%= baiViet.getDiaChi()%>},'+'{<%= dateTimeFormat.format(baiViet.getNgayXuatBan())%>},'+'{<%= key%>},'+'{<%= royalties.get(key)%>}':';{<%= "rating_"+baiViet.getId()%>},'+'{<%= baiViet.getTieuDe()%>},'+'{<%= baiViet.getTacGia()%>},'+'{<%= baiViet.getDiaChi()%>},'+'{<%= dateTimeFormat.format(baiViet.getNgayXuatBan())%>},'+'{<%= baiViet.getRating()%>},'+'{<%= baiViet.getRatingValue()%>},'+'{<%= String.valueOf(baiViet.getLoaiBaiViet())%>}';
				        			      
				        			</script>
				        			<%	
				        			}
				        		}
				        	%>
				        	<aui:option value="<%=royalties.get(key)%>" selected="<%= key.equals(baiViet.getRating()) %>" ><%=key%></aui:option>
				        	<%	
				        	}
				        }
				    %>
				</aui:select>
				<script type="text/javascript">
				    $('#<portlet:namespace />'+'<%= "rating_"+baiViet.getId()%>').change(function() {
					   var x=document.getElementById('<portlet:namespace />phongBanIds');
					   var y=$(this).find(":selected").text().trim();
					   var yValue=$(this).find(":selected").val().trim();
					   yValue=parseInt(parseFloat('<%= typeNewsValues.get(String.valueOf(baiViet.getLoaiBaiViet()))%>')*parseFloat(yValue)/100);
						   AUI().use('aui-io-request-deprecated',function(A) {
					            A.io.request("<%=callMyUrl%>",
					            {
					            method:'post',
					            dataType:'text/html',
					            data:{
					            	<portlet:namespace />baiVietId:'{<%= "rating_"+baiViet.getId()%>},'+'{<%= baiViet.getTieuDe()%>},'+'{<%= baiViet.getTacGia()%>},'+'{<%= baiViet.getDiaChi()%>},'+'{<%= dateTimeFormat.format(baiViet.getNgayXuatBan())%>},'+'{'+y+'},'+'{'+yValue+'},'+'{<%= String.valueOf(baiViet.getLoaiBaiViet())%>}',
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
			
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
</div>
	</aui:column>
</aui:fieldset>


<aui:script>
	AUI().ready(function(A){
		
		var closeChamDiemBaiVietUpdateFormBtn = A.one('#<portlet:namespace/>closeChamDiemBaiVietUpdateFormBtn');
		if(closeChamDiemBaiVietUpdateFormBtn){
            
			closeChamDiemBaiVietUpdateFormBtn.on('click',function(){
                
				Liferay.Util.getWindow().destroy();
                
			});
		}
        
	});
</aui:script>

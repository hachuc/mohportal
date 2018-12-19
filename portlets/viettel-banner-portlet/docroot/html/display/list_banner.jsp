
<%@page import="com.viettel.portal.banner.permission.BannerPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.viettel.portal.banner.util.BannerFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.viettel.portal.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.viettel.portal.banner.model.Banner"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% String empty = ""; %>
<%@include file="/html/display/init.jsp"%>

<liferay-portlet:renderURL var="searchBannerURL">
	<liferay-portlet:param name="mvcPath" value="/html/display/list_banner.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="listBannerURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/display/list_banner.jsp"/>
	<liferay-portlet:param name="keywords" value="<%=keywords %>"/>
</liferay-portlet:renderURL>


<div class="list-vl-banner">
	<div class="form-search">
		<aui:form action="<%= searchBannerURL %>" method="post" name="fm">
			<liferay-ui:input-search id="keywords1" name="keywords" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
		</aui:form>
	</div>
	<liferay-ui:search-container emptyResultsMessage="no-found-banner">
		<%
			List<Banner> banners = BannerLocalServiceUtil.findBanners(scopeGroupId, keywords, searchContainer.getStart(), searchContainer.getEnd());
			total = (int)BannerLocalServiceUtil.countBanners(scopeGroupId, keywords);
		%>
		
		<liferay-ui:search-container-results results="<%=banners %>" total="<%=total %>"/>
		
		<liferay-ui:search-container-row className="Banner" keyProperty="id" modelVar="banner" escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text name="#" cssClass="tbl_cell_banner_image">
				<%
					String bannerThumbnailURL = request.getContextPath() + "/images/default-banner-thumbnail.jpg";
					if(banner.getFileId() > 0){
						FileEntry thumbnailImage = null;
						try{
							thumbnailImage = DLAppServiceUtil.getFileEntry(banner.getFileId());
						}catch(Exception e){}
						
						if(thumbnailImage != null){
							bannerThumbnailURL = BannerFileUtil.getBannerThumbnailURL(themeDisplay, thumbnailImage);
						}
					}
				%>
				
				<div style="position: relative;">
					<img src = "<%=bannerThumbnailURL %>" width = "130px" height = "130px"/>
				</div>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Tên-banner" orderable="<%=false %>" value="<%=banner.getTen()%>"
				title="<%= HtmlUtil.escape(banner.getTen()) %>" 
			/>
			
			<liferay-ui:search-container-column-text name="Liên-kết" orderable="<%=false %>" value="<%=banner.getLienKet()%>"
				title="<%= HtmlUtil.escape(banner.getLienKet()) %>" 
			/>
			
			<liferay-ui:search-container-column-text name="Ngày-kết-thúc" orderable="<%=false %>" value="<%=banner.getNgayKetThuc() != null ? dateTimeFormat.format(banner.getNgayKetThuc()) : empty%>"
				title="<%=banner.getNgayKetThuc() != null ? dateTimeFormat.format(banner.getNgayKetThuc()) : empty %>" valign="middle"
			/>
			
			<liferay-ui:search-container-column-text name="select" align="center" cssClass="tbl_cell_action">
				<aui:button name="select" value="select" bannerid="<%=banner.getId() %>"
				 bannername="<%= HtmlUtil.escape(banner.getTen()) %>" bannerlienket="<%= HtmlUtil.escape(banner.getLienKet()) %>" bannernkt="<%= banner.getNgayKetThuc() != null ? dateTimeFormat.format(banner.getNgayKetThuc()) : empty %>"/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>


<aui:script use="aui-base">
	AUI().ready(function(A){
		var selectBtns = A.all('#<portlet:namespace/>select');
		selectBtns.each(function(btn){
			btn.on('click', function(){
				var bannerid = btn.attr('bannerid');
				var bannername = btn.attr('bannername');
				var bannerlienket = btn.attr('bannerlienket');
				var bannernkt = btn.attr('bannernkt');
				
				var openingWindow = Liferay.Util.getOpener();
				
				var tblSelectedBanners = openingWindow.document.getElementById("cfg-tbl-banner-selected-body");
				var row = document.createElement('tr');
				row.setAttribute('class', 'tbl-row');
				var cols = '<td class="tbl-col-1">' + bannername + '</td>' +
				'<td class="tbl-col-2">' + bannerlienket + '</td>' + 
				'<td class="tbl-col-3">' + bannernkt + '</td>' +
				'<td class="tbl-col-4"><span onclick="removeSelectedBanner(this)">X</span>' + '</td><input type="hidden" name="_86_selectedBannerId" value="'+bannerid +'">';
				row.innerHTML = cols;
				tblSelectedBanners.appendChild(row);
			});
		});
	});
	
	Liferay.provide(
			window,
			'viewBannerForm',
			function(url){
				var title="<liferay-ui:message key='view-banner'/>";
				var dialogWidow = {
					dialog: {
						constrain: true,
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						cache: false,
						width:640
					},
					title: title,
					uri: url,
				};
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
</aui:script>
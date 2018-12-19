<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.viettel.portal.banner.permission.BannerPermission"%>
<%@page import="com.viettel.portal.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.viettel.portal.banner.model.Banner"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/admin/init.jsp"%>
<%
	String blank = "";
%>

<liferay-portlet:renderURL varImpl="bannerAdminHomePageImplURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="bannerSearchKeyword" value="<%=bannerSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div class="list-vl-banner">
	<liferay-ui:search-container emptyResultsMessage="no-found-banner">
		<%
			List<Banner> banners = BannerLocalServiceUtil.findBanners(scopeGroupId, bannerSearchKeyword, searchContainer.getStart(), searchContainer.getEnd());
			total = (int)BannerLocalServiceUtil.countBanners(scopeGroupId, bannerSearchKeyword);
		%>
		
		<liferay-ui:search-container-results results="<%=banners %>" total="<%=total %>"/>
		
		<liferay-ui:search-container-row className="Banner" keyProperty="id" modelVar="banner" escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text name="Tên-banner" value="<%= banner.getTen()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Liên-kết" value="<%= banner.getLienKet()%>" 
				orderable="<%=false %>"
			/>			
			<liferay-ui:search-container-column-text name="Ngày-kết-thúc" value="<%= (banner.getNgayKetThuc() != null ? dateFormat.format(banner.getNgayKetThuc()) : blank) %>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Vị-trí" value="<%= blank + banner.getOrder_() %>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Ngày-tạo" value="<%=dateTimeFormat.format(banner.getNgayTao())%>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Người-tạo" value="<%= banner.getNguoiTao()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
				<c:if test="<%=BannerPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
					<portlet:renderURL var="editBannerURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/edit_banner.jsp" />
						<portlet:param name="id" value="<%= String.valueOf(banner.getId()) %>" />
					</portlet:renderURL>
					
					<a href="javascript:;" onclick='updateBannerForm("<%=editBannerURL.toString() %>");'>
						<liferay-ui:icon image="edit"/>
					</a>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
				<c:if test="<%=BannerPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE) %>">
					<portlet:actionURL  name="deleteBanner" var="deleteBannerActionURL">
						<portlet:param name="id" value="<%=String.valueOf(banner.getId())%>"/>
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>   
						<portlet:param name="redirectURL" value='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace()%>'/>
					</portlet:actionURL>            
					<liferay-ui:icon-delete url="<%= deleteBannerActionURL %>" />
				</c:if>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
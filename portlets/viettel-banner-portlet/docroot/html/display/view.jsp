<%@page import="com.viettel.portal.banner.util.BannerConstants"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.viettel.portal.banner.util.BannerFileUtil"%>
<%@page import="com.viettel.portal.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.viettel.portal.banner.model.Banner"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.swing.plaf.ListUI"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/display/init.jsp"%>
<style type="text/css">
	.mb1rem{
		margin-bottom: 1rem;
	}
</style>
<%
	long[] bannerIds = selectedBannersId != null && !selectedBannersId.isEmpty() ? StringUtil.split(selectedBannersId, 0L) : null;
	List<Banner> list = new ArrayList<Banner>();
	if(bannerIds != null && bannerIds.length > 0){
		List<Long> ids = new ArrayList<Long>();
		for(long id :bannerIds){
			ids.add(id);
		}
		list = BannerLocalServiceUtil.findBannersByIds(ids);
	}
	String emptyUrl = "#";
%>
 <c:choose>
	<c:when test="<%=!list.isEmpty()%>">
		<div class="banner-player-default-style">
			<div class="banner-player-frame" >
				<div class="banner-list">
					<%
						String fileUrl = "";
						for(Banner banner : list) {
							if(banner.getFileId() > 0){
								FileEntry bannerFileEntry = DLAppServiceUtil.getFileEntry(banner.getFileId());
								if(bannerFileEntry != null){
									fileUrl = BannerFileUtil.getBannerThumbnailURL(themeDisplay, bannerFileEntry);
								}
							}
							
					    	 %><c:if test="<%= Validator.isNotNull(banner.getLienKet()) %>">
						    	 	<a class="mb1rem" target="_blank" href="<%= banner.getLienKet() != null && !banner.getLienKet().isEmpty() ? banner.getLienKet() : emptyUrl  %>">
						    	 		<img class="img-responsive" src="<%=fileUrl %>"/>
					    	 		</a>
				    	 		</c:if>
				    	 		<c:if test="<%= Validator.isNull(banner.getLienKet()) %>">
				    	 			<img class="img-responsive" src="<%=fileUrl %>"/>
				    	 		</c:if>
					    	 <%
						}
					%>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg"><liferay-ui:message key="Không-tìm-thấy-banner"/></div>
	</c:otherwise>
</c:choose>


<%@page import="com.viettel.portal.magazine.model.MagazineContent"%>
<%@page
	import="com.viettel.portal.magazine.service.MagazineContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.model.MagazineZone"%>
<%@page
	import="com.viettel.portal.magazine.service.MagazineZoneLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.model.Magazine"%>
<%@page
	import="com.viettel.portal.magazine.service.MagazineLocalServiceUtil"%>
	
<%@page import="com.viettel.portal.magazine.model.Magazine"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.viettel.portal.magazine.util.MagazineFileUtil" %>
	
<%@ include file="/html/frontend/init.jsp"%>
<%
	//Magazine mgz = MagazineLocalServiceUtil.fetchMagazine(magazineId);
	List<MagazineZone> lstZone = MagazineZoneLocalServiceUtil
			.GetByMagazineId(magazineId);
%>
<div class="bacday">
	<h4 class="headerBox0">
		<liferay-ui:message key="magazine-head-title" />
	</h4>
	<c:if
		test='<%=Validator.isNotNull(mgz)
						&& Validator.isNotNull(lstZone)%>'>
						<%
						String thumbnailURL = request.getContextPath() + "/images/default-thumbnail.jpg";
						FileEntry thumbnailImage = null;
						if(mgz.getImageID() > 0){
							try{
								thumbnailImage = DLAppServiceUtil.getFileEntry(mgz.getImageID());
							}catch(Exception e){
								
							}
							if(thumbnailImage != null){
								thumbnailURL = MagazineFileUtil.getThumbnailURL(themeDisplay, thumbnailImage);
							}
						}
						else{
							thumbnailURL = "http://xaydungdang.org.vn" + mgz.getImageUrl();
						}
						%>
		<table class="table">
			<tbody>
				<tr>
					<td class="text" style="text-align: center" width="180px"><img
						src="<%=thumbnailURL%>"
						style="border-width: 0px;"></td>
					<td width="10px"></td>
					<td valign="top">
						<table class="table borderless">
							<tbody>
								<tr>
									<td style="WIDTH: 110px" class="magazine"><liferay-ui:message
											key="magazine-title" />&nbsp; :</td>
									<td class="magazine"><span><%=HtmlUtil.escape(mgz.getName())%></span></td>
								</tr>
								<tr>
									<td style="WIDTH: 110px" class="magazine"><liferay-ui:message
											key="magazine-number" /> :</td>
									<td class="magazine"><span><%=mgz.getPublishNumber()%></span></td>
								</tr>
								<tr>
									<td class="magazine" style="WIDTH: 110px"><liferay-ui:message
											key="publish-year-label" /> :</td>
									<td class="magazine"><span><%=mgz.getPublishYear()%></span></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<hr />
		<%
			for (MagazineZone zone : lstZone) {
					List<MagazineContent> lstContent = MagazineContentLocalServiceUtil
							.GetByMagazineAndZone(magazineId, zone.getID());
		%>
		<div class="magazinezone">
			<img src="/TapChiIn-portlet/images/reply.gif" align="absmiddle">
			<span><%=HtmlUtil.escape(zone.getName())%></span>
		</div>
		<div class="col-md-12 ml10">
			<%
				for (MagazineContent content : lstContent) {
			%>
			<liferay-portlet:renderURL var="viewMagazineContentDetail">
				<portlet:param name="magazineId"
					value="<%=String.valueOf(magazineId)%>" />
				<portlet:param name="mzId" value="<%=String.valueOf(zone.getID())%>" />
				<portlet:param name="mcId"
					value="<%=String.valueOf(content.getID())%>" />
			</liferay-portlet:renderURL>
			<div class="magazineheadline">
				<img src="/TapChiIn-portlet/images/timetip.gif" align="absmiddle">
				<c:choose>
					<c:when test='<%= mgz.getDistributedDate().before(new Date()) %>'>
						<a href="<%=viewMagazineContentDetail%>"><%=HtmlUtil.escape(content.getHeadline())%></a>
					</c:when>
					<c:otherwise>
						<span><%=HtmlUtil.escape(content.getHeadline())%></span>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="magazineauthor">
				<span><liferay-ui:message key="magazine-author" /> : <%=HtmlUtil.escape(content.getAuthor())%><c:if
						test='<%=Validator.isNotNull(content.getJobtitle())%>'> - <%=HtmlUtil.escape(content.getJobtitle())%></c:if></span>
			</div>
			<%
				}
			%>
		</div>
		<%
			}
		%>
	</c:if>
</div>

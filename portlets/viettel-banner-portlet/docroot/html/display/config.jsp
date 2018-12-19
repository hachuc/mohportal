<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.viettel.portal.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.viettel.portal.banner.model.Banner"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/display/init.jsp"%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL var="selectBannerFormURL" portletName="<%=portletResource %>">
	<liferay-portlet:param name="jspPage" value="/html/display/list_banner.jsp"/>
</liferay-portlet:renderURL>
<aui:form name="fm" method="post" action="<%=configurationActionURL %>">
<div id="selected-banner-display">
	<aui:button name="selectBanner" value="Chọn banner" type="button"/>
	<table width="100%" class="tbl-banner-selected" id="cfg-tbl-banner-selected">
		<thead>
			<tr class="tbl-header">
				<th class="tbl-col-1"><liferay-ui:message key="Tên-banner"/></th>
				<th class="tbl-col-3"><liferay-ui:message key="Liên-kết"/></th>
				<th class="tbl-col-2"><liferay-ui:message key="Ngày-kết-thúc"/></th>
				<th class="tbl-col-4"><liferay-ui:message key="Xóa"/></th>
			</tr>
		</thead>
		<tbody id="cfg-tbl-banner-selected-body">
			<c:if test="<%=Validator.isNotNull(selectedBannersId) %>">
			<%
				long[] bannerIds = StringUtil.split(selectedBannersId, 0L);
				if(bannerIds != null && bannerIds.length > 0){
					for(long bannerId:bannerIds){
						if(bannerId > 0){
							Banner banner = null;
							try{
								banner = BannerLocalServiceUtil.getBanner(bannerId);
							}catch(Exception e){
								_log.warn(e);
							}
							
							if(banner != null){
								%>
									<tr class="tbl-row">
										<td class="tbl-col-1"><%= banner.getTen() %></td>
										<td class="tbl-col-2"><%= banner.getLienKet() %></td>
										<td class="tbl-col-3"><%= banner.getNgayKetThuc() %></td>
										<td class="tbl-col-4 td-fn-column">
											<span onclick="removeSelectedBanner(this)">X</span>
											<input type="hidden" name="_86_selectedBannerId" value="<%=banner.getId()%>">
										</td>
									</tr>
								<%
							}
						}
					}
				}
			%>
			</c:if>
		</tbody>
	</table>
		
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button name="cancelBtn" value="cancel"/>
	</aui:button-row>
</div>
</aui:form>

<aui:script use="aui-base">
	AUI().ready(function(A){
		
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		var displayStyleSelect = A.one('#<portlet:namespace/>displayStyle');
		
		if (displayStyleSelect){
			if(displayStyleSelect.val == 'grid-style'){
				A.one ('#selected-banner-display').setStyle ("display","none");
			}
			displayStyleSelect.on('change',function(){
				var displayStyle = displayStyleSelect.attr('value');
				
				if (displayStyle == 'grid-style'){
					A.one ('#selected-banner-display').setStyle ("display","none");
				}
				else{
					A.one ('#selected-banner-display').setStyle ("display","block");
				}
			});
		}
		
		if(closeConfigPageBtn){	
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
		
		var selectBanner = A.one('#<portlet:namespace/>selectBanner');
		
		if(selectBanner){
			selectBanner.on('click', function(A){
				selectBannerForm('<%=selectBannerFormURL.toString()%>');
			});
		}
	});
	
	Liferay.provide(
		window,
		'selectBannerForm',
		function(url){
			var title="<liferay-ui:message key='select-banner'/>";
			var dialogWidow = {
				dialog: {
					constrain: true,
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: '80%',
					cache: false,
					after: {
						visibleChange: function(event) {
						}
                    }
				},
				title: title,
				uri: url,
			};
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	Liferay.provide(
		window,
		'removeSelectedBanner',
		function(e){
			var A = AUI();
			var row = A.one(e).ancestor();
			var msg="<liferay-ui:message key='do-you-want-remove-this-banner'/>";
			var r = confirm(msg);
			if(r){
				if(row){
					row.remove();
				}
			}else{
				return;
			}
		}
	);
</aui:script>		
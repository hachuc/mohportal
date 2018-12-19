<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.viettel.portal.videolibrary.permission.CategoryPermission"%>
<%@page import="com.viettel.portal.videolibrary.service.VLCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.videolibrary.model.VLCategory"%>
<%@page import="java.util.List"%>
<%@ include file="/html/admin/init.jsp" %>

<aui:fieldset >
	<aui:column columnWidth="20">
		<liferay-util:include page="/html/admin/categories.jsp"  servletContext="<%=application %>" />
	</aui:column>
	<aui:column columnWidth="80">
		<liferay-util:include page="/html/admin/toolbar.jsp"  servletContext="<%=application %>" />
		<liferay-util:include page="/html/admin/videos.jsp"  servletContext="<%=application %>" />
	</aui:column>
</aui:fieldset>

<aui:script use="aui-base,uploader">
	if (!A.UA.ios && (A.Uploader.TYPE != 'none')) {
		var uploadMultipleDocumentsIcon = A.all('.upload-multiple-documents:hidden');

		uploadMultipleDocumentsIcon.show();
	}
	
		Liferay.provide(
			window,
			'updateVLCategoryForm',
			function(url){
				
				var dialogWidow = {
					dialog: {
						constrain: true,
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: '80%',
						cache: false,
						after: {
							visibleChange: function(event) {
								location.reload();
							}
                        }
					},
					title: Liferay.Language.get('add-new-category'),
					uri: url,
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
	
		Liferay.provide(
			window,
			'updateVLVideoForm',
			function(url){
				
				var dialogWidow = {
					dialog: {
						constrain: true,
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: '80%',
						cache: false,
						after: {
							visibleChange: function(event) {
								location.reload();
							}
                        }
					},
					title: Liferay.Language.get('update-video'),
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
		
		Liferay.provide(
				window,
				'migrateVideo',
				function(url){
					
					var dialogWidow = {
						dialog: {
							constrain: true,
							align: Liferay.Util.Window.ALIGN_CENTER,
							modal: true,
							width: '80%',
							cache: false,
							after: {
								visibleChange: function(event) {
									location.reload();
								}
	                        }
						},
						title: Liferay.Language.get('migrate-video'),
						uri: url,
						
					};
					
					Liferay.Util.openWindow(dialogWidow);	
				}
			);
		
		Liferay.provide(
				window,
				'viewVLVideoForm',
				function(url){
					var title="<liferay-ui:message key='view-video'/>";
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


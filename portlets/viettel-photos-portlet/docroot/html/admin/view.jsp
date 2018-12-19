<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<aui:fieldset >
	<aui:column columnWidth="20">
		<liferay-util:include page="/html/admin/categories.jsp"  servletContext="<%=application %>" />
	</aui:column>
	<aui:column columnWidth="80">
		<liferay-util:include page="/html/admin/toolbar.jsp"  servletContext="<%=application %>" />
		<liferay-util:include page="/html/admin/photos.jsp"  servletContext="<%=application %>" />
	</aui:column>
</aui:fieldset>

<aui:script use="aui-base,uploader">
	if (!A.UA.ios && (A.Uploader.TYPE != 'none')) {
		var uploadMultipleDocumentsIcon = A.all('.upload-multiple-documents:hidden');
		uploadMultipleDocumentsIcon.show();
	}
	
	Liferay.provide(
		window,
		'updatePhotoForm',
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
				title: Liferay.Language.get('cap-nhap-photo'),
				uri: url,
				
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	
	Liferay.provide(
			window,
			'updatePCategoryForm',
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
					title: Liferay.Language.get('cap-nhap-pcategory'),
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);	
</aui:script>


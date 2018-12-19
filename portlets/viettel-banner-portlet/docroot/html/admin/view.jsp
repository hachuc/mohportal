<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.viettel.portal.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.viettel.portal.banner.model.Banner"%>
<%@page import="java.util.List"%>
<%@ include file="/html/admin/init.jsp" %>

<aui:fieldset >
	<aui:column columnWidth="100">
		<liferay-util:include page="/html/admin/toolbar.jsp"  servletContext="<%=application %>" />
		<liferay-util:include page="/html/admin/banners.jsp"  servletContext="<%=application %>" />
	</aui:column>
</aui:fieldset>

<aui:script use="aui-base,uploader">
	if (!A.UA.ios && (A.Uploader.TYPE != 'none')) {
		var uploadMultipleDocumentsIcon = A.all('.upload-multiple-documents:hidden');
		uploadMultipleDocumentsIcon.show();
	}
	
	Liferay.provide(
		window,
		'updateBannerForm',
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
				title: Liferay.Language.get('cap-nhap-banner'),
				uri: url,
				
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
</aui:script>


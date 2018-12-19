<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp" %>

<aui:fieldset >
	<aui:column columnWidth="100">
		<liferay-util:include page="/html/admin/phongban/toolbar.jsp"  servletContext="<%=application %>" />
		<liferay-util:include page="/html/admin/phongban/phongban.jsp"  servletContext="<%=application %>" />
	</aui:column>
</aui:fieldset>

<aui:script use="aui-base">
	Liferay.provide(
		window,
		'updatePhongBanForm',
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
                    },
                    on: {
                        destroy: function() { 
                            parent.location.reload();                   
                        }
                    }
				},
				title: Liferay.Language.get('cap-nhap-phongban'),
				uri: url,
				
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	
	
</aui:script>


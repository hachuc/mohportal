<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.util.List"%>
<%@ include file="/html/init.jsp" %>

<aui:fieldset >
	<aui:column columnWidth="20">
		<liferay-util:include page="/html/admin/chamdiem/menus.jsp"  servletContext="<%=application %>" />
	</aui:column>
	<aui:column columnWidth="80">
		<liferay-util:include page="/html/admin/chamdiem/toolbar.jsp"  servletContext="<%=application %>" />
		<liferay-util:include page="/html/admin/chamdiem/chamdiem.jsp"  servletContext="<%=application %>" />
	</aui:column>
</aui:fieldset>
<portlet:resourceURL var="callMyUrl">
</portlet:resourceURL>
<aui:script use="aui-base">
	
	Liferay.provide(
		window,
		'updateChamDiemPhongBanForm',
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
				title: Liferay.Language.get('cap-nhap-chamdiemphongban'),
				uri: url,
				
			};
			
			Liferay.Util.openWindow(dialogWidow);	
			AUI().use('aui-io-request-deprecated','aui-base',function(A) {
	            A.io.request("<%=callMyUrl%>",
	            {
	            method:'post',
	            dataType:'text/html',
	            data:{
	            	<portlet:namespace />phongBanId:'clear',
	            },
	                on:{
	                success:function() {
	                    //alert(this.get('responseData'));
	                                    }
	                    }
	            });
	        });
		}
	);
	
	Liferay.provide(
			window,
			'updateChamDiemBaiVietForm',
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
					title: Liferay.Language.get('cap-nhap-chamdiembaiviet'),
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);	
	Liferay.provide(
			window,
			'updateChamDiemBaiVietNgoaiForm',
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
					title: Liferay.Language.get('cap-nhap-chamdiembaivietngoai'),
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);	
</aui:script>


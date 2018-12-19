<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/html/admin/chamdiem/init.jsp" %>

<div class="list-pcategory">
	<div class="bcategory-header">
		<liferay-ui:message key="cham-diem-menus"/>
	</div>
	
	
	<ul>
		<li class='<%=(menuId==0) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=0"%>'>
				<liferay-ui:message key="cham-diem-phong-ban"/>
			</a>
		</li>
		<li class='<%=(menuId==1) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=1"%>'>
				<liferay-ui:message key="cham-diem-bai-viet"/>
			</a>
		</li>
		<li class='<%=(menuId==2) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=2"%>'>
				<liferay-ui:message key="cham-diem-bai-viet-ngoai"/>
			</a>
		</li>
	</ul>
</div>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/html/admin/nhuanbut/init.jsp" %>

<div class="list-pcategory">
	<div class="bcategory-header">
		<liferay-ui:message key="danh-sach-bao-cao"/>
	</div>
	<!-- <div style="height:100px;overflow-y:auto;margin-bottom: 10px;"> -->
	
	<ul>
		<%--  <li class='<%=(menuId==0) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=0"%>'>
				<liferay-ui:message key="bang-ke-thanh-toan-tong-hop"/>
			</a>
		</li>
		<li class='<%=(menuId==1) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=1"%>'>
				<liferay-ui:message key="bang-ke-nhuan-but-ca-nhan"/>
			</a>
		</li>
		<li class='<%=(menuId==2) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=2"%>'>
				<liferay-ui:message key="tong-hop-nhuan-but"/>
			</a>
		</li>
		<li class='<%=(menuId==3) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=3"%>'>
				<liferay-ui:message key="bang-ke-nhuan-but-ngay"/>
			</a>
		</li>
		<li class='<%=(menuId==4) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=4"%>'>
				<liferay-ui:message key="tong-hop-thu-lao-bo-phan"/>
			</a>
		</li> --%>
		<li class='<%=(menuId==5) ?"selected":StringPool.BLANK%>'>
			<a href='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace() + "menuId=5"%>'>
				<liferay-ui:message key="muc-nhuan-but"/>
			</a>
		</li>
	</ul>
	<!-- </div> -->
</div>
<%-- <aui:select name='selectReport' label="">
		     <aui:option value="0" selected="<%= menuId==0 %>" ><%= LanguageUtil.get(locale, "bang-ke-thanh-toan-tong-hop") %></aui:option>
		     <aui:option value="1" selected="<%= menuId==1 %>" ><%= LanguageUtil.get(locale, "bang-ke-nhuan-but-ca-nhan") %></aui:option>
		     <aui:option value="2" selected="<%= menuId==2 %>" ><%= LanguageUtil.get(locale, "tong-hop-nhuan-but") %></aui:option>
		     <aui:option value="3" selected="<%= menuId==3 %>" ><%= LanguageUtil.get(locale, "bang-ke-nhuan-but-ngay") %></aui:option>
		     <aui:option value="4" selected="<%= menuId==4 %>" ><%= LanguageUtil.get(locale, "tong-hop-thu-lao-bo-phan") %></aui:option>
		</aui:select> --%>
<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@ include file="/html/admin/list-content/init.jsp"%>
<%
	int index = ParamUtil.getInteger(request, "index", 0);
	
	String layoutUuidIndex = portletPreferences.getValue("layoutUuid" + index,
			StringPool.BLANK);
	int statusIndex = GetterUtil.getInteger(portletPreferences.getValue("layoutStatus" + index, StringPool.BLANK), 0);
%>

<div class="block-preview">
	<div style="padding: 10px">
		<div class="remove-block" id="remove-block" index="<%=index%>">
			<span class="icon icon-remove">&nbsp</span>
		</div>
		<div class="block-title">			
			<aui:select name='<%="layoutUuid" + index%>' label="link-to-page" id='<%="layoutUuid" + index%>'
			 showEmptyOption="<%=true %>">
				<%=VCMSPubliserUtil.buildLayoutsToSelect(layoutUuidIndex, true, themeDisplay, true) %>
			</aui:select>
		</div>
			
		<div class="block-title">	
			<aui:select name="<%="layoutStatus" + index %>" label="choose-status" id='<%="layoutStatus" + index%>' showEmptyOption="<%= true %>">
				<aui:option value='1' label='page-title-v1s1' selected="<%= statusIndex == 1 %>"></aui:option>
				<aui:option value='2' label='page-title-v1s2' selected="<%= statusIndex == 2 %>"></aui:option>
				<aui:option value='4' label='page-title-v2s4' selected="<%= statusIndex == 4 %>"></aui:option>
				<aui:option value='8' label='page-title-v2s8' selected="<%= statusIndex == 8 %>"></aui:option>
				<aui:option value='16' label='page-title-v2s16' selected="<%= statusIndex == 16 %>"></aui:option>
				<aui:option value='32' label='page-title-v2s32' selected="<%= statusIndex == 32 %>"></aui:option>
				<aui:option value='128' label='page-title-v3s128' selected="<%= statusIndex == 128 %>"></aui:option>
				<aui:option value='256' label='page-title-v3s256' selected="<%= statusIndex == 256 %>"></aui:option>
				<aui:option value='512' label='page-title-v3s512' selected="<%= statusIndex == 512 %>"></aui:option>
				<aui:option value='1024' label='page-title-v3s1024' selected="<%= statusIndex == 1024 %>"></aui:option>
				<aui:option value='64' label='page-title-v4s64' selected="<%= statusIndex == 64 %>"></aui:option>
				<aui:option value='2048' label='page-title-v4s2048' selected="<%= statusIndex == 2048 %>"></aui:option>
				<aui:option value='4096' label='page-title-v4s4096' selected="<%= statusIndex == 4096 %>"></aui:option>
				<aui:option value='8192' label='page-title-v4s8192' selected="<%= statusIndex == 8192 %>"></aui:option>
			</aui:select>
		</div>
	</div>
</div>